import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/**
 * This class define the constants, constructors and methods of each event.
 *
 * @author Araika Khokhar, Pavan Machhi
 */

public class Event implements Comparable<Event> {
   private Date date; //the event date
   private Timeslot startTime; //the starting time
   private Location location;
   private Contact contact; //includes the department name and email
   private int duration; //in minutes

   /**
    * Constructor method for event
    *
    * @param date, startTime, location, contact and duration for creating a valid Event
    */
   public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
      this.date = date;
      this.startTime = startTime;
      this.location = location;
      this.contact = contact;
      this.duration = duration;
   }

   /**
    * Getter method for date of Event
    *
    * @return Date - date
    */
   public Date getDate() {
      return date;
   }

   /**
    * Getter method for startTime of Event
    *
    * @return Timeslot - startTime
    */
   public Timeslot getStartTime() {
      return startTime;
   }

   /**
    * Getter method for location of Event
    *
    * @return Location - location
    */
   public Location getLocation() {
      return location;
   }

   /**
    * Getter method for contact of Event
    *
    * @return Contact - contact
    */
   public Contact getContact() {
      return contact;
   }

   /**
    * Getter method for duration of Event
    *
    * @return Int - duration
    */
   public int getDuration() {
      return duration;
   }

   /**
    * Override method for toString method - converts Event to string
    *
    * @return String of "date startTime location contact duration"
    */
   @Override
   public String toString() {
      return date + " " + startTime + " " + location + " " + contact + " " + duration;
   }

   /**
    * Override method for equals method - checks if Events are equal by checking if every parameter is equal
    *
    * @return true if equal, false otherwise or for null objects/null classes of objects
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }

      Event otherEvent = (Event) obj;
      return date.equals(otherEvent.date) &&
            startTime == otherEvent.startTime &&
            location == otherEvent.location &&
            duration == otherEvent.duration &&
            contact == otherEvent.contact;
   }

   /**
    * Override method for compareTo method - compares the date first then time if needed
    *
    * @return positive int if this.date (or time) > otherEvent.date (or time)
    * negative int if this.date (or time) < otherEvent.date (or time), zero if equal
    */

   @Override
   public int compareTo(Event otherEvent) {
      // Implement the compareTo method to compare Event objects.
      // First, compare dates.
      int dateComparison = this.date.compareTo(otherEvent.date);
      if (dateComparison != 0) {
         return dateComparison;
      }

      int startTimeComparison = this.startTime.compareTo(otherEvent.startTime);
      if (startTimeComparison != 0) {
         return startTimeComparison;
      }

      int locationComparison = this.location.compareTo(otherEvent.location);
      if (locationComparison != 0) {
         return locationComparison;
      }

      int contactComparison = this.contact.getEmail().compareTo(otherEvent.contact.getEmail());
      if (contactComparison != 0) {
         return contactComparison;
      }

      return Integer.compare(this.duration, otherEvent.duration);
   }

   /**
    * Calculates End Time method - calculates the endTime of an Event based on startTime and duration
    *
    * @param startTime as Timeslot and duration as int
    * @return String of endTime in the format 00:00am or 0:00am
    */
   private String calculateEndTime(Timeslot startTime, int duration) {
      int startHr = startTime.getHour();
      int startMin = startTime.getMinute();

      // Calculate end time
      int endHr = (startHr + (startMin + duration) / 60) % 24;
      int endMin = (startMin + duration) % 60;
      String amPm = (endHr < 12) ? "am" : "pm";

      //converts back to 12-based clock system
      if (endHr > 12) {
         endHr -= 12;
      }

      String returnedEndTime = endHr + ":" + endMin + amPm;
      return returnedEndTime;
   }

}
