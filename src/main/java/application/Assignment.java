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
	private Class classInst;
	private int status;
	public String origName;
	
	public Assignment() {
		setDueDate(0,0,0,0,0);
		assignmentID = autoAssignmentID;
		autoAssignmentID++;
		status = -1;
		origName = "";
	}
	
	public Assignment(int month, int day, int year, int hour, int minute, String desc, String name) {
		dueDate.set(year, month, day, hour, minute);
		description = desc;
		assignmentName = name;
		assignmentID = autoAssignmentID;
		autoAssignmentID++;
		status = -1;
		origName = name;
	}
	public Assignment(int month, int day, int year, int hour, int minute, String desc, String name, Class newClassInst) {
		dueDate.set(year, month, day, hour, minute);
		description = desc;
		assignmentName = name;
		assignmentID = autoAssignmentID;
		autoAssignmentID++;
		classInst = newClassInst;
		status = -1;
		origName = name;
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
	
	public void setClassInst(Class newClass) {
		classInst = newClass;
	}
	
	public Class getClassInst() {
		return classInst;
	}
	
	public String getClassName() {
		return classInst.getClassName();
	}
	
	
	
	public int status() {
		return status;
	}
	
	public int modStatus() {
		System.out.println(status);
		if(status == 1)
			status = -1;
		else
			status = 1;
		
		return status;
	}
}