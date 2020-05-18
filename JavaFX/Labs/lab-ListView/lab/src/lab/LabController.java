package lab;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LabController {
	
	@FXML
	AnchorPane rootAnchorPane;
	
	@FXML
	private ListView<String> listVieweNumbers;

	@FXML
	protected void handleListViewItemsMouseClick(MouseEvent event) {

	   ObservableList<String> observableList = 
	      (ObservableList<String>) listVieweNumbers.getItems();


	   int selectedIndex = listVieweNumbers.getSelectionModel().getSelectedIndex();



	   if (selectedIndex >= 0 && selectedIndex < observableList.size()) {
	      System.out.println("Selected Item: " + observableList.get(selectedIndex));
	   }
	}
	
	@FXML
	private TextField showNameTextField;
	
	@FXML
	private Button addShowButton;
	
	
	@FXML 
	   
	protected void handleButtonAction(ActionEvent event) {
	        System.out.println("Button pressed");
	        
	        String newShowName;
	        
	        // Get new Show Name from TextField
	        newShowName = this.showNameTextField.getText();
	        
	        // Get the collection from the list
	 	   ObservableList<String> items = 
	 		      (ObservableList<String>) listVieweNumbers.getItems();
	 	   
	 	   items.add(newShowName);
	 	   this.showNameTextField.clear();
	        
	        
	   }


	
	
	

}
