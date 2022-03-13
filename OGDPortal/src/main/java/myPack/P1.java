package myPack;


          //The necessary imports for the execution of the first principle :

import java.io.IOException;
import java.util.ArrayList;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.Ontology;
import org.apache.jena.ontology.impl.OntologyImpl;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.iterator.ExtendedIterator;

/**Class P1 which allows to test the first principle thus extract the primitives of ontology**/ 
public class P1
{
public static int nbliteral;
//Table containing anonymous primitives
public static ArrayList<Integer>  Anon = new ArrayList<Integer> (0); 

   //Table containing the primitives evaluated according to the first principle
public static ArrayList <Triple> TP2 = new ArrayList<Triple>();

  //To calculate the primitives Which respects the first principle
public static int NombrePrimitiveCorrecte = 0; 

  //To calculate anonymous nodes
	public static int NoeudAnonyme = 0;
	
	 //To calculate non-URI primitives
	public static int NonURI = 0;
	
	 //To calculate the null primitives
		public static int NbNull = 0;

public static String literal="";

public static ArrayList <Triplet> Vec = new ArrayList<Triplet>(); 

  //Variable to calculate the rate of primitives identified by a URI
public static double Taux = 0 ;

						/**
						 * 
						 * ***************************             ***********************
						 *****************************THE METHODS ***********************
						 ****************************              ************************ 
						 * 
						 * */



/** Method that returns the URI of the ontology:
* 
* Input: The ontology model
* 		 Path or URI of the ontology to be tested 
* 
*/
 public static String URI_Ontologie(OntModel m,String ontologie )
 
 {                                    
	    //Iterator to browse the ontology list
	 	ExtendedIterator<Ontology> iter=m.listOntologies();
	 	
	 	//A string that is then returned as an ontology URI
	 	String ontologieURI=""; 
	 	
	 	//A loop to browse the ontology list to extract its URI  
	 	while(iter.hasNext())
	 	{	
	 		OntologyImpl onto=(OntologyImpl)iter.next();
	 		ontologieURI=(onto.getURI());  
	    }
	 	
	 	//Call to the function that checks the validity of the URI
	 	//VerifierURI verif = new VerifierURI();
 	
	   return ontologieURI;
	
 }
 

 

/**Method returns an array of primitives containing the ontology triplets:
 * 
 * Input: The ontology model 
 * 		  Path or URI of the ontology to be tested 
 */
  public static ArrayList<Triple> Extraire_Primitif(OntModel m,String ontologie)
  
