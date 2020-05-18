/**
 * Contains a class to generate Purchase information
 */

package Aritra.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Contains main program code. This class generates the Purchase class of the business 
 * package of assignment2.
 * 
 * @author Mufrat Karim Aritra
 * @version 1.0
 * @since 9/27/2019
 *
*/


public class Purchase {
	
/**
* * Private Variables with Data Hiding.
* */
	
	private Product m_Product;
	private int m_Quantity;
	
	
/**
* * Default Constructor with no parameters.
* */
	
	public Purchase() {
		
		m_Product = new Product();
		
		m_Quantity = 50;
		
	}

/**
* * Setter and Getter for Setter and Getter for Product.
* */	
			
	
	public void setProduct(Product Product) {
		m_Product = Product;	
		}
	
	public Product getProduct() {
		return m_Product;
		}	
	
	
/**
* * Setter and Getter for Quantity.
* */
		
		public void setQuantity(int Quantity) {	
			m_Quantity = Quantity;
			}
		
		public int getQuantity() {
			return m_Quantity;
			}

/**
* * This method does Write function.
* */
		
		
		public void Write(PrintStream ps) {
			
			
			// Using Write Method from another class for help
			m_Product.Write(ps);
			
			ps.println(m_Quantity);
				
			}
		
/**
* * This method does Read function.
* */

		public void Read(Scanner s) {
			
			// Using Read Method from another class for help
			m_Product.Read(s);
				
			m_Quantity = s.nextInt();
			
			// Third Comment Fix
			if(s.hasNext()) {
		    	  s.nextLine();
		      }
			
			
			}

/**
* * This method does WriteJSON function.
* */
			
		public void WriteJSON(PrintStream ps) {
				
			Purchase pu2 = new Purchase();
			pu2.setProduct(m_Product);
			pu2.setQuantity(m_Quantity);
			

				
			// Setting up JSON
			GsonBuilder builder = new GsonBuilder(); 
			builder.setPrettyPrinting(); 
			Gson gson = builder.create();

			String jsonString2 = gson.toJson(pu2);
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
			Purchase pu2 = gson.fromJson(fr, Purchase.class);

			m_Product = pu2.getProduct();	
			jsonString += m_Product;
					
			m_Quantity = pu2.getQuantity();	
			jsonString += m_Quantity;
					
				
			System.out.println(pu2);
			
		}

				
/**
* * This method does overriding toString function.
* */
				
		
		@Override
		public String toString()  {
			String s = String.format("%d, %s, $%.2f", m_Quantity, m_Product.getDescription(), m_Product.getPrice());	
			return s;	
		}


}
