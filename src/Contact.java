/*
 This is Contact class which is the creates the Contact based on Department and email input.
 @author Araika Khokhar, Pavan Machhi
 */

public class Contact {
 private Department department;
 private String email;

 /**
  * Constructor method for Contact
  *
  * @ param Department department, String email
  */
 public Contact(Department department, String email) {
  this.department = department;
  this.email = email;
 }

 /**
  * Getter methods for constructor variable
  *
  */
 public Department getDepartment(){
  return department;
 }

 public String getEmail(){
  return email;
 }



 /**
  * isValid method for Contacts - checks if contact info provided is sufficient to make a contact
  *
  * @return true if valid, false otherwise
  */
 public boolean isValid() {
  // Check if department is valid
  boolean validDepartment = department != null;

  // Check if email is valid
  boolean validEmail = email != null &&
        (email.endsWith("@rutgers.edu") && email.startsWith(department.toString().toLowerCase()));

  return validDepartment && validEmail;
 }

}