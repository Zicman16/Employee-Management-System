/*
 * The purpose of this class is to store all of the sql queries I want to run,
 * 
 */

 // W w


import java.sql.*;
import java.util.Scanner;

public class QueryUtility 
{


    static public void getEmployees()
    {
        //LinkedList<Employees> employees = new LinkedList<>();
        

        try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
        {
            StringBuilder output = new StringBuilder("");
            output.append("Empid\tEmployee Name\t\tEmployee Email\t\tSocial Security Number\n" );
            output.append("__________________________________________________________________________________\n");
            String sqlQuery = "SELECT e.*, jt.job_title " +
                  "FROM employees e " +
                  "JOIN employee_job_titles ejt ON e.empid = ejt.empid " + 
                  "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id";

            PreparedStatement pst = conn.prepareStatement(sqlQuery);

            ResultSet myRS = pst.executeQuery();

            while(myRS.next()) 
            {
                /*
                 * The String.format is used to align the different rows of information so that it appears in different results into neat columns
                 */


                output.append(String.format("%-8s", myRS.getInt("e.empid"))); 
                output.append(String.format("%-24s", myRS.getString("e.Fname") + " " + myRS.getString("e.LName"))); 
                output.append(String.format("%-24s",myRS.getString("e.email"))); 
                output.append(myRS.getString("e.SSN") + "\n"); 

            }
            System.out.println( output.toString() );
            output.setLength( 0 ); 
            conn.close();

        } catch (SQLException e) 
        {
            System.out.println("ERROR (Get Employees) " + e.getLocalizedMessage());
        }

    }

    /*
     * This function is meant to 
     */

    static void EmployeeSearchID(int ID)
    {

        //System.out.println("ID entered: " + ID);

        try(Connection conn = DatabaseUtility.getDatabaseConnection())
        {
            StringBuilder output = new StringBuilder("");
            output.append("Employee Search (Employee ID)\n\n" );

            String sqlQuery2 = "SELECT e.*, jt.job_title, d.Name, d.addressLine1, d.addressLine2, d.country ,d.postalCode, s.State_Name, c.City_Name " +
                  "FROM employees e " +
                  "JOIN employee_job_titles ejt ON e.empid = ejt.empid " + 
                  "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                  "join employee_division ed on e.empid = ed.empid " +
                  "join division d on ed.div_ID = d.ID " +
                  "join state s on d.State_ID = s.State_ID " +
                  "join city c on d.City_ID = c.City_ID " +
                  "where e.empid =" + ID;

                  

            
            PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

            ResultSet myRS2 = pst2.executeQuery();
  

            while(myRS2.next())
            {
                output.append("Employee Name: " + myRS2.getString("e.Fname") + " " + myRS2.getString("e.LName") + "\n\n");

                output.append(String.format("%-10s","Employee ID:      " + myRS2.getInt("e.empid") + "\n")); 
                output.append(String.format("%-25s","Employee Email:   " + myRS2.getString("e.email") + "\n"));
                output.append(String.format("%-25s","Hire Date:        " + myRS2.getString("e.HireDate") + "\n"));
                output.append(String.format("%-25s","Salary:           " + myRS2.getBigDecimal("e.Salary") + "\n"));
                output.append(String.format("%-25s","SSN:              " + myRS2.getString("e.SSN") + "\n"));
                output.append(String.format("%-25s","Job Title:        " + myRS2.getString("jt.job_title") + "\n"));
                output.append(String.format("%-21s","Division Name:    " + myRS2.getString("d.Name") + "\n"));
                output.append(String.format("%-17s","Address Line 1:   " + myRS2.getString("d.addressLine1") + "\n"));
                output.append(String.format("%-17s","Address Line 2:   " + myRS2.getString("d.addressLine2") + "\n"));
                output.append(String.format("%-21s","Country:          " + myRS2.getString("d.country") + "\n"));
                output.append(String.format("%-24s","Postal Code:      " + myRS2.getString("d.postalCode") + "\n"));
                output.append(String.format("%-18s","State:            " + myRS2.getString("s.State_Name") + "\n"));
                output.append(String.format("%-25s","City:             " + myRS2.getString("c.City_Name") + "\n"));
            }
            System.out.println( output.toString() );
            output.setLength( 0 ); 
            conn.close();

        } catch (SQLException e) 
        {
            System.out.println("ERROR (Employee Search) " + e.getLocalizedMessage());
        }


    }

