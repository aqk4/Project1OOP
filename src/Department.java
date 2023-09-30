import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/**
 * This enum describes the Department that is hosting the event.
 * @author Araika Khokhar, Pavan Machi
 */

public enum Department {
   CS("Computer Science"),
   EE("Electrical Engineering"),
   ITI("Information Technology and Informatics"),
   MATH("Mathematics"),
   BAIT("Business Analytics and Information Technology");

   private final String fullName;

   /**
    * Constructs the full name of the Dept
    */
  Department(String fullName) {
      this.fullName = fullName;
   }

   /**
    * Returns the full name of the Dept
    * @return String fullName
    */
   public String getFullName(){
      return fullName;
   }
}
