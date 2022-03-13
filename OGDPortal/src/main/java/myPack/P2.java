package myPack;



			//The necessary imports for the execution of the second principle :

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;




/**Class P2 which allows to test the second principle thus extract the primitives of ontology**/

public class P2 {


/****************************************************************************   
 * 	User Agent :     It is the name of the utility that asks for a page,	*
 *    			  -> It can be modified, it is not necessarily informed,	*
 *     			  -> It does not relate to the IP.							*
 *	  			  -> This is one of the elements of the HTTP protocol		* 
 *																			*
 ****************************************************************************/

	private final static String USER_AGENT = "Mozilla/5.0";

	//Variable to calculate the rate of primitives whose http URI is dereferencable
	public static double Taux = 0;
	public static int nbnondereferençable=0;

	public static int NombrePrimitiveP2;
	
	public static ArrayList <TripleCode> TC= new ArrayList<TripleCode>(0);
	
	public static int m=0;
	
					/*******************************************************************
					 * 																   *
					 * ***************************             *************************
					 ****************************  THE METHODS  ************************
					 ****************************               ************************ 
					 * 													  			   *
					 *******************************************************************/



/** Method that returns: the response of the request sent by the user
 * Input:  URI to test 
 */
    public static int sendGet(String url) throws Exception 
    
    {
     try{
    	try{
    		HttpClient client = new DefaultHttpClient();
    		
    		HttpGet request = new HttpGet(url);

    		//Addition to the query header
    		request.addHeader("User-Agent", USER_AGENT);
    		
    		//Execute the request
    		HttpResponse response = client.execute(request);
    		
    
    		
    		//Returns the server response
    		return response.getStatusLine().getStatusCode();

    	}catch(HttpHostConnectException e1){
    		System.out.println("Connection Denied: Error Occurs When You Try to Open "
    				+ "			a TCP Connection to an IP Address / Port where there is currently "
    				+ "			no listening for connections. If nothing is listening,"
    				+ "			the operating system on the server side denies the connection.");
    	
    	}
    	
    	}catch(NoHttpResponseException e2){
    		System.out.println("The target server failed to respond");
    	
    	}
		return 0;
     }



    
		/** Method Returns an array containing the codes returned by the server
		 * 
		 * Input:  Table of primitives represented by valid HTTP URIs	
		 */
     public static ArrayList <TripleCode> Evaluation_Dereferencement(ArrayList<Triplet> T) throws Exception{

		
		 for (int i= 0 ; i< T.size(); i++){
			 
			 TripleCode e =new TripleCode();
			 
			 //System.out.println("je suis là !"+T.size());
			 //~~~~~~~~~~~~~~~~~~~~~~~~~Sujet~~~~~~~~~~~~~~~~~~~~~~~~~
			 System.out.println("Loading.");
			 if(T.get(i).getS().startsWith("http://www.w3.org/1999/02/22-rdf-syntax-ns#")
						||
				        T.get(i).getS().startsWith("http://www.w3.org/2000/01/rdf-schema#")){
				 
				e.sujet=200; 
			 }
			 else{
				 
				 if(T.get(i).getS().equals("*******")){
					
					 e.sujet=0;
					 //System.out.println("T.get(i).sujet"+i+" ----- "+e.sujet);
				 }
				 else
				 e.sujet   = sendGet(T.get(i).getS());
			 }
			 
			 
			 System.out.println("Loading..");
			 if(T.get(i).getP().startsWith("http://www.w3.org/1999/02/22-rdf-syntax-ns#")
						||
				        T.get(i).getP().startsWith("http://www.w3.org/2000/01/rdf-schema#")){
				 
				 e.predicat=200;
			 }
			 else{
				 if(T.get(i).getO().equals("*******")){
					 e.objet=0;
				 }
				 else {
				 e.predicat  = sendGet(T.get(i).getP());
				 }
			 }
				
			 
			 System.out.println("Loading...");
			 if(T.get(i).getO().startsWith("http://www.w3.org/1999/02/22-rdf-syntax-ns#")
					   ||
				       T.get(i).getO().startsWith("http://www.w3.org/2000/01/rdf-schema#")){
				 e.objet=200;
				 
			 }
			 else{
				 if(T.get(i).getO().equals("*******")){
					 e.objet=0;
				 }
				 else {
					 e.objet   = sendGet(T.get(i).getO());
					 if(e.objet == 404) System.out.println("HERE: "+ T.get(i).getO()+" N°"+ i);
				 }
			 }
			 
			 TC.add(i,e);
			 //System.out.println("!!!! "+TC.get(i).sujet);

		 }	
		 System.out.println("N° 40 :"+ TC.get(40).predicat+" "+T.get(40).getS());
		 // TABLE CONTAINING HTTP CODES
		 return TC;
	}
     

 	/** Methode qui Retourne :le nbre de primitifs
 	 * 
 	 * Input: Tableau de primitifs representés par URI_HTTP VALIDE et les codes https
 	 */
     public static void CompterNbCorrecte(ArrayList<TripleCode> TC)//,ArrayList<Triple> T
     {

    	 //Variable containing the number of primitives that respect the dereference
    	  NombrePrimitiveP2 = TC.size()*3;
    	 
    	 
    	 for(int i=0; i<TC.size();i++){

    		 if (TC.get(i).sujet == 404 || TC.get(i).sujet == 406 ||TC.get(i).sujet == 409 ||TC.get(i).sujet == 410)	nbnondereferençable++;
    		 if (TC.get(i).predicat == 404 || TC.get(i).predicat == 406 ||TC.get(i).predicat == 409 ||TC.get(i).predicat == 410) nbnondereferençable++;
    		 if (TC.get(i).objet == 404 || TC.get(i).objet == 406 ||TC.get(i).objet == 409 ||TC.get(i).objet == 410)    nbnondereferençable++;
    		     		 
    	 }
    	 	 
    	 NombrePrimitiveP2 =  NombrePrimitiveP2 -  nbnondereferençable ;
	
	//Calculating the rate of dereferenceable primitives http URI
	 Taux = (double) Math.round(NombrePrimitiveP2 * 100 ) /(P1.NombrePrimitiveCorrecte);
	 
	 //Take 2 values after the decimal point.
     Taux = (double) Math.round(Taux * 100 ) /100;
     
	 System.out.println("Rate of primitives whose http URI is dereferenceable  =  "+Taux + " %");
	 
     System.out.println("Number P2  correct =  "+NombrePrimitiveP2 +" and P1 correct= " +P1.NombrePrimitiveCorrecte);

}

}
