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
   String commandLine = scanner.nextLine();
   String[] tokens = commandLine.split("\\s+");

   String command = tokens[0].toUpperCase();
   switch (command) {
    case "A":
     addEvent(tokens);
     break;
    case "R":
     removeEvent(tokens);
     break;
    case "P":
     printEvents();
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
     System.out.println("Event Organizer terminated.");
     break;
    default:
     System.out.println(command + " is an invalid command!");
     break;
   }
  }
  scanner.close();
 }
}



