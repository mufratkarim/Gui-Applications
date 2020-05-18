/**
 * Contains a class to generate customer information
 */

package Aritra.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Contains main program code. This class generates the Customer class of the business 
 * package of assignment2.
 * 
 * @author Mufrat Karim Aritra
 * @version 1.0
 * @since 9/27/2019
 *
*/

public class Customer {
	
/**
* * Private Variables with Data Hiding.
* */
	
	private String m_FirstName;
	private String m_LastName;
	private Address m_Address;
	
/**
* * Default Constructor with no parameters.
* */
	
	public Customer() {
		m_FirstName = "Bill";
		m_LastName = "Gates";
		
		m_Address = new Address();
	}
	
/**
* * Setter and Getter for FirstName.
* */	
	
	public void setFirstName(String FirstName) {	
		m_FirstName = FirstName;
			
	}
			
	public String getFirstName() {
		return m_FirstName;
			
	}
			
/**
* * Setter and Getter for LastName.
* */
	
	public void setLastName(String LastName) {	
		m_LastName = LastName;
		
	}
	
	public String getLastName() {
		return m_LastName;
			
	}
	
/**
* * Setter and Getter for Setter and Getter for Address.
* */	
	
	public void setAddress(Address Address) {
		
		m_Address = Address;
		
	}
	
	public Address getAddress() {
		return m_Address;
			
	}

/**
* * This method does Write function.
* */
	
	public void Write(PrintStream ps) {
		ps.println(m_FirstName);
		ps.println(m_LastName);
		
		// Using Write Method from another class for help
		m_Address.Write(ps);
		
	}
	
/**
* * This method does Read function.
* */

	public void Read(Scanner s) {
		m_FirstName = s.nextLine();
		m_LastName = s.nextLine();
		
		// Using Read Method from another class for help
		m_Address.Read(s);
	
	}



/**
* * This method does WriteJSON function.
* */
	
	public void WriteJSON(PrintStream ps) {
		
		Customer c2 = new Customer();
		c2.setFirstName(m_FirstName);
		c2.setLastName(m_LastName);
		c2.setAddress(m_Address);

		
		// Setting up JSON
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();

		String jsonString2 = gson.toJson(c2);
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
		Customer c2 = gson.fromJson(fr, Customer.class);
		
		m_FirstName = c2.getFirstName();	
		jsonString += m_FirstName;
				
		m_LastName = c2.getLastName();	
		jsonString += c2.getLastName();
				
		m_Address = c2.getAddress();
			
			
		System.out.println(c2);
		
	}

		
/**
* * This method does overriding toString function.
* */
		
		@Override
		public String toString()  {
			String s = String.format("%s %s\n%s %s\n%s, %s %s", m_FirstName, m_LastName, m_Address.getNumber(), m_Address.getStreet(), m_Address.getCity(), m_Address.getState(), m_Address.getZip());
			return s;
		}
	
}
