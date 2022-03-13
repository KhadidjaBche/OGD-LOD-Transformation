package myPack;


//The necessary imports for the execution of the third principle :


import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.util.Iterator;
import java.util.List;

import org.apache.jena.atlas.io.IndentedWriter;

import uk.ac.manchester.cs.datadesc.validator.ExternalLinkValdiationTest;
import uk.ac.manchester.cs.datadesc.validator.RdfValidator;
//import uk.ac.manchester.cs.datadesc.validator.ExternalLinkValdiationTest;
//import uk.ac.manchester.cs.datadesc.validator.ExternalLinkValdiationTest;
//import uk.ac.manchester.cs.datadesc.validator.RdfValidator;
import uk.ac.manchester.cs.datadesc.validator.metadata.MetaDataSpecification;
import uk.ac.manchester.cs.datadesc.validator.rdftools.VoidValidatorException;

import org.apache.jena.ontology.OntModel;
//import com.hp.hpl.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
//import com.hp.hpl.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
//import com.hp.hpl.jena.rdf.model.Literal;
//import com.hp.hpl.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
/*import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;*/

/**Class P3 allows to test the 3rd principle thus calculate the number of syntactic errors**/ 
public class P3 { 
	
	
	//Variable to calculate the rate of useful information provided by the ontology:
		//Calculate the number of syntactic errors in relation to the number of primitives.
	public static double Taux = 0 ;
	//public static double Tauxsecondaire = 0 ;
	public static int Erreurs;
	public static String InfoUtiles ="";
	public static int compteur=0;
	public static int Infos = 0;
	public static ByteArrayOutputStream bos;
	public static QuerySolution resreq;
	public static String resr="";


						/**
						 * 
						 * ***************************             ***********************
						 *****************************THE METHODS ***********************
						 ****************************              ************************ 
						 * 
						 * */
	
	
 
	/**Method that verifies that the ontology is syntactically correct: Call to validator methods
	 * 
	 * Input: Path or URI of the ontology to be tested 
	 */
	public static void Tester_Validation_Ontologie(String ontologie) throws VoidValidatorException, IOException{
		 
		try{
			try{
				//If it is an ontology that exists on the web: URL of the ontology that is in parameter
				if (ontologie.startsWith("http://")||ontologie.startsWith("https://"))
					
					
					//Validator method called to validate the ontologies that exist on the web and given by their URL.
					ExternalLinkValdiationTest.validateURIOps(ontologie, true);
				
				
				//If it is an ontology that exists on the disk: it is represented by a file
				else{ 
					
					
					//Define the variable specification from the validator to give it in parameter the method that lists the syntactic errors of an ontology represented as a file on the disk
					MetaDataSpecification specifications = MetaDataSpecification.specificationByName("simpleTest");
				   
					
					//Validator method that validates the ontologies that exist on the disk to retrieve the list of syntax errors.
					ExternalLinkValdiationTest.validateFile(ontologie,  specifications, true);
				}
			 }catch(NullPointerException er){
				 System.out.println("Validator can not detect the errors because of Error Null Pointer Exception ");
			 }
		}catch(VoidValidatorException e1){ //java.lang.NullPointerException
			System.out.println("Ontology without specified extension for validator !");
		}
		
		 //Variable obtained from the RdfValidator class of the validator to detect the number of errors
	    Erreurs = RdfValidator.get_NbError(); 
	     
	     
	     // Rule of three to calculate rate of primitives identified by URI
	     Taux = (double) Math.round(Erreurs * 100 ) /(P1.NombrePrimitiveCorrecte);
	     
	     
	     //Round the value of 2 digits after the decimal point.
		 Taux = (double) Math.round(Taux * 100 ) /100; 
		 
		 System.out.println("Nbre erreurs = "+Erreurs);
		 
		 System.out.println("Rate of erroneous information in the ontology  =  "+Taux + " %");
		 
		 
		 Taux = 100 - Taux;
		 
	
		 
		 //Display Number Error and Rate...
	      System.out.println("Rate of useful information provided by ontology  !=  "+Taux + " %");
	
	}
	

	/**Method illustrating examples of recovery of useful data (not for machine, for human)
	 * 
	 * 
	 *  Example of retrieval of useful data (but not for machine, for human):
	 *  SPARQL Interrogation to RDF Data
	 * 
	 * 
	 * Input: Path or URL of the ontology to be tested 
	 */
		
	
	public static void Sparql_Test(OntModel m){
				
			//rdfs:label , foaf:name , skos:prefLabel and dcterms:title
			/*final String p= "PREFIX  rdf:<" + RDF.getURI() + ">";
			final String f = "PREFIX foaf:<" + FOAF.getURI() + ">";
			final String s = "PREFIX rdfs: <" + RDFS.getURI() + ">";
			final String sk = "PREFIX skos :<http://www.w3.org/2004/02/skos/core#>";
			final String dc = "PREFIX  dcterms : <http://purl.org/dc/terms/>";*/


			//Variable of the writing of the query 
			String queryString2 = 
					
					//Declaration of prefixes
					"PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
					"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
					"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
					"PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
					"PREFIX dcterms: <http://purl.org/dc/terms/>" +
					"PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
					"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
					"PREFIX : <http://dbpedia.org/resource/>" +
					"PREFIX ru: <http://ru.dbpedia.org/resource/>" +
					"PREFIX dbpedia2: <http://dbpedia.org/property/>" +
					"PREFIX dbpedia: <http://dbpedia.org/>" +
					"PREFIX dbo: <http://dbpedia.org/ontology/>" +
			 		"PREFIX dbp: <http://dbpedia.org/ontology/>"+
			 		"PREFIX dbpprop: <http://dbpedia.org/property/>"+

			 		//Query "select" for possible information 
			 		//SELECT ?x  WHERE{ { ?y rdf:about ?x .}
					"SELECT *   WHERE{ { ?res dc:creator ?c .}" +
					"UNION{  ?res rdf:about ?c .}" +
					"UNION{  ?res dc:description ?c .}" +
					"UNION{  ?res dc:title ?c .}" +
					"UNION{  ?res dc:language ?c .}" +
					"UNION{  ?res dc:publisher ?c .}" +
					"UNION{  ?res rdfs:label ?c .}" +
					"UNION{  ?res foaf:name ?c .}" +
					"UNION{  ?res skos:prefLabel ?c .}" +
					"UNION{  ?res dcterms:title ?c .}" +
					"UNION{  ?res dcterms:description ?c .}" +
					"UNION{  ?res rdfs:comment ?c .}" +
					"UNION{  ?res foaf:knows ?c .}" +
					"UNION{  ?res dcterms:date ?c .}" +
					
					"}";

			//Create the query with QueryFactory and run it to get the results
			Query query = QueryFactory.create(queryString2);
			
			//*****************************************************************
			query.serialize(new IndentedWriter(System.out, true));
		    System.out.println();
		    
		    //******************************************************************
		    final QueryExecution qexec = QueryExecutionFactory.create(query, m);  
		    bos= new ByteArrayOutputStream();
		    ResultSet results;
		    //Variable to count the amount of information.
		   

		    try
	         {
	        	 //Retrieve the result of select execution
	        	 results = qexec.execSelect();
	        	 
	        	 /*********************To view the sparql table************************************/	        	 
	        	 while(results.hasNext())
	        	 {
	        		 QuerySolution soln = results.nextSolution();
	        	
	        		 //compteur++;
	        		 //Print the result of the query.
	        	 	// ResultSetFormatter.out( System.out,results,query);
	        	 	 resreq=soln;
	        	 	 resr=resr+resreq;
	        	 	ResultSetFormatter.out(bos, results );
	        	 	//ResultSetFormatter.out( results );
	        	 	 Infos = results.getRowNumber()-1;
	        	 	//ResultSetFormatter.out(bos, results );
	        	 }
				
 /**************************To calculate the number of useful information*************************************/	  

			//try 
			//{
				//Hypothèse: c'est une SELECT requête.
				//ResultSet rs = qexec.execSelect();
				
				//*******************************************
				List<String> vars=results.getResultVars(); //elle était juste List vars = machin. pour enlever yellow color
				
				//*******************************************
				ResultSetFormatter.out( System.out,results,query);
				
				
				// The result order is undefined.
				for (; results.hasNext();) 
				{
					
					//*****************************************
					QuerySolution rb = results.nextSolution();
			                
					
					//Get the title: variable names does not include the '?'
					for(int i=0;i<vars.size();i++)
					{
			           	//*********************************************
						String var=vars.get(i).toString();
			           	
						//*********************************************
					    RDFNode node=rb.get(var);
					    
					    //**********************************************
					    System.out.println("\n var  "+node.toString());  
					    
					}
			               
					//******************************
					final RDFNode y = rb.get("res");
			         
					//Display of information number i according to the counter variable.
					InfoUtiles = InfoUtiles+y.toString()+"\n";
					System.out.println("information "+compteur+": " + y );
					
					//compteur++;
			   } 			
		   }
		   finally
			{
				qexec.close();
			}
			

			//Display of number of information retrieved.
		   System.out.println("The number of information retrieved: "+ Infos);
		   //Infos = compteur;
		   
			 compteur = Infos;
			
			
		 	 //Rule of three to calculate number of useful info with respect to the number of correct primitives 
			 Infos = (int) Math.round(Infos * 100 ) /(P1.NombrePrimitiveCorrecte);
			 
			//Round the value up to 2 digits after the decimal point.
			// Infos  = (int) Math.round((Infos ) * 100 ) /100;
			 
			 System.out.println("Rate of information retrieved: "+ Infos+"%");

			 
			 //Total rate
			 Taux=(Taux+Infos)/2;
			 
			 System.out.println("Total rate: "+ Taux);

		}

}
