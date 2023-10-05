---
layout: page
title: Developer Guide
---
# ClubMembersContact

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**:

* is a member of an organisation
* has a responsibility in managing applicants who are applying into the organisation
* has a need to manage a significant number of contacts
* prefers data to be organized and separated into categories
* prefers desktop apps over other types
* prefers typing to mouse interactions
* prefers to use a separate app that is made to manage CCA-related contacts efficiently
* is reasonably comfortable using CLI apps

**Value proposition**: categorises contacts into 'members' and 'applicants' groups, allowing for easier management of contacts


### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​ | I want to …​                          | So that I can…​                                                   |
|----------|---------|---------------------------------------|-------------------------------------------------------------------|
| `* * *`  | user    | add existing members' contact         | get the contact of existing members to contact them               |
| `* * *`  | user    | view existing members' contact        | see a list of all current members in the organisation             |
| `* * *`  | user    | delete an existing members' contact   | remove existing members' contacts that should be removed          |
| `* * *`  | user    | add prospective members' contact      | get the contact of applicants to contact them for further updates |
| `* * *`  | user    | view prospective members' contact     | see a list of all applicants                                      |
| `* * *`  | user    | delete a prospective members' contact | remove applicants' contacts that should be removed                |

*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `ClubMembersContact` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Delete a person**

**MSS**

1.  User requests to list persons
2.  AddressBook shows a list of persons
3.  User requests to delete a specific person in the list
4.  AddressBook deletes the person

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. AddressBook shows an error message.

      Use case resumes at step 2.

*{More to be added}*

### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

*{More to be added}*

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Private contact detail**: A contact detail that is not meant to be shared with others

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

   1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

1. _{ more test cases …​ }_

### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_
