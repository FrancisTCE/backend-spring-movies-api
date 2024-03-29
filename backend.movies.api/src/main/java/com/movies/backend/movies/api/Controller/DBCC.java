package com.movies.backend.movies.api.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCC {

    // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:mem:import.sql";  
   
   // Database credentials : should be .env
   static final String USER = "admin"; 
   static final String PASS = "admin"; 

   public void sqlController(){
    Connection conn = null;
    Statement stmt = null; 

    try { 
        // STEP 1: Register JDBC driver 
        Class.forName(JDBC_DRIVER); 
        
        // STEP 2: Open a connection 
        System.out.println("Connecting to a database..."); 
        conn = DriverManager.getConnection(DB_URL,USER,PASS);  
        
        // STEP 3: Execute a query 
        System.out.println("Connected database successfully..."); 
        stmt = conn.createStatement();         
        
        String table = "moviedb";
        String sql = new SQLBuilder().getSQLTable("\""+table+"\""); 
        ResultSet rs = stmt.executeQuery(sql);  
        
        while(rs.next()){ 
           // Retrieve by column name 
           int id  = rs.getInt("id"); 
           int age = rs.getInt("movie_year"); 
           int rating = rs.getInt("rating"); 
           String name = rs.getString("name");  

           
           // Display values 
           System.out.print("ID: " + id); 
           System.out.print(", Age: " + age); 
           System.out.print(", Rating: " + rating); 
           System.out.println(", Name: " + name); 
        } 
        rs.close();    
     } catch(SQLException se) { 
        // Handle errors for JDBC 
        se.printStackTrace(); 
     } catch(Exception e) { 
        // Handle errors for Class.forName 
        e.printStackTrace(); 
     } finally { 
        // finally block used to close resources  
        try { 
           if(stmt!=null) stmt.close(); 
        } catch(SQLException se2) { 
        } // nothing we can do 
        try { 
           if(conn!=null) conn.close(); 
        } catch(SQLException se) { 
           se.printStackTrace(); 
        } // end finally try 
     } // end try 
   }
}
