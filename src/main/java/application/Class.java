/* what a class needs:
 * --------------------------------------------------------
 * Assignments
 * Meeting time and location
 * Icon
 * Color
 * Name
 */
package application;
	
import java.util.ArrayList;
import java.util.Calendar;
import application.Assignment;
import javafx.scene.paint.Color;

public class Class {
	
	private static int autoClassID = 1000;
	
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	//private ArrayList<Calendar> meetingDow = new ArrayList<Calendar>();
	private ArrayList<String> meetingDow = new ArrayList<String>();
	private String meetingTime = "";//Format: %02d:%02d %s
	private int classDuration = 0;//in minutes
	private String meetingLoc = "";
	private int icon = -1;
	private Color color = new Color(0,0,0,1);
	private String className = "";
	private int classID;
	
	public Class() {
		classID = autoClassID;
		autoClassID++;
	}
	
	public Class(ArrayList<Assignment> newAssignments, ArrayList<String> newMeetingDow, String newMeetingTime,  
			String newMeetingLoc, int newIconNumber, Color newColor, String newClassName, int newDuration) {
		assignments = newAssignments;
		meetingDow = newMeetingDow;
		meetingTime = newMeetingTime;
		meetingLoc = newMeetingLoc;
		icon = newIconNumber;
		color = newColor;
		className = newClassName;
		classDuration = newDuration;
		classID = autoClassID;
		autoClassID++;
	}
	
	public void setAssignments(ArrayList<Assignment> newAssignments) {
		assignments = newAssignments;
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
	
	public void setmeetingDow(ArrayList<String> newMeetingDow) {
		meetingDow = newMeetingDow;
	}
	
	public ArrayList<String> getmeetingDow(){
		return meetingDow;
	}
	
	public void setMeetingTime(String newMeetingTime) {
		meetingTime = newMeetingTime;
	}
	
	public String getMeetingTime() {
		return meetingTime;
	}
	
	public void setMeetingLoc(String newMeetingLoc) {
		meetingLoc = newMeetingLoc;
	}
	
	public String getMeetingLoc() {
		return meetingLoc;
	}
	
	public void setIcon(int newIcon) {
		icon = newIcon;
	}
	
	public int getIcon() {
		return icon;
	}
	
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setClassName(String newClassName) {
		className = newClassName;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassDuration(int newDuration) {
		classDuration = newDuration;
	}
	
	public int getClassDuration() {
		return classDuration;
	}
	public int getClassID() {
		return classID;
	}
	
	public String toString() {
		return className + "-" + classID + " Dur: " + classDuration + " Loc: " + meetingLoc + " Meeting Time: " + meetingTime;
	}
}



