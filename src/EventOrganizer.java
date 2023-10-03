/**
 This is Event Organizer which is the user interface class to process the command line arguments.
 @author Araika Khokhar, Pavan Machhi
 */

import java.util.Scanner;
import java.util.Calendar;

public class EventOrganizer {
   private boolean isRunning;
   private EventCalendar eventCalendar;
   private Scanner scanner;

   /**
    * Method to begin the Event organizer, create Event calender, and implement Scanner
    *
    */
   public EventOrganizer() {
      System.out.println("Event Organizer running....");
      isRunning = true;
      eventCalendar = new EventCalendar();
      scanner = new Scanner(System.in);
   }

   /**
    * Converts date String to their date data types
    *
    * @param String - date String you are converting
    */
   public static Date parseDate(String dateString) {
      String[] dateParts = dateString.split("/");
      if (dateParts.length != 3) {
         return null;
      }
      int month = Integer.parseInt(dateParts[0]);
      int day = Integer.parseInt(dateParts[1]);
      int year = Integer.parseInt(dateParts[2]);
      return new Date(year, month, day);
   }

   /**
    * Converts time String to their Timeslot data types
    *
    * @param String - time String you are converting
    */   public static Timeslot parseTime(String timeString) {
      switch (timeString.toLowerCase()) {
         case "morning":
            return Timeslot.MORNING;
         case "afternoon":
            return Timeslot.AFTERNOON;
         case "evening":
            return Timeslot.EVENING;
         default:
            return null;
      }
   }

   /**
    * Converts Location String to their Location data types
    *
    * @param String - Location String you are converting
    */
   public static Location parseLocation(String locationString) {
      for (Location locationEnum : Location.values()) {
         if (locationEnum.getLocation().equalsIgnoreCase(locationString)) {
            return locationEnum;
         }
      }
      return null;
   }

   /**
    * Converts department String to their department data types
    *
    * @param String - department String you are converting
    */
   public static Department parseDepartment(String departmentString) {
      for (Department deptEnum : Department.values()) {
         if (deptEnum.getAcronym().equalsIgnoreCase(departmentString)) {
            return deptEnum;
         }
      }
      return null;
   }

   /**
    * Creates a new event by using previous converter methods
    *
    * @param String - String input command, you will convert
    */
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

   /**
    * Gets current dae
    *
    */
   //get current date
   public Date getCurrentDate(){
      Calendar checkingCalendar = Calendar.getInstance();
      int currYear = checkingCalendar.get(Calendar.YEAR);
      int currMonth = checkingCalendar.get(Calendar.MONTH) + 1;
      int currDay = checkingCalendar.get(Calendar.DAY_OF_MONTH);
      Date currentDate = new Date(currYear, currMonth, currDay);
      return currentDate;
   }

   /**
    * Adds an event by using checking for various errors converter methods
    *
    * @param Event - Event you can add
    */
   public void addEventToCalendar(Event addedEvent) {
      //get current Date and months difference
      Date currentDate = getCurrentDate();

      if (eventCalendar.contains(addedEvent)) {
         System.out.println("The event is already on the calendar.");
         return;
      } else if(!addedEvent.getDate().isValid()){
         System.out.println(addedEvent.getDate()  + ": Invalid calendar date!");
         return;
      } else if (addedEvent.getStartTime() == null) {
         System.out.println("Invalid Timeslot!");
         return;
      } else if (addedEvent.getLocation() == null) {
         System.out.println("Invalid location!");
         return;
      } else if(!addedEvent.getContact().isValid()){
         System.out.println("Invalid contact information!");
         return;
      } else if(addedEvent.getDate().compareTo(currentDate) == -1){
         System.out.println(addedEvent.getDate()  + ": Event date must be a future date!");
         return;
      } else if(currentDate.calculateMonthDifference(addedEvent.getDate()) > 6){
         System.out.println(addedEvent.getDate()  + ": Event date must be a within 6 months!");
         return;
      } else if(addedEvent.getDuration() < 30 || addedEvent.getDuration() > 120){
         System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
         return;
      } else{
         eventCalendar.add(addedEvent);
         System.out.println("Event added to the calendar.");
         return;
      }
   }

   /**
    * Adds an event by using checking for various errors converter methods
    *
    * @param Event - Event you can add
    */
   public void removeEventToCalendar(EventCalendar changingCalender, Event removedEvent) {
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else if (eventCalendar.contains(removedEvent)) {
         eventCalendar.remove(removedEvent);
         System.out.println("Event has been removed from the calendar!");
      } else {
         System.out.println("Cannot remove; event is not in the calendar!");
      }
   }

   /**
    * Prints events as is
    *
    */
   public void printEventsFromCalendar() {
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else {
         System.out.println("* Event calendar *");
         eventCalendar.print();
      }
   }

   /**
    * Prints events by date
    *
    */   public void printEventsbyDate() {
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else {
         System.out.println("* Event calendar *");
         eventCalendar.printByDate();
      }
   }

   /**
    * Prints events by Campus
    *
    */
   public void printEventsbyCampus() {
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else {
         System.out.println("* Event calendar *");
         eventCalendar.printByCampus();
      }
   }

   /**
    * Prints events by Department
    *
    */
   public void printEventsbyDepartment() {
      if (eventCalendar.getNumEvents() == 0) {
         System.out.println("Event calendar is empty!");
      } else {
         eventCalendar.printByDepartment();
      }
   }

   /**
    * Runs the event Organizer
    *
    */
   public void run() {
      Event newEvent = null;
      String command = null;
      System.out.print("Enter a command: ");
      System.out.println();
      while (isRunning) {
         String commandLine = scanner.nextLine().trim();
         if(commandLine.isEmpty()){
            continue;
         }
         if (commandLine.substring(0, 1).equals("A")) {
            String[] longInput = commandLine.split("\\s+");
            newEvent = createEvent(longInput);
            command = longInput[0];
         } else if(commandLine.substring(0, 1).equals("R")){
            String[] longInput = commandLine.split("\\s+");
            command = longInput[0];
         } else {
            command = commandLine;
         }
         switch (command) {
            case "A":
               addEventToCalendar(newEvent);
               break;
            case "R":
               removeEventToCalendar(eventCalendar, newEvent); // fix this
               break;
            case "P":
               printEventsFromCalendar();
               break;
            case "PE":
               printEventsbyDate();
               break;
            case "PC":
               printEventsbyCampus();
               break;
            case "PD":
               printEventsbyDepartment();
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
