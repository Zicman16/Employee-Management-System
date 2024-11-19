
/*
 *The Purpose of this class is connect to a database before running a 
 query 
 * 
 */


import java.sql.*;




public class DatabaseUtility 
{
    
    
    public static Connection getDatabaseConnection() 
    {
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "123jklASIS";
        

        try {
            conn = DriverManager.getConnection(url, user, password);
            //System.out.println("Connection Establised Successfully\n");
            System.out.printf("Connection Establised Successfully\n\n");
        } catch (Exception e) {
            System.err.println("Error in Establishing connection to Database");
            e.printStackTrace();
        }

        return conn;
    }

        
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    /* 
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "123jklASIS";
        StringBuilder output = new StringBuilder("");

        try ( Connection myConn = DriverManager.getConnection( url, user, password ) ) 
        {
            System.err.println("Connection Established");
        }
        catch (SQLException e) 
        {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }

    */



