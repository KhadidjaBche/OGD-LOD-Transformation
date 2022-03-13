package myPack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStream;
import java.io.OutputStream;
//import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

//import pjena.OntoModel;



import org.apache.http.HttpException;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Property;
//import com.hp.hpl.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.reasoner.rulesys.builtins.Equal;
import org.apache.jena.shared.BadURIException;
//import com.hp.hpl.jena.util.FileManager;
import org.apache.jena.util.iterator.ExtendedIterator;


/**Correction class which deals with the proposed corrections of the four principles.**/ 

public class Correction{
	
	public static int nbnondereferensable=0;
	public static String primitivesCor="";   //For corrected primitives 
	public static String primitives="";     //For primitives before correction 
	public static String primitivesCor2="";//For primitives corrected 2nd Principle
	public static String primitives2="";  //For primitives before correction 2nd Principle
	public static String classe="";
	public static int cpt=0;
	public static int nbprimacorrige =0;
	public static QuerySolution resreq;
	public static String resr="";
	public static ByteArrayOutputStream bos;
	public static int nbres=0;
	
	public static String Separateur(String element, String separateur){
		
		StringTokenizer stringTokenizer = new StringTokenizer(element,separateur); 
		   
		String[] items = new String[stringTokenizer.countTokens()] ; 
	   
		int k= 0;
	   //This loop is used in order to separate the ^^ from a String 
		while ( stringTokenizer.hasMoreTokens() ){ 
			items[k] = stringTokenizer.nextToken(); 
			k++;
		}

		//We take the first substring ; i,e. the first string befor the ==> ^^
		String id=items[0] ;
		return id;
	}
	
	
	
	
	
	

										 	 /**************************
										 	 *                         *  
											 * Correction  Principle 1 *
											 *                         *
											 **************************/
	
	//In this method we give as parameter the array of P1.Evaluate_URI containing the null values
	//and the array of all extracted primitives
	
	public static ArrayList<Triple> Corriger_Principe1(OntModel model,String ontologie,ArrayList<Triple> V) throws IOException {
		int i = 0;
		
		//An array list that will contain the corrected triples
		
		ArrayList<Triple> URI_corriges = new ArrayList<Triple>(V);
		
		//A loop that will make the correction
		for (i = 0; i< URI_corriges.size(); i++){
			
			String ns;		
			
			if(URI_corriges.get(i).objet.isLiteral() == true){
				
				System.out.println("I display the copied literal "+URI_corriges.get(i).objet.toString());
				
				String chaine = URI_corriges.get(i).objet.toString();
				
				if(chaine.contains("^^")){
					chaine = Separateur(chaine, "^^");
				}
				   chaine = chaine.replaceAll("\n", "");
				   chaine = chaine.replaceAll(" ", "");
				   chaine = chaine.replaceAll(",", "_");
				   chaine = chaine.replaceAll(":", "_");
				   chaine = chaine.replaceAll("/", "_");
				 
				System.out.println("The corrected string "+chaine);
				
				 Resource m;
				 System.out.println("Show the Prefix namespace\t"+model.getNsPrefixURI(""));
				 
				if(model.getNsPrefixURI("")!=null){
					if (!model.getNsPrefixURI("").endsWith("#"))
						ns = model.getNsPrefixURI("").concat("#").concat(chaine);
					else 
						ns = model.getNsPrefixURI("").concat(chaine);
					
					//Here we cut the string ns containing ^^ but with StringTokenizer
					if (ns.contains("^^")){
						 m= model.createResource(Separateur(ns, "^^"));
					}
					else{
						 m= model.createResource(ns);
					}
				}
				else {
					ns = "http://localhost".concat("#").concat(chaine);
					
					m= model.createResource(ns);
					
				}	
				primitives=primitives+"\n"+ URI_corriges.get(i).objet.toString();
					
				//Delete the erroneous primitive				
				model.removeAll(null, null,URI_corriges.get(i).objet );
			  

			    System.out.println("The subject is "+URI_corriges.get(i).sujet+ "    The object   "+URI_corriges.get(i).objet);
			 
			    URI_corriges.get(i).objet=m;
					    
			    System.out.println("    the object m:  "+URI_corriges.get(i).objet);
			    
			    //Here: Replace with the correct corrected primitive 
			    
			    Statement sadd = ResourceFactory.createStatement(URI_corriges.get(i).sujet,
			    													URI_corriges.get(i).predicat,
			    														URI_corriges.get(i).objet);
			  
			    model.add(sadd);
			   
			    primitivesCor=primitivesCor+"\n"+URI_corriges.get(i).objet;
			    
			    System.out.println("Corrected literal "+URI_corriges.get(i).objet); 

			}

		}
		//Generate the corrected file from Principle 1
		
		OutputStream out = new FileOutputStream("jadid.owl");
		
		try{
			model.write( out);
			
		}catch(BadURIException error){
			System.out.println("Bad URI EXCEPTION ! ");
		}
	 
	 	
	 	out.close();
		
	 	return URI_corriges;
	}
	


