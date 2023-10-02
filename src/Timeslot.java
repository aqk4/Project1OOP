/**
 This is the one sentence, descriptive summary, part of a doc comment.
 There can be more lines after the first one if necessary.
 ....
 @author Araika Khokhar, Pavan Machi
 ...
 */

public enum Timeslot {
 MORNING(10, 30),
 AFTERNOON(14, 0 ),
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