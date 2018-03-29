/*
 * GIVE EXPLANATION OF ASSIGNMENT HERE
 * 
 * 
 */
package ASS2;

//imported classes 
import java.util.*;
import java.net.*;
import java.text.*;
import java.lang.*;
import java.io.*;
import java.sql.*;

/*
 * DEFINE PUBLIC class yrb here
 */
public class yrb {
	
	//declare variables
	 private Connection conDB;   // Connection to the database system.
	 private String url;         // URL
	 
	 
	//more variables to come
	
	/*
	 * Define Constructor here
	 */
	    public yrb() {

	        // Set up the DB connection.
	    	
	        try {// Register the driver with DriverManager.
	        	Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
	           
	        //check for possible exceptions
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.exit(0);

	        } catch (InstantiationException e) {
	            e.printStackTrace();
	            System.exit(0);

	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	            System.exit(0); 

	        }//all exception checking done
	        
	        // URL establishment
	        url = "jdbc:db2:c3421a"; //make sure we use a instead of m

	        // Initialize the connection.

	        try {
	           // Connect with a fall-thru id & password
	            conDB = DriverManager.getConnection(url);

	        } catch (SQLException e) {
	            System.out.print("\nSQL: database connection error.\n");
	            System.out.println(e.toString());
	            System.exit(0);
	        }//catch exception
	        
	     // Turn autocommit off here

	        try {
	            conDB.setAutoCommit(false);
	            
	        } catch (SQLException e) {
	            System.out.print("\nFailed trying to turn autocommit off.\n");
	            e.printStackTrace();
	            System.exit(0);
	        }//catch exception
	        
	        /*
	         * AT THIS POINT WE SHOULD BE INPUTTING THE ACTUAL PROGRAMS AND METHODS
	         */
	        
	        
	        System.out.println("PROGRAM RUNS");
	        
	        
	        /*
	         * AT THIS POINT WE SHOULD BE FINISHED RUNNING THE PROGRAM.
	         * Next, we commit and close the transaction
	         */
	        
	     // Commit the transaction
	        try {
	            conDB.commit();
	            
	        } catch (SQLException e) {
	            System.out.print("\nFailed trying to commit.\n");
	            e.printStackTrace();
	            System.exit(0);
	        }//catch exception

	        // Close the connection.
	        try {
	            conDB.close();

	        } catch (SQLException e) {
	            System.out.print("\nFailed trying to close the connection.\n");
	            e.printStackTrace();
	            System.exit(0);
	        }//catch exception
	        
	    }//constructor
	    
	    /*
	    *EXPLAIN MAIN METHOD HERE
	    */
	    public static void main(String[] args) {
	        yrb x = new yrb();
	        System.out.println("MAIN METHOD WORKING");
	    }//main method
	
}//public class yrb
