/**
 * Contains a class to generate Purchase Collections 
 */

package Aritra.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Contains main program code. This class generates the PurchaseCollection class of the business 
 * package of assignment2.
 * 
 * @author Mufrat Karim Aritra
 * @version 1.0
 * @since 9/27/2019
 *
*/

public class PurchaseCollection {
	
/**
* * Private Variables with Data Hiding.
* */
	
	private Customer m_Customer;
	private Purchase[] m_PurchaseCollection;
	
/**
* * Default Constructor with no parameters.
* */
	
	public PurchaseCollection() {
		
		m_Customer = new Customer();
		
		m_PurchaseCollection = new Purchase[4];
		m_PurchaseCollection[0] = new Purchase();
		m_PurchaseCollection[1] = new Purchase();
		m_PurchaseCollection[1].getProduct().setDescription("Asus Zenfone 6");
		m_PurchaseCollection[1].getProduct().setPrice(835.99);
		m_PurchaseCollection[1].setQuantity(80);
		m_PurchaseCollection[2] = new Purchase();
		m_PurchaseCollection[2].getProduct().setDescription("Microsoft Surface Pro X");
		m_PurchaseCollection[2].getProduct().setPrice(1399.99);
		m_PurchaseCollection[3] = new Purchase();
		m_PurchaseCollection[3].getProduct().setDescription("WWE 2K20");
		m_PurchaseCollection[3].getProduct().setPrice(2);
		m_PurchaseCollection[3].setQuantity(1);
		
		
		
	}

/**
* * Setter and Getter for Customer.
* */	
	
	public void SetCustomer(Customer c) {
		
		m_Customer = c;
		
	}
	
	public Customer GetCustomer() {
		return m_Customer;
	}


/**
* * This method will return the Maximum Purchase or Null.
* */
	
	public Purchase GetMaxPurchase() {
		
		// 5th Comment was already fixed!!
		Purchase Max_Purchase = new Purchase();
		
		double max_cost = m_PurchaseCollection[0].getProduct().getPrice() * m_PurchaseCollection[0].getQuantity();
		Max_Purchase.setProduct(m_PurchaseCollection[0].getProduct());
		Max_Purchase.setQuantity(m_PurchaseCollection[0].getQuantity());
		
		for(int i = 0; i < m_PurchaseCollection.length; i++) {
			
			// Creating another temporary purchase cost
			// so that we can compare it with the first cost
			double cost_elements = m_PurchaseCollection[i].getProduct().getPrice() * m_PurchaseCollection[i].getQuantity();

			if (cost_elements > max_cost) {
		
				// When the temporary purchase cost exceeds the first cost
				// It will replace the highest cost value
				
				max_cost = cost_elements;
				
				// Max_Purchase should only have highest cost
				Max_Purchase.setProduct(m_PurchaseCollection[i].getProduct());
				Max_Purchase.setQuantity(m_PurchaseCollection[i].getQuantity());
				
			}
			
			// No Purchases in the array
			else if (m_PurchaseCollection.length == 0) {
				
				Max_Purchase = null;
		
			}
			
			// Assuming that the initial cost is the largest cost
			
		}
		
		System.out.printf("The Highest Calculated Cost of the Purchase is: $%.2f\n\nAdditional Purchase Info(Quantity, Description, Price/Unit):\n", max_cost);
		return Max_Purchase;
		
		
	}
	
/**
* * This method will return the Maximum Purchase or Null.
* */	
	// Throwing ArrayIndexOutOfBounds Exception
	public Purchase GetByIndex(int index) throws ArrayIndexOutOfBoundsException {
	
		if ((index > m_PurchaseCollection.length) && (index < 0)) {
			ArrayIndexOutOfBoundsException e;
			e = new ArrayIndexOutOfBoundsException();
			throw e;
		}

		return m_PurchaseCollection[index];
		
		
	
	}
	
/**
* * This method does Report function.
* */
	
