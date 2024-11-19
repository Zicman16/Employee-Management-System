//import java.sql.*;
//import java.util.ArrayList;
import java.util.Scanner;
// W w





/*
 * 
 * 
 * 
 * 
 */






 
public class Main 
{
    GetEmpList gel = new GetEmpList();


    public static void main(String[] args) 
    {
        ////////////////// Variables /////////////////////////

        //GetEmpList gel = new GetEmpList();
        Scanner scanner = new Scanner(System.in);

        boolean Quit = false;

        // welcome message, tree that allows user to pick what they want to do.

        System.out.println("Hello!, welcome to JIMEK'S Employee Database System!");

        
        while (Quit != true)
        {

        System.out.println("What would you like to do?");
        
        System.out.println(
            "1. Get A list of all current employees\n" +
            "2. Search for an employee\n" +
            "3. Update Salaries\n"+
            "4. Get Payroll Information\n" +
            "5. Get Job Title Pay report\n" +
            "6. Get Division Pay report\n" +
            "7. Update Employee Information\n" +
            "8. Insert a new Employee" +
            "0. Quit" +
            "\n"

        
        );

        System.out.printf("Enter selection here: ");
        
        int userNumber = scanner.nextInt();

        System.out.println('\n');

        // Get a List of employees
        if (userNumber == 1)
        {

            QueryUtility.getEmployees();

            

        } else if (userNumber == 2)
        {

            EmployeeSearch.EmpSearch();

        } else if (userNumber == 3)
        {

            QueryUtility.SalaryUpdate(); 

        } else if (userNumber == 4){


           QueryUtility.Payroll();

        } else if (userNumber == 5){


            JobTitleReport.JobTitlePayroll();

        } else if (userNumber == 6){

        
            DivisionReport.DivisionPayroll();

        } else if (userNumber == 7)
        {

            EmployeeUpdate.UpdateEmployee();

        } else if (userNumber == 8)
        {

            EmployeeInsert.InsertEmployee();

        }else if (userNumber == 0)
        {

            Quit = true;

            System.out.println("Quitting Application"); 

            scanner.close();

        } else
        {
            System.out.println("Invalid Input detected, please try again\n");
        }

        }

        System.out.println("Closing Application");

    }
}
