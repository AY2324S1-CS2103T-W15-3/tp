package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddApplicantCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.CopyMemberCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ViewMembersCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Applicant;
import seedu.address.testutil.ApplicantBuilder;
import seedu.address.testutil.ApplicantUtil;

public class AddressBookParserTest {

    private final AddressBookParser parser = new AddressBookParser();

    //    @Test
    //    public void parseCommand_add() throws Exception {
    //        Person person = new PersonBuilder().build();
    //        AddCommand command = (AddCommand) parser.parseCommand(PersonUtil.getAddCommand(person));
    //        assertEquals(new AddCommand(person), command);
    //    }

    // TODO: add parseCommand_addMember
    @Test
    public void parseCommand_addApplicant() throws Exception {
        Applicant applicant = new ApplicantBuilder().build();
        AddApplicantCommand command =
                (AddApplicantCommand) parser.parseCommand(ApplicantUtil.getAddApplicantCommand(applicant));
        assertEquals(new AddApplicantCommand(applicant), command);
    }

    @Test
    public void parseCommand_clear() throws Exception {
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    // TODO: adapt for deleteMember and deleteApplicant
    //    @Test
    //    public void parseCommand_delete() throws Exception {
    //        DeleteCommand command = (DeleteCommand) parser.parseCommand(
    //                DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
    //        assertEquals(new DeleteCommand(INDEX_FIRST_PERSON), command);
    //    }

    // TODO: adapt for editMember and editApplicant
    //    @Test
    //    public void parseCommand_edit() throws Exception {
    //        Person person = new PersonBuilder().build();
    //        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder(person).build();
    //        EditCommand command = (EditCommand) parser.parseCommand(EditCommand.COMMAND_WORD + " "
    //                + INDEX_FIRST_PERSON.getOneBased() + " " + PersonUtil.getEditPersonDescriptorDetails(descriptor));
    //        assertEquals(new EditCommand(INDEX_FIRST_PERSON, descriptor), command);
    //    }

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    // TODO: adapt for findMember and findApplicant
    //    @Test
    //    public void parseCommand_find() throws Exception {
    //        List<String> keywords = Arrays.asList("foo", "bar", "baz");
    //        FindCommand command = (FindCommand) parser.parseCommand(
    //                FindCommand.COMMAND_WORD + " " + keywords.stream().collect(Collectors.joining(" ")));
    //        assertEquals(new FindCommand(new NameContainsKeywordsPredicate(keywords)), command);
    //    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_viewMember() throws Exception {
        assertTrue(parser.parseCommand(ViewMembersCommand.COMMAND_WORD) instanceof ViewMembersCommand);
        assertTrue(parser.parseCommand(ViewMembersCommand.COMMAND_WORD + " 3") instanceof ViewMembersCommand);
    }

    @Test
    public void parseCommand_viewApplicant() throws Exception {
        assertTrue(parser.parseCommand(ViewMembersCommand.COMMAND_WORD) instanceof ViewMembersCommand);
        assertTrue(parser.parseCommand(ViewMembersCommand.COMMAND_WORD + " 3") instanceof ViewMembersCommand);
    }

    @Test
    public void parseCommand_copyMember() throws Exception {
        CopyMemberCommand command = (CopyMemberCommand) parser.parseCommand(
                CopyMemberCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
        assertEquals(new CopyMemberCommand(INDEX_FIRST_PERSON), command);
    }

    @Test
    public void parseCommand_copyApplicant() throws Exception {
        CopyMemberCommand command = (CopyMemberCommand) parser.parseCommand(
                CopyMemberCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
        assertEquals(new CopyMemberCommand(INDEX_FIRST_PERSON), command);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
                -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}
