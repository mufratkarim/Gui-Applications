package Aritra.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import Aritra.bcs345.hwk.purchases.business.Address;
import Aritra.bcs345.hwk.purchases.business.Product;
import Aritra.bcs345.hwk.purchases.business.Customer;
import Aritra.bcs345.hwk.purchases.business.Purchase;
import javafx.application.*;

/**
 * Contains main program code. This class generates the main class of the presentation 
 * package of assignment2.
 * 
 * @author Mufrat Karim Aritra
 * @version 1.0
 * @since 9/27/2019
 * 
 * Following FeedBack from Arthur Hoskey from Assignment 4
 *
 *
 *
 *Read. Program crashes. Missing code to read in the purchase count from the input file. 
 *The input file required in the homework specifications contains a purchase count after the customer data.
 *After reading in the purchase count the purchase array should be reallocated. 
 *This is necessary so that we are guaranteed to be able to store all the purchase being read from the file. 
 *After reallocating the array you will also need code that loops and calls new for every element of the array.
 *
 *
 *
 *Read. The price should be read in as a double (not as an int).
 *
 *
 *
 *Product.Read. Need to consume the newline character after reading the price (in Product.Read). 
 *A string will be read after price (in another method) and this will cause an InputMismatchException. Similar issue with reading an int in Purchase.Read and PurchaseCollection.Read.
 *
 *
 *Write. Should write out the number of purchases (from the purchase array length) in the output file.
 *
 *
 *
 *GetMaxPurchase. This method should declare a max purchase instance before the loop (set it to the 0 element). 
 *Inside the loop just check the current element cost against the max instance cost (cost is quantity * price). 
 *If the current element is higher then set that one to be the max instance. 
 *After the loop just return max instance. 
 *You cannot assume that the max purchase will be in the first element of the array. 
 *It needs work wherever the max cost purchase is in the array.
 *
 *
 *
 *GetByIndex. Should use the throw keyword to throw an exception if the index is invalid. 
 *There needs to be an if statement that checks if the index is in the valid range of indexes. If the index is not valid it should create an instance of ArrayIndexOutOfBoundsException and then use the throw keyword to actually throw the exception. Check slide 46 of the exceptions slides for an example of using the throw keyword to throw an exception.
 *
 *
 *
 *ReadJSON. Incorrect. 
 *The pc2 instance correctly gets the data from the JSON file but that data needs to be put into the current instance. 
 *You did get the customer from pc2 and correctly put it into the customer member variable but you did not do that for the purchase array (need to get the purchase array from pc2 and put it in the purchase array member variable).
 *
 *
 *
 *toString. Incorrect. 
 *It will only ever have two purchase in the generated string. It needs to work no matter how many purchases are in the array.
 *
 *
 *Note: ShowUI Option 5. There is no need to call GetByIndex twice. Just remove line 118. Did not take off points for this.

*/



public class Driver {
	/**
     * This is the starting point for the program.
     * @param args
     */
	public static void main(String[] args) {
/*	Commenting out all of the following lines 
 * 	So that only GUI Application will initiate 	
 * 
		System.out.printf("%-10s\n%-10s\n", "Choose UI", "---------");
		System.out.printf("1 –  CustomerPurchaseConsoleUI\n"
				+ "2 –  PurchaseCollectionConsoleUI\n"
				+ "3 –  PurchasesGraphicalUI\n" 
				+ "4 –  Exit\n"
				+ "Enter Choice:\n");
		
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		
		while (option != 1 && option != 2 && option != 3 && option != 4) {
			
			System.out.printf("%-10s\n%-10s\n", "Choose UI", "---------");
			System.out.printf("Incorrect input. Enter 1/2/3/4: \n");
			input = new Scanner(System.in);
			option = input.nextInt();
			
		}
		
		if (option == 1) {
			
			CustomerPurchaseConsoleUI menu = new CustomerPurchaseConsoleUI();
			menu.ShowUI();
				
		}
		
		else if (option == 2) {
			PurchaseCollectionConsoleUI menu2 = new PurchaseCollectionConsoleUI();
			menu2.ShowUI();
		}
		
		else if (option == 3) {*/
			
			PurchasesGraphicalUI pg = new PurchasesGraphicalUI();
			pg.ShowUI();
		/*
		 * }
		 * 
		 * else if (option == 4) {
		 * 
		 * System.out.printf("Bye!"); System.exit(option); }
		 * 
		 */
		
	}

}

