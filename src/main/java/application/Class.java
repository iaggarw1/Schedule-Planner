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
	
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private ArrayList<Calendar> meetingTimes = new ArrayList<Calendar>();
	private int classDuration = 0;//in minutes
	private String meetingLoc = "";
	private String icon = "";
	private Color color = new Color(0,0,0,1);
	private String className = "";
	
	public Class() {
		
	}
	
	public Class(ArrayList<Assignment> newAssignments, ArrayList<Calendar> newMeetingTimes, 
			String newMeetingLoc, String newIcon, Color newColor, String newClassName, int newDuration) {
		assignments = newAssignments;
		meetingTimes = newMeetingTimes;
		meetingLoc = newMeetingLoc;
		icon = newIcon;
		color = newColor;
		className = newClassName;
		classDuration = newDuration;
	}
	
	public void setAssignments(ArrayList<Assignment> newAssignments) {
		assignments = newAssignments;
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
	
	public void setMeetingTimes(ArrayList<Calendar> newMeetingTimes) {
		meetingTimes = newMeetingTimes;
	}
	
	public ArrayList<Calendar> getMeetingTimes(){
		return meetingTimes;
	}
	
	public void setMeetingLoc(String newMeetingLoc) {
		meetingLoc = newMeetingLoc;
	}
	
	public String getMeetingLoc() {
		return meetingLoc;
	}
	
	public void setIcon(String newIcon) {
		icon = newIcon;
	}
	
	public String getIcon() {
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
}






















