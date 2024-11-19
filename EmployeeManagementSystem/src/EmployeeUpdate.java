
import java.sql.*;

import java.util.Scanner;

//TODO: when updating job title, remove the second prompt asking for job title again


// W w
public class EmployeeUpdate 
{
    // Print the list of all employees, then see what needs to be updated.

    static void UpdateEmployee()
    {
        int Spaces = 25;

        Scanner scanner6 = new Scanner(System.in);

        int[] empidArray = new int[Spaces];
        String[] FnameArray = new String[Spaces], LnameArray = new String[Spaces] ;
        int i = 0;

        int chosenID = 0, userChoice, userChoice2, userChoice3, userChoice4;
        String chosenFName = "", chosenLName = "";

        // Update Employee Vars
        String changedFName, changedLName, changedEmail, changedHireDate, changedSSN;
        Double changedDouble;


        // Update Job Title Vars
        String changedTitle;
        



        System.out.println("List of Employees: ");

        try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
        {
            StringBuilder output = new StringBuilder("");
            output.append("Empid\tEmployee Name:\n\n");

            String sqlQuery = "select e.empid, e.Fname, e.Lname "+
            "from employees e";

            PreparedStatement pst = conn.prepareStatement(sqlQuery);

            ResultSet myRS = pst.executeQuery();

            while(myRS.next()) 
            {
                output.append(myRS.getInt("e.empid") + "\t"); 
                output.append(myRS.getString("e.Fname") + " " + myRS.getString("e.LName") + "\n");

                // This will "append" a new value into the empid and fname arrays.
                empidArray[i] = myRS.getInt("e.empid");
                FnameArray[i] = myRS.getString("e.Fname");
                LnameArray[i] = myRS.getString("e.LName");
                i += 1;
            }
            System.out.println( output.toString() );
            output.setLength( 0 ); 
            conn.close();


        }catch (SQLException e) 
        {
        System.out.println("ERROR (Employee Update) " + e.getLocalizedMessage());
        }

        System.out.println("Enter the ID of the employee you would like to update: ");
        System.out.printf("Enter selection here: ");

        chosenID = scanner6.nextInt();

        for (int j = 0; j < empidArray.length; j++) 
        {
            if (chosenID == empidArray[j])
            {
                chosenFName = FnameArray[j];
                chosenLName = LnameArray[j];

            }
        }

        //System.out.println(chosenFName + " " + chosenLName);
        System.out.println("Select a Table to update: ");

        System.out.println
        (
            "1. Employees\n" +
            "2. Job Title\n" +
            "3. Payroll\n"+
            "4. Personal Information\n" +
            "5. Employee Division\n" +
            "6. Division Information\n" +
            "0. Quit" +
            "\n"
        );

        System.out.printf("Enter selection here: ");

        userChoice = scanner6.nextInt();


        if (userChoice == 1) 
        {

            System.out.println("what would you like to update: \n");

            System.out.println
        (
            "1. Fname\n" +
            "2. Lname\n" +
            "3. email\n" +
            "4. HireDate\n" +
            "5. Salary\n" +
            "6. Social Security Number\n"
        );


        userChoice2 = scanner6.nextInt();
        scanner6.nextLine();


        if (userChoice2 == 1)
        {
            // This line empties the scanner to ensure it function correctly when it is called next.
            //String TempString = scanner6.nextLine();

            System.out.printf("Enter the new First Name here: ");
            
            changedFName = scanner6.nextLine();

            System.out.print("\n");


            try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
            {

                String sqlQuery2 = "update employees " +
                "set Fname = '" + changedFName + "' " +
                "where empid = " + chosenID;

                PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                int Update = pst2.executeUpdate();

                if (Update >= 1) 
                {
                    System.out.println("Update Successful!");
                }
            
                conn.close();



            } catch (SQLException e) 
            {
            System.out.println("ERROR (Employee Update Fname) " + e.getLocalizedMessage());
            }



        } else if ( userChoice2 == 2)  
        {

            // This line empties the scanner to ensure it function correctly when it is called next.
            //String TempString = scanner6.nextLine();

            System.out.printf("Enter the new Last Name here: ");

            changedLName = scanner6.nextLine();

            System.out.print("\n");


            try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
            {

                String sqlQuery2 = "update employees " +
                "set Lname = '" + changedLName + "' " +
                "where empid = " + chosenID;

                PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                int Update = pst2.executeUpdate();

                if (Update >= 1) 
                {
                    System.out.println("Update Successful!");
                }

                conn.close();



            } catch (SQLException e) 
            {
            System.out.println("ERROR (Employee Update Lname) " + e.getLocalizedMessage());
            }

        } else if ( userChoice2 == 3)   // email =
        {

            // This line empties the scanner to ensure it function correctly when it is called next.
            //String TempString = scanner6.nextLine();

            System.out.printf("Enter the new Email here: ");

            changedEmail = scanner6.nextLine();

            System.out.print("\n");


            try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
            {

                String sqlQuery2 = "update employees " +
                "set email = '" + changedEmail + "' " +
                "where empid = " + chosenID;

                PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                int Update = pst2.executeUpdate();

                if (Update >= 1) 
                {
                    System.out.println("Update Successful!");
                }

                conn.close();



            } catch (SQLException e) 
            {
            System.out.println("ERROR (Employee Update Lname) " + e.getLocalizedMessage());
            }



        }else if ( userChoice2 == 4) // Hire Date  
        {

            // This line empties the scanner to ensure it function correctly when it is called next.
            //String TempString = scanner6.nextLine();

            System.out.printf("Enter the new Hire Date here (YYYY-MM-DD): ");

            changedHireDate = scanner6.nextLine();

            System.out.print("\n");


            try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
            {

            String sqlQuery2 = "update employees " +
            "set HireDate = '" + changedHireDate + "' " +
            "where empid = " + chosenID;

            PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

            int Update = pst2.executeUpdate();

            if (Update >= 1) 
            {
                System.out.println("Update Successful!");
            }

            conn.close();



            } catch (SQLException e) 
            {
                System.out.println("ERROR (Employee Update HireDate) " + e.getLocalizedMessage());
            }

        } else if ( userChoice2 == 5)  // Salary
        {


            // This line empties the scanner to ensure it function correctly when it is called next.
            //String TempString = scanner6.nextLine();

            System.out.printf("Enter the new Salary: ");

            changedDouble = scanner6.nextDouble();

            System.out.print("\n");


            try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
            {

            String sqlQuery2 = "update employees " +
            "set Salary = '" + changedDouble + "' " +
            "where empid = " + chosenID;

            PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

            int Update = pst2.executeUpdate();

            if (Update >= 1) 
            {
                System.out.println("Update Successful!");
            }

            conn.close();



        } catch (SQLException e) 
        {
        System.out.println("ERROR (Employee Update Salary) " + e.getLocalizedMessage());
        }


        } else if ( userChoice2 == 6) // Social Security Number
        {

            // This line empties the scanner to ensure it function correctly when it is called next.
            //String TempString = scanner6.nextLine();

            System.out.printf("Enter the new SSN (9 Digits): ");

            changedSSN = scanner6.nextLine();

            System.out.print("\n");


            try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
            {

                String sqlQuery2 = "update employees " +
                "set SSN = '" + changedSSN + "' " +
                "where empid = " + chosenID;

                PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                int Update = pst2.executeUpdate();

                if (Update >= 1) 
                {
                    System.out.println("Update Successful!");
                }

                conn.close();



            } catch (SQLException e) 
            {
            System.out.println("ERROR (Employee Update SSN) " + e.getLocalizedMessage());
            }

    }

        } else if (userChoice == 2) // Job Title

        {
            /*
            System.out.println("what would you like to update: \n");

            System.out.println
            (
                "1. Job Title\n" +
                "0. Quit"

            );

            
            userChoice3 = scanner6.nextInt();
            */

            userChoice3 = 1;

            if (userChoice3 == 1) 
            {

                System.out.println("which job Title would you like to switch to: ");

                System.out.println
                (

                    "1. Software Manager (100)\n" +
                    "2. Software Architect (101)\n" +
                    "3. Software Engineer (102)\n" +
                    "4. Software developer (103)\n" +
                    "5. Marketing Manager (200)\n" +
                    "6. Marketing Associate (201)\n" +
                    "7. Marketing Assistant (202)\n" +
                    "8. Chief Exec. Officer (900)\n" +
                    "9. Chief Finn. Officer (901)\n" +
                    "10. Chieft Info. Officer (902)\n"

                );

                userChoice4 = scanner6.nextInt();
                // Stores the query used in the update
                String sqlQuery3 = "";

                
                if (userChoice4 == 1) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 100 " +
                    "where empid = " + chosenID;


                } else if( userChoice4 == 2) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 101 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 3) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 102 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 4) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 103 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 5) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 200 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 6) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 201 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 7) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 202 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 8) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 900 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 9) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 901 " +
                    "where empid = " + chosenID;

                } else if( userChoice4 == 10) 
                {
                    sqlQuery3 = "update employee_job_titles " +
                    "set job_title_id = 902 " +
                    "where empid = " + chosenID;

                }


                 
                try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
                {

                    PreparedStatement pst2 = conn.prepareStatement(sqlQuery3);

                    int Update = pst2.executeUpdate();
        
                    if (Update >= 1) 
                    {
                        System.out.println("Update Successful!");
                    }
        
                    conn.close();

                }catch (SQLException e) 
                {
                    System.out.println("ERROR (Employee Update Job Title) " + e.getLocalizedMessage());
                }
                


            }
            

        } else if (userChoice == 3) // Payroll
        {

            String [] payRollColumn = {"pay_date","earnings","fed_tax", "fed_med", "fed_SS", "state_tax", "retire_401k", "health_care"} ;

            String [] payDates = {"2023-11-30", "2023-12-31"};

            int chosenColumn, chosenDate;

            double updateValue;

            String UpdateValue_Str;

            System.out.println("what would you like to update: \n");

            System.out.println
            (
                "1. Pay Date\n" +
                "2. Earnings\n" + 
                "3. Federal Tax\n" +
                "4. Federal Med Payments\n" +
                "5. Federal Social Security\n" +
                "6. State Tax\n" +
                "7. Retirement (401k)\n" +
                "8. Healthcare Payments\n"

            );

            System.out.printf("Enter Selection here: ");
            userChoice2 = scanner6.nextInt();
            chosenColumn = userChoice2 - 1;


            System.out.println("which date would you like to update: ");

            System.out.println
            (
                "1. 2023-11-30\n" +
                "2. 2023-12-31\n"
            );


            System.out.printf("Enter Selection here: ");
            userChoice2 = scanner6.nextInt();
            chosenDate = userChoice2 - 1;
            // to properly reset the scanner                                         TODO
            scanner6.nextLine();

            if (chosenColumn == 0) // is pay date is being chosen  
            {
                System.out.printf("Enter a new Date here: "); 

                UpdateValue_Str = scanner6.nextLine();

                String sqlQuery2 = "update payroll " +
                    "set " + payRollColumn[chosenColumn] + " = '" + UpdateValue_Str + "' " +
                    " where empid = " + chosenID + " And pay_date = '" + payDates[chosenDate] + "'";

                try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
                {

                    PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                    int Update = pst2.executeUpdate();

                    if (Update >= 1) 
                    {
                        System.out.println("Update Successful!");
                    }

                    conn.close();



                } catch (SQLException e) 
                {
                System.out.println("ERROR (Employee Update Payroll Date) " + e.getLocalizedMessage());
                }

            } else if(chosenColumn > 0 && chosenColumn <= 7) // if any of the other columns were picked.
            {

                System.out.printf("Enter a new Value here: "); 

                Double UpdateValue = scanner6.nextDouble();

                String sqlQuery2 = "update payroll " +
                "set " + payRollColumn[chosenColumn] + " = '" + UpdateValue + "' " +
                " where empid = " + chosenID + " And pay_date = '" + payDates[chosenDate] + "'";



                try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
                {

                    PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                    int Update = pst2.executeUpdate();

                    if (Update >= 1) 
                    {
                        System.out.println("Update Successful!");
                    }

                    conn.close();



                } catch (SQLException e) 
                {
                System.out.println("ERROR (Employee Update Payroll Data) " + e.getLocalizedMessage());
                }



            }

            
        }else if (userChoice == 4) // Personal Information
        {

            String [] personalInfoColumn = {"Gender", "Pronouns", "Identified_Race", "DOB", "Mobile_Phone"};

            String updateValue;
            int chosenColumn;


            System.out.println("what would you like to update: \n"); 

            System.out.println
            (
                "1. Gender\n" +
                "2. Pronouns\n" +
                "3. Identified Race\n" +
                "4. DOB\n" +
                "5. Mobile Phone\n"
            );

            System.out.printf("Enter Selection here: ");

            userChoice2 = scanner6.nextInt();
            chosenColumn = userChoice2 - 1;

            scanner6.nextLine();

            System.out.printf("Enter the new value here: ");

            updateValue = scanner6.nextLine();

            String sqlQuery2 = "update personal_information " +
                "set " + personalInfoColumn[chosenColumn] + " = '" + updateValue +"' " + 
                " where empid = " + chosenID;

                // "set " + personalInfoColumn[chosenColumn] + " = " + updateValue + " " +

                /* working version
                String sqlQuery2 = "update personal_information " +
                "set Gender = '" + updateValue +  "' " + //removed the String array.
                " where empid = " + chosenID;
                */

                try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
                {

                    PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                    int Update = pst2.executeUpdate();

                    if (Update >= 1) 
                    {
                        System.out.println("Update Successful!");
                    }

                    conn.close();



                } catch (SQLException e) 
                {
                System.out.println("ERROR (Employee Update Personal Info) " + e.getLocalizedMessage());
                }






            
        }else if (userChoice == 5) // Employee Division  // TODO
        {
            int divIDs [] = {1,2,3,999,-1};

            int chosenDivision = 0;

            System.out.println("which division would you like to switch to: \n");

            System.out.println
            ( 
                "1. Technology Engineering\n" +
                "2. Marketing\n" +
                "3. Human Resources\n" +
                "4. HQ\n" +
                "5. None"
            );

            userChoice2 = scanner6.nextInt();
            chosenDivision = userChoice2 - 1;

            String sqlQuery2 = "update employee_division " +
                "set div_ID = " + divIDs[chosenDivision] + " " +
                "where empid = " + chosenID;


                try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
                {

                    PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                    int Update = pst2.executeUpdate();

                    if (Update >= 1) 
                    {
                        System.out.println("Update Successful!");
                    }

                    conn.close();

                } catch (SQLException e) 
                {
                System.out.println("ERROR (Employee Division) " + e.getLocalizedMessage());
                }




            
        }else if (userChoice == 6) // Division Information TODO
        {   
            int [] divID = {1, 2, 3, 999, -1};

            String [] divColumn = {"Name", "addressLine1", 
            "addressLine2", "country", "postalCode", "State_ID", "City_ID"}; 

            int chosenDivID = -1 , chosenColumn = -1;

            String sqlQuery2;

            // lets the determine which table you would like to update

            System.out.println("which ID would you like to Edit: ");

            System.out.println
            (
                "1. Technology Engineering      (1)\n" +
                "2. Marketing                   (2)\n" + 
                "3. Human Resources             (3)\n" +
                "4. HQ                          (999)\n" +
                "5. None                        (-1)" 
            
            );

            System.out.printf("Enter Selection here: ");

            userChoice2 = scanner6.nextInt();
            chosenDivID = userChoice2 - 1;


            // Updates the the division Table information

            System.out.println("what would you like to update: \n");

            System.out.println
            (
                "1. Name\n" +
                "2. Address Line 1\n" +
                "3. Address Line 2\n" +
                "4. Country\n" +
                "5. Postal Code\n" +
                "6. State ID\n" +
                "7. City ID"
            );

            System.out.printf("Enter Selection here: ");

            userChoice2 = scanner6.nextInt();
            chosenColumn = userChoice2 - 1;

            scanner6.nextLine();

            if (chosenColumn >= 0 && chosenColumn <= 4) 
            {
                String updateValue = "";

                System.out.printf("Enter the new value here: ");

                updateValue = scanner6.nextLine();


                sqlQuery2 = "update division " +
                "set " + divColumn[chosenColumn] + " = '" + updateValue +"' " +
                "where ID = " + divID[chosenDivID]; 

                try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
                {

                    PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                    int Update = pst2.executeUpdate();

                    if (Update >= 1) 
                    {
                        System.out.println("Update Successful!");
                    }

                    conn.close();

                } catch (SQLException e) 
                {
                System.out.println("ERROR (Employee Division) " + e.getLocalizedMessage());
                }



            } else if (chosenColumn >= 5 && chosenColumn <= 6) 
            {
                int updateValueInt = -1;

                System.out.printf("Enter the new value here: ");

                updateValueInt = scanner6.nextInt();

                sqlQuery2 = "update division " +
                "set " + divColumn[chosenColumn] + " = " + updateValueInt + " " +
                "where ID = " + divID[chosenDivID];

                try(Connection conn = DatabaseUtility.getDatabaseConnection()) 
                {

                    PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                    int Update = pst2.executeUpdate();

                    if (Update >= 1) 
                    {
                        System.out.println("Update Successful!");
                    }

                    conn.close();

                } catch (SQLException e) 
                {
                System.out.println("ERROR (Employee Division) " + e.getLocalizedMessage());
                }


            }


            
        }else if (userChoice == 0) 
        {

            //System.out.println("what would you like to update: \n");
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) 
    {
        
        UpdateEmployee();
    }



}
