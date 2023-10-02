
/*
@author Araika Khokhar, Pavan Machhi
        ...
        */

public enum Location {
 HLL114("HLL114","Hill Center", "Busch"),
 ARC103("ARC103","Allison Road Classroom", "Busch"),
 BE_AUD("BE_AUD","Beck Hall", "Livingston"),
 TIL232("TIL232","Tillett Hall", "Livingston"),
 AB2225("AB2225","Academic Building", "College Avenue"),
 MU302("MU302","Murray Hall", "College Avenue");

 private final String room;
 private final String campus;
 private final String location;

 Location(String location, String room, String campus){
  this.location = location;
  this.room = room;
  this.campus = campus;
 }

 public String getLocation (){
  return location;
 }

 public String getCampus(){
  return campus;
 }

 public String getRoom (){
  return room;
 }

 @Override
 public String toString() {
  return location;
 }

}