    static void EmployeeSearchName(String Fname, String Lname)
    {
        try(Connection conn = DatabaseUtility.getDatabaseConnection())
        {
            StringBuilder output = new StringBuilder("");
            output.append("Employee Search (Employee Name)\n\n" );

            String sqlQuery2 = "SELECT e.*, jt.job_title, d.Name, d.addressLine1, d.addressLine2, d.country ,d.postalCode, s.State_Name, c.City_Name " +
                  "FROM employees e " +
                  "JOIN employee_job_titles ejt ON e.empid = ejt.empid " + 
                  "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                  "join employee_division ed on e.empid = ed.empid " +
                  "join division d on ed.div_ID = d.ID " +
                  "join state s on d.State_ID = s.State_ID " +
                  "join city c on d.City_ID = c.City_ID " +
                  "where e.Fname = '" + Fname + "'" +
                  " And e.Lname = '" + Lname + "'";

                  //"where e.Fname = " + Fname + " And e.Lname = " + Lname;

            PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

            ResultSet myRS2 = pst2.executeQuery();


            while(myRS2.next())
            {
                output.append("Employee Name: " + myRS2.getString("e.Fname") + " " + myRS2.getString("e.LName") + "\n\n");

                output.append(String.format("%-10s","Employee ID:      " + myRS2.getInt("e.empid") + "\n")); 
                output.append(String.format("%-25s","Employee Email:   " + myRS2.getString("e.email") + "\n"));
                output.append(String.format("%-25s","Hire Date:        " + myRS2.getString("e.HireDate") + "\n"));
                output.append(String.format("%-25s","Salary:           " + myRS2.getBigDecimal("e.Salary") + "\n"));
                output.append(String.format("%-25s","SSN:              " + myRS2.getString("e.SSN") + "\n"));
                output.append(String.format("%-25s","Job Title:        " + myRS2.getString("jt.job_title") + "\n"));
                output.append(String.format("%-21s","Division Name:    " + myRS2.getString("d.Name") + "\n"));
                output.append(String.format("%-17s","Address Line 1:   " + myRS2.getString("d.addressLine1") + "\n"));
                output.append(String.format("%-17s","Address Line 2:   " + myRS2.getString("d.addressLine2") + "\n"));
                output.append(String.format("%-21s","Country:          " + myRS2.getString("d.country") + "\n"));
                output.append(String.format("%-24s","Postal Code:      " + myRS2.getString("d.postalCode") + "\n"));
                output.append(String.format("%-18s","State:            " + myRS2.getString("s.State_Name") + "\n"));
                output.append(String.format("%-25s","City:             " + myRS2.getString("c.City_Name") + "\n"));
            


            }
            System.out.println( output.toString() );
            output.setLength( 0 ); 
            conn.close();

        } catch (SQLException e) 
        {
            System.out.println("ERROR (Employee Name) " + e.getLocalizedMessage());
        }

    }

    static void EmployeeSearchSSN(int SSN)
    {
        try(Connection conn = DatabaseUtility.getDatabaseConnection())
        {
            String SSN_Str = String.valueOf(SSN);
            StringBuilder output = new StringBuilder("");
            output.append("Employee Search (Employee SSN)\n\n" );


            String sqlQuery2 = "SELECT e.*, jt.job_title, d.Name, d.addressLine1, d.addressLine2, d.country ,d.postalCode, s.State_Name, c.City_Name " +
                  "FROM employees e " +
                  "JOIN employee_job_titles ejt ON e.empid = ejt.empid " + 
                  "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                  "join employee_division ed on e.empid = ed.empid " +
                  "join division d on ed.div_ID = d.ID " +
                  "join state s on d.State_ID = s.State_ID " +
                  "join city c on d.City_ID = c.City_ID " +
                  "where e.SSN = '" + SSN_Str + "'";


            PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

            ResultSet myRS2 = pst2.executeQuery();


            while(myRS2.next())
            {
                output.append("Employee Name: " + myRS2.getString("e.Fname") + " " + myRS2.getString("e.LName") + "\n\n");

                output.append(String.format("%-10s","Employee ID:      " + myRS2.getInt("e.empid") + "\n")); 
                output.append(String.format("%-25s","Employee Email:   " + myRS2.getString("e.email") + "\n"));
                output.append(String.format("%-25s","Hire Date:        " + myRS2.getString("e.HireDate") + "\n"));
                output.append(String.format("%-25s","Salary:           " + myRS2.getBigDecimal("e.Salary") + "\n"));
                output.append(String.format("%-25s","SSN:              " + myRS2.getString("e.SSN") + "\n"));
                output.append(String.format("%-25s","Job Title:        " + myRS2.getString("jt.job_title") + "\n"));
                output.append(String.format("%-21s","Division Name:    " + myRS2.getString("d.Name") + "\n"));
                output.append(String.format("%-17s","Address Line 1:   " + myRS2.getString("d.addressLine1") + "\n"));
                output.append(String.format("%-17s","Address Line 2:   " + myRS2.getString("d.addressLine2") + "\n"));
                output.append(String.format("%-21s","Country:          " + myRS2.getString("d.country") + "\n"));
                output.append(String.format("%-24s","Postal Code:      " + myRS2.getString("d.postalCode") + "\n"));
                output.append(String.format("%-18s","State:            " + myRS2.getString("s.State_Name") + "\n"));
                output.append(String.format("%-25s","City:             " + myRS2.getString("c.City_Name") + "\n"));

            }
            System.out.println( output.toString() );
            output.setLength( 0 ); 
            conn.close();

        } catch (SQLException e) 
        {
            System.out.println("ERROR (Employee SSN) " + e.getLocalizedMessage());
        }

    }

