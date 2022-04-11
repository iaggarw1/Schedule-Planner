package application;
import java.awt.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;	
import javafx.scene.image.*;


public class DropDownListIconController implements Initializable{
		
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
	    private ComboBox <Image> comboBox;
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {	    	
	    	
	    	/* Create strings for the images using getClassLoader() */
	    	String image1 = getClass().getClassLoader().getResource("lab.png").toString();
			String image2 = getClass().getClassLoader().getResource("math.png").toString();
			//System.out.println(image1);
	    	String image3 = getClass().getClassLoader().getResource("art.png").toString();
	    	String image4 = getClass().getClassLoader().getResource("books.png").toString();
	    	String image5 = getClass().getClassLoader().getResource("sports.png").toString();
	    	String image6 = getClass().getClassLoader().getResource("guitar.png").toString();
	    	
	    	/* Create ObservableList of images, added to the comboBox */
	    	ObservableList<Image> list = FXCollections.observableArrayList();
	    	
	    	/* Create images & add to observableList*/
	    	Image lab = new Image(image1);
	    	Image math = new Image(image2);
	    	Image art = new Image(image3);
	    	Image books = new Image(image4);
	    	Image sports = new Image(image5);
	    	Image guitar = new Image(image6);
	    	list.addAll(lab, math, art, books, sports, guitar);
	    	comboBox.getItems().addAll(list);
	    	
	    	
			comboBox.setButtonCell(new StatusListCell()); 		/* Sets the icon in the box to the selected icon by the user*/
	    	comboBox.setCellFactory(c-> new StatusListCell()); 	/* Sets rendering data within each row */
	    	//comboBox.getSelectionModel().select(0); 			/* This defaults the selection to the first image in the list, not sure if needed, keep in case */
	    }    
	   
	    /* Use this function to grab the users selection value of icon */
	    @FXML
	    void getComboBoxInfo(ActionEvent event) {
	    	int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
	    	System.out.println("Printing selection value: " + selectedIndex);
	    }
	}

