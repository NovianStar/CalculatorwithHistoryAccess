import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import javax.swing.filechooser.*;

public class Main 
{
    //Attempt to create CalculationHistory.txt at local document//

    private static String Filepath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

    private static File HistoryFile = new File(Filepath + "\\CalulationHistory.txt"); 

    //=================================================================================================//

    private static String string;

    private static boolean ActiveState = true;

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        HistoryFile.createNewFile();

        System.out.println("======================================================");
        System.out.println("\nWelcome to Pre-Alpha \"Calculator with History Access!\"");
        System.out.println("\n======================================================");

        while (ActiveState)
        {
            ChooseOperation(); //Choose the Operator...
        }

        System.out.println("\n=====================================================================");
        System.out.println("\nThank you for using! Consider give us feedback if your would like to!");
        System.out.println("\n=====================================================================");
    }
    //Choose Operation, most working will be in here...

    public static void ChooseOperation() throws IOException 
    {
        System.out.println("\n=============================");
        System.out.println("\nPlease, choose your operation");
        System.out.println("\n1. Calculator");
        System.out.println("\n2. History");
        System.out.println("\n3. Clear History");
        System.out.println("\n9. Help");
        System.out.println("\n0. Exit");
        System.out.println("\n=============================");

        string = "";

        string = input.nextLine();

        while(string == null)
        {
            System.out.println("Please, enter valid input...");
            string = input.nextLine();
        }

        string = string.toLowerCase();
        switch(string)
        {
            case("1"):
            {
                CalculatorInput();
                break;
            }
            case("2"):
            {
                AccessHistory();
                break;
            }
            case("3"):
            {
                ClearHistory();
                break;
            }
            case("9"):
            {
                Help();
                break;
            }
            case("0"):
            {
                ActiveState = false;
                break;
            }
            default:
            {
                System.out.println("Please, enter valid input...");
                break;
            }
        }
    }

    //This is Number One Operator, will receive input and calculate it, also write result in text file
    
    public static void CalculatorInput() throws IOException
    {
        System.out.println("\n================================");
        System.out.println("\nPlease enter your first value...");
        System.out.println("\n================================");

        float var1 = 0, var2 = 0, result1;

        int op1 = 0;

        try
        {
            string = input.nextLine();
            var1 = Float.parseFloat(string);
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex);
            System.out.println("\nPlease try again...");
            return;
        }

        System.out.println("\n============================");
        System.out.println("\nPlease enter the operator...");
        System.out.println("\n1. +");
        System.out.println("\n2. -");
        System.out.println("\n3. x / *");
        System.out.println("\n4. /");
        System.out.println("\n5. %");
        System.out.println("\n============================");

        try
        {
            string = input.nextLine();
            op1 = Integer.parseInt(string);
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex);
            System.out.println("\nPlease try again...");
            return;
        }

        System.out.println("\n=================================");
        System.out.println("\nPlease enter your second value...");
        System.out.println("\n=================================");

        try
        {
            string = input.nextLine();
            var2 = Float.parseFloat(string);
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex);
            System.out.println("\nPlease try again...");
            return;
        }

        result1 = Calculator.calculation(var1, var2, op1);

        System.out.println(result1); 
        
        char Character;

        int nameLength;

        string = String.valueOf(result1);

        nameLength = string.length(); 

        for(int i = 0; i < nameLength ; i++)
                
        {    
            Character = string.charAt(i);

            int ascii = (int) Character;

            FileStreaming.FileWriting(ascii, true);

        }

        FileStreaming.FileWriting(44, true);

        FileStreaming.FileWriting(32, true);
        
        System.out.println("Press Enter key to continue...");

        string = input.nextLine();
        
    }

    //Access Result History

    public static void AccessHistory() throws IOException
    {
        FileStreaming.FileReading();

        System.out.println("\nAccess History Completed!");

        System.out.println("Press Enter key to continue...");

        string = input.nextLine();
    }

    //Clear Result History

    public static void ClearHistory() throws IOException
    {
        FileStreaming.FileClear();

        System.out.println("History Cleared");

        System.out.println("Press Enter key to continue...");

        string = input.nextLine();
    }

    //Help, mostly for description...

    public static void Help()
    {
        System.out.println("\n================================================================");
        System.out.println("\n\"Calculator with History Access\" is in pre-alpha state.");
        System.out.println("\nThis program will attempt to create txt file at User's document,");
        System.out.println("\nwhich will store and allow to access calculating log.");
        System.out.println("\nI welcome all the feedback for improvement...");
        System.out.println("\n================================================================");

        System.out.println("Press Enter key to contunue...");

        string = input.nextLine();
    }

}
