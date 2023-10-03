/**
 * This is the Date class which implements the Date, it's constructors and relevant methods (getter, isValid, compareTo)
 *
 * @author Araika Khokhar, Pavan Machhi
 */

public class Date implements Comparable<Date> {
   private int year;
   private int month;
   private int day;
   public static final int QUADRENNIAL = 4;
   public static final int CENTENNIAL = 100;
   public static final int QUATERCENTENNIAL = 400;
   public static final int JAN_MAR_MAY_JUL_AUG_OCT_DEC_DAYS = 31;
   public static final int APR_JUN_SEP_NOV_DAYS = 30;
   public static final int FEB_LEAP = 29;
   public static final int FEB_NONLEAP = 28;

   /**
    * Constructor method for Date
    *
    * @param year, month, day
    */
   public Date(int year, int month, int day) {
      this.year = year;
      this.month = month;
      this.day = day;
   }

   /**
    * Getter methods for Dates
    *
    */
   public int getYear() {return year;
   }

   public int getMonth() {
      return month;
   }

   public int getDay(){ return day; }


   /**
    * Check if the date is a valid calendar date by checking if year month date input is valid and correct
    *
    * @return boolean true if valid, false otherwise
    */
   //check if the date is a valid calendar date
   public boolean isValid() {
      if (year < 1 || month < 1 || day < 1 || month > 12 || day > daysInMonth(year, month)) {
         return false;
      }
      return true;
   }

   /**
    * Assigns months to amount of days
    *
    * @param year, month
    * @return int - days in given month
    */
   private int daysInMonth(int year, int month) {
      if (month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12) {
         return JAN_MAR_MAY_JUL_AUG_OCT_DEC_DAYS;
      }
      if (month == 4 || month == 6 || month == 9 || month == 11) {
         return APR_JUN_SEP_NOV_DAYS;
      }
      if (month == 2) {
         return checkLeapYear(year) ? FEB_LEAP : FEB_NONLEAP;
      } else {
         return 0;
      }
   }

   /**
    * Checks if given year is leap or not
    *
    * @param given year
    * @return true if leap, false otherwise
    */
   //checks if it's a leap year
   private boolean checkLeapYear(int year) {
      if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
         return true;
      } else if (year % 4 == 0 && year % 100 != 0) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * Override method for comparison of date of Event
    * Checks year, then month then date
    * @return 0 if equal, 1 if this date > other date, -1 if this date < other date
    */

   @Override
      public int compareTo(Date otherDate) {
         if (this.year != otherDate.year) {
            return Integer.compare(this.year, otherDate.year);
         }
         if (this.month != otherDate.month) {
            return Integer.compare(this.month, otherDate.month);
         }
         return Integer.compare(this.day, otherDate.day);
      }

   /**
    * Override method for toString method - constructs the string as 1/1/1111 format
    *
    * @return String
    */

   @Override
   public String toString() {
      return getMonth() + "/" + getDay() + "/" + getYear();
   }

   /**
    * Calculates the month difference method for 2 dates
    * @return int difference in months
    */
   public int calculateMonthDifference(Date otherDate) {
      int monthsInYear = 12;  // Total number of months in a year

      int yearDiff = otherDate.getYear() - this.getYear();
      int monthDiff = Math.abs(otherDate.getMonth() - this.getMonth());

      // Calculate the difference as if it's a circular clock
      int circularDifference = (yearDiff * monthsInYear + monthDiff) % monthsInYear;

      // Ensure the circular difference is non-negative
      if (circularDifference < 0) {
         circularDifference += monthsInYear;
      }

      return circularDifference;
   }

   /**
    * TestBed for main method
    */
   public static void main(String[] args) {
      // Test cases
      Date date1 = new Date(-2023, 10, 10);
      Date date2 = new Date(2023, 14, 14);
      Date date3 = new Date(2023, 9, 4);
      Date date4 = new Date(2023, 9, 9);
      Date date5 = new Date(2020, 2, 2);

      System.out.println("Test Case 1: " + date1.isValid());  // Expected: false
      System.out.println("Test Case 2: " + date2.isValid());  // Expected: false
      System.out.println("Test Case 3: " + date3.isValid());  // Expected: true
      System.out.println("Test Case 4: " + date4.isValid());  // Expected: true
      System.out.println("Test Case 5: " + date5.isValid());  // Expected: true
   }

}