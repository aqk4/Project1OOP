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

   //Constructor
   public EventCalendar() {
      events = new Event[INTIAL_ARRAY];
      numEvents = 0;
   }

   //search an event in the list
   private int find(Event event) {
      for (int i = 0; i < numEvents; i++) {
         if (events[i].equals(event)) {
            return i;
         }
      }
      return NOT_FOUND;
   }

   //increase the capacity by 4
   private void grow() {
      Event[] newEvents = new Event[events.length + GROWTH_FACTOR];
      System.arraycopy(events,0, newEvents, 0, numEvents);
      events = newEvents;
   }

   public boolean add(Event event) {
      if(numEvents == events.length){
         grow();
      }
      events[numEvents] = event;
      numEvents++;
      return true;
   }

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

   public boolean contains(Event event) {
      return find(event) != NOT_FOUND;
   }

   public void print() {
      for(int i = 0; i < numEvents; i++){
         System.out.println(events[i]);
      }
   }

   public void printByDate() {
      sortbyDate();
      print();
   }

   public void printByCampus() {
      sortbyCampus();
      print();
   }

   public void printByDepartment() {
      sortbyDepartment();
      print();
   }

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
