package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;

import java.awt.TextField;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MewTwoLayoutController {
	
	private static ComboBox<String> tempComboBox = new ComboBox<String>();
	private Circle[][] circle_grid;
	@FXML
	private GridPane calPane;
	@FXML
	private Circle c1;
	@FXML
	private Circle c2;
	@FXML
	private Circle c3;
	@FXML
	private Text currentDate; 
	@FXML
	private Text fullDate;
	@FXML

	private AnchorPane assignmentTab;
	
	private ArrayList<Rectangle> assignmentObjects = new ArrayList<Rectangle>();
	@FXML
	private Text dowSlot1, dowSlot2, dowSlot3, dowSlot4, dowSlot5, dowSlot6, dowSlot7;
	private Calendar cal = Calendar.getInstance();
	//private Text[] dowSlots = {dowSlot1, dowSlot2, dowSlot3, dowSlot4, dowSlot5, dowSlot6, dowSlot7};
	private Text[] dowSlots = new Text[7];
	
	private ArrayList<Circle> circle_list = new ArrayList<Circle>();
	int y = 131;
	int x = 166;
	private Date date = new Date();
	public Calendar selectedDate = Calendar.getInstance();
	private LocalDate assignmentDate = LocalDate.now();

	FXMLLoader loader = new FXMLLoader(getClass().getResource("MewTwoLayout.fxml"));
	
	public void initialize() {
		dowSlots[0] = dowSlot1;
		dowSlots[1] = dowSlot2;
		dowSlots[2] = dowSlot3;
		dowSlots[3] = dowSlot4;
		dowSlots[4] = dowSlot5;
		dowSlots[5] = dowSlot6;
		dowSlots[6] = dowSlot7;
		int dayNum = 1;
		//Update Assignments Tab
		//updateAssignments();
		//Get Date
		selectedDate.setTime(date);
		int currMonth = selectedDate.get(Calendar.MONTH);
		String monthString;
		
		switch(currMonth) {
		case 0:
			monthString = "January";
			break;
		case 1:
			monthString = "Febuary";
			break;
		case 2:
			monthString = "March";
			break;
		case 3:
			monthString = "April";
			break;
		case 4:
			monthString = "May";
			break;
		case 5:
			monthString = "June";
			break;
		case 6:
			monthString = "July";
			break;
		case 7:
			monthString = "August";
			break;
		case 8:
			monthString = "September";
			break;
		case 9: 
			monthString = "October";
			break;
		case 10:
			monthString = "November";
			break;
		case 11:
			monthString = "December";
			break;
		default:
			monthString = "UNDEFINED";
		}
		currentDate.setText(monthString + " " + selectedDate.get(Calendar.YEAR));
		setFullDate(monthString); /* Set full date text field to current date*/
		
		//Fill calendar with dates
		int dayCount = 0; /* Used to highlight current day */
		GridPane.setHalignment(calPane, HPos.CENTER);
		for (int j = 1; j <= calPane.getRowCount(); j++) {
			for (int i = 1; i <= calPane.getColumnCount(); i++) {
				dayCount ++;
				Rectangle rect = new Rectangle(81,20);
				GridPane.setHalignment(rect, HPos.CENTER);
				if(dayCount == selectedDate.get(Calendar.DAY_OF_MONTH)) {
					rect.setFill(Color.YELLOW);
				}
				else {
					rect.setFill(Color.WHITE);
					
				}
				if (dayNum <= 31) {
					Text tempDay = new Text(Integer.toString(dayNum));
					dayNum++;
					GridPane.setHalignment(tempDay, HPos.CENTER);
					calPane.add(rect, i-1, j-1);
					calPane.add(tempDay, i - 1, j - 1);
				} else {
					//Break for loop
					i = calPane.getColumnCount() + 2;
					j = calPane.getRowCount() + 2;
					break;
				}
			}
		}
		
		//changes days of week to align with the correct dates
		for(int dayOfMonth = 1; dayOfMonth <= 7; dayOfMonth++) {
			//System.out.println(cal.get(Calendar.YEAR) + " " + cal.get(Calendar.MONTH)+1 + " " + dayOfMonth);
			//System.out.printf("Day of month: %d \n", dowSlots[dayOfMonth- 1]);
			LocalDate testDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, dayOfMonth);//year, month, day
			String tempS = testDate.getDayOfWeek().toString();
			dowSlots[dayOfMonth - 1].setText(tempS);
		}
		
		c1.setVisible(false);
		c2.setVisible(false);
		c3.setVisible(false);
		circle_grid = new Circle[calPane.getRowCount()][calPane.getColumnCount()];
		ObservableList<String> list = FXCollections.observableArrayList();
    	comboBox.setItems(list);   
    	getClass().getClassLoader();
    	updateAssignments();
	}
	
	
	private void setFullDate(String monthString) {
		String dow; 
		int temp = selectedDate.get(Calendar.DAY_OF_WEEK); /* Used to assign dow to a string of DOW */
		switch(temp) {
		case 1:
			dow = "Sunday";
			break;
		case 2:
			dow = "Monday";
			break;
		case 3:
			dow = "Tuesday";
			break;
		case 4:
			dow = "Wednesday";
			break;
		case 5:
			dow = "Thursday";
			break;
		case 6:
			dow = "Friday";
			break;
		case 7:
			dow = "Saturday";
			break;
		default:
			dow = "UNDEFINED";
		}	
		fullDate.setText(dow + " " + monthString + " " + selectedDate.get(Calendar.DAY_OF_MONTH) + ", " + selectedDate.get(Calendar.YEAR)); /* Set text to full date */
		//System.out.println(cal.getTime().toString());
	}

	public void refreshComboBox() {
		comboBox.setItems(tempComboBox.getItems());
		//comboBox.getItems().addAll(tempComboBox.getItems());
	}
	public static void updateComboBox() {

		ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
		ObservableList<String> classList = FXCollections.observableArrayList();
		for(Class tempClass : classes) {
			classList.add(tempClass.getClassName());
		}
    	tempComboBox.setItems(classList);
    	AssignmentCreationLayoutController.updateComboBox();
	}
	
	public void updateAssignments() {
		ArrayList<Assignment> allAssignments = AssignmentCreationLayoutController.getAssignments();
		ArrayList<Assignment> currentAssignments = new ArrayList<Assignment>();
		int currentYear = selectedDate.get(Calendar.YEAR);
		int currentMonth = selectedDate.get(Calendar.MONTH);
		int currentDay = selectedDate.get(Calendar.DAY_OF_MONTH);
		
		assignmentTab.getChildren().clear();
		//Find assignments of selected Date
		for (Assignment ass : allAssignments) {

			Calendar dueDate = ass.getDueDate();
			System.out.printf("Current Year:%d, CurrentMonth:%d, Current Day:%d\n", currentYear, currentMonth, currentDay);
			System.out.printf("Test Year:%d, Test Month:%d, Test Day:%d\n", dueDate.get(Calendar.YEAR), dueDate.get(Calendar.MONTH), dueDate.get(Calendar.DAY_OF_MONTH));

			if(dueDate.get(Calendar.YEAR)== currentYear && dueDate.get(Calendar.MONTH) + 1  == currentMonth
					&& dueDate.get(Calendar.DAY_OF_MONTH)  == currentDay) {
				currentAssignments.add(ass);
			}
		}

		//Display current assignments
		
		for (int i = 0; i < currentAssignments.size(); i++) {
			Rectangle tempRect = new Rectangle(26, 55 * (i) + 30, 525, 30);
			tempRect.setFill(Color.BLACK);
			Text tempText = new Text(26, (55) * i + 50, currentAssignments.get(i).getDueDate().getTime() + " " + currentAssignments.get(i).getAssignmentName() + " - " + currentAssignments.get(i).getDescription());

			tempText.setFill(Color.WHITE);
			try {
				if(assignmentTab != null) {
					assignmentTab.getChildren().add(tempRect);
					assignmentTab.getChildren().add(tempText);
				} else {
					System.out.print("assignment tab not found\n");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//tempRect.;
			//assignmentObjects.add(tempRect);
			



		}
	}
	@FXML
	public void deleteCircles(ActionEvent event) {
		c1.setVisible(false);
		c2.setVisible(false);
		c3.setVisible(false);
		
		for(Circle circ : circle_list) {
			circ.setVisible(false);
		}
	}

	@FXML
	public void drawCircles(ActionEvent event) {

		//System.out.print(AssignmentCreationLayoutController.getAssignments());
		for(Circle circ : circle_list) {
			circ.setVisible(true);
		}
	}

	@FXML
	public void drawNewCircle(MouseEvent event) {
		try {
			Node clickedNode = event.getPickResult().getIntersectedNode();
			
			int col = GridPane.getColumnIndex(clickedNode);
			int row = GridPane.getRowIndex(clickedNode);
			//System.out.println("Row: " + (row + 1) + " Col: " + (col + 1));
			if(circle_grid[row][col] == null) {
				Circle c = new Circle();
				GridPane.setHalignment(c, HPos.LEFT);
				Color color = Color.web("0x009eff");
				c.setRadius(7);
				c.setFill(color);
				c.setVisible(true);
				GridPane.setColumnIndex(c, col);
				GridPane.setRowIndex(c, row);
				//System.out.println(c.getCenterX());
				//System.out.println(c.getCenterY());
				//calPane.getChildren().add(c);
				circle_list.add(c);
				circle_grid[row][col] = c;
				//getNodeFromGridPane(calPane, col, row);
				

			} else {
				//System.out.println("There is already a circle there");
			}
			//Set Selected Date NEED TO UPDATE WHEN WE FIX DATE ISSUE
			//selectedDate.set(selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), (row) * 7 + col + 1);
			selectedDate.set(selectedDate.get(Calendar.YEAR), 4, (row) * 7 + col + 1);
			//System.out.printf("Date: %d\n", (row) * 7 + col + 1);
			//System.out.printf("Day: %d\n", selectedDate.get(Calendar.DAY_OF_MONTH));
			//Current Known issue: entering 31 doesn't update properly on the first time, but works after that. I'm bad at programming so I don't know why this happens
			updateAssignments();
		} catch (Exception err) {
			System.out.println(err);
			System.out.println("Missed the box");
		}

	}
	
	//dropdown list
	@FXML
    private ComboBox <String> comboBox;
    
    @FXML
    private TextField textInput;
    
    
    @FXML
    void getComboBoxInfo(ActionEvent event) {
    	System.out.println(comboBox.getValue());
    }
    @FXML
	public void switchToAddClassScene() {
		Main.switchScene(1);
	}
    @FXML
	public void switchToAddAssignmentScene() {
		Main.switchScene(2);
	}
    
    public static ComboBox <String> getComboBox(){
    	return tempComboBox;
    }

    public static void setComboBox(ComboBox <String> comboBox) {
    	tempComboBox = comboBox;
    }
    
    public static void forTestingComboBox() {
    	ObservableList<String> list = FXCollections.observableArrayList();
    	list.add("Class 1");
    	list.add("Class 2");
    	tempComboBox.setItems(list);
    }

    @FXML
    public void switchToDescription() {
    	Main.switchScene(3);
    }

}
