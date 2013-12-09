import org.sparx.Collection;
import org.sparx.Connector;
import org.sparx.Diagram;
import org.sparx.Element;
import org.sparx.Package;

public class Main 
{
	public static void main(String[] args) 
	{

		org.sparx.Repository r = new org.sparx.Repository();
		r.OpenFile("U:\\mINF31_svn\\Aufgabe5_ModellVisualisieren\\U05.eap");
		//r.OpenFile("U:\\mINF31_svn\\Aufgabe4_Fabrik\\U04_Fabrik.eap");
		
		//Modelle und Pakete auslese
		Collection<org.sparx.Package> models = r.GetModels();
		short nModels = models.GetCount();
				
		System.out.println("Models: " + nModels);
		
		for( short i = 0; i < nModels; ++i )
		{
			Package p = models.GetAt(i);
			System.out.println("\t " + p.GetName() );
			
			Collection<org.sparx.Package> subpackages = p.GetPackages();
			short nPackages = subpackages.GetCount();
			
			System.out.println("Packages: " + nPackages);
			
			for( short j = 0; j < nPackages; ++j )
			{
				Package subpackage = subpackages.GetAt(j);
				System.out.println("\t " + subpackage.GetName() );
				
				Collection<Diagram> diagrams = subpackage.GetDiagrams();
				short nDiagram = diagrams.GetCount();
				
				System.out.println("Diagram: " + nPackages);
				
				//Get Diagrams
				for( short k = 0; k < nDiagram; ++k )
				{
					Diagram diagram = diagrams.GetAt(k);
					System.out.println("\t " + diagram.GetName() );
					
					Collection<Element> elements = subpackage.GetElements();
					short nElements = elements.GetCount();
								
					System.out.println("Elements: " + nElements);

					for( short h = 0; h < nElements; ++h )
					{
						Element e = elements.GetAt(h);
						System.out.println("\t " + e.GetName() );
						
						Collection< Connector > connectors = e.GetConnectors();
						short nConnectors = connectors.GetCount();
						System.out.println("\t\t" + "Connectors: " + nConnectors);
						
						for( short l = 0; l < nConnectors ; ++l )
						{
							Connector c = connectors.GetAt(l);
							System.out.println("\t\t\t " + c.GetType() );
						}
					}
				}
			}
		}
		
		DotPak dotPak = new DotPak();
		dotPak.write(null);
		
		GraphViz.makeGraph();
		
		
		
		r.CloseFile();

	}

}
