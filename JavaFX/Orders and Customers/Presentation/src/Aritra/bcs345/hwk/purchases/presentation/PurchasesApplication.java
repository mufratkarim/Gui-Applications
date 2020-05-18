package Aritra.bcs345.hwk.purchases.presentation;

import java.io.IOException;

import javax.swing.JFileChooser;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class PurchasesApplication extends Application {

	   @Override
	   public void start(Stage primaryStage) {
	      Parent root = null;
	      Scene scene = null;
	      
	      try {
	         FXMLLoader loader= new FXMLLoader(getClass().getResource("Main.fxml"));
	         root = loader.load();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      // Put the root containing the FXML into the scene
	      scene = new Scene(root, 420, 500);
	      
	      primaryStage.setTitle("Orders and Customers");
	      primaryStage.setScene(scene);
	      
	      primaryStage.show();

	      

	   }

}
