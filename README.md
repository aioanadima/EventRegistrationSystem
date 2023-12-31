# EventRegistrationSystem

The project implements a back-end system responsible for managing the list of participants in an event. 

The application will consist of 3 component parts:
1. Guest class: a representation of a participant;
2. GuestsList class: a class that implements the management of the list of participants;
3. Main class: a main class, which represents the engine of the application that will accept commands from the user, perform the appropriate actions on the join lists, and respond to queries.

The enrollment management system will provide the user with a set of possible commands and a command to close the application. 
The program will receive commands (and respond to each command in turn) until the shutdown command is received. 

The set of commands that the program can receive is shown below: 

help - Show this list of commands
add - Add a new person (registration)
check - Check if a person is registered to the event
remove - Delete an existing person from the list
update - Updates a person's details
guests - The list of people participating in the event
waitlist - People on the waiting list
available - The number of free seats
guests_no - The number of people participating in the event
waitlist_no - The number of people on the waiting list
subscribe_no - The total number of registered people
search - Search all invitations according to the entered character string
quit - Close the application
