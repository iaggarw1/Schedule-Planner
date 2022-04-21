/* what a assignment needs:
 * --------------------------------------------------------
 * Due date/time
 * details/instructions
 * Name
 * 
 */
package application;
	
import java.util.Calendar;

public class Assignment {
	
	private static int autoAssignmentID = 1000;
	
	private Calendar dueDate = Calendar.getInstance();
	private String description = "";//the description of what the assignment is
	private String assignmentName = "";
	private int assignmentID;
	
	public Assignment() {
		setDueDate(0,0,0,0,0);
		assignmentID = autoAssignmentID;
		autoAssignmentID++;
	}
	
	public Assignment(int month, int day, int year, int hour, int minute, String desc, String name) {
		dueDate.set(year, month, day, hour, minute);
		description = desc;
		assignmentName = name;
		assignmentID = autoAssignmentID;
		autoAssignmentID++;
	}
	
	public void setDueDate(int month, int day, int year, int hour, int minute) {
		dueDate.set(year, month, day, hour, minute);
	}
	
	public Calendar getDueDate() {
		return dueDate;
	}
	
	public void setDescription(String newDesc) {
		description = newDesc;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setAssignmentName(String newName) {
		assignmentName = newName; 
	}
	
	public String getAssignmentName() {
		return assignmentName;
	}
	
	public int getAssignmentID() {
		return assignmentID;
	}
}