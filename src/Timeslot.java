/**
 * This enum represents different timeslots of the day, namely MORNING, AFTERNOON, and EVENING.
 * Each timeslot has an associated hour and minute.
 *
 * <p>The enum provides constants for specific timeslots and their corresponding hours and minutes.
 *
 * @author Araika Khokhar, Pavan Machhi
 */

public enum Timeslot {
 MORNING(10, 30),
 AFTERNOON(14, 0),
 EVENING(18, 30);

 private final int hour;
 private final int minute;

 Timeslot(int hour, int minute) {
  this.hour = hour;
  this.minute = minute;
 }

 public int getHour() {
  return hour;
 }

 public int getMinute() {
  return minute;
 }



}