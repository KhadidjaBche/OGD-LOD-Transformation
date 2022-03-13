package myPack;


import org.apache.commons.validator.UrlValidator;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

@SuppressWarnings("deprecation")

		/**Additional VerifieUri class to perform the P1 test to check if the URI
  			Is not null and it respects the syntax http: // ...**/ 
public class VerifierURI {
	
	
	/**
	 * 
	 * ***************************             ***********************
	 *****************************THE METHODS ***********************
	 ****************************              ************************ 
	 * 
	 * */
	

	
	/**A method to test if the URI of the ontology is null
	 * 
	 * Input:- URI Resource type 
	 */
		public boolean URINull(Resource uri){
					  
			if(uri == null)  return true;							
				
			
							return false;
		}

		public boolean URINullO(RDFNode uri){
			  
			if(uri == null)  return true;							
				
			
							return false;
		}
		
		
		/**A method to test the regular expression
		 * 
		 * Input:- URI of String type 
		 */
		public static  boolean EXPReg(String uri)
		{
			
				String[] schemes = {"http","https"};
			 
			    UrlValidator urlValidator = new UrlValidator(schemes);
			    
			    //If the URI respects the URL validator syntax
			    if (urlValidator.isValid(uri))
			    {
			    	return true;
			    } 
			    else
			    {
			    	 return false;
			    }
		}	

}