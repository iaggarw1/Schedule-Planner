package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.Formatter;
import java.util.ResourceBundle;

import application.DropDownListIconController.StatusListCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
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
	private int icon = 0;
	private Color color = new Color(0,0,0,1);
	private String className = "";
	private String image1, image2, image3, image4, image5, image6, image7, image8;
	private ObservableList<Image> imageList;
	private static ComboBox<String> tempComboBox = new ComboBox<String>();
	
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
	@FXML
    private ComboBox <Image> iconDropDown;
	@FXML
    private ComboBox <String> editBox;
	
	@FXML
	private ColorPicker cp;
	@FXML
	void editSelect(ActionEvent event) {
		updateClassInfo(editBox.getSelectionModel().getSelectedIndex());
	}
	
	public void initialize() {
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
    	
    	/* */
    	/* Create strings for the images using getClassLoader() */
    	createIconStrings();
    	/* Create ObservableList of images, added to the comboBox */
    	imageList = FXCollections.observableArrayList();
    	/* Add images to observableList */
    	addIconImageList();
    	
		iconDropDown.setButtonCell(new StatusListCell()); 		/* Sets the icon in the box to the selected icon by the user*/
    	iconDropDown.setCellFactory(c-> new StatusListCell()); 	/* Sets rendering data within each row */
    	//comboBox.getSelectionModel().select(0); 			/* This defaults the selection to the first image in the list, not sure if needed, keep in case */
    	/* */
    	
	}
	
	@FXML
	public void changeColor(ActionEvent event) {
		Color c = cp.getValue();
		System.out.println(c);
		color = c;
		System.out.println(color);
	}
	
	@FXML
	public void switchToMainScene() {
		MewTwoLayoutController.updateComboBox();
		Main.switchScene(0);
	}
	/* */
	public void updateClassInfo(int selection) {
		ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
		System.out.println("Updating Text Fields...");
		int temp = 0;
		
		String className = null;
		String location = null;
		int iconNumber = -1;
		int duration = 0;
		Color tempColor = null;
		ArrayList<Calendar>mt = null;
		
		for(Class tempClass : classes) {	/* Iterate until reach the class for selected value */
			if(selection == temp) {
				className = tempClass.getClassName();
				location = tempClass.getMeetingLoc();
				iconNumber = tempClass.getIcon();
				tempColor = tempClass.getColor();
				duration = tempClass.getClassDuration();	
				mt = tempClass.getMeetingTimes();
			}
			temp++;
		}
		
		/* Set text fields to selection */
		classNameID.setText(className);
		meetingLocationID.setText(location);
		iconDropDown.getSelectionModel().select(iconNumber);	
		duration = duration/15;
		durationDropDown.getSelectionModel().select(duration-1);
		datePicker.setValue(null);
		cp.setValue(tempColor);
		//Date d1 = (mt.get(0).getTime());
		//LocalDate date1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		//datePicker.setValue(date1);
		/* Replace class element */
		//classes.remove(selection);
	}
	
	public void refreshComboBox() {
		editBox.setItems(tempComboBox.getItems());
		//comboBox.getItems().addAll(tempComboBox.getItems());
	}
	public static void updateComboBox() {
		ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
		ObservableList<String> classList = FXCollections.observableArrayList();
		for(Class tempClass : classes) {
			classList.add(tempClass.getClassName());
		}
    	tempComboBox.setItems(classList);
	}
	private void addIconImageList() {
		Image lab = new Image(image1);
    	Image math = new Image(image2);
    	Image art = new Image(image3);
    	Image books = new Image(image4);
    	Image sports = new Image(image5);
    	Image guitar = new Image(image6);
    	Image programming = new Image(image7);
    	Image history = new Image(image8);
    	imageList.addAll(lab, math, art, books, sports, guitar, programming, history);
    	iconDropDown.getItems().addAll(imageList);
	}
	
	private void createIconStrings() {
		image1 = getClass().getClassLoader().getResource("lab.png").toString();
		image2 = getClass().getClassLoader().getResource("math.png").toString();
    	image3 = getClass().getClassLoader().getResource("art.png").toString();
    	image4 = getClass().getClassLoader().getResource("books.png").toString();
    	image5 = getClass().getClassLoader().getResource("sports.png").toString();
    	image6 = getClass().getClassLoader().getResource("guitar.png").toString();
    	image7 = getClass().getClassLoader().getResource("programming.png").toString();
    	image8 = getClass().getClassLoader().getResource("history.png").toString();

	}
	
	 public class StatusListCell extends ListCell<Image> {
	    	private final ImageView imageView;
	    	public StatusListCell() {
	    		//System.out.println("Initializing");
	    		setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    		imageView = new ImageView();
	    	}
		@Override
		protected void updateItem(Image item, boolean empty) {
			super.updateItem(item, empty);
			if(empty) {
				//System.out.println("Printing name " + item);
				setGraphic(null);
			}else {
				//System.out.println("Printing image");
				imageView.setImage(item);
				//imageView.setFitWidth(40);
				//imageView.setFitHeight(40);
				setGraphic(imageView);
			}
		}
	}
	 
	@FXML
    void getIconDropDownInfo(ActionEvent event) {
    	int selectedIndex = iconDropDown.getSelectionModel().getSelectedIndex();
    	System.out.println("Printing selection value: " + selectedIndex);
    	icon = iconDropDown.getSelectionModel().getSelectedIndex();
    }
	/* */
	
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
		tempCalendar.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), tempHour, tempMin);
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
		if(hourDropDown.getValue() != "hr:" && minuteDropDown.getValue() != "Min:") {
			String tempDuration = durationDropDown.getValue();
			if(tempDuration != null) {
				String[] splitDuration = tempDuration.split(":");
				String tempHrs, tempMins = "";
				tempHrs = splitDuration[0];
				tempMins = splitDuration[1];
				classDuration = Integer.valueOf(tempMins) + (Integer.valueOf(tempHrs) * 60);
			}
			Class tempClass = new Class(assignments, meetingTimes, meetingLoc, icon, color, className, classDuration);
			classes.add(tempClass);
			ClassCreationLayoutController.updateComboBox();
			
			addClassTimeSlot();

			resetScene();
		}
		else {
			System.out.println("Please fill in all of the fields");
		}
	}
	
	
	
	public static ArrayList<Class> getClasses(){
		return classes;
	}
	
	public void resetScene() {
		classNameID.clear();
		meetingLocationID.clear();
		iconDropDown.setValue(null);
		editBox.setValue(null);
		System.out.println("resetting: " + iconDropDown.getSelectionModel().getSelectedIndex());
		
	}
	
	private void resetClassTimeSlot() {
		hourDropDown.setValue("Hr:");
		minuteDropDown.setValue("Min:");
		amPmDropDown.setValue("AM");
		durationDropDown.setValue(null);
		datePicker.setValue(null);
		iconDropDown.setValue(null);
		editBox.setValue(null);
		cp.setValue(null);
	}
}