    static void SalaryUpdate()
    {
        //double salaryLowBound, salaryHighBound;
        int salaryLowBound, salaryHighBound;
        double salaryIncPecentage;


        Scanner scanner3 = new Scanner(System.in);

        System.out.printf("Enter Lower Salary Range: ");
        //salaryLowBound = scanner3.nextDouble();
        salaryLowBound = scanner3.nextInt();

        System.out.printf("Enter Upper Salary Range: ");
        //salaryHighBound = scanner3.nextDouble();
        salaryHighBound = scanner3.nextInt();

        System.out.println("Enter Pecent Increase");
        System.out.println("(For example, if you want a 15% increase, enter 15)");
        System.out.printf("Enter Here: ");
        
        salaryIncPecentage = scanner3.nextDouble();
        salaryIncPecentage = (1 + (salaryIncPecentage / 100));

        System.out.println("Salary Percent: " + salaryIncPecentage);

        try(Connection conn = DatabaseUtility.getDatabaseConnection())
        {
            
            String sqlQuery2 = "UPDATE employees " +
                   "SET Salary = " +
                   "CASE " +
                   "WHEN Salary >= " + salaryLowBound + " AND Salary < " + salaryHighBound + " THEN Salary * " + salaryIncPecentage + " " + 
                   "ELSE Salary " +
                   "END " +
                   "WHERE Salary >= " + salaryLowBound + " AND Salary < " + salaryHighBound;



            PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);
            int myRS2 = pst2.executeUpdate();
            
            System.out.println("Salary Update Successful!");
            //scanner3.close();
        } catch (SQLException e) 
        {
            System.out.println("ERROR (Salary Update) " + e.getLocalizedMessage());
        }
        
    }


    static void Payroll()
    {

        try(Connection conn = DatabaseUtility.getDatabaseConnection())
        {
            StringBuilder output = new StringBuilder("");

            String sqlQuery2 = "SELECT e.Fname, e.Lname, e.email, jt.job_title, e.empid " +
                "FROM employees e  " +
                "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id  " +
                "ORDER BY e.empid ; ";

                Statement myStmt = conn.createStatement();
                output.append("\nEMPLOYEE PAYROLL REPORT\n");
                ResultSet myRS = myStmt.executeQuery(sqlQuery2);
                /*      Original
                while (myRS.next()) {
                    output.append("Name = " + myRS.getString("e.Fname") + " " + myRS.getString("e.Fname") + "\t");
                    output.append("Title =    " + myRS.getString("jt.job_title") + "     " + myRS.getString("e.email") + "\n");
                    System.out.print(output.toString());
                    output.setLength(0);
                    getPayroll(myRS.getInt("e.empid"), conn);
                
                }
                */
                while (myRS.next()) {
                    output.append("Name = " + myRS.getString("e.Fname") + " " + myRS.getString("e.Lname") + "\t");
                    output.append("Title =    " + myRS.getString("jt.job_title") + "     " + myRS.getString("e.email") + "\n");
                    System.out.print(output.toString());
                    output.setLength(0);
                    getPayroll(myRS.getInt("e.empid"), conn);
                
                }





        } catch (SQLException e) 
        {
            System.out.println("ERROR (Salary Update) " + e.getLocalizedMessage());
        }


    }

    public static void getPayroll(int empID, Connection myConn1) 
    {
        StringBuilder output1 = new StringBuilder("");
        String sqlcommand1 = "SELECT e.empid, p.pay_date, p.earnings, p.fed_tax, " +
                "p.fed_med,p.fed_SS,p.state_tax,p.retire_401k,p.health_care  " +
                "FROM employees e " +
                "JOIN payroll p ON e.empid = p.empid " +
                "WHERE e.empid = " + empID + " " +
                "ORDER BY p.pay_date;";
        try {
            Statement myStmt = myConn1.createStatement();

            output1.append("\tEMP ID\tPAY DATE\tGROSS\tFederal\tFedMed\tFedSS\tState\t401K\tHealthCare\n");
            ResultSet myRS1 = myStmt.executeQuery(sqlcommand1);
            while (myRS1.next()) {
                output1.append("\t" + myRS1.getString("e.empid") + "\t");
                output1.append(myRS1.getDate("p.pay_date") + "\t" + myRS1.getDouble("p.earnings") + "\t");
                output1.append(myRS1.getDouble("p.fed_tax") + "\t" + myRS1.getDouble("p.fed_med") + "\t");
                output1.append(myRS1.getDouble("p.fed_SS") + "\t" + myRS1.getDouble("p.state_tax") + "\t");
                output1.append(myRS1.getDouble("p.retire_401K") + "\t" + myRS1.getDouble("p.health_care")+"\n" );
            }
            System.out.println(output1.toString());
            output1.setLength( 0 );
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }


    public static void main(String[] args)
    {
        //getEmployees();
        //EmployeeSearchID(5);
        //EmployeeSearchName("Charlie", "brown");
        //EmployeeSearchSSN(123456789);
        //SalaryUpdate();

        Payroll();

    }

    

}
