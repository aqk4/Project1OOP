/*
 This is the one sentence, descriptive summary, part of a doc comment.
 There can be more lines after the first one if necessary.
 ....
 @author Araika Khokhar, Pavan Machhi
 ...
 */

import java.util.Scanner;

public class EventOrganizer {
 private boolean isRunning;
 private EventCalendar eventCalendar;
 private Scanner scanner;

 public EventOrganizer() {
  System.out.println("Event Organizer running....");
  isRunning = true;
  eventCalendar = new EventCalendar();
  scanner = new Scanner(System.in);
 }

 public void run() {
  while (isRunning) {
   System.out.print("Enter a command: ");
   String commandLine = scanner.nextLine().toUpperCase();
   String[] tokens = commandLine.split("\\s+");

   String command = tokens[0];
   switch (command) {
    case "A":
     addEvent(tokens);
     break;
    case "R":
     removeEvent(tokens);
     break;
    case "P":
     eventCalendar.print();
     break;
    case "PE":
     eventCalendar.printByDate();
     break;
    case "PC":
     eventCalendar.printByCampus();
     break;
    case "PD":
     eventCalendar.printByDepartment();
     break;
    case "Q":
     isRunning = false;
     break;
    default:
     System.out.println(command + " is an invalid command!");
     break;
   }
  }

  System.out.println("Event Organizer terminated.");
  scanner.close();
 }

 private void addEvent(String[] tokens) {
  // Implement the logic to add an event to the EventCalendar.
  // Parse tokens and create an Event object, then add it to eventCalendar.
  // Handle error cases and display appropriate messages as needed.
 }

 private void removeEvent(String[] tokens) {
  // Implement the logic to remove an event from the EventCalendar.
  // Parse tokens and create an Event object, then remove it from eventCalendar.
  // Handle error cases and display appropriate messages as needed.
 }
}