												 /**************************
												 *                         *  
												 * Correction  Principle 2  *
												 *                         *
												 * ************************/
	
	
	// @throws FileNotFoundException 
	/**Method for invoking the method of Switch_code in order to be able to manage the repair of P2
	 * 
	 * 
	 * Input:- The ontology model
	 * 		 - Table of primitives containing URIs
	 * 		 - The namespace for each URI******************
	 * 		 - Table of codes
	 * 		 - Path to the ontology file that contains******************
	 */
	public static OntModel Reparer_P2(OntModel model,ArrayList<Triple> T, ArrayList<TripleCode> C) throws FileNotFoundException{
		
		for (int i = 0; i< C.size(); i++){
			
			model = Switch_code(model,T,C,C.get(i).sujet);
			model = Switch_code(model,T,C,C.get(i).predicat);
			model = Switch_code(model,T,C,C.get(i).objet);
		}
	return model;	
		
	}


	/**Method Displays the correction code for each sendGet of a http URI.
	 * Informing thus the information on the dereferencing or not of a URI/
	 * 
	 * Input:- The ontology model
	 * 		 - Table of primitives containing URIs
	 * 		 - The namespace for each URI******************
	 * 		 - Table of codes
	 * 		 - Path to the ontology file that contains******************
	 * 
	 */
	static boolean b =false;
	public static OntModel Switch_code(OntModel model,ArrayList<Triple> T,ArrayList<TripleCode> TC ,int CodeR) throws FileNotFoundException{
		
		
		
		switch (CodeR){
		
		case 0 : System.out.println("Unable to repair : URI null ! "); break;
		
		//****************************The Code 200*****************************************
		
		case 200 : System.out.println("Success code: Dereferenceable URI "); break;
		case 201 : System.out.println("Success code: Dereferenceable URI "); break;
		case 202 : System.out.println("Success code: Dereferenceable URI "); break;
		case 203 : System.out.println("Success code: Dereferenceable URI "); break;
		case 204 : System.out.println("Success code: Dereferenceable URI "); break;
		case 205 : System.out.println("Success code: Dereferenceable URI "); break;
		case 206 : System.out.println("Success code: Dereferenceable URI "); break;
		
		//****************************The Code 300*****************************************
		
		case 300 : System.out.println("Redirect code : Dereferenceable URI "); break;
		case 301 : System.out.println("Redirect code : Dereferenceable URI "); break;
		case 302 : System.out.println("Redirect code : Dereferenceable URI "); break;
		case 303 : System.out.println("Redirect code : Dereferenceable URI "); break;
		case 304 : System.out.println("Redirect code : Dereferenceable URI "); break;
		case 305 : System.out.println("Redirect code : Dereferenceable URI "); break;
		
		//*****************************The Code 400***************************************
		case 400 : System.out.println("A HTTP request could not be understood "
					+ "by the server because of an incorrect syntax: URI dereferenceable "); break;
					
		case 401 : System.out.println("The request requires an identification of "
					+ "of the user: URI dereferenceable "); break;
					
		case 402 : System.out.println("This code is not yet implemented in"
					+ " the HTTP protocol: URI dereferenceable "); break;
					
		case 403 : System.out.println("The HTTP server understood the query, but "
					+ "refused to process it: URI dereferenceable ");
					b = true; break;
					
		case 404 : System.out.println("The server did not find anything that corresponds "
					+"to the requested (URI) address (not found): Non-dereferenceable URI "); 
					
					Correction_P2(model, TC,T );
					b = true; break;
			
		case 405 : System.out.println("This code indicates that the method used by "
					+ "the client is not supported for this URI: URI dereferenceable "); break;
					
		case 406 : System.out.println("The specified address (URI) exists, but not" 
				+"in the client's preferred format: non-dereferenceable URI ");
					
					Correction_P2(model, TC,T);
					b = true; break;
					
		case 407 : System.out.println("The proxy server requires authentication of the"
				+ " client before passing the request. : Dereferenceable URI "); break;
				
		case 408 : System.out.println("The client did not submit a complete request"
				+ " within the maximum time allowed, and the server "
				+ "dropped the connection: Dereferenceable URI "); break;
				
		case 409 : System.out.println("The request conflicts with another " 
					+"query or server configuration: non-dereferenceable URI ");
					
					Correction_P2(model,TC, T); 
					b = true; break;
			
		case 410 : System.out.println("The requested (URI) address no longer exists and has been"
				    +"permanently deleted from the server: Non-dereferenceable URI ");
					
				   Correction_P2(model,TC, T);
				   b = true; break;
			
		case 411 : System.out.println("The server needs to know the size of this query "
				+ " in order to be able to respond: URI dereferenceable "); break;
				
		case 412 : System.out.println("The conditions specified in the request "
				+ "are not fulfilled. : Dereferencable URI "); break;
				
		case 413 : System.out.println("The server can not process the request because"
				+ " the size of the object (URI) to return is too large: URI dereferenceable "); break;
				
		case 414 : System.out.println("The server can not process the request because"
				+ " the size of the object (URI) to return is too large: URI dereferenceable "); break;
				
		case 415 : System.out.println("The server can not process the request because"
				+ " its contents are written in an unsupported format: URI dereferenceable "); break;
				
		case 416 : System.out.println("The specified search subset"
				+ " is invalid: URI dereferencable "); break;
				
		case 417 : System.out.println("The expected behavior for the server is "
				+ " not supported: URI dereferencable "); break;
		
		//******************************************The Code 500 ***********************************************
		
		case 500 : System.out.println("Server Error Code: Dereferenceable URI "); break;
		case 501 : System.out.println("Server Error Code: Dereferenceable URI "); break;
		case 502 : System.out.println("Server Error Code: Dereferenceable URI "); break;
		case 503 : System.out.println("Server Error Code: Dereferenceable URI "); break;
		case 504 : System.out.println("Server Error Code: Dereferenceable URI "); break;
		case 505 : System.out.println("Server Error Code: Dereferenceable URI "); break;
		}
		return model;		
	}
	
	
	
	
	/**Method correcting non-dereferencable URI by replacing it with dereferencable URI using its localname of its namespace
	 * 
	 * 
	 * Input: - The ontology model 
	 * 		  - Table of primitives containing URIs "TP2"
	 * 		  - The namespace for each URI******************
	 * 
	 */
	public static void Correction_P2(OntModel model,ArrayList<TripleCode> TC,ArrayList<Triple> T) throws FileNotFoundException{
		
		int i = 0; 
		boolean genere=false;
		
		 //m : Its use is to create a new resource containing the proposed correction 
		 Resource m;
		 
		 //To get the corresponding namespace (using split on the resource to get its namespace)
		 String [] ns;
		 
		 //Variable containing the dereferencable URI corrected by using the localhost + the namespace of the erroneous URI preceded by a #
		 String uri;
		//Generate the corrected file from Principle 1
			OutputStream out = new FileOutputStream("jadid.owl");
			System.out.println("here out is ::  "+out);

			for ( i = 0; i< T.size(); i++){	
			//~~~~~~~~~~~~~~~~~~~~~~~~~Sujet~~~~~~~~~~~~~~~~~~~~~~~~~
				if ((TC.get(i).sujet)== 404 || TC.get(i).sujet == 406||TC.get(i).sujet == 409||TC.get(i).sujet ==410){	
			 		System.out.println("T.get(i).sujet.toString() "+T.get(i).sujet.toString());
										
					int k=T.get(i).sujet.toString().lastIndexOf("/");
					
					String first = T.get(i).sujet.toString().substring(k+1 ); 
					
					if(!first.startsWith("#")&& first.contains("#"))
					{
						int j=first.lastIndexOf("#");
						
						String second = first.substring(j );
						//URI contains the correction ie: URI dereferenceable

			 			uri= "http://localhost/"+second;
			 			System.out.println("APRESSSS   1  TESTTT DE #"  +first);
			 			
						
					}
						
					
					else
						if(first.startsWith("#")){
	
				 			uri= "http://localhost/"+first;
				 			System.out.println("APRESSSS   1  TESTTT DE #"  +first);
						}
							//URI contains the correction ie: URI dereferenceable 
						else{
							uri= "http://localhost/#"+first;
						}
				 						 		
				 		 //Here we create a resource to be able to then replace it with URI-dereferenceable "which is in string"  
				 		 m= model.createResource(uri);
				 		 
				 		primitives2=primitives2+"\n"+ T.get(i).sujet.toString();
				 		nbprimacorrige++;
				 		 
				 		 //Remove the wrong resource
				 		 model.removeAll(T.get(i).sujet, null,null );
				 		 
				 		 //Add the corrected resource.
				 		 T.get(i).sujet=m;
				 		 
					 	System.out.println("*** le sujet apres correction c'est ::::"+T.get(i).sujet);
	
				 		 
				 		 Statement sadd = ResourceFactory.createStatement(T.get(i).sujet,T.get(i).predicat,T.get(i).objet);
						  
					     model.add(sadd);
					     
					     primitivesCor2=primitivesCor2+"\n"+ T.get(i).sujet.toString();
					     
					     genere=true;
					     TC.get(i).sujet=200;
				}
				
				//~~~~~~~~~~~~~~~~~~~~~~~~~Predicate~~~~~~~~~~~~~~~~~~~~~~~~~
				
				Property m1;
			 	if (TC.get(i).predicat == 404|| TC.get(i).predicat == 406||TC.get(i).predicat == 409||TC.get(i).predicat ==410) {	
			 		
			 		System.out.println("T.get(i).redicat.toString() "+T.get(i).predicat.toString());
			 		int k=T.get(i).predicat.toString().lastIndexOf("/");
					
					String first = T.get(i).predicat.toString().substring(k+1 );  
					
					if(!first.startsWith("#")&& first.contains("#")){
						int j=first.lastIndexOf("#");
						
						String second = first.substring(j);
						
						//uri contains the correction ie: URI dereferenceable
						uri= "http://localhost/"+second;
					}
						
					
					else
							if(first.startsWith("#")){
					 			uri= "http://localhost/"+first;
							}
								//uri contains the correction ie: URI dereferenceable 
							else {
								uri= "http://localhost/#"+first;	 
							}
					 		 
					 		 //Here we create a property to be able to then replace it with URI-dereferenceable "which is in string"  
					 		 m1=model.createProperty(uri);
					 		 
					 		primitives2=primitives2+"\n"+ T.get(i).predicat.toString();
					 		nbprimacorrige++;
					 		//Remove the wrong property
					 		 model.removeAll( null,T.get(i).predicat,null );
					 		 
					 		 T.get(i).predicat=m1;
					 		 
					 		//Add the corrected property.
					 		 Statement sadd = ResourceFactory.createStatement(T.get(i).sujet,T.get(i).predicat,T.get(i).objet);
							  
						     model.add(sadd);
						     genere=true;
						     primitivesCor2=primitivesCor2+"\n"+ T.get(i).predicat.toString();
						     System.out.println("Je suis cote predicat 2 ");
				   
			 	}
				
			 	//~~~~~~~~~~~~~~~~~~~~~~~~~Object~~~~~~~~~~~~~~~~~~~~~~~~~
			 	  System.out.println("Here is the object ! ");
			 	if (TC.get(i).objet == 404|| TC.get(i).objet == 406||TC.get(i).objet == 409||TC.get(i).objet ==410){	
			 
			 		int k=T.get(i).objet.toString().lastIndexOf("/");
					
					String first = T.get(i).objet.toString().substring(k +1);  
					System.out.println("T.get(i).objet.toString() "+T.get(i).objet.toString());
					
					if(!first.startsWith("#")&& first.contains("#")){
						
						int j=first.lastIndexOf("#");
						
						String second = first.substring(j );
						//uri contains the correction ie: URI dereferenceable
			 			uri= "http://localhost/"+second;
					}
						
					
					else
						if(first.startsWith("#")){
		
					 			uri= "http://localhost/"+first;
					 			System.out.println("APRESSSS   1  TESTTT DE #"  +first);
							}
						 //URI contains the correction ie: URI dereferenceable
						else{	
								
							uri= "http://localhost/#"+first;
						}
			 		//Here we create a resource to be able to then replace it by dereferenceable URI "which is in string"  
			 		 m=model.createResource(uri);
			 		 
			 		primitives2=primitives2+"\n"+ T.get(i).objet.toString();
			 		nbprimacorrige++;
			 		//Delete the erroneous resource.
			 		 model.removeAll( null,null,T.get(i).objet );
			 		 
			 		//Add the corrected resource.
			 		 T.get(i).objet=m;
			 	
			 		 System.out.println("The object after correction is :::::: "+T.get(i).objet);
			 		
			 		 Statement sadd = ResourceFactory.createStatement(T.get(i).sujet,T.get(i).predicat,T.get(i).objet);
					  
				     model.add(sadd);
				     genere=true;
				     primitivesCor2=primitivesCor2+"\n"+ T.get(i).objet.toString();
				    
				     TC.get(i).objet=200;
				     	
			 	}
	}
				 	if(genere==true){
				 		//Generate the corrected file from Principle 1
					 	model.write( out); 
					 	
					 	try {
							out.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 	}
				 	try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				 	
		}
	

	public static void Generer_fichier(OntModel model,String fichier) throws FileNotFoundException{
		
	    OutputStream out = new FileOutputStream(fichier);
		 	model.write( out); // readable rdf/xml
		 	try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	public static void Principes (OntModel model, String ontologie,ArrayList<Triple> V,ArrayList<TripleCode> C) throws IOException{
		
		 ArrayList<Triple> Tableau = Corriger_Principe1( model,ontologie,V);
	    model =	Reparer_P2(model, Tableau, C);	
	}
	

										 /**************************
										 *                         *  
										 * Correction  Principle 3  *
										 *                         *
										 * ************************/
	
	
	 
	
	
	/**Method to propose corrections to syntactic errors:
	 * 
	 * Input: -File containing the syntactic errors of ontology in reading.
	 *		  -File containing all possible errors in reading.
	 * 		  -File result of proposal of correction of the error.
	 * 
	 */
	 public static void Corriger_Principe3(File fichier_resultat, File fichier_erreurs,String fichier_correction) throws IOException{
		 
		//A buffer to read the result file of errors containing in the ontology.
		 BufferedReader readerResultat = new BufferedReader(new FileReader(fichier_resultat));	
		 
		//Line to browse result file containing errors in the ontology.
		 String lineResultat = null;
		 
		//A buffer to read the file of all possible errors
		 BufferedReader readerErreurs =null;
		 
		//Line to browse file
		 String lineErreurs = null;
		 
		 //Boolean list to check if an error exists in the ontology
		 ArrayList<Boolean> list =  new ArrayList<Boolean>();
		 
		 int cpt =0, i=0;
		 
		 boolean b= false;
		 
		 //Initialize ArrayList to false
		 for (cpt=0; cpt<75;cpt++){
			 list.add(false);
		 }
		 
		 
		try{

			FileWriter output = new FileWriter(fichier_correction,false);

			// The BufferedWriter output to which one gives as argument the FileWriter fw created just above
		
			while ((lineResultat = readerResultat.readLine())!=null){
			
				//A buffer to read the file
				readerErreurs = new BufferedReader(new FileReader(fichier_erreurs));
				i=0; b = false;
				
				//Exit the loop if you find the error in the possible error files or the end of this file.
				while ((lineErreurs = readerErreurs.readLine())!=null && b == false){
					
					String recuperError = Separateur(lineErreurs, "=");


					//If we find the error in the file of all the syntactic errors.
					if (lineResultat.contains(recuperError)){  
						b =true;
						if (list.get(i)==false){
					
						 //We mark in the file or rather in the BufferedWriter which serves as a buffer (stream)
							output.write(lineErreurs+"\n\n");
							
							//Mark that the error of the i position of the file exists on the ontology file.
							list.add(i, true);
							
						}
				
						if(lineResultat.contains("Unable to validate")){
							
							String [] ligne = lineResultat.split("Unable to validate");
														
							String [] ligne2 = ligne[1].split(recuperError);
							
							//Writes the error line in the correction file.
							output.write(ligne2[0]+"\n");
							//fw.write("\r\n");
					 	}
					}
					
					//flush sends to the write file.
					 	output.flush();
							i++;
				 }
			 }
			
			//Closing the file containing all possible syntax errors.
			 readerErreurs.close();
		}catch(IOException ioe){
			//Case of failure of creation Write Files.
			System.out.print("Write file error: ");
		}
		
		//Closure of the file containing the syntactic errors of the ontology.
		readerResultat.close();

	 }
	
 
								 	/***************************
									 *                         *  
									 * Correction  Principle 4 *
									 *                         *
									 * ************************/
	 
		
		/**Method for Retrieving Classes and Subclass of an Ontology :
		 * 
		 * Input: The ontology model 
		 * 
		 * Output: A string representing a class of ontology.
		 * @return *****
		 * 
		 */
	 public static void Recuperer_classe(OntModel Modele) {
 
         ExtendedIterator classes = Modele.listClasses();
         
          classe="";
          String C="";  cpt=0;
          
          OntClass c;
          while (classes.hasNext()) {
          
        	  OntClass essaClasse = (OntClass) classes.next();

         	  //Viewing the class.
              System.out.println("Classe: " + essaClasse.getLocalName());
              if(essaClasse.getLocalName()!=null){
            	  classe=classe+essaClasse.getLocalName()+"\n";
            	  cpt++;
              }
              
              //Display subclasses of the class if they exist
              for (Iterator i = essaClasse.listSubClasses(); i.hasNext();) {
                 
             	 c = (OntClass) i.next();
             	
             	 if(c.getLocalName()!=null){
             		classe=classe+c.getLocalName()+"\n";
             		cpt++;
             	}
             	
             	 System.out.print("   " + c.getLocalName() + "\n");
              
              }
          }
         if(cpt==0)
        	 if (!P1.literal.equals(""))
        		 	classe=P1.literal;
 
	 }

	 

	 
		/**Method to query DBpedia according to the chosen class in order to link the ontology with this class.
		 * 
		 * 
		 * Input:- The ontology model
		 * 		 - Classes among the classes of the ontology recovered from the previous method
		 * 
		 */
	 public static void Sparql_Requete(OntModel m, String classe) throws HttpException
	 {
		 //Writing the SPARQL query
		 String queryString2 = 
				 
				 	//Prefix declaration
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +				
					"PREFIX : <http://dbpedia.org/resource/>" +
					"PREFIX dbpedia2: <http://dbpedia.org/property/>" +
					"PREFIX dbpedia: <http://dbpedia.org/>" +
					"PREFIX dbo: <http://dbpedia.org/ontology/>" +
			 		"PREFIX dbp: <http://dbpedia.org/ontology/>"+
			 		"PREFIX dbpprop: <http://dbpedia.org/property/>"+
			 		
			 		//SPARQL query
			        "select ?dbsp ?valeur where {"+
					"?dbsp rdfs:seeAlso ?valeur ."+
					"filter contains( str(?valeur), '"+classe+"' )"+
					"	}"+
					"limit 10";
		 
			//Create query with QueryFactory
			 Query query = QueryFactory.create(queryString2); 
			 
			//Run the query in the SPARQL service specific to wikipedia.
	         QueryExecution qexec =QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
	         
	         bos= new ByteArrayOutputStream();
	         
	         try{
	        	 //Retrieve the result of select execution
	        	 ResultSet results = qexec.execSelect();
	        	
	        	 while(results.hasNext()){
	        		 
	        		 QuerySolution soln = results.nextSolution();

	        		 //Print the result of the query.
	        	 	// ResultSetFormatter.out( System.out,results,query);
	        	 	 resreq=soln;
	        	 	 resr=resr+resreq;
	        	 	 nbres = results.getRowNumber();
	        	 	ResultSetFormatter.out(bos, results );
	        	 	ResultSetFormatter.out( results );
	        	 }
	         }finally{
	             qexec.close();
	         }
	 }
	 
	 public static void ajout_lien(OntModel model, String lien) throws IOException {
			
		 
		 //Create the subject resource corresponding to the rdf-schema
		 	Resource resource=model.createResource("http://www.w3.org/2000/01/rdf-schema");
		 	
		 //Create the rdf: seeAlso property (for example)	
		 	Property prop=model.createProperty("rdf:seeAlso");
		 	
		 //Create the object by putting the selected link as the primitive of the object 	
		    Resource obj=model.createResource(lien);
		  
		  //Add this triplet created in the ontology model  
		    model.add(resource,prop,obj); 
		    
			//Generate the corrected file of Principle 4
			OutputStream out = new FileOutputStream("new.owl");
			
		 	model.write( out); 
		 	
		 	out.close();
		 	
		}
	 
}