/**
 * Contains a class to generate Address information
 */

package Aritra.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Contains main program code. This class generates the address class of the business 
 * package of assignment2.
 * 
 * @author Mufrat Karim Aritra
 * @version 1.0
 * @since 9/27/2019
 *
*/

public class Address {
		
/**
 * * Member Variables with Data Hiding.
 * */
	
	private String m_Number;
	private String m_Street;
	private String m_City;
	private String m_State;
	private String m_Zip;

/**
 * * Default Constructor with no parameters.
 * */
		
	public Address() {
		m_Number = "88-34";
		m_Street = "161St Street";
		m_City = "Jamaica";
		m_State = "NY";
		m_Zip = "11432";
		}
		
/**
 * * Parameterized Constructor with all the parameters.
 * */
		
	public Address(String Number, String Street, String City, String State, String Zip) {
		m_Number = Number;
		m_Street = Street;
		m_City = City;
		m_State = State;
		m_Zip = Zip;	
		}
		
/**
 * * Setter and Getter for Number.
 * */
		
	public void setNumber(String Number2) {
		m_Number = Number2;
		}
		
	public String getNumber() {
		return m_Number;
		}
		
/**
 * * Setter and Getter for Street.
 * */
		
	public void setStreet(String Street2) {
		m_Street = Street2;
		}
	
	public String getStreet() {
		return m_Street;
		}
	
/**
 * * Setter and Getter for Setter and Getter for City.
 * */
		
	public void setCity(String City2) {
		m_City = City2;
		}
		
	public String getCity() {
		return m_City;
		}
	
/**
 * * Setter and Getter for Setter and Getter for State.
 * */
		
	public void setState(String State2) {	
		m_State = State2;
		}
	
	public String getState() {	
		return m_State;
		}
		
/**
 * * Setter and Getter for Setter and Getter for Zip.
 * */
	public void setZip(String Zip2) {
		m_Zip = Zip2;
		}
		
	public String getZip() {
		return m_Zip;
		}
		
/**
 * * This method does Write function.
 * */	
		
	public void Write(PrintStream ps) {
		ps.println(m_Number);	
		ps.println(m_Street);
		ps.println(m_City);	
		ps.println(m_State);	
		ps.println(m_Zip);	
		}
	
/**
 * * This method does Read function.
 * */		
		
	public void Read(Scanner s) {
		m_Number = s.nextLine();
		m_Street = s.nextLine();
		m_City = s.nextLine();
		m_State = s.nextLine();
		m_Zip = s.nextLine();
		}
	
/**
 * * This method does WriteJSON function.
 * */
		 	
	public void WriteJSON(PrintStream ps) {
		// Setting up JSON
			
		GsonBuilder builder = new GsonBuilder(); 	
		builder.setPrettyPrinting(); 	
		Gson gson = builder.create();
			
		Address e = new Address();
			
		e.setNumber(m_Number);
		e.setStreet(m_Street);
		e.setCity(m_City);	
		e.setCity(m_State);	
		e.setZip(m_Zip);
		
		String jsonString = gson.toJson(e);	
		ps.println(jsonString);  
			
		}
		
/**
 * * This method does ReadJSON function.	
 * */	
		
	public void ReadJSON(FileReader fr) {
		// Setting up JSON
			
		GsonBuilder builder = new GsonBuilder(); 	
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();
		
		String jsonString = " ";	
		Address e2 = gson.fromJson(fr, Address.class);
			
		// Adding variable values in JSON
			
		m_Number = e2.getNumber();
		jsonString += m_Number;
		
		m_Street = e2.getStreet();
		jsonString += m_Street;
			
		m_City = e2.getCity();
		jsonString += m_City;
			
		m_State = e2.getState();
		jsonString += m_State;
			
		m_Zip = e2.getZip();
		jsonString += m_Zip;	
		
		System.out.println(e2);
		
	}
		
	
/**
 * * This method does overriding toString function.
 * */		
	
	@Override
		
	public String toString()  {	
		String s = m_Number + " " + m_Street + ", " + m_City + ", " + m_State + ", " + m_Zip;	
		return s;
		}

	}