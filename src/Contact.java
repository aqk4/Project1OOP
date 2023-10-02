/*
 * This is the Date class which implements the Date, it's constructors and relevant methods (getter, isValid, compareTo)
 *
 * @author Araika Khokhar, Pavan Machhi
 */

public class Contact {
 private Department department;
 private String email;

 // Constructor
 public Contact(Department department, String email) {
  this.department = department;
  this.email = email;
 }

 // isValid method
 public boolean isValid() {
  // Check if department is valid
  boolean validDepartment = department != null;

  // Check if email is valid
  boolean validEmail = email != null &&
          (email.endsWith("@rutgers.edu") && email.startsWith(department.toString().toLowerCase()));

  return validDepartment && validEmail;
 }

}
