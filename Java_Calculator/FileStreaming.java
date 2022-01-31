import java.io.*;
import javax.swing.filechooser.*;

public class FileStreaming 
{
    private static String Filepath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

    private static File HistoryFile = new File(Filepath + "\\CalulationHistory.txt");

    //For Wrinting to file

    public static void FileWriting(int ascii_in, boolean WriteOver) throws IOException
    {
        

        FileOutputStream FileWriteOut = new FileOutputStream(HistoryFile, WriteOver);

        try
        {

            HistoryFile.createNewFile();

            FileWriteOut.write(ascii_in);

        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            FileWriteOut.close();
        }
    }
    
    //For Reading File and display to Terminal

    public static void FileReading()throws IOException
    {
        FileInputStream FileReadIn = new FileInputStream(HistoryFile);

        int ascii_out;

        while((ascii_out = FileReadIn.read()) != -1)
        {
            System.out.write(ascii_out);
        }

        FileReadIn.close();
    }
    
    //Clear File

    public static void FileClear() throws IOException
    {
        FileOutputStream FileClear = new FileOutputStream(HistoryFile);

        FileClear.write(13);

        FileClear.close();
    }
}
