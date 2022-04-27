package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class AssignmentDescriptionController {
	Assignment assignment = new Assignment();
	
	@FXML
	private TextArea description;

    @FXML
    private Text assignmentName;

    @FXML
    private Button backButton;

    @FXML
    private Text className;

    @FXML
    private Text dueDate;

    @FXML
    private Button saveButton;
    
    public void initialize() {
    	description.setText(assignment.getDescription());
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy\nHH:mm");
    	Calendar due = assignment.getDueDate();
        dueDate.setText(dateFormat.format(due.getTime()));

        assignmentName.setText(assignment.getAssignmentName());
        
        //className.setText(assignment.getClassInst().getClassName());
    }

    @FXML
    void saveAssignment(ActionEvent event) {
    	assignment.setDescription(description.getText());
    }

    @FXML
    void switchToMain(ActionEvent event) {
    	Main.switchScene(0);
    }

}
