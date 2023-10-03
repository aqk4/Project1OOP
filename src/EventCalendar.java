import java.util.Calendar;
/**
 * This an array-based implementation of a linear data structure to hold the list of events.
 * @author Araika Khokhar, Pavan Machhi
 */

public class EventCalendar {
   private Event[] events; //the array holding the list of events
   private int numEvents; //current number of events in the array

   //constants
   private static final int INTIAL_ARRAY = 4;
   private static final int GROWTH_FACTOR = 4;
   private static final int NOT_FOUND = -1;

   /**
    * Constructor method for Events Calendar
    *
    */
   public EventCalendar() {
      events = new Event[INTIAL_ARRAY];
      numEvents = 0;
   }

   /**
    * Getter method for Events Calendar
    *
    */
   public int getNumEvents() {
      return numEvents;
   }

   /**
    * Searches for an event in a Calendar
    *
    * @param Event you're searching for
    * @return int = index if found, -1 otherwise
    */
   private int find(Event event) {
      for (int i = 0; i < numEvents; i++) {
         if (events[i].equals(event)) {
            return i;
         }
      }
      return NOT_FOUND;
   }


   /**
    * Increases the capacity of Events Calendar by 4f
    *
    */
   private void grow() {
      Event[] newEvents = new Event[events.length + GROWTH_FACTOR];
      System.arraycopy(events,0, newEvents, 0, numEvents);
      events = newEvents;
   }

   /**
    * Adds an event in a Calendar, checks if the Event needs to grow first
    *
    * @param Event you're adding
    * @return true if added, false otherwise
    */
   public boolean add(Event event) {
      if(numEvents == events.length){
         grow();
      }
      events[numEvents] = event;
      numEvents++;
      return true;
   }

   /**
    * Removes an event in a Calendar, checks if the Event is in Calendar first
    *
    * @param Event you're removing
    * @return true if removed, false otherwise
    */
   public boolean remove(Event event) {
      int index = find(event);
      if(index != NOT_FOUND){
         for(int i = index; i < (numEvents - 1); i++) {
            events[i] = events[i+1];
         }
         events[numEvents- 1] = null;
         numEvents--;
         return true;
      }
      return false;
   }

   /**
    * Checks if the Event is in Calendar
    *
    * @param Event you're checking
    * @return true if there, false otherwise
    */

   public boolean contains(Event event) {
      return find(event) != NOT_FOUND;
   }

   /**
    * Prints the events in a Calendar
    *
    */
   public void print() {
      for(int i = 0; i < numEvents; i++){
         System.out.println(events[i]);
      }
   }


   /**
    * Prints the events in a Calendar sorted by Date
    *
    */
   public void printByDate() {
      sortbyDate();
      print();
   }


   /**
    * Prints the events in a Calendar sorted by Campus
    *
    */
   public void printByCampus() {
      sortbyCampus();
      print();
   }


   /**
    * Prints the events in a Calendar sorted by Department
    *
    */
   public void printByDepartment() {
      sortbyDepartment();
      print();
   }


   /**
    * Sorts the events in a Calendar by date
    *
    */

   public void sortbyDate() {
      for(int i = 0 ; i < numEvents - 1; i++){
         for(int j = 0; j < numEvents- i - 1; j++){
            if(events[j].getDate().compareTo(events[j+1].getDate()) > 0){
               Event temp = events[j];
               events[j] = events[j+1];
               events[j+1] = temp;
            }
         }
      }
   }


   /**
    * Sorts the events in a Calendar by Campus
    *
    */

   public void sortbyCampus() {
      for(int i = 0 ; i < numEvents - 1; i++){
         for(int j = 0; j < numEvents- i - 1; j++){
            int campusCompare = events[j].getLocation().getCampus().compareTo(events[j+1].getLocation().getCampus());
            int roomCompare = events[j].getLocation().getRoom().compareTo(events[j+1].getLocation().getRoom());
                  if(campusCompare > 0 || campusCompare == 0 && roomCompare > 0) {
                     Event temp = events[j];
                     events[j] = events[j + 1];
                     events[j + 1] = temp;
                  }
         }
      }
   }


   /**
    * Sorts the events in a Calendar by Department
    *
    */
   public void sortbyDepartment() {
      for(int i = 0 ; i < numEvents - 1; i++){
         for(int j = 0; j < numEvents- i - 1; j++){
            if(events[j].getContact().getDepartment().compareTo(events[j+1].getContact().getDepartment()) > 0){
               Event temp = events[j];
               events[j] = events[j+1];
               events[j+1] = temp;
            }
         }
      }
   }




}
