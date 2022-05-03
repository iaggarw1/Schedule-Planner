package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ScheduleController {
	private ArrayList<Class> classes = ClassCreationLayoutController.getClasses();
	private ArrayList<Rectangle> class_box;
	private ArrayList<Text> class_text;
	
	@FXML
	private AnchorPane schedulePane;
	
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
    		Rectangle r = new Rectangle(104, 90+(50*i), 450, 45);
    		Text t = new Text(115, 115+(50*i), classes.get(i).toString());
    		Color class_color = classes.get(i).getColor();
    		t.setFill(class_color);
    		
    		if(class_color.getBrightness() > 0.5) {
    			r.setFill(Color.GRAY);
    		} else {
        		r.setFill(Color.WHITE);
    		}

    		r.setVisible(true);
    		schedulePane.getChildren().add(r);
    		schedulePane.getChildren().add(t);
    	}
		System.out.println(classes);
	}
	

	
}
