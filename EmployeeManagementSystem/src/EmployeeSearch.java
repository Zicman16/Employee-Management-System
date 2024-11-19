
// W w

import java.util.Scanner;
public class EmployeeSearch 
{
    static boolean quitSearch = false;

    
    static public void EmpSearch()
    {
        Scanner scanner2 = new Scanner(System.in);

        int userNumber, userSSN, userID;
        
        while( quitSearch != true)
        {
            System.out.println("what would you like to search with?");
            System.out.println
            (
                "1. Name\n" +
                "2. Social Security Number\n" +
                "3. Employee Id\n" +
                "0. Return to Main"
            );

            System.out.printf("Enter selection here: ");
            
            userNumber = scanner2.nextInt();

            if (userNumber == 1)
            {

                System.out.printf("Enter the first name: ");
                String searchFName = scanner2.next();

                System.out.printf("Enter the last name:  ");
                String searchLName = scanner2.next();
        

                //System.out.println("The name you have entered:");
                //System.out.println(searchFName + " " + searchLName + "\n");

                QueryUtility.EmployeeSearchName(searchFName, searchLName);


            } 
            
            else if (userNumber == 2) 
            {
                System.out.printf("Enter a Social Security Number here: ");
                userSSN = scanner2.nextInt();

                QueryUtility.EmployeeSearchSSN(userSSN);
            } 
            
            else if (userNumber == 3) 
            {
                System.out.printf("Enter an employee ID here: ");
                userID = scanner2.nextInt();

                QueryUtility.EmployeeSearchID(userID);


                

            }
            
            
            else if (userNumber == 0) 
            {
                quitSearch = true;
            }










        }
    
        System.out.println("Closing Search\n");
        //scanner2.close();
    }


    public static void main(String[] args) 
    {
        EmpSearch();
    }
}
