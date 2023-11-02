package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Member;
import seedu.address.model.task.Task;

/**
 * Assigns a task to the Member in the address book.
 */
public class AddMemberTaskCommand extends Command {

    public static final String COMMAND_WORD = "addTask";
    public static final String COMMAND_ALIAS = "addt";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a task to the specified member "
            + "by the index number used in the displayed member list. \n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_TASK + " {taskName} ";

    public static final String MESSAGE_ADD_TODO_SUCCESS = "Task added to member %1$s";

    private final Index index;
    private final AddMemberTaskDescriptor addMemberTaskDescriptor;


    /**
     * Creates an AddMemberCommand to add the specified {@code Member}
     */
    public AddMemberTaskCommand(Index index, AddMemberTaskDescriptor addMemberTaskDescriptor) {
        requireNonNull(addMemberTaskDescriptor);
        requireNonNull(index);

        this.index = index;
        this.addMemberTaskDescriptor = addMemberTaskDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Member> lastShownList = model.getFilteredMemberList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MEMBER_DISPLAYED_INDEX);
        }

        Member memberToAssign = lastShownList.get(index.getZeroBased());
        Member taskAddedMember = assignTaskToMember(memberToAssign, addMemberTaskDescriptor);

        model.setMember(memberToAssign, taskAddedMember);
        model.updateFilteredMemberList(PREDICATE_SHOW_ALL_PERSONS);
        model.setTaskListForMember(taskAddedMember);
        return new CommandResult(String.format(MESSAGE_ADD_TODO_SUCCESS, Messages.format(memberToAssign)));
    }

    private static Member assignTaskToMember(Member member, AddMemberTaskDescriptor addMemberTaskDescriptor) {
        assert member != null;

        List<Task> updatedTasks;
        if (addMemberTaskDescriptor.getTasks().isPresent()) {
            updatedTasks = addMemberTaskDescriptor.getTasks().get();
            updatedTasks.addAll(member.getTasks());
        } else {
            updatedTasks = member.getTasks();
        }

        return new Member(member.getName(), member.getPhone(), member.getEmail(),
                member.getTelegram(), member.getTags(), updatedTasks);

    }

    /**
     * Helper function for AddMemberTaskCommand
     */
    public static class AddMemberTaskDescriptor {
        private List<Task> tasks;

        public AddMemberTaskDescriptor() {
        }

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public AddMemberTaskDescriptor(AddMemberTaskDescriptor toCopy) {
            setTasks(toCopy.tasks);
        }

        public void setTasks(List<Task> tasks) {
            this.tasks = tasks;
        }

        public Optional<List<Task>> getTasks() {
            return Optional.ofNullable(this.tasks);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("tasks", tasks)
                    .toString();
        }
    }
}