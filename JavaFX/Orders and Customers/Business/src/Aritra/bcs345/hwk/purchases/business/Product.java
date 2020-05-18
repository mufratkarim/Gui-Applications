/**
 * Contains a class to generate product information
 */

package Aritra.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Contains main program code. This class generates the Product class of the business 
 * package of assignment2.
 * 
 * @author Mufrat Karim Aritra
 * @version 1.0
 * @since 9/27/2019
 *
*/

public class Product {
	
/**
* * Member Variables with Data Hiding.
* */
	
	private String m_Description;
	private double m_Price;

	
/**
* * Default Constructor with no parameters.
* */
	
	
	public Product() {
		m_Description = "Oneplus 7T";
		m_Price = 430.99;
	}
	
/**
* * Setter and Getter for Description.
* */
	
	public void setDescription(String Description) {
		m_Description = Description;
	}
	
	public String getDescription() {
		return m_Description;
	}
	
/**	 
* * Setter and Getter for Price.
* */
	
	public void setPrice(double Price) {
		m_Price = Price;
	}
	
	public double getPrice() {
		return m_Price;
	}
	
	
/**
* * This method does Write function.
* */	
	
	public void Write(PrintStream ps) {
		
		ps.println(m_Description);
		ps.println(m_Price);
		
	}

/**
 * * This method does Read function.
* */	
	
	
	public void Read(Scanner s) {
		
		m_Description = s.nextLine();
		// Second Comment of Hwk 4
		m_Price = s.nextDouble();
		
		// Third Comment Fix
		if(s.hasNext()) {
	    	  s.nextLine();
	      }
	}
	
/**
 * * This method does WriteJSON function.
 * */
	
	public void WriteJSON(PrintStream ps) {
		
		Product p2 = new Product();
		p2.setDescription(m_Description);
		p2.setPrice(m_Price);

		
		// Setting up JSON
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();

		String jsonString2 = gson.toJson(p2);
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
		Product p2 = gson.fromJson(fr, Product.class);
		
		Scanner s = new Scanner(fr);
		
		// LOOP for Unlimited Products
		while (s.hasNext()) {
			m_Description = p2.getDescription();
			jsonString += m_Description;
			m_Price = p2.getPrice();
			jsonString += m_Price;
			
			
			// Insurance if the loop hits a breakpoint 
			if(s.hasNext()) {
		    	  s.nextLine();
		      }
		    
		}
		
		System.out.println(p2);
	}

	
/**
* * This method does overriding toString function.
* */
	
	
	@Override
	
	public String toString()  {
		String s = String.format("%s, $%.2f", m_Description, m_Price);
		return s;
	}
	
	

}