  {
	  	//An arraylist that will contain the triplets 
	    ArrayList <Triple> T = new ArrayList<Triple>();
	    
	    //An iterator allowing to traverse the returned triplets 
        StmtIterator iter2 = m.listStatements();
        
	
        //The extraction of primitives: Subject, Predicate and Object of each statement
        while (iter2.hasNext())
        {		
        		//Get the next statement
        		Statement stmt      = iter2.nextStatement(); 
        		
        		//Retrieve the subject
        		Resource  subject   = stmt.getSubject();
        		
        		//Retrieve the predicate
        		Property  predicate = stmt.getPredicate();
        		
        		//Retrieve the object
        		RDFNode   object    = stmt.getObject();   
        		
        		//To keep it as it is.
        		Triple e= new Triple(subject, predicate,object);
        		
        		//Add a triplet in the table
        		T.add(e);
        		
        		Triple e1= new Triple(null, null,null);
        		
        		//Initialization of the array containing the primitives evaluated according to the 1st principle
        		TP2.add(e1);
        }
   
         //Number of ontology primitives :
        
          System.out.println("The number of ontology primitives  :"+T.size()*3); 
  
          return T;
	
    }
  


/**A method that returns an array of primitives containing the ontology triplets that respect the 1st Principle:
 * 
 * Input: An array of primitives extracted from the ontology
 */
   public static ArrayList <Triplet>  Evaluer_URI(ArrayList <Triple> V)
   {	
	   
	   //Call to the function that checks the validity of the URI
     	VerifierURI verif = new VerifierURI();
     	
     	//Variable j to calculate the number of litterals
    	int i, j=0;
    	Triplet element;
    	for (i=0; i<V.size();i++){
    		
    		element = new Triplet(V.get(i).sujet.toString(),V.get(i).predicat.toString(),V.get(i).objet.toString());
    		element.setS(V.get(i).sujet.toString());
    		element.setP(V.get(i).predicat.toString());
    		element.setO(V.get(i).objet.toString());
    		Vec.add(element);
    		//System.out.print("Vect.getSujet ==> " +Vec.get(i).getS()+"\t");
    		//System.out.print("Vect.getPredicat ==> " +Vec.get(i).getP()+"\t");
    		//System.out.println("Vect.getObjet ==> " +Vec.get(i).getO());
    	}
    	
    	
     	 
    	//Loop to check the validity of the URIs in the resource ie: Subject, predicate and object
    	for (i=0; i<V.size();i++)
    	{
         
    		//~~~~~~~~~~~~~~~~~~~~~~~~~Subject~~~~~~~~~~~~~~~~~~~~~~~~~
    		
    		//If the subject is an anonymous node
         		if ( (V.get(i).sujet.isAnon() == true))
         		{
             		//System.out.println("TRIPLET N°  "+i+"\tSujet anonyme  "+V.get(i).sujet);
         			NoeudAnonyme++;
         			Vec.get(i).setS("*******");

         		 }
         		else
         		{
         			// If subject does not have a URI
     				if (verif.URINull(V.get(i).sujet) == true)
     				{  
     					NbNull++;
     					//System.out.println("TRIPLET N°  "+i+"\tSujet incorrect  "+V.get(i).sujet);
     					Vec.get(i).setS("*******");
     				}
     				else{
     					//If the subject's regular expression is false | /*if (verif.EXPReg(V.get(i).sujet.toString()) == false)*/

	         			if (VerifierURI.EXPReg(V.get(i).sujet.toString()) == false)
	         			{
	         				
	                 		//System.out.println("TRIPLET N°  "+i+"\tSujet incorrect  "+V.get(i).sujet);
	         				NonURI++;
	         				Vec.get(i).setS("*******");
	                 		
	         			}
         				else
         				{
         					//Otherwise the primitive is correct (respect the first principle)
         					NombrePrimitiveCorrecte++; 

         				}
     				}
         		}
         	

         //~~~~~~~~~~~~~~~~~~~~~~~~~Predicate~~~~~~~~~~~~~~~~~~~~~~~~~
         
         	
         	//If the predicate URI is null
         	if(verif.URINull(V.get(i).predicat) == true)
         	{
         		
         		//System.out.println("TRIPLET N°  "+i+"\tpredicat incorrect  "+V.get(i).predicat);
         		
         		NbNull++;
         		Vec.get(i).setP("*******");
         		//V.get(i).predicat=null ;
         	}
         	else
         	{
         		//If its regular expression is false
         		if (VerifierURI.EXPReg(V.get(i).predicat.toString()) == false)
         		{
         			
             		//System.out.println("TRIPLET N° "+i+"\tpredicat incorrect  "+V.get(i).predicat);
             		
         			NonURI++;
         			Vec.get(i).setP("*******");
             		
             		//V.get(i).predicat=null ;
         		}
         		else
         		{
         			//Otherwise the primitive is correct (respect the first principle)
     				NombrePrimitiveCorrecte++;
     			
     			}
         	}

         	
         	
         //~~~~~~~~~~~~~~~~~~~~~~~~~Object~~~~~~~~~~~~~~~~~~~~~~~~~
         	
         	
         	
         		//If the object is an anonymous node
         		if (V.get(i).objet.isAnon() == true)
         		{
         			
             		//System.out.println("TRIPLET N°  "+i+"\tobjet est anonyme  "+V.get(i).objet);
             		
             		//TP2.get(i).objet=null;
             		
             		//V.get(i).objet=null ;
         			NoeudAnonyme++;
         			Vec.get(i).setO("*******");
         		}
         		else
         		{
         			//If the object is not a literal 
         			if (V.get(i).objet.isLiteral()!= true)
         			{
         				
         				//And that it has a false regular expression!
         				if (VerifierURI.EXPReg(V.get(i).objet.toString())== false)
         				{
         					NonURI++;
         					Vec.get(i).setO("*******");
                     		//System.out.println("TRIPLET N°  "+i+"\tobjet incorrect "+V.get(i).objet);
                     		
                     		//TP2.get(i).objet=null;
                     		
                     		//V.get(i).objet=null ;
                     		
         				}
         				else
         				{
         					// Otherwise the primitive is correct (respect the first principle)
         					NombrePrimitiveCorrecte++;
         			
         				}
         			}
         			else
         			{
         				//If the URI of the object is null
         				if (verif.URINullO(V.get(i).objet) == true)
         				{
         					NbNull++;
         					//System.out.println("TRIPLET N°  "+i+"\tobjet incorrect  "+V.get(i).objet);
         					Vec.get(i).setO("*******");
         					TP2.get(i).objet=null;
         					
         					//V.get(i).objet=null ;
    	         		
         				}
    	         	
         			 else
         			 { 
         				//Here Object is literal
         				j++;
         				
         				//System.out.println("TRIPLE N°  "+i+"\t is a LITERAL  "+V.get(i).objet);

         				TP2.get(i).objet=V.get(i).objet ;
         				Vec.get(i).setO("*******");
         				System.out.println("TRIPLET N°  "+i+"\t is a  LITERAL  "+TP2.get(i).objet);
         				System.out.println("Vec.Literal ? "+Vec.get(i).getO());
         				literal=literal+TP2.get(i).objet+"\n";
         				//V.get(i).objet=null ;
         				
         			}
         					
         		}
         	}
    }     	
    	nbliteral=j;
		System.out.println("nbliteral "+nbliteral);
    	
		System.out.println("Literal number =  "+j);
		
		//Calculating the rate of primitives identified by URI
		 Taux = (double) Math.round(NombrePrimitiveCorrecte * 100 ) /(V.size()*3);
		 
	     Taux = (double) Math.round(Taux * 100 ) /100;
	     
		 System.out.println("Rate of primitives represented by URIs  =  "+Taux + " %");
		 
	     System.out.println("NbP1  correct =  "+NombrePrimitiveCorrecte +" and total primitives = " +V.size()*3);
		 
    
    return Vec;//Containing valid URIs
	
}



/**Method for displaying ontology primitives.
 * 
 * Input: An array of extracted primitives
 */
 public static void Afficher (ArrayList<Triple> T){
		
		for (int i = 0 ; i< T.size(); i++)
		{
			
	     System.out.println(" =========================================================================================================");
	        
	    
	     System.out.println("|TRIPLE N°"+i+"|SUBJECT :"+T.get(i).sujet);
	     //System.out.println("|TRIPLE N°"+i+"|SUBJECT :"+Vec.get(i).getS());
	     System.out.println(" -------------------------------------------------------------------------------------------------------- ");
	        	 			
	     System.out.println("|          |PREDICATE :"+T.get(i).predicat);
	     //System.out.println("|          |PREDICATE :"+Vec.get(i).getP());
	     System.out.println(" -------------------------------------------------------------------------------------------------------- ");  	 			

	     			 
	 	 System.out.println("|          |OBJECT :"+T.get(i).objet);
	 	 //System.out.println("|          |OBJECT :"+Vec.get(i).getO());
	     System.out.println(" -------------------------------------------------------------------------------------------------------- ");
	     		 			

	        }
	     System.out.println(" =========================================================================================================");	
	        	
	}
 

/** Method that returns the ontology namespace.
 * 
 * Input: An array of extracted primitives
 */
 public static String namespace(OntModel model,String ontologie) throws IOException 
 {  
 	//Get the namespace
 	return model.getNsPrefixURI("");
 	 
 	
 }
}