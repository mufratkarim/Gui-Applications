package Aritra.bcs345.hwk.purchases.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import Aritra.bcs345.hwk.purchases.business.PurchaseCollection;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class PurchasesController {

	@FXML
	PurchaseCollection pc1 = new PurchaseCollection();

	@FXML
	private AnchorPane rootAnchorPane;
	
	@FXML
	private VBox vBox = new VBox();
	
	@FXML
	protected MenuBar menuBar = new MenuBar();

	@FXML
	private Window w1;
	private Window w2;
	private Window w3;
	
	@FXML
	private TabPane tabPane;
	
	@FXML
	private Tab CustomerTab;
	
	@FXML
	private Tab PurchasesTab;
	
	@FXML
	private TextField FirstNameTextArea;
	
	@FXML
	private TextField LastNameTextArea;
	
	@FXML
	private TextField NumberTextArea;
	
	@FXML
	private TextField StreetTextArea;
	
	@FXML
	private TextField CityTextArea;
	
	@FXML
	private TextField StateTextArea;
	
	@FXML
	private TextField ZipTextArea;
	
	@FXML
	private ListView<String> listViewItems;

	@FXML
	protected void handleListViewItemsMouseClick(MouseEvent event) {

	   ObservableList<String> observableList = 
	      (ObservableList<String>) listViewItems.getItems();
	   
	   int selectedIndex = listViewItems.getSelectionModel().getSelectedIndex();

	   if (selectedIndex >= 0 && selectedIndex < observableList.size()) {
	      System.out.println("Selected Item: " + observableList.get(selectedIndex));
	   }
	}


	
	@FXML
	private File readFile;
	
	@FXML
	protected void handleOpenAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open PurchaseCollection File");
		
		// You can only open the file that follows the structure
		
		readFile = fileChooser.showOpenDialog(w1);
		
		Scanner inputFile;
		try {
			inputFile = new Scanner(new FileReader(readFile));
			pc1.Read(inputFile);
			
			this.FirstNameTextArea.setText(pc1.GetCustomer().getFirstName());
			this.LastNameTextArea.setText(pc1.GetCustomer().getLastName());
			this.NumberTextArea.setText(pc1.GetCustomer().getAddress().getNumber());
			this.StreetTextArea.setText(pc1.GetCustomer().getAddress().getStreet());
			this.CityTextArea.setText(pc1.GetCustomer().getAddress().getCity());
			this.StateTextArea.setText(pc1.GetCustomer().getAddress().getState());
			this.ZipTextArea.setText(pc1.GetCustomer().getAddress().getZip());
			  
			
			ObservableList<String> observableList = (ObservableList<String>) listViewItems.getItems();
			
			for (int i = 0; i < 4; i++) {
				
				// Beware !!!!
				// The Purchase File shouldn't have less than 4 purchases, or the program will crash! 
				// More than 4 purchase is fine, but no less than 4!!!
				String s = String.format("%d, %s, $%.2f", pc1.GetByIndex(i).getQuantity(), pc1.GetByIndex(i).getProduct().getDescription(), pc1.GetByIndex(i).getProduct().getPrice());
			
				observableList.set(i, s);
			
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@FXML
	protected void handleSaveAsAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save As PurchaseCollection");
		File file2 = fileChooser.showSaveDialog(w2);
		
		PrintStream outputFile;
		try {
			outputFile = new PrintStream(file2);
			pc1.Write(outputFile);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@FXML
	protected void handleSaveReportAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save As Report");
		File file3 = fileChooser.showSaveDialog(w3);
		
		PrintStream ps;
		try {
			ps = new PrintStream(file3);
			pc1.Report(ps);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	protected void handleExitAction(ActionEvent event) {
		System.exit(0);

	}
	
	
	
	

}