	public void Report(PrintStream ps) {

	ps.printf("Purchase Report\n---------------\n%s %s\n%s %s\n%s, %s %s\n\n", m_Customer.getFirstName(), m_Customer.getLastName(), m_Customer.getAddress().getNumber(), m_Customer.getAddress().getStreet(), m_Customer.getAddress().getCity(), m_Customer.getAddress().getState(), m_Customer.getAddress().getZip());
	ps.printf("%-30s %15s %10s %15s\n", "Description", "Price", "Quantity", "Cost");
	ps.printf("%-30s %15s %10s %15s\n", "-----------", "-----", "--------", "----");
	
	try {
		double totalCost = 0;
		int totalQuantity = 0;
		
		for (int i = 0; i < m_PurchaseCollection.length; i++) {
			
			String description = m_PurchaseCollection[i].getProduct().getDescription();
			double price = m_PurchaseCollection[i].getProduct().getPrice();
			double cost = m_PurchaseCollection[i].getProduct().getPrice() * m_PurchaseCollection[i].getQuantity();
			int quantity = m_PurchaseCollection[i].getQuantity();
			
			ps.printf("%-30s %15.2f %10d %15.2f\n", description, price, quantity, cost);
			
			totalCost += cost;
			totalQuantity += quantity;
			
		}

		ps.printf("%-30s %15s %10s %15s\n", "-----------", "-----", "--------", "----");
		ps.printf("%-30s %15s %10d %15.2f\n", "Total", " ", totalQuantity, totalCost);
	}
	catch (Exception e) {
		
		e.printStackTrace();
		
	}	
		
	}
	
/**
* * This method does Write function.
* */
					
	public void Write(PrintStream ps) {
						
		// Using Write Method from another class for help
		m_Customer.Write(ps);
		
		// Writing Purchase Count on the File, Fourth Comment Fix
		ps.println(m_PurchaseCollection.length);
		
		for (int i = 0; i < m_PurchaseCollection.length; i++) {
			
			m_PurchaseCollection[i].Write(ps);
		}				
				
	}
			
/**
* * This method does Read function.
* */
		
	public void Read(Scanner s) {
						
		// Using Read Method from another class for help		
		m_Customer.Read(s);
		
		// Purchase Count, Fixing the first Mistake
		int z = m_PurchaseCollection.length;
		z = s.nextInt();
		s.nextLine();
	
		for (int i = 0; i < m_PurchaseCollection.length; i++) {
			m_PurchaseCollection[i].Read(s);
		}
				
	}

/**
* * This method does WriteJSON function.
* */
						
	public void WriteJSON(PrintStream ps) {
						
		PurchaseCollection pc2 = new PurchaseCollection();	
		pc2.SetCustomer(m_Customer);
		
		// Setting up JSON	
		GsonBuilder builder = new GsonBuilder(); 	
		builder.setPrettyPrinting(); 		
		Gson gson = builder.create();
	
		String jsonString2 = gson.toJson(pc2);	
		ps.println(jsonString2);  

						
	}
				
/**
* * This method does ReadJSON function.	
* */	
			
	public void ReadJSON(FileReader fr) {
						
		String jsonString = " ";
					
				
		// Setting up JSON
				
		GsonBuilder builder = new GsonBuilder(); 		
		builder.setPrettyPrinting(); 		
		Gson gson = builder.create();						
				
		
		String jsonString2 = " ";
		PurchaseCollection pc2 = gson.fromJson(fr, PurchaseCollection.class);
		
		
		m_Customer = pc2.GetCustomer();	
		jsonString += m_Customer;
		
		for (int i = 0; i < m_PurchaseCollection.length; i++) {
			
			// 7th Comment Fixed
			m_PurchaseCollection[i] = pc2.m_PurchaseCollection[i];
			jsonString += m_PurchaseCollection[i];
			
		}
		
		System.out.println(pc2);
				
			
	}
	
/**
* * This method does overriding toString function.
* */
					
			@Override
			public String toString()  {
				
				// 8th Comment Fixed
				String arr = "";
				for (int i = 0; i < m_PurchaseCollection.length; i++) {
					int q = m_PurchaseCollection[i].getQuantity();
					String d = m_PurchaseCollection[i].getProduct().getDescription();
					double p = m_PurchaseCollection[i].getProduct().getPrice();
					arr += String.format("%d, %s, $%.2f\n", q, d, p);
				}
				
				String s = String.format("%s %s\n%s %s\n%s, %s %s\n%s", m_Customer.getFirstName(), m_Customer.getLastName(), m_Customer.getAddress().getNumber(), m_Customer.getAddress().getStreet(), m_Customer.getAddress().getCity(), m_Customer.getAddress().getState(), m_Customer.getAddress().getZip(), arr);	
				
				return s;	
			}
	

}
