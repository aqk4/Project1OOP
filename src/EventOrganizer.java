/*
 This is Event Organizer which is the user interface class to process the command line arguments.
 @author Araika Khokhar, Pavan Machhi
 */

import java.util.Scanner;

//Event organizer class
public class EventOrganizer {
   private boolean isRunning;
   private EventCalendar eventCalendar;
   private Scanner scanner;

   //Method to begin the Event organizer, create Event calender, and implement Scanner
   public EventOrganizer() {
      System.out.println("Event Organizer running....");
      isRunning = true;
      eventCalendar = new EventCalendar();
      scanner = new Scanner(System.in);
   }


   //converts date String to their date data types
   public static Date parseDate(String dateString) throws IllegalArgumentException {
      String[] dateParts = dateString.split("/");
      if (dateParts.length != 3) {
         throw new IllegalArgumentException("Invalid date format: " + dateString);
      }

      int month = Integer.parseInt(dateParts[0]);
      int day = Integer.parseInt(dateParts[1]);
      int year = Integer.parseInt(dateParts[2]);

      return new Date(year, month, day);
   }

   //converts time String to Timeslot data type
   public static Timeslot parseTime(String timeString) {
      switch (timeString.toLowerCase()) {
         case "morning":
            return Timeslot.MORNING;
         case "afternoon":
            return Timeslot.AFTERNOON;
         case "evening":
            return Timeslot.EVENING;
         default:
            throw new IllegalArgumentException("Invalid timeslot: " + timeString);
      }
   }

   //converts Location String to location data type
   public static Location parseLocation(String locationString) {
      for (Location locationEnum : Location.values()) {
         if (locationEnum.getLocation().equalsIgnoreCase(locationString)) {
            return locationEnum;
         }
      }
      throw new IllegalArgumentException("Invalid location: " + locationString);
   }

   //converts Department String to department data type
   public static Department parseDepartment(String departmentString) {
      for (Department deptEnum : Department.values()) {
         if (deptEnum.getAcronym().equalsIgnoreCase(departmentString)) {
            return deptEnum;
         }
      }
      throw new IllegalArgumentException("Invalid department: " + departmentString);
   }

   //Creates the new Event
   public Event createEvent(String[] inputLongCommand) {
      Date eventArrDate = parseDate(inputLongCommand[1]);
      Timeslot eventArrTime = parseTime(inputLongCommand[2]);
      Location eventArrLocation = parseLocation(inputLongCommand[3]);
      Department eventArrDepartment = parseDepartment(inputLongCommand[4]);
      Contact eventArrContact = new Contact(eventArrDepartment, inputLongCommand[5]);
      Integer eventArrDuration = Integer.parseInt(inputLongCommand[6]);

      Event inputEvent = new Event(eventArrDate, eventArrTime, eventArrLocation, eventArrContact, eventArrDuration);
      return inputEvent;

   }

   //add event
   public void addEventToCalendar(Event addedEvent){
      if (eventCalendar.contains(addedEvent)) {
         System.out.println("The event is already on the calendar.");
      } else {
         eventCalendar.add(addedEvent);
         System.out.println("Event added to the calendar.");
      }
   }

   //remove event from Calendar - fix this to take in the appropriate amount of input
   public void removeEventToCalendar(EventCalendar changingCalender, Event removedEvent){
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else if (eventCalendar.contains(removedEvent)) {
         eventCalendar.remove(removedEvent);
         System.out.println("Event has been removed from the calendar!");
      } else {
         System.out.println("Cannot remove; evennet is not in the calendar!");
      }
   }

   //print the event Calendar as is
   public void printEventsFromCalendar(){
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else {
         eventCalendar.print();
      }
   }

   //print the event Calendar by date
   public void printEventsbyDate(EventCalendar printingByDateCalendar){
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else {
         eventCalendar.printByDate();
      }
   }

   //print the event calendar by campus

   //print the event calendar by dept


   //runs the Event Organizer
   public void run() {
      while (isRunning) {
         System.out.print("Enter a command: ");
         String command;
         Event newEvent = new Event(null, null, null, null, 0);

         //reads each line
         String commandLine = scanner.nextLine();

         //if it's a longer command (not p), make an array of just that one line split
         if (commandLine.length() > 2) {
            String[] longInput = commandLine.split("\\s+");
            newEvent = createEvent(longInput);
            command = longInput[0];
         } else {
            command = commandLine;
         }

            switch (command) {
               case "A":
                  addEventToCalendar(newEvent);
               case "R":
                  removeEventToCalendar(eventCalendar, newEvent); // fix this
               case "P":
                  printEventsFromCalendar();
               case "PE":
                  if (eventCalendar.getNumEvents() == 0) {
                     System.out.println("Event calendar is empty!");
                     break;
                  } else {
                     eventCalendar.printByDate();
                     break;
                  }
               case "PC":
                  if (eventCalendar.getNumEvents() == 0) {
                     System.out.println("Event calendar is empty!");
                     break;
                  } else {
                     eventCalendar.printByCampus();
                     break;
                  }
               case "PD":
                  if (eventCalendar.getNumEvents() == 0) {
                     System.out.println("Event calendar is empty!");
                     break;
                  } else {
                     eventCalendar.printByDepartment();
                     break;
                  }
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
