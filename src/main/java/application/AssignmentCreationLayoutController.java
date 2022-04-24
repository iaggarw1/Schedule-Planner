package application;

import javafx.fxml.FXML;
import javafx.geometry.HPos;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
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
		updateAssignmentInfo(editBox.getSelectionModel().getSelectedIndex());
	}
	
	public void initialize() {
		//classComboBox.setItems(tempComboBox.getItems());
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
		MewTwoLayoutController.updateComboBox();
		Main.switchScene(0);
	}
	@SuppressWarnings("deprecation")
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
		
		if(hourDropDown.getValue() != "hr:" && minuteDropDown.getValue() != "Min:") {
			dueDate = Calendar.getInstance();
			dueDate.clear();
			LocalDate date = datePicker.getValue();
			tempHour = Integer.valueOf(hourDropDown.getValue());
			if(amPmDropDown.getValue().equalsIgnoreCase("PM")) {
				tempHour += 12;
			}
			tempMin = Integer.valueOf(minuteDropDown.getValue());
			dueDate.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), tempHour, tempMin);
			
			System.out.println(dueDate.getTime().toString());
			
			tempMonth = dueDate.getTime().getMonth();
			tempDay = dueDate.getTime().getDay();
			tempYear = dueDate.getTime().getYear();
			
			Assignment tempAssign = new Assignment(tempMonth, tempDay, tempYear, tempHour, tempMin, assignmentDesc, assignmentName, classInst);
			assignments.add(tempAssign);
			AssignmentCreationLayoutController.updateEditComboBox();
			resetScene();
		}
		else {
			System.out.println("Please fill in all of the fields");
		}
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
		int temp = 0;
		
		String assignmentName = null;
		String assignmentDescription = null;
		
		for(Assignment tempAssignment : assignments) {
			if(selection == temp) {
				assignmentName = tempAssignment.getAssignmentName();
				assignmentDescription = tempAssignment.getDescription();
			}
			temp++;
		}
		
		/* Set text fields to selection */
		assignmentNameID.setText(assignmentName);
		assignmentDescID.setText(assignmentDescription);
	}
	
	public Class getClassInst() {
		return classInst;
	}
}
