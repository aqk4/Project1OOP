/**
 This is Timeslot enum class
 @author Araika Khokhar, Pavan Machhi
 */

public enum Timeslot {
 MORNING(10, 30, "am"),
 AFTERNOON(14, 0,  "pm"),
 EVENING(18, 30, "pm");

 private final int hour;
 private final int minute;
 private final String startAmPm;

 Timeslot(int hour, int minute, String startAmPm) {
  this.hour = hour;
  this.minute = minute;
  this.startAmPm = startAmPm;
 }

 /**
  * Getter method for constructor variables
  *
  */
 public int getHour() {return hour;
 }
 public int getMinute() {
  return minute;
 }

 public String getStartAmPm(){
  return startAmPm;
 }

 }



