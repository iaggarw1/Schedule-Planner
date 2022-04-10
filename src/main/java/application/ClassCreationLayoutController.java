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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class ClassCreationLayoutController {
	
	private static ArrayList<Class> classes = new ArrayList<Class>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private ArrayList<Calendar> meetingTimes = new ArrayList<Calendar>();
	private String meetingLoc = "";
	private String icon = "";
	private Color color = new Color(0,0,0,1);
	private String className = "";
	
	@FXML
	private TextField classNameID;//classNameID.getText();
	@FXML
	private TextField meetingLocationID;
	
	@FXML
	public void switchToMainScene() {
		MewTwoLayoutController.updateComboBox();
		Main.switchScene(0);
	}
	public void initiateClass() {//(ArrayList<Assignment> newAssignments, ArrayList<Calendar> newMeetingTimes, 
								 //String newMeetingLoc, String newIcon, Color newColor, String newClassName)
		
		if(!classNameID.getText().equalsIgnoreCase(className)) {
			className = classNameID.getText();
		}
		Class tempClass = new Class(assignments, meetingTimes, meetingLoc, icon, color, className);
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
}
