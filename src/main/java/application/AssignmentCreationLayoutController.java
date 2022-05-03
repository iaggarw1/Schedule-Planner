package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class AssignmentCreationLayoutController {
	
	private static ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private String assignmentName = "";
	private String assignmentDesc = "";
	private Calendar dueDate;
	private Class classInst;
	private static ComboBox<String> tempComboBox = new ComboBox<String>();
	private static ComboBox<String> tempAssignmentBox = new ComboBox<String>();
	private MewTwoLayoutController mainPage;
	private static int editAssignmentID = 0;
	private static String tempClassCheck = null;
	@FXML
	private TextField assignmentNameID;
	@FXML
	private ComboBox<String> classComboBox;
	@FXML
	private TextArea assignmentDescID;
	@FXML
	private DatePicker datePicker;
	@FXML
	private ComboBox<String> hourDropDown;
	@FXML
	private ComboBox<String> minuteDropDown;
	@FXML
	private ComboBox<String> amPmDropDown;
	@FXML
	private ComboBox<String> editBox;
	
	@FXML
	void editSelect(ActionEvent event) {
		if(editBox.getSelectionModel().getSelectedIndex() != -1) {
			updateAssignmentInfo(editBox.getSelectionModel().getSelectedIndex());
		}
	}
	
	
	public MewTwoLayoutController getMainPage() {
		return mainPage;
	}
	public void setMainPage(MewTwoLayoutController mainPage) {
		this.mainPage = mainPage;
		
	}
	public void initialize() {
		//classComboBox.setItems(tempComboBox.getItems());
		dueDate = Calendar.getInstance();
		ObservableList<String> hourList = FXCollections.observableArrayList();
		hourList.add("Hr:");
		for(int hr = 1; hr <= 12; hr++) {
			String tempStr = String.format("%02d", hr);
			hourList.add(tempStr);
		}
    	hourDropDown.setItems(hourList);
    	hourDropDown.setValue("Hr:");
    	
    	ObservableList<String> minuteList = FXCollections.observableArrayList();
    	minuteList.add("Min:");
    	for(int min = 0; min <= 59; min++) {
			String tempStr = String.format("%02d", min) + "";
			minuteList.add(tempStr);
		}
    	minuteDropDown.setItems(minuteList);
    	minuteDropDown.setValue("Min:");
    	
    	ObservableList<String> amPmList = FXCollections.observableArrayList();
		amPmList.addAll("AM", "PM");
    	amPmDropDown.setItems(amPmList);
    	amPmDropDown.setValue("AM");
	}
	@FXML
	public void switchToMainScene() {
		try {
		//mainPage.setMainController(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
		MewTwoLayoutController.updateComboBox();
		Main.switchScene(0);
	}

	public void initiateAssignment() {//(int month, int day, int year, int hour, int minute, String desc, String name)
		
		int tempMonth = -1, tempDay = -1, tempYear = -1, tempHour = -1, tempMin = -1;
		
		if(!assignmentNameID.getText().equalsIgnoreCase(assignmentName)) {
			assignmentName = assignmentNameID.getText();
		}
		if(!assignmentDescID.getText().equalsIgnoreCase(assignmentDesc)) {
			assignmentDesc = assignmentDescID.getText();
		}
		
		if(classComboBox.getValue() != null) {
			ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
			for(Class tempClass : classes) {
				if(classComboBox.getValue().equalsIgnoreCase(tempClass.getClassName())) {
					classInst = tempClass;
				}
			}
		}
		

		//System.out.println(dueDate.getTime().toString());
		
		//int tempMonth, tempDay, tempYear;
		tempMonth = dueDate.get(Calendar.MONTH);
		tempDay = dueDate.get(Calendar.DAY_OF_MONTH);
		tempYear = dueDate.get(Calendar.YEAR);
		
		//Assignment tempAssign = new Assignment(tempMonth, tempDay, tempYear, tempHour, tempMin, assignmentDesc, assignmentName, classInst);
		//assignments.add(tempAssign);
		
		//resetScene();
//=======
		if(hourDropDown.getValue() != "hr:" && minuteDropDown.getValue() != "Min:") {
			dueDate.clear();
			LocalDate date = datePicker.getValue();
			tempHour = Integer.valueOf(hourDropDown.getValue());
			if(amPmDropDown.getValue().equalsIgnoreCase("PM")) {
				tempHour += 12;
			}
			tempMin = Integer.valueOf(minuteDropDown.getValue());
			tempDay = date.getDayOfMonth();
			dueDate.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), tempHour, tempMin);
			
			System.out.println(dueDate.getTime().toString());
			
			Assignment tempAssign = new Assignment(tempMonth, tempDay, tempYear, tempHour, tempMin, assignmentDesc, assignmentName, classInst);
			if(editAssignmentID != 0) { //replace existing assignment
				int iter = 0;
				for(Assignment temp: assignments) {
					if(editAssignmentID == temp.getAssignmentID()) {
						assignments.set(iter, tempAssign);
						System.out.println("Replacing Existing Assignments at INDEX " + iter);
						break;
					}
					iter++;
				}
				if(tempClassCheck == classComboBox.getValue()) {
					ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
					for(Class tempClass: classes) {
						if(tempClass.getClassName() == classComboBox.getValue()) {
							ArrayList<Assignment> tempAssignments = new ArrayList<Assignment>();
							for(Assignment tempAssignment: tempClass.getAssignments()) {
								if(editAssignmentID == tempAssignment.getAssignmentID()) {
									tempAssignments.add(tempAssign);
								}
								else {
									tempAssignments.add(tempAssignment);
								}
							}
							tempClass.setAssignments(tempAssignments);
						}
					}
				}
				else {
					ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
					/* Remove assignment from old class */
					for(Class tempClass: classes) {
						if(tempClass.getClassName() == tempClassCheck) {
							ArrayList<Assignment> tempAssignments = new ArrayList<Assignment>();
							for(Assignment tempAssignment: tempClass.getAssignments()) {
								if(editAssignmentID == tempAssignment.getAssignmentID()) {
									continue;
								}
								else {
									tempAssignments.add(tempAssignment);
								}
							}
							tempClass.setAssignments(tempAssignments);
						}
					}
					/* Add assignment to new class */
					for(Class tempClass: classes) {
						if(tempClass.getClassName() == classComboBox.getValue()) {
							ArrayList<Assignment> tempAssignments = new ArrayList<Assignment>();
							for(Assignment tempAssignmet: tempClass.getAssignments()) {
								tempAssignments.add(tempAssignmet);
							}
							tempAssignments.add(tempAssign);
							tempClass.setAssignments(tempAssignments);
						}
					}
				}
			}
			else { //add new assignment
				assignments.add(tempAssign);
				ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
				for(Class tempClass : classes) {
					if(tempClass.getClassName() == classComboBox.getValue()) {
						ArrayList<Assignment> tempAssignments = new ArrayList<Assignment>();
						for(Assignment tempAssignment: tempClass.getAssignments()) {
							tempAssignments.add(tempAssignment);
						}
						tempAssignments.add(tempAssign);
						tempClass.setAssignments(tempAssignments);
					}
				}
			}
			AssignmentCreationLayoutController.updateEditComboBox();
			
			resetScene();
		}
		else {
			System.out.println("Please fill in all of the fields");
		}
		
		MewTwoLayoutController mewTwoLayoutController = Main.getMew2Controller();
		mewTwoLayoutController.updateAssignments();
	}
	public void resetScene() {
		assignmentNameID.clear();
		assignmentDescID.clear();
		hourDropDown.setValue("Hr:");
		minuteDropDown.setValue("Min:");
		amPmDropDown.setValue("AM");
		datePicker.setValue(null);
		classComboBox.setValue(null);
		editBox.setValue(null);
		editAssignmentID = 0;
		tempClassCheck = null;
	}
	
	public static ArrayList<Assignment> getAssignments(){
		return assignments;
	}
	
	public static ComboBox <String> getComboBox(){
    	return tempComboBox;
    }
    
    public static void setComboBox(ComboBox <String> comboBox) {
    	tempComboBox = comboBox;
    }
    
    public void refreshClassComboBox() {
		classComboBox.setItems(tempComboBox.getItems());
		//comboBox.getItems().addAll(tempComboBox.getItems());
	}
    
    public void refreshEditComboBox() {
    	editBox.setItems(tempAssignmentBox.getItems());
    }
    
	public static void updateComboBox() {
		ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
		ObservableList<String> classList = FXCollections.observableArrayList();
		
		for(Class tempClass : classes) {
			classList.add(tempClass.getClassName());
		}
    	tempComboBox.setItems(classList);
	}
	
	public static void updateEditComboBox() {
		ArrayList<Assignment> assignments = AssignmentCreationLayoutController.getAssignments();
		ObservableList<String> assignmentList = FXCollections.observableArrayList();
		for(Assignment tempAssignment : assignments) {
			System.out.println("+1 Assignment");
			assignmentList.add(tempAssignment.getAssignmentName());
			
		}
    	tempAssignmentBox.setItems(assignmentList);
    
	}
	
	public void setClassInst(Class newClassInst) {
		classInst = newClassInst;
	}
	
	public void updateAssignmentInfo(int selection) {
		System.out.println("Upating Text Fields..");
		ArrayList<Assignment> assignments = AssignmentCreationLayoutController.getAssignments();
		ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
		int temp = 0;
		
		String assignmentName = null;
		String assignmentDescription = null;
		Calendar mt = null;
		
		for(Assignment tempAssignment : assignments) {
			if(selection == temp) {
				assignmentName = tempAssignment.getAssignmentName();
				assignmentDescription = tempAssignment.getDescription();
				mt = tempAssignment.getDueDate();
				editAssignmentID = tempAssignment.getAssignmentID();
				break;
			}
			temp++;
		}
		
		
		for(Class tempClass : classes) {
			System.out.println("Size of " + tempClass.getClassName() + ": " + tempClass.getAssignments().size());
			for(Assignment tempAssignment: tempClass.getAssignments()) {
				if(tempAssignment.getAssignmentName() == assignmentName) {
						//			classInst = tempClass;
					System.out.println(tempAssignment.getAssignmentName());
					classComboBox.setValue(tempClass.getClassName());
					tempClassCheck = tempClass.getClassName();
					//break;
				}
			}
		}
		/* Set text fields to selection */
		assignmentNameID.setText(assignmentName);
		assignmentDescID.setText(assignmentDescription);
		
		Date d1 = mt.getTime();
		LocalDate date1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		datePicker.setValue(date1);
		
		
		updateStartTime(d1);
	}
	
	private void updateStartTime(Date d1) {
		System.out.println(d1.toString());

		SimpleDateFormat formatHour = new SimpleDateFormat("HH");
		SimpleDateFormat formatSeconds = new SimpleDateFormat("mm");
		String hour = formatHour.format(d1);
		String minutes = formatSeconds.format(d1);
		System.out.println("Hour: " + hour + " Minutes: " + minutes);
		
		int hourNumber = Integer.parseInt(hour);
		int minutesNumber = Integer.parseInt(minutes);
		
		if(hourNumber < 12) { /* AM */
			if(hourNumber == 0) {
				hourNumber = 12;
			}
			hourDropDown.getSelectionModel().select(hourNumber);
			minuteDropDown.getSelectionModel().select(minutesNumber+1);
			amPmDropDown.getSelectionModel().select(0);
		}
		else {					/* PM */
			if(hourNumber != 12) {
				hourNumber -= 12;
			}
			hourDropDown.getSelectionModel().select(hourNumber);
			minuteDropDown.getSelectionModel().select(minutesNumber+1);
			amPmDropDown.getSelectionModel().select(1);
		}
	}
	
	public Class getClassInst() {
		return classInst;
	}
}
