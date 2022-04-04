package application;
import java.awt.TextField;
import java.net.URL;
	import java.util.ResourceBundle;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.Initializable;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;	

public class DropDownListController implements Initializable {

	    @FXML
	    private ComboBox <String> comboBox;
	    
	    @FXML
	    private TextField textInput;
	    
	    /*
	    @FXML
	    void Select(ActionEvent event) {
	    	String s = comboBox.getSelectionModel().getSelectedItem().toString();
	    	label.setText(s);
	    }
	    */
	
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	ObservableList<String> list = FXCollections.observableArrayList("Physics", "Math", "Science");
	    	comboBox.setItems(list);
	    }    
	    
	    @FXML
	    void getComboBoxInfo(ActionEvent event) {
	    	System.out.println(comboBox.getValue());
	    }
	    
	}
