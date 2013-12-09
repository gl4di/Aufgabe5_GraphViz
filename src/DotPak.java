import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class DotPak implements java.io.Serializable
{

	private static final long serialVersionUID = 2755395314710897149L;
	
	public DotPak()
	{
		
	}
	
	
	public static void write( DotPak dotpak )
	{
		PrintWriter printWriter = null;
        
		try 
        {
            // Will overwrite the file if exists or creates new
            printWriter = new PrintWriter("paket.dot","UTF-8");
            printWriter.println("digraph Beziehungen {");
            printWriter.println("Bernd -> Franz [label=\"hasst\"]");
            printWriter.println("Franz -> Bernd [label=\"hasst\"]");
            printWriter.println("Franz -> Jutta [label=\"liebt\"]");
            printWriter.println("Bernd -> Jutta [label=\"liebt\"]");
            printWriter.println("}");
        }
		catch (FileNotFoundException fileNotFoundException) 
		{
            fileNotFoundException.printStackTrace();
        } 
		catch (UnsupportedEncodingException unsupportedEncodingException) 
		{
            unsupportedEncodingException.printStackTrace();
        } 
		finally 
		{
            printWriter.close();
        }
        
		
	}
	
	public static DotPak read()
	{
		
		return new DotPak();
	}
}
