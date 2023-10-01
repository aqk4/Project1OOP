public class Contact {
 private Department department;
 private String email;

 // Constructor
 public Contact(Department department, String email) {
  this.department = department;
  this.email = email;
 }

 //getter method
 public Department getDepartment(){
  return department;
 }

 public String getEmail(){
  return email;
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