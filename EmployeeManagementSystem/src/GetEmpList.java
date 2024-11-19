import java.sql.*;
//import java.util.ArrayList;

public class GetEmpList 
{
    
    
    static public void GetEmployeeList()
    {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "123jklASIS";
        StringBuilder output = new StringBuilder("");
        String sqlcommand = "SELECT e.*, jt.job_title " +
                "FROM employees e " +
                "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id;" ;

        try ( Connection myConn = DriverManager.getConnection( url, user, password ) ) 
        {
            Statement myStmt = myConn.createStatement();
            output.append("List of all current employees\n");
            output.append("_______________________________________________________\n");
            ResultSet myRS = myStmt.executeQuery( sqlcommand );
            while ( myRS.next () )
            {
                output.append(myRS.getInt("e.empid") + " " + myRS.getString("e.Fname") + " ");
                output.append(myRS.getString("e.LName") + "\t\t\t" + myRS.getString("e.email") + "\n");


            }
            System.out.println( output.toString() );
            output.setLength( 0 ); 
            myConn.close();
        }
        catch (SQLException e) 
        {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
        finally
        {
        }

    }

    
    
    
    
    
    public static void main(String[] args) 
    {
        GetEmployeeList();
    }
}    

