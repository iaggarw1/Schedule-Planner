package application;

import javafx.fxml.FXML;
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

	private ArrayList<Circle> circle_list = new ArrayList<Circle>();
	int y = 131;
	int x = 166;
	private Date date = new Date();
	private Calendar cal = Calendar.getInstance();
	
	public void initialize() {
		int dayNum = 1;

		//Get Date
		cal.setTime(date);
		
		int currMonth = cal.get(Calendar.MONTH);
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
		currentDate.setText(monthString + " " + cal.get(Calendar.YEAR));
		setFullDate(monthString); /* Set full date text field to current date*/
		
		//Fill calendar with dates
		int dayCount = 0; /* Used to highlight current day */
		GridPane.setHalignment(calPane, HPos.CENTER);
		for (int j = 1; j <= calPane.getRowCount(); j++) {
			for (int i = 1; i <= calPane.getColumnCount(); i++) {
				dayCount ++;
				Rectangle rect = new Rectangle(81,20);
				GridPane.setHalignment(rect, HPos.CENTER);
				if(dayCount == cal.get(Calendar.DAY_OF_MONTH)) {
					rect.setFill(Color.AQUAMARINE);
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
		c1.setVisible(false);
		c2.setVisible(false);
		c3.setVisible(false);
		circle_grid = new Circle[calPane.getRowCount()][calPane.getColumnCount()];
		ObservableList<String> list = FXCollections.observableArrayList();
    	comboBox.setItems(list);    	
	}
	
	private void setFullDate(String monthString) {
		String dow; 
		int temp = cal.get(Calendar.DAY_OF_WEEK); /* Used to assign dow to a string of DOW */
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
		fullDate.setText(dow + " " + monthString + " " + cal.get(Calendar.DAY_OF_MONTH) + ", " + cal.get(Calendar.YEAR)); /* Set text to full date */
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
			System.out.println("Row: " + (row + 1) + " Col: " + (col + 1));
			if(circle_grid[row][col] == null) {
				Circle c = new Circle();
				GridPane.setHalignment(c, HPos.LEFT);
				Color color = Color.web("0x009eff");
				c.setRadius(7);
				c.setFill(color);
				c.setVisible(true);
				GridPane.setColumnIndex(c, col);
				GridPane.setRowIndex(c, row);
				System.out.println(c.getCenterX());
				System.out.println(c.getCenterY());
				calPane.getChildren().add(c);
				circle_list.add(c);
				circle_grid[row][col] = c;
			} else {
				System.out.println("There is already a circle there");
			}
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
}
