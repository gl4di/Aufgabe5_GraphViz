
public class GraphViz 
{
	public static void makeGraph()
	{
	  try
	  {
		 String dotEXE = "U:\\mINF31_svn\\Aufgabe5_ModellVisualisieren\\release\\bin\\dot.exe"; 
		 //String dotDatei = "U:\\mINF31_svn\\Aufgabe5_ModellVisualisieren\\paket.dot";
		  
		  Runtime rt = Runtime.getRuntime();
		   rt.exec( dotEXE + " -Tpng paket.dot -o Paket.png");
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception");
	  }
	}
}
