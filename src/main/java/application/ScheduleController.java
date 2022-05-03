package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ScheduleController {
	private ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
	private ArrayList<Rectangle> class_box;
	private ArrayList<Text> class_text;
	
    @FXML
    void switchToMain(ActionEvent event) {
    	Main.switchScene(0);
    }
    
    public void initialize() {
    	for(int i = 0; i < classes.size(); i++) {
    		Rectangle r = new Rectangle(104, 90+(50*i), 100, 30);
    		r.setFill(classes.get(i).getColor());
    		r.setVisible(true);
    	}
    }

	public void update() {
		// TODO Auto-generated method stub
		classes = ClassCreationLayoutController.getClasses();
		for(int i = 0; i < classes.size(); i++) {
    		Rectangle r = new Rectangle(104, 90+(50*i), 100, 30);
    		r.setFill(classes.get(i).getColor());
    		r.setVisible(true);
    	}
		System.out.println(classes);
	}

}
