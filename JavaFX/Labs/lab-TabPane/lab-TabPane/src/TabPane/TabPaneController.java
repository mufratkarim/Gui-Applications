package TabPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class TabPaneController {

	@FXML
	AnchorPane RootAnchorPane;
	
	@FXML
	TabPane tabPane;
	
	@FXML
	Tab MessagesTab;
	
	@FXML
	Tab InputDataTab;
	
	@FXML
	TextArea messagesTextArea;
	
	@FXML
	TextArea FirstNameTextArea;
	
	@FXML
	TextArea LastNameTextArea;
	
	@FXML
	Button InputButton;
	
	@FXML
	public void handleInputButtonAction(ActionEvent event) {

		    String first;
		    first = this.FirstNameTextArea.getText();
		    
		    String last;
		    last = this.LastNameTextArea.getText();
		    
		    String fullName;
		    fullName = first + " " + last + "\n";
		    
		    this.messagesTextArea.setText(fullName);
		   
	}
	
	
}
