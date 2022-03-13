package myPack;


import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

public class Triple {

	public Resource sujet;
	public Property predicat;
	public RDFNode objet;
	
	public  Triple(Resource s,Property p,RDFNode o){
		
		sujet=s;
		predicat=p;
		objet=o;
	}
	
public  Triple(){
		
		sujet=this.sujet;
		predicat=this.predicat;
		objet=this.objet;
	}

	public void affichtriple(Triple t)
	{
		System.out.println("Subject : "+ t.sujet +"\t Predicate : "+t.predicat+"\t Object : "+t.objet );
	}

}

