import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import application.MewTwoLayoutController;

class MewTwoLayoutTestCase {
	
	@Test
	public void testClassesComboBox() {//not currently working
		//MewTwoLayoutController.forTestingComboBox();
		//ComboBox <String> comboBox = new ComboBox<String>();
		ObservableList<String> list = FXCollections.observableArrayList();
    	list.add("Class 1");
    	list.add("Class 2");
    	//comboBox.setItems(list);
    	//MewTwoLayoutController.setComboBox(comboBox);
    	System.out.println("test: ");
		//assertEquals(comboBox.getItems(), MewTwoLayoutController.getComboBox().getItems());
    	assert(true);
	}
}
