package myPack;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.rdf.model.Model;

import at.jku.xlwrap.exec.XLWrapMaterializer;
import at.jku.xlwrap.map.MappingParser;
import at.jku.xlwrap.map.XLWrapMapping;

public class GeographyXlsToRDF {
	 private static final Logger log = LoggerFactory.getLogger( CrossDomainXlsToRDF.class );

	    //public static void main( String[] args ) {
	    public void execute(String[] args) throws ExecutionException {
	        if (args.length < 1) {
	            System.out.println( "Usage java ConvertCSVtoRDF  []" );
	        }
	        else {
	            try {
	                String source = args[0];
	                System.out.println("Source: "+ source);
	            //String source = "C:\\Users\\khadidja\\eclipse-workspace\\csv-triples\\csv-test\\src\\main\\java\\com\\rdf\\test.csv";
	                OutputStream out = (args.length == 1) ? System.out : new FileOutputStream( args[1] );

	                System.out.println("Source 1 ");
	                XLWrapMapping map = MappingParser.parse( source );

	                System.out.println("Source 2 ");
	                Model m = new XLWrapMaterializer().generateModel(map);
	                /*********/
	                //OntModel m = ModelFactory.createOntologyModel();
	                /*********/
	                System.out.println("Source 3 ");
	                setPrefixes( m );//*********************************************
	                
	                System.out.println("Source 4 ");

	                m.write( out, "Turtle" );
	                //m.write(out, "RDF/XML");
	                System.out.println("Source 5 ");
	            }
	            catch (Exception e) {
	            	
	                log.error( e.getMessage(), e );
	            }
	        }
	    }

	    private static void setPrefixes( Model m ) {
	        m.setNsPrefix( "rdfs", "https://www.w3.org/2000/01/rdf-schema#" );//***
	        m.setNsPrefix( "rdf",  "https://www.w3.org/1999/02/22-rdf-syntax-ns#" );
	        m.setNsPrefix( "xsd",  "https://www.w3.org/2001/XMLSchema#" );
	        m.setNsPrefix( "owl",  "https://www.w3.org/2002/07/owl#" );//***
	        m.setNsPrefix( "dc",   "https://purl.org/dc/elements/1.1/" );//+++++++++++
	        m.setNsPrefix( "scv",  "https://purl.org/NET/scovo#" );//++++++++++++++++
	        m.setNsPrefix( "ckan", "https://ckan.net/ns#" );
	        m.setNsPrefix( "sdx",  "https://www.epimorphics.com/vocab/sdx#" );
	        m.setNsPrefix( "foaf", "https://xmlns.com/foaf/0.1/" );//++++++++++++++++
	        m.setNsPrefix("dbo", "http://dbpedia.org/ontology/" );
	        m.setNsPrefix( "marineTLO", "http://ics.forth.gr/Ontology/MarineTLO/icore#" );
	       
	    }
}
