import java.sql.*;
import java.util.Scanner;

// W w
public class EmployeeInsert 
{
    
    

    static void InsertEmployee() 
    {
        Scanner scanner = new Scanner(System.in);

        String Fname;
        
        

        System.out.println("Enter the Basic Information Here:");

        System.out.printf("Enter the new employee's First Name: ");
        Fname = scanner.nextLine();


        String sqlInsertEmployee = "insert into employees (Fname) " +
        "values " +
        "('" + Fname + "')";

        String sqlGetLastEmpid = "select last_insert_id()";

        String sqlInsertEmployeeJobTitles = "insert into employee_job_titles (empid) " +
                "values ";

        String sqlInsertPayroll = "insert into payroll (empid) " +
                "values ";

        String sqlInsertPersonalInformation = "insert into personal_information (empid) " +
                "values ";

        String sqlInsertEmployeeDivision = "insert into employee_division (empid) " +
                "values ";



        try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
        {

            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlInsertEmployee, Statement.RETURN_GENERATED_KEYS);
            
            // Step 2: Get the last inserted empid
            ResultSet rs = statement.getGeneratedKeys();
            int lastEmpid = 0;
            if (rs.next()) {
                lastEmpid = rs.getInt(1);
            }
            
            
            statement.executeUpdate(sqlInsertEmployeeJobTitles + "(" + lastEmpid + ")");
            
            
            statement.executeUpdate(sqlInsertPayroll + "(" + lastEmpid + ")");
            
            
            statement.executeUpdate(sqlInsertPersonalInformation + "(" + lastEmpid + ")");
            
            
            statement.executeUpdate(sqlInsertEmployeeDivision + "(" + lastEmpid + ")");
            
            
            statement.close();
            rs.close();

            System.out.println("Update Successful!");

        } catch (SQLException e) 
        {
        System.out.println("ERROR (Employee Division) " + e.getLocalizedMessage());
        }



    }



    public static void main(String[] args) 
    {
        /* 
        Scanner scanner = new Scanner(System.in);
        String TestString = "";

        System.out.printf("Enter Value Here: ");

        TestString = scanner.nextLine();

        System.out.println(TestString);

        */

        InsertEmployee();
    }
}
