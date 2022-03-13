package myPack;


import java.io.File;
import java.util.Scanner;

public class Support {
	
	public static String  OntologiePubliee="nonpublie";
	public  static void Test_onto_ressource(File fichier)
	{
		 
	    //Get Parent File Name
	    String nm_parent = fichier.getParent();

	    if (nm_parent.equals ("/home/user/Bureau/A/TONTOLOGIE"))
	    {
	    	System.out.println(nm_parent);
	    	OntologiePubliee="publie";
	    }
	    else System.out.println("Error : Unpublished Ontology");
	}

	
	public static void LectureOntologie()
	{
		
		System.out.println("Enter 1 if URL \n");
		Scanner url = new Scanner(System.in);
		int str = url.nextInt();
		System.out.println("Ontology:  ");
		
		Scanner sc = new Scanner(System.in);
		Tests.owlFile = Tests.owlFile +sc.nextLine();
		System.out.println(Tests.owlFile);
		
		File fich=new File(Tests.owlFile);
	    if(str==1)	OntologiePubliee="publie";
	    else Test_onto_ressource(fich);

	
	}
	
	public static String LectureClasse()
	{
		System.out.println("Enter a class from those presented \n");
		Scanner sc = new Scanner(System.in);
		
		String classe =""; 
			   
			return	classe = sc.nextLine();
		
	}

}
