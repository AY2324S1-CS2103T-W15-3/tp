package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Member;
import seedu.address.model.person.Person;
import seedu.address.model.person.fields.Email;
import seedu.address.model.person.fields.Name;
import seedu.address.model.person.fields.Phone;
import seedu.address.model.person.fields.Tasklist;
import seedu.address.model.person.fields.Telegram;
import seedu.address.model.tag.Tag;
import seedu.address.task.Task;
import seedu.address.task.ToDo;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedMember {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String telegram;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();
    private final List<JsonAdaptedToDo> toDoList = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedMember(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email, @JsonProperty("telegram") String telegram,
                             @JsonProperty("todo") List<JsonAdaptedTag> tags,
                             @JsonProperty("todo") List<JsonAdaptedToDo> toDoList) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.telegram = telegram;
        if (tags != null) {
            this.tags.addAll(tags);
        }
        if (toDoList != null) {
            this.toDoList.addAll(toDoList);
        }
    }

    /**
     * Converts a given {@code Member} into this class for Jackson use.
     */
    public JsonAdaptedMember(Member source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        telegram = source.getTelegram().value;
        tags.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        toDoList.addAll(source.getTasks().getTaskAsList().stream()
                .map(JsonAdaptedToDo::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted member object into the model's {@code Member} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Member toModelType() throws IllegalValueException {
        final List<Tag> memberTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            memberTags.add(tag.toModelType());
        }

        final Tasklist toDos = new Tasklist();
        for (JsonAdaptedToDo toDo : toDoList) {
            toDos.addToDo(toDo.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (telegram == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Telegram.class.getSimpleName()));
        }
        if (!Telegram.isValidHandle(telegram)) {
            throw new IllegalValueException(Telegram.MESSAGE_CONSTRAINTS);
        }
        final Telegram modelTelegram = new Telegram(telegram);

        final Set<Tag> modelTags = new HashSet<>(memberTags);

        return new Member(modelName, modelPhone, modelEmail, modelTelegram, modelTags, toDos);
    }

}
