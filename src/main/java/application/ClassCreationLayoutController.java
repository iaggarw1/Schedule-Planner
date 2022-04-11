package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Calendar;
import javafx.geometry.HPos;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class ClassCreationLayoutController {
	
	private static ArrayList<Class> classes = new ArrayList<Class>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private ArrayList<Calendar> meetingTimes = new ArrayList<Calendar>();
	private int classDuration = 0;
	private String meetingLoc = "";
	private String icon = "";
	private Color color = new Color(0,0,0,1);
	private String className = "";
	
	@FXML
	private TextField classNameID;//classNameID.getText();
	@FXML
	private TextField meetingLocationID;
	@FXML
	private DatePicker datePicker;
	@FXML
	private ComboBox<String> hourDropDown;
	@FXML
	private ComboBox<String> minuteDropDown;
	@FXML
	private ComboBox<String> amPmDropDown;
	@FXML
	private ComboBox<String> durationDropDown;
	
	public void initialize() {
		ObservableList<String> hourList = FXCollections.observableArrayList();
		for(int hr = 1; hr <= 12; hr++) {
			String tempStr = hr + "";
			hourList.add(tempStr);
		}
    	hourDropDown.setItems(hourList);
    	
    	ObservableList<String> minuteList = FXCollections.observableArrayList();
		for(int min = 1; min <= 59; min++) {
			String tempStr = min + "";
			minuteList.add(tempStr);
		}
    	minuteDropDown.setItems(minuteList);
    	
    	ObservableList<String> amPmList = FXCollections.observableArrayList();
		amPmList.addAll("AM", "PM");
    	amPmDropDown.setItems(amPmList);
    	
    	ObservableList<String> durationList = FXCollections.observableArrayList();
		for(int hr = 0; hr <= 12; hr++) {
			for(int min = 0; min < 60; min+=15) {
				//String tempStr = hr + ":" + min;
				String tempStr1 = String.format("%02d", hr);
				String tempStr2 = String.format("%02d", min);
				durationList.add(tempStr1 + ":" + tempStr2);
			}
		}
		durationList.remove(0);
    	durationDropDown.setItems(durationList);
	}
	
	@FXML
	public void switchToMainScene() {
		MewTwoLayoutController.updateComboBox();
		Main.switchScene(0);
	}
	
	public void addClassTimeSlot() {
		//TODO:check to see if all needed inputs are in
		
		
		Calendar tempCalendar = Calendar.getInstance();
		tempCalendar.clear();
		LocalDate date = datePicker.getValue();
		int tempHour = Integer.valueOf(hourDropDown.getValue());
		if(amPmDropDown.getValue().equalsIgnoreCase("PM")) {
			tempHour += 12;
		}
		int tempMin = Integer.valueOf(minuteDropDown.getValue());
		tempCalendar.set(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), tempHour, tempMin);
		
		meetingTimes.add(tempCalendar);
		System.out.println(meetingTimes.get(0).getTime().toString());
		
		resetClassTimeSlot();
	}
	
	public void initiateClass() {//(ArrayList<Assignment> newAssignments, ArrayList<Calendar> newMeetingTimes, 
								 //String newMeetingLoc, String newIcon, Color newColor, String newClassName)
		
		if(!classNameID.getText().equalsIgnoreCase(className)) {
			className = classNameID.getText();
		}
		if(!meetingLocationID.getText().equalsIgnoreCase(meetingLoc)) {
			meetingLoc = meetingLocationID.getText();
		}
		String tempDuration = durationDropDown.getValue();
		String[] splitDuration = tempDuration.split(":");
		String tempHrs, tempMins = "";
		tempHrs = splitDuration[0];
		tempMins = splitDuration[1];
		classDuration = Integer.valueOf(tempMins) + (Integer.valueOf(tempHrs) * 60);
		Class tempClass = new Class(assignments, meetingTimes, meetingLoc, icon, color, className, classDuration);
		classes.add(tempClass);
		
		resetScene();
	}
	
	public static ArrayList<Class> getClasses(){
		return classes;
	}
	
	public void resetScene() {
		classNameID.clear();
		meetingLocationID.clear();
	}
	
	private void resetClassTimeSlot() {
		hourDropDown.setValue(null);
		minuteDropDown.setValue(null);
		amPmDropDown.setValue(null);
		durationDropDown.setValue(null);
		datePicker.setValue(null);
	}
}
