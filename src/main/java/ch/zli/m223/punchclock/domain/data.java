import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  

class H2jdbcInsert {
   // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:file:./punchclock";
   
   //  Database credentials 
   static final String USER = "sa"; 
   static final String PASS = "password";
  
   public static void main(String[] args) { 
      Connection conn = null; 
      Statement stmt = null; 
      try{
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);  
         
         // Open a connection
         System.out.println("Connecting to a selected database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
         System.out.println("Connected database successfully..."); 
         
         // Execute a query
         stmt = conn.createStatement();  
         String sql = "INSERT INTO ApplicationUser " + "VALUES ('Testuser', 'testpassword')";
         
         stmt.executeUpdate(sql); 
         sql = "INSERT INTO Entry " + "VALUES ('23-09-2020 12:12', 20)";

         stmt.executeUpdate(sql); 
         System.out.println("Inserted records into the table...");

         // Execute another query
         stmt = conn.createStatement();
         String sql2 = "INSERT INTO ApplicationUser " + "VALUES ('Athlete', 'athlete')";

         stmt.executeUpdate(sql2);
         sql2 = "INSERT INTO Entry " + "VALUES ('27-10-2020 18:12', 7)";

         stmt.executeUpdate(sql2);
         System.out.println("Inserted records into the table...");

         // Clean-up environment
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         // Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         e.printStackTrace();
      } finally { 
         // finally block used to close resources 
         try {
            if(stmt!=null) stmt.close();  
         } catch(SQLException se2) { 
         } 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se) { 
            se.printStackTrace(); 
         } // end finally try 
      } // end try 
      System.out.println("Goodbye!"); 
   } 
}