package lab;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LabApplication extends Application {
	
	   @Override
	   public void start(Stage primaryStage) {
	      Parent root = null;
	      Scene scene = null;
	      try {
	         FXMLLoader loader= new FXMLLoader(getClass().getResource("main.fxml"));
	         root = loader.load();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      // Put the root containing the FXML into the scene
	      scene = new Scene(root, 300, 700);
	      primaryStage.setScene(scene);
	      primaryStage.show();
	      
	      primaryStage.setTitle("Lab-ListView");
	   }


}
