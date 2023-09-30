/**
 This is the one sentence, descriptive summary, part of a doc comment.
 There can be more lines after the first one if necessary.
 ....
 @author Araika Khokhar, Pavan Machi
 ...
 */

public enum Location {
 HLL114("Hill Center, Busch"),
 ARC103("Allison Road Classroom, Busch"),
 BE_AUD("Beck Hall, Livingston"),
 TIL232("Tillett Hall, Livingston"),
 AB2225("Academic Building, College Avenue"),
 MU302("Murray Hall, College Avenue");

 private final String fullLocation;

 Location(String fullLocation){
  this.fullLocation = fullLocation;
 }

 public String getFullLocation(){
  return fullLocation;
 }

}
