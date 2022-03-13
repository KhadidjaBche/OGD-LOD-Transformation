package myPack;



//import java.io.File;
import java.io.File;
import java.util.ArrayList;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class Tests
{
	
	public static String  OntologiePubliee="nonpublie";
	public static String owlFile = "";
	public static OntModel Modele = ModelFactory.createOntologyModel(); 
	public static double MoyenTaux ;

	public static void main(String[] args) throws Exception, NullPointerException 
	{
		//Reading ontology: Either by its URL or by its file.
		Support.LectureOntologie();

		try
		{
			FileManager.get().readModel(Modele, owlFile );
		}
		catch(Exception e1 )
		{
			System.out.println("ERROR Attention votre ontologie est incorrecte !");
			return;
		}
		
		
		
		
		
		
		
		
 /***************************************************************************************************************
 *                          							                                                        *  
 *                                                                 										        *
 * 			~~~~~~~~~~~~~~~~~~~~~~~~   Evaluation according to the four principles   ~~~~~~~~~~~~~~~~~~~~         	*
 *                                                                                                              *
 *                                                                                                              *
 ****************************************************************************************************************/		
		
		
		
		
		
		
		
														
						 /****************************************************************
					 	 *                          							         *  
						 * Principle 1 : Using URIs to name concepts :				     *
						 *  			Extracting primitives from ontologies            *
						 *  		                                                     *
						 *  ~~~~~~~~~~~~        Call for P1 methods        ~~~~~~~~~~~~  *
						 *                                                               *
						 *****************************************************************/
		

		
		//Extract URI from ontology
		String uri = P1.URI_Ontologie(Modele, owlFile);
		
		//Test if the URI is not null
		if (uri != null)
			System.out.println("URI de l'ontologie est :  " + uri);
			
		else
			System.out.println("L'ontologie n'a pas d'URI! ");
		
		//Extract: Subject, Predicate, Object
		ArrayList <Triple> primitif = new ArrayList<Triple>();
		
		
		//Evaluate primitive of P1: subject, predicate, object
		ArrayList <Triplet> primitifV = new ArrayList<Triplet>();
		
		primitif = P1.Extraire_Primitif(Modele, owlFile);
		
		try
		{
			
			//Test if the concepts are URIs
			primitifV = P1.Evaluer_URI(primitif);
		}
		catch(Exception e2)
			{
				System.out.println("Attention en Evaluation: votre ontologie est incorrecte !");
			}
		
		
		//Display primitives extracted from ontology thus the rate of primitives who respect the 1st principle
		P1.Afficher(primitif);


		
		
					 /*******************************************************************************
				 	 *                          							                        *  
					 * Principle 2 : Use HTTP URIs so people can look at these names:				*
					 *  												                            *
					 *  		                                                                    *
					 * 		~~~~~~~~~~~~~~~~~~~~~~~~ Call for P2 methods   ~~~~~~~~~~~~~~~~~~~~~~~~ *
					 *                                                                              *
					 ********************************************************************************/

	
		
		//Test if the URI of the ontology is dereferenceable
		/*System.out.println(" Send Http GET request");
		
		try{
			
			try{
				
				P2.sendGet(uri);
				System.out.println("Code = "+P2.sendGet(uri));
			   
				}
			
				catch(NullPointerException e2){System.out.println("L'ontologie n'a pas d'URI! ");}
			
		    }
		    
			catch(Exception e3){System.out.println("Pas de Connexion internet sur le réseau !");}
		
		//Display URI response code if it is dereferenceable
		ArrayList <TripleCode> Code_Reponse = new ArrayList <TripleCode>();
		
		Code_Reponse = P2.Evaluation_Dereferencement(primitifV);
		
		for(int i=0; i< Code_Reponse.size();i++)
		{
			//System.out.println("je ne suis pas là !");----------------------------------------
			System.out.println("Code réponse de :"+primitifV.get(i).getS()+" est : "+Code_Reponse.get(i).sujet);
			System.out.println("Code réponse de :"+primitifV.get(i).getP()+" est : "+Code_Reponse.get(i).predicat);
			System.out.println("Code réponse de :"+primitifV.get(i).getO()+" est : "+Code_Reponse.get(i).objet);
		}
	/*	------------------------------------------------------------------------------------------------
		System.out.println("je suis là !"+P2.TC.size());
		for(int i=0; i< Code_Reponse.size();i++){
			System.out.println(i+"eme triplet");
			System.out.println(P2.TC.get(i).sujet+"--"+P2.TC.get(i).predicat+"--"+P2.TC.get(i).objet);
		}------------------------------------------------------------------------------------------------*/
		
		//Calculate the rate of correct primitives:
		//P2.CompterNbCorrecte(P2.TC);
		
	
			
				     /*************************************************************
				 	 *                          							      *  
					 * Principle 3 : Provide useful information to the machine :  *
					 *  			Calculate the number of syntactic errors      *
					 *  		                                                  *
					 * 		~~~~~~~~~~~~    Call for P3 methods   ~~~~~~~~~~~~    *
					 *                                                            *
					 *************************************************************/




		
		//Ontology valid if it is written by machine-readable language	
			P3.Tester_Validation_Ontologie(owlFile); 
			P3.Sparql_Test(Modele);	 
		//Ontology has significant content: All ontology information.
	

					 /*************************************************************************
				 	 *                          							                  *  
					 * Principle 4 : Include links to other URIs:		                      *
					 *  			Calculate the number of links representing in the ontology*
					 *  		                                                              *
					 * 		~~~~~~~~~~~~~~~     Call for P4 methods         ~~~~~~~~~~~~~~~~~ *
					 *                                                                        *
					 **************************************************************************/

		//File containing the vocabulary of the linked properties
	File Fichier_Vocabulaire = new File("./Vocabulaire.txt");// LE CHEMIN
		
		//Show the rate of the existing links in the ontology.
		P4.Nombre_liens(Fichier_Vocabulaire, primitif);

		
		//Calculation of average rate of all rates of 4 principles
		double Moyenne_Taux = (P1.Taux + P2.Taux+ P3.Taux + P4.Taux) / 4;
		
		Moyenne_Taux = (double) Math.round(Moyenne_Taux * 100 ) /100;
		
		System.out.println("Rate of ontology evaluation according to the four principles =  " + Moyenne_Taux+ " % ");

		MoyenTaux = Moyenne_Taux;
		
		
		
		
		
		
 /***************************************************************************************************************
 *                          							                                                        *  
 *                                                                 										        *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    Correction    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 *                                                                                                              *
 *                                                                                                              *
 ****************************************************************************************************************/
	
	
	
	
	
	
	
		
					 /*********************************************************************
					 *                          							              *  
					 * Correction of P1 :   Primitive not represented by URI:             *
					 * 				        		Make the literals as URIs			  *
					 *  			           									  		  *
					 *  		                                                  		  *
					 * 		~~~~~~~~~~~~~~  Call to Correction Methods   ~~~~~~~~~~~~     *
					 *                                                                    *
					 **********************************************************************/
/*	

	Correction.Corriger_Principe1(Modele, owlFile, primitifV);
	
	//Correction.Principes(Modele, owlFile, primitifV, Code_Reponse);	
		//System.out.println("in this statement we have :");
	
				 /******************************************************************************
				 *                          							                       *  
				 * Correction of P2 :  Primitive represented by non-dereferenceable URI        *
				 *  			       Make the URIs with code 404 406 409 410 dereferenceable *
				 *  		                                                  		           *
				 *		 ~~~~~~~~~~~~~~  Call to Correction Methods   ~~~~~~~~~~~~             *
				 *                                                                             *
				 *******************************************************************************/
	
	
	//Correction.Reparer_P2(Modele,primitifV,Code_Reponse);

	//Correction.Principes (Modele, owlFile,primitifV,Code_Reponse);
	
				 /************************************************************************************
			 	 *                          							                             *  
				 * Correction of P3 :Ontologie contenant des informations non utiles à la machine:   *
				 *  			     Proposer un fichier contenant des corrections "semi-automatique"*
				 *  		                                                  		  			     *
				 * 		~~~~~~~~~~~~~~~~~~~~~  Call to Correction Methods   ~~~~~~~~~~~~~~~~~~~      *
				 *                                                                    			     *
				 *************************************************************************************/
	
	//Display the file and the corresponding correction. //LE CHEMIN
	Correction.Corriger_Principe3(new File("./exec.txt"), new File("./Erreurs_syntaxique.txt"), "Corriger7");

	
	
				 /****************************************************************************************
				 *                          							                                 *  
				 * Correction of P4 :    Ontology not containing links to other data sources			 *
				 *  			           									  		                     *
				 *  		                                                  		                     *
				 * 		~~~~~~~~~~~~~~~~~~~~  Call to Correction Methods   ~~~~~~~~~~~~~~~~~~~~~~~~~~~   *
				 *                                                                                       *
				 *****************************************************************************************/
	
	
	//Show all ontology classes
	//Correction.Recuperer_classe(Modele);
	
	
	//Interaction with the user who chooses the class that wishes to find links to him in DBpedia
	//String liensClasse = Support.LectureClasse();
	
	//Links of the chosen class
	//Correction.Sparql_Requete(Modele, liensClasse);
		
	}
}
