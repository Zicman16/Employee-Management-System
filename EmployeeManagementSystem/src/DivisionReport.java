import java.sql.*;
import java.util.Scanner;

import java.text.DecimalFormat;


public class DivisionReport 
{
    
    static void DivisionPayroll()
    {
        String DateSelection = new String();

        int chosenDate;

        Double totalEarnings = 0.0, totalFed_Tax = 0.0, totalFed_Med = 0.0, totalFed_SS = 0.0, totalState_Tax = 0.0;
        Double totalRetirement = 0.0, totalHealth_Care = 0.0;

        DecimalFormat df = new DecimalFormat("#.##");

        int[] intArray = {1, 2, 3, 999, -1};
        //int[] intArray = {1};
        String[] Division = {"Technology Engineering", "Marketing",
         "Human Resources", "HQ", "No Division"};

         Scanner scanner5 = new Scanner(System.in);

         System.out.println("which month would you like to view?");
         System.out.println("1. 2023-12-31\n" +
         "2. 2023-11-30"
         );
 
         System.out.printf("Enter Selection here: ");
 
         chosenDate = scanner5.nextInt(); 

         if (chosenDate == 1)
         {
             DateSelection = "2023-12-31";
             //date = Date.valueOf(DateSelection);
 
         } else if (chosenDate == 2) {
 
             DateSelection = "2023-11-30";
             //date = Date.valueOf(DateSelection);
         }

         StringBuilder output = new StringBuilder("");
         output.append("Employee Pay Report (By Division)\n\n" );
         for (int i = 0; i < intArray.length; i++) 
         {

            try (Connection conn = DatabaseUtility.getDatabaseConnection()) 
            {
                output.append("Pay Date: " + DateSelection + "\n");
                
                output.append("Division: " + Division[i] + "\n\n");

                String sqlQuery2 = "select e.empid, e.Fname, e.Lname, d.ID, d.Name, p.* " +
                "from employees e " +
                "JOIN employee_division ed on e.empid = ed.empid " +
                "join division d on ed.div_ID = d.ID " +
                "join payroll p on e.empid = p.empid " +
                "where d.ID  = " + intArray[i] + " and p.pay_date_str = '" + DateSelection + "'";


                PreparedStatement pst2 = conn.prepareStatement(sqlQuery2);

                ResultSet myRS2 = pst2.executeQuery();

                while(myRS2.next())
            {
                output.append("Employee Name: " + myRS2.getString("e.Fname") + " " + myRS2.getString("e.LName") + "\n\n");

                output.append("Empid Earnings Fed_Tax Fed_Med Fed_SS State_Tax Retirement Health_Care\n");
                output.append("___________________________________________________________________________\n");


                output.append(myRS2.getString("e.empid") + " ");
                output.append("   " + myRS2.getDouble("p.earnings") + "  ");
                output.append(myRS2.getDouble("p.fed_tax") + "   " + myRS2.getDouble("p.fed_med") + "   ");
                output.append(myRS2.getDouble("p.fed_SS") + "  " + myRS2.getDouble("p.state_tax") + "\t");
                output.append(myRS2.getDouble("p.retire_401K") + "\t   " + myRS2.getDouble("p.health_care")+"\n\n" );


                totalEarnings = totalEarnings + myRS2.getDouble("p.earnings");
                totalFed_Tax = totalFed_Tax + myRS2.getDouble("p.fed_tax");
                totalFed_Med = totalFed_Med + myRS2.getDouble("p.fed_med");
                totalFed_SS = totalFed_SS + myRS2.getDouble("p.fed_SS");
                totalState_Tax = totalState_Tax + myRS2.getDouble("p.state_tax");
                totalRetirement = totalRetirement + myRS2.getDouble("p.retire_401K");
                totalHealth_Care = totalHealth_Care + myRS2.getDouble("p.health_care");
            }
            output.append("\tTotal Spending: \n\n");
            output.append("Total Earnings:                  " + df.format(totalEarnings) + "\n");
            output.append("Total Fed Taxes:                 " + df.format(totalFed_Tax) + "\n");
            output.append("Total Fed Medical:               " + df.format(totalFed_Med) + "\n");
            output.append("Total Fed Social Security:       " + df.format(totalFed_SS) + "\n");
            output.append("Total State Tax:                 " + df.format(totalState_Tax) + "\n");
            output.append("Total Retirement:                " + df.format(totalRetirement) + "\n");
            output.append("Total Healthcare Payments:       " + df.format(totalHealth_Care) + "\n");

            output.append("_________________________________________________________________________\n");
            System.out.println( output.toString() );
            output.setLength( 0 ); 
            conn.close();

            // Sets all values back to zero for next iteration.

            totalEarnings = 0.0;
            totalFed_Tax = 0.0;
            totalFed_Med = 0.0;
            totalFed_SS = 0.0;
            totalState_Tax = 0.0;
            totalRetirement = 0.0;
            totalHealth_Care = 0.0;
            } catch (SQLException e) 
            {
            System.out.println("ERROR (Get Employees) " + e.getLocalizedMessage());
            }

         }
    }



    public static void main(String[] args) 
    {
        DivisionPayroll();    
    }



}
