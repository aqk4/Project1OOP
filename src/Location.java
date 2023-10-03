/**
 * This is the Location enum class, it contains various relevant methods.
 *
 * @author Araika Khokhar, Pavan Machi
 * ...
 */

public enum Location {
   HLL114("HLL114", "Hill Center", "Busch"),
   ARC103("ARC103", "Allison Road Classroom", "Busch"),
   BE_AUD("BE_AUD", "Beck Hall", "Livingston"),
   TIL232("TIL232", "Tillett Hall", "Livingston"),
   AB2225("AB2225", "Academic Building", "College Avenue"),
   MU302("MU302", "Murray Hall", "College Avenue");

   private final String room;
   private final String campus;
   private final String location;

   Location(String location, String room, String campus) {
      this.location = location;
      this.room = room;
      this.campus = campus;
   }

   /**
    * Getter method for constructor variables
    *
    */
   public String getLocation() {
      return location;
   }

   public String getCampus() {
      return campus;
   }

   public String getRoom() {
      return room;
   }

   /**
    * Override method for toString method - returns location
    *
    * @return String
    */
   @Override
   public String toString() {
      return location;
   }

   /**
    * Checks if 2 locations are equal
    *
    * @return true if they are, false otherwise
    */
   public boolean stringEquals(Location other) {
      if (other == null) {
         return false;
      } else {
         return (this.room.equals(other.room) &&
               this.campus.equals(other.campus) &&
               this.location.equals(other.location));
      }
   }

}
