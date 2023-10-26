//package seedu.address.logic.commands;
//
//import static java.util.Objects.requireNonNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static seedu.address.testutil.Assert.assertThrows;
//
//import java.util.ArrayList;
//import java.util.function.Predicate;
//
//import javafx.collections.ObservableList;
//import seedu.address.model.AddressBook;
//import seedu.address.model.Model;
//import seedu.address.model.ReadOnlyAddressBook;
//import seedu.address.model.person.Applicant;
//import seedu.address.model.person.Member;
//import seedu.address.model.person.Person;
//
//public class AddCommandTest {
//
////    @Test
////    public void constructor_nullPerson_throwsNullPointerException() {
////        assertThrows(NullPointerException.class, () -> new AddCommand(null));
////    }
//
////    @Test
////    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
////        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
////        Person validPerson = new PersonBuilder().build();
////
////        CommandResult commandResult = new AddCommand(validPerson).execute(modelStub);
////
////        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(validPerson)),
////                commandResult.getFeedbackToUser());
////        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
////    }
//
////    @Test
////    public void execute_duplicatePerson_throwsCommandException() {
////        Person validPerson = new PersonBuilder().build();
////        AddCommand addCommand = new AddCommand(validPerson);
////        ModelStub modelStub = new ModelStubWithPerson(validPerson);
////
////        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () ->
////        addCommand.execute(modelStub));
////    }
//
////    @Test
////    public void equals() {
////        Person alice = new PersonBuilder().withName("Alice").build();
////        Person bob = new PersonBuilder().withName("Bob").build();
////        AddCommand addAliceCommand = new AddCommand(alice);
////        AddCommand addBobCommand = new AddCommand(bob);
////
////        // same object -> returns true
////        assertTrue(addAliceCommand.equals(addAliceCommand));
////
////        // same values -> returns true
////        AddCommand addAliceCommandCopy = new AddCommand(alice);
////        assertTrue(addAliceCommand.equals(addAliceCommandCopy));
////
////        // different types -> returns false
////        assertFalse(addAliceCommand.equals(1));
////
////        // null -> returns false
////        assertFalse(addAliceCommand.equals(null));
////
////        // different person -> returns false
////        assertFalse(addAliceCommand.equals(addBobCommand));
////    }
//
////    @Test
////    public void toStringMethod() {
////        AddCommand addCommand = new AddCommand(ALICE);
////        String expected = AddCommand.class.getCanonicalName() + "{toAdd=" + ALICE + "}";
////        assertEquals(expected, addCommand.toString());
////    }
//
//    /**
//     * A default model stub that have all of the methods failing.
//     */
//    private class ModelStub implements Model {
//        @Override
//        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ReadOnlyUserPrefs getUserPrefs() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public GuiSettings getGuiSettings() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setGuiSettings(GuiSettings guiSettings) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public Path getAddressBookFilePath() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setAddressBookFilePath(Path addressBookFilePath) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addPerson(Person person) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addMember(Member member) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addApplicant(Applicant applicant) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setAddressBook(ReadOnlyAddressBook newData) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ReadOnlyAddressBook getAddressBook() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasPerson(Person person) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasMember(Member member) {
//            return false;
//        }
//
//        @Override
//        public boolean hasApplicant(Applicant applicant) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deletePerson(Person target) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteApplicant(Applicant target) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteMember(Member member) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setPerson(Person target, Person editedPerson) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setApplicant(Applicant target, Applicant editedApplicant) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Person> getFilteredPersonList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Member> getFilteredMemberList() {
//            return null;
//        }
//
//        @Override
//        public ObservableList<Applicant> getFilteredApplicantList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredPersonList(Predicate<Person> predicate) {
//
//        }
//
//        @Override
//        public void updateFilteredMemberList(Predicate<? super Member> predicate) {
//
//        }
//
//        @Override
//        public void updateFilteredApplicantList(Predicate<? super Applicant> predicate) {
//
//        }
//    }
//
//    /**
//     * A Model stub that contains a single person.
//     */
//    private class ModelStubWithPerson extends ModelStub {
//        private final Person person;
//
//        ModelStubWithPerson(Person person) {
//            requireNonNull(person);
//            this.person = person;
//        }
//
//        @Override
//        public boolean hasPerson(Person person) {
//            requireNonNull(person);
//            return this.person.isSamePerson(person);
//        }
//    }
//
//    /**
//     * A Model stub that contains a single applicant.
//     */
//    private class ModelStubWithApplicant extends ModelStub {
//        private final Applicant applicant;
//
//        ModelStubWithApplicant(Applicant applicant) {
//            requireNonNull(applicant);
//            this.applicant = applicant;
//        }
//
//        @Override
//        public boolean hasApplicant(Applicant applicant) {
//            requireNonNull(applicant);
//            return this.applicant.isSameApplicant(applicant);
//        }
//    }
//
//    /**
//     * A Model stub that always accept the person being added.
//     */
//    private class ModelStubAcceptingPersonAdded extends ModelStub {
//        final ArrayList<Person> personsAdded = new ArrayList<>();
//
//        @Override
//        public boolean hasPerson(Person person) {
//            requireNonNull(person);
//            return personsAdded.stream().anyMatch(person::isSamePerson);
//        }
//
//        @Override
//        public void addPerson(Person person) {
//            requireNonNull(person);
//            personsAdded.add(person);
//        }
//
//        @Override
//        public ReadOnlyAddressBook getAddressBook() {
//            return new AddressBook();
//        }
//    }
//
//    private class ModelStubAcceptingApplicantAdded extends ModelStub {
//        final ArrayList<Applicant> applicantsAdded = new ArrayList<>();
//
//        @Override
//        public boolean hasApplicant(Applicant applicant) {
//            requireNonNull(applicant);
//            return applicantsAdded.stream().anyMatch(applicant::isSameApplicant);
//        }
//
//        @Override
//        public void addApplicant(Applicant applicant) {
//            requireNonNull(applicant);
//            applicantsAdded.add(applicant);
//        }
//
//        @Override
//        public ReadOnlyAddressBook getAddressBook() {
//            return new AddressBook();
//        }
//    }
//
//}