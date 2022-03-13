package myPack;


		//The necessary imports for the execution of the fourth principle :


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



/**Class P4 which allows to test the fourth principle thus count the number of link 
 *	 of an ontology to evaluate it if it has links to other data.**/ 
public class P4 {
	

	//Variable to calculate the Rate of the links pointed by ontological primitives
	public static double Taux = 0 ;
	public static int link = 0;
	public static String [] proprietes = new String[10000];
	public static Set<String> set = new HashSet<String>();
	
	
	
					/**
					 * 
					 * ***************************             ***********************
					 ***************************** THE METHODS ***********************
					 ****************************              ************************ 
					 * 
					 * */
	

	/**Method that displays the number of links pointed by an ontology :
	 * 
	 * Input:- A file containing the links properties
	 * 		 - Table of all primitives 
	 */
	public static void Nombre_liens(File f1 , ArrayList<Triple> T) throws IOException
	{

		//Line to browse file
		String linef1 = null;
		
		//i : To browse ArrayList   -  link: To count the number of links.
		int i = 0;
		
		//Browse All ontology triplets that are in ArrayList.
		for(i = 0; i< T.size();i++)
		{	
		
			//A buffer to read the file
			BufferedReader readerf1 = new BufferedReader(new FileReader(f1));
			
			
			//Trouve : boolean Informing the existence or not of link property in ontology.
			boolean trouve = false;
			
			//While it is not the end of the file containing the vocabulary of the links properties
			while ((linef1 = readerf1.readLine())!=null && trouve == false)
			{
				//Test if predicate = property that represents a link property
				
				if (T.get(i).predicat.toString().contains(linef1))
				
				{ 	
					//We found a link property
					trouve = true;
					//proprietes
					//proprietes[link] = linef1;
					System.out.println("TAF TAF TAF ---"+T.get(i).predicat.toString());
					set.add(linef1);
					//Increase the number of links
					link++; 
				 }
				
			}
			//Closes the reading file containing the properties of the links. 
			readerf1.close();
		}
		

		 System.out.println(set);
		
		
		//Display corresponding to the number of ontology links.
		if (link > 0 )
			
			System.out.println("There are at least : "+link +" link (s) in this ontology ");
		else
			
			System.out.println("This ontology has no link! ");
			
		
		//Rule of three to calculate the rate of the links represented in the ontology with respect to the correct primitives.
		Taux = (double) Math.round(link * 100 ) /(P1.NombrePrimitiveCorrecte);
		
		
		 //Round the value up to 2 digits after the decimal point.
		Taux = (double) Math.round(Taux * 100 ) /100;
		
		
		//Print the correct number of primitives
		System.out.println("Number of correct primitives =  "+P1.NombrePrimitiveCorrecte); 
		
		
		//Print the calculated rate of links
		System.out.println("Rate of links pointed to by ontology primitives =  "+Taux + " %");
	}
	

}