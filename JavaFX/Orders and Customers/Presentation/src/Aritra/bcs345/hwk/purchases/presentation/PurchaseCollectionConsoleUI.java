/**
 * Contains a class to generate the Customer Purchase menu
 */

package Aritra.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import Aritra.bcs345.hwk.purchases.business.PurchaseCollection;

public class PurchaseCollectionConsoleUI {
	
public void ShowUI() {
	
		/* Creating only one instance of Purchase Collection */
		PurchaseCollection pc1= new PurchaseCollection();
	
		System.out.printf("%-20s\n%-20s\n", "Customer/Purchase UI", "--------------------");
		System.out.printf("1 –  Read PurchaseCollection from file\n"
				+ "2 –  Read PurchaseCollection from file as JSON\n"
				+ "3 –  Write PurchaseCollection to file\n"
				+ "4 –  Write PurchaseCollection to file as JSON\n"
				+ "5 –  Show Purchase by index\n"
				+ "6 –  Show Maximum Purchase\n"
				+ "7 –  Show PurchaseCollection Report on Screen\n" 
				+ "8 -  Show PurchaseCollection toString on Screen\n" 
				+ "9 -  Exit\n" + 
				"Enter Choice:\n");
		
		
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		
		
		while (option != 9) {
			/* Option not equaling to 9, so that when someone enters 9, program will stoop */
			
			if (option >= 1 && option <= 8) {
				
				if (option <= 4) {
					
					System.out.println("Enter the File Name: ");
					Scanner s = new Scanner(System.in);
					String FileName = s.nextLine();
					
					switch (option) {
		
					case 1:
						Scanner inputFile;
						try {
							inputFile = new Scanner(new FileReader(FileName));
							pc1.Read(inputFile);
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 2:
						FileReader inputJSONFile;
						try {
							inputJSONFile = new FileReader(FileName);
							pc1.ReadJSON(inputJSONFile);
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 3:
						PrintStream outputFile;
						try {
							outputFile = new PrintStream(FileName);
							pc1.Write(outputFile);
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 4:
						PrintStream outputJSONFile;
						try {
							outputJSONFile = new PrintStream(FileName);
							pc1.WriteJSON(outputJSONFile);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
					}		
					
				}
				
				else if (option >= 5) {

					switch (option) {
		
					case 5:
						
						System.out.printf("Enter a valid index: ");
						
						// 6th Comment Fixed...
						try {
							Scanner index_input = new Scanner(System.in);
							int index = index_input.nextInt();
							// Fixed the additional Note
							System.out.println(pc1.GetByIndex(index));
						}
						
						catch (ArrayIndexOutOfBoundsException a) {
							System.out.printf("\nInvalid index!!!\n");
						}
						
						break;
						
					case 6:
						System.out.println(pc1.GetMaxPurchase());
						
						break;
						
					case 7:
						
						PrintStream ps = new PrintStream(System.out);
						pc1.Report(ps);
						
						break;
						
					case 8:
						
						System.out.println(pc1.toString());
						
						break;
						
					}
				}
				
				System.out.println("\nTAKING YOU BACK TO MAIN MENU\n ");
				System.out.printf("%-20s\n%-20s\n", "Customer/Purchase UI", "--------------------");
				System.out.printf("1 –  Read PurchaseCollection from file\n"
						+ "2 –  Read PurchaseCollection from file as JSON\n"
						+ "3 –  Write PurchaseCollection to file\n"
						+ "4 –  Write PurchaseCollection to file as JSON\n"
						+ "5 –  Show Purchase by index\n"
						+ "6 –  Show Maximum Purchase\n"
						+ "7 –  Show PurchaseCollection Report on Screen\n" 
						+ "8 -  Show PurchaseCollection toString on Screen\n" 
						+ "9 -  Exit\n" + 
						"Enter Choice:\n");
				
				input = new Scanner(System.in);
				option = input.nextInt();
				
			}
			
			else {
				System.out.println("\n\nWrong Number!! Enter a valid number between 1-9(Exit for 9): ");
				input = new Scanner(System.in);
				option = input.nextInt();
			}
			
			
		}
		
		System.out.println("Successfully Exited!!!");

	}

}
