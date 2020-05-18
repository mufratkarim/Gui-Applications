package labButtons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class ColorController {
	
	@FXML
	Button yellowButton;
	Button redButton;
	Button greenButton;
	
	@FXML
	private AnchorPane rootAnchorPane;
	
	@FXML
	private ComboBox<String> colorComboBox;
	
	
	@FXML
	protected void handleyellowButtonAction() {
		System.out.printf("Yellow Button Pressed\n");
		rootAnchorPane.setStyle("-fx-background-color: #FFFF00;");  
	}
	
	@FXML
	protected void handleRedButtonAction() {
		System.out.printf("Red Button Pressed\n");
		rootAnchorPane.setStyle("-fx-background-color: #FF0000;");  
	}
	
	@FXML
	protected void handleGreenButtonAction() {
		System.out.printf("Green Button Pressed\n");
		rootAnchorPane.setStyle("-fx-background-color: #00FF00;");  
	}
	
	@FXML
	protected void handleColorComboBoxAction(ActionEvent event) {
		
	      String selectedItem = colorComboBox.getSelectionModel().getSelectedItem();
	      if (selectedItem.equals("Red"))  {
	    	  rootAnchorPane.setStyle("-fx-background-color: #FF0000;");
	      }
	      
	      else if (selectedItem.equals("Yellow"))  {
	    	  rootAnchorPane.setStyle("-fx-background-color: #FFFF00;"); 
		    
	      }
	      
	      
	      else if (selectedItem.equals("Green"))  {
	    	  
	    	  rootAnchorPane.setStyle("-fx-background-color: #00FF00;"); 
		     
	      }

	      
		System.out.printf("ComboBox Button Pressed\n");
		//rootAnchorPane.setStyle("-fx-background-color: #00FF00;");  
	}
	
	


}
