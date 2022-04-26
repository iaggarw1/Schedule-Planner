package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	private static Stage displayedStage;
	static Parent mainPane;
	static Parent addClassPane;
	static Parent addAssignmentPane;
	private MewTwoLayoutController m2Controller;
	private AssignmentCreationLayoutController assignmentController;
	public Main() {
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MewTwoLayout.fxml"));
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("AssignmentCreationLayout.fxml"));
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			mainPane = loader.load();
			addClassPane = FXMLLoader.load(getClass().getResource("ClassCreationLayout.fxml"));
			addAssignmentPane = loader2.load();
			primaryStage.show();
			SplitPane root = FXMLLoader.load(getClass().getResource("MewTwoLayout.fxml"));
			Scene scene = new Scene(root);
			GridPane calendar = (GridPane) root.lookup("#calendar");
			primaryStage.setTitle("Main");
			primaryStage.setScene(scene);
			primaryStage.show();
			displayedStage = primaryStage;
			assignmentController = loader2.getController();
			m2Controller = loader.getController();
			assignmentController.setMainPage(m2Controller);


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
		}
	}
}
