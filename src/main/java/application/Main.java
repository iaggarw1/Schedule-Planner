package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	private static Stage displayedStage;
	static Parent mainPane;
	static Parent addClassPane;
	static Parent addAssignmentPane;
	static Parent assignmentDescription;
	
	public Main() {
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			mainPane = FXMLLoader.load(getClass().getResource("MewTwoLayout.fxml"));
			addClassPane = FXMLLoader.load(getClass().getResource("ClassCreationLayout.fxml"));
			addAssignmentPane = FXMLLoader.load(getClass().getResource("AssignmentCreationLayout.fxml"));
			assignmentDescription = FXMLLoader.load(getClass().getResource("AssignmentDescription.fxml"));
			primaryStage.show();
			SplitPane root = FXMLLoader.load(getClass().getResource("MewTwoLayout.fxml"));
			Scene scene = new Scene(root);
			GridPane calendar = (GridPane) root.lookup("#calendar");
			primaryStage.setTitle("Main");
			primaryStage.setScene(scene);
			primaryStage.show();
			displayedStage = primaryStage;
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void switchScene(int sceneNum) {
		switch(sceneNum) {
			case 0:
				displayedStage.getScene().setRoot(mainPane);
				displayedStage.setTitle("Main");
				break;
			case 1:
				displayedStage.getScene().setRoot(addClassPane);
				displayedStage.setTitle("Add Class");
				break;
			case 2:
				displayedStage.getScene().setRoot(addAssignmentPane);
				displayedStage.setTitle("Add Assignment");
				break;
			case 3:
				displayedStage.getScene().setRoot(assignmentDescription);
				displayedStage.setTitle("Assignment Description");
				break;
		}
	}
}
