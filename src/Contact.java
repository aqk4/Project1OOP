/**
 This is the one sentence, descriptive summary, part of a doc comment.
 There can be more lines after the first one if necessary.
 ....
 @author Araika Khokhar, Pavan Machhi
 ...
 */

public class Contact {
 private Department department;
 private String email;

 public enum Department {
  CS, EE, ITI, MATH, BAIT;
 }

 // Constructor
 public Contact(Department department, String email) {
  this.department = department;
  this.email = email;
 }

 // isValid method with correct curly braces
 public boolean isValid() {
  boolean validDepartment = department != null;
  boolean validEmail = email != null && email.endsWith("@rutgers.edu");
  return validDepartment && validEmail;
 }

}
