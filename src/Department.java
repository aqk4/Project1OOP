import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.text.DecimalFormat;

/**
 * This enum describes the Department that is hosting the event.
 * @author Araika Khokhar, Pavan Machi
 */

public enum Department {
   CS("Computer Science", "CS"),
   EE("Electrical Engineering", "EE"),
   ITI("Information Technology and Informatics", "ITI"),
   MATH("Mathematics", "MATH"),
   BAIT("Business Analytics and Information Technology", "BAIT");

   private final String departmentName;
   private final String acronym;


   /**
    * Constructs the full name of the Dept
    */
  Department(String departmentName, String acronym) {
      this.departmentName = departmentName;
      this.acronym = acronym;

   }

   /**
    * Returns the full name of the Dept
    * @return String fullName
    */
   public String getDeptName(){
      return departmentName;
   }

   public String getAcronym(){
      return acronym;
   }


}
