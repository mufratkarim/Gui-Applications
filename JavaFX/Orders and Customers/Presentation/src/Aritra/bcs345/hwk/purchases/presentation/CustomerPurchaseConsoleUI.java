/**
 * Contains a class to generate the Customer Purchase menu
 */

package Aritra.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import Aritra.bcs345.hwk.purchases.business.Customer;
import Aritra.bcs345.hwk.purchases.business.Purchase;


public class CustomerPurchaseConsoleUI {
	
	public void ShowUI() {
		
		/* Creating only instance of Customer and Purchase */
		Customer c1= new Customer();
		Purchase p1= new Purchase();
		
		
		System.out.printf("%-20s\n%-20s\n", "Customer/Purchase UI", "--------------------");
		System.out.printf("1 –  Read customer from file\n"
				+ "2 –  Read customer from file as JSON\n"
				+ "3 –  Write customer to file\n"
				+ "4 –  Write customer to file as JSON\n"
				+ "5 –  Show customer info on screen\n"
				+ "6 –  Read purchase from file\n"
				+ "7 –  Read purchase from file as JSON\n" 
				+ "8 -  Write purchase to file\n" 
				+ "9 -  Write purchase to file as JSON\n" 
				+ "10 – Show purchase info on screen\n"
				+ "11 - Exit\n" + 
				"Enter Choice:\n");
		
		
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		
		
		while (option != 11) {
			/* Option not equaling to 11, so that when someone enters 11, program will stoop */
			
			if (option >= 1 && option <= 10) {
				
				/* Displaying  all the options except for 5 and 10, because we don't need to
				 * ask for filename for option 5 and 10 */
				
				if (option != 5 && option != 10) {
					
					System.out.println("Enter the File Name: ");
					Scanner s = new Scanner(System.in);
					String FileName = s.nextLine();
					
					switch (option) {
		
					case 1:
						Scanner inputFile;
						try {
							inputFile = new Scanner(new FileReader(FileName));
							c1.Read(inputFile);
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 2:
						FileReader inputJSONFile;
						try {
							inputJSONFile = new FileReader(FileName);
							c1.ReadJSON(inputJSONFile);
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 3:
						PrintStream outputFile;
						try {
							outputFile = new PrintStream(FileName);
							c1.Write(outputFile);
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 4:
						PrintStream outputJSONFile;
						try {
							outputJSONFile = new PrintStream(FileName);
							c1.WriteJSON(outputJSONFile);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 6:
						Scanner inputFile2;
						try {
							inputFile2 = new Scanner(new FileReader(FileName));
							p1.Read(inputFile2);
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;
						
					case 7:
						FileReader inputJSONFile2;
						
						try {
							inputJSONFile2 = new FileReader(FileName);
							p1.ReadJSON(inputJSONFile2);
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						break;
						
					case 8:
						
						PrintStream outputFile2;
						
						try {
							outputFile2 = new PrintStream(FileName);
							p1.Write(outputFile2);
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
						
					case 9:
						
						PrintStream outputJSONFile2;
						
						try {
							outputJSONFile2 = new PrintStream(FileName);
							p1.WriteJSON(outputJSONFile2);
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
					
					}
						
				}
				
				/* Writing both of the option 5 & 10 statement together in order to prevent over-crowding*/
				else if (option == 5) { System.out.printf(c1.toString()); }
				else if (option == 10) { System.out.printf(p1.toString()); }
				
				System.out.println("\nFINISHED!!!!TAKING YOU BACK TO PREVIOUS MENU\n ");
				System.out.printf("%-20s\n%-20s\n", "Customer/Purchase UI", "--------------------");
				System.out.printf("1 –  Read customer from file\n"
						+ "2 –  Read customer from file as JSON\n"
						+ "3 –  Write customer to file\n"
						+ "4 –  Write customer to file as JSON\n"
						+ "5 –  Show customer info on screen\n"
						+ "6 –  Read purchase from file\n"
						+ "7 –  Read purchase from file as JSON\n" 
						+ "8 -  Write purchase to file\n" 
						+ "9 -  Write purchase to file as JSON\n" 
						+ "10 – Show purchase info on screen\n"
						+ "11 - Exit\n" + 
						"Enter Choice:\n");
				
				input = new Scanner(System.in);
				option = input.nextInt();
				
			}
			
			else {
				System.out.println("\n\nWrong Number!! Enter a valid number between 1-11(Exit for 11): ");
				input = new Scanner(System.in);
				option = input.nextInt();
			}
			
			
		}
		
		System.out.println("Successfully Exited!!!");

	}
}
