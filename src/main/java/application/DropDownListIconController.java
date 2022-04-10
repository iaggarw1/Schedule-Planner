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
	    		System.out.println("Initializing");
	    		setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    		imageView = new ImageView();
	    	}
		@Override
		protected void updateItem(Image item, boolean empty) {
			super.updateItem(item, empty);
			if(empty) {
				System.out.println("Printing name " + item);
				setGraphic(null);
			}else {
				System.out.println("Printing image");
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
	    	//ObservableList<String> items = FXCollections.observableArrayList("RUBY", "APPLE", "TWITTER");
	    	//listView.setItems(items);
	    	//ImageIcon image1 = new ImageIcon("/media/guitar.png");
	    	//ImageIcon image2 = new ImageIcon("/customer-project-mewtwo/media/guitar.png");
			//ObservableList<ImageIcon> list = FXCollections.observableArrayList(image1, image2);
			//comboBox.setItems(list);
	    	//comboBox = new ComboBox<>();
	    	String image3 = "file: media/guitar.png";
			String image1 = getClass().getClassLoader().getResource("guitarsmall.png").toString();
	    	String image2 = "/customer-project-mewtwo/media/guitar.png";
	    	ObservableList<Image> list = FXCollections.observableArrayList();
	    	Image img3 = new Image(image1);
	    	list.addAll(img3);
	    	comboBox.getItems().addAll(list);
	    	
	    	//StatusListCell statusList = new StatusListCell();
			comboBox.setButtonCell(new StatusListCell());
	    	comboBox.setCellFactory(c-> new StatusListCell());
	    	comboBox.getSelectionModel().select(0);;
	    }    
	   
	    /*
	    public class StatusListCell extends ListCell<String> {
	        protected void updateItem(String item, boolean empty){
	            super.updateItem(item, empty);
	            //setGraphic(null);
	            //setText(null);
	            /*
	            if(empty) {
	            	setText(null);
	            	setGraphic(null);
	            }
	            if(item!=null){
	                ImageView imageView = new ImageView(new Image(item));
	                imageView.setFitWidth(40);
	                imageView.setFitHeight(40);
	                setGraphic(imageView);
	                setText("a");
	            }
	        }

	    }*/
	    
	    private DefaultComboBoxModel<Icon> loadImages() {
	    	DefaultComboBoxModel<Icon> dm = new DefaultComboBoxModel<Icon>();
	    	dm.addElement(new ImageIcon("/customer-project-mewtwo/media/guitar.png"));
	    	return dm;
	    }
	    
	}

