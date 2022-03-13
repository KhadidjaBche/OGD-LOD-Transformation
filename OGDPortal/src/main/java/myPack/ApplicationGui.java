package myPack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;


import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Model;
//import com.hp.hpl.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


public class ApplicationGui  {
	

	private JFrame frame;
	private JTextField textField;
	private JButton btnvaluerLontologieSelon;
	private JButton btnNewButton;
	private JTextArea textArea;
	static JButton btnvaluerOntologieSelon;
	private String Ontologie="";
	public static String owlFile = "";
	public static OntModel Modele = ModelFactory.createOntologyModel(); 
	public static boolean uri_ou_chemin=false;
	private String Path ;
	public static int etoile = 0;
	//Create a file chooser
	JFileChooser fc;
	private JComboBox comboBox;
	private JScrollPane scrollPane_3;
	private JLabel lblNewLabel_1;

	static String Format;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 ApplicationGui window = new  ApplicationGui();
					setBestLookAndFeelAvailable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationGui() {
		initialize();
	}
	/**
	 * To have the look of the current system.
	 */
	public static void setBestLookAndFeelAvailable(){
		   String system_lf = UIManager.getSystemLookAndFeelClassName().toLowerCase();
		   if(system_lf.contains("metal")){
		       try {
		    	  
		           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		       }catch (Exception e) {}
		   }else{
		       try {
		           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		       }catch (Exception e) {}
		   }
		 }
	static private String selectedString(ItemSelectable is) {
	    Object selected[] = is.getSelectedObjects();
	    return ((selected.length == 0) ? "null" : (String) selected[0]);
	  }
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 778, 700);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JFileChooser.setDefaultLocale(new Locale("en","US"));
		fc = new JFileChooser();

		
		/* 		*************************************************  
 				* Here the field of URI or path of the ontology *
 				*************************************************       */
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ontologie=textField.getText();
				
				Format = Ontologie.substring(Ontologie.toString().lastIndexOf("."));
				
				//Put the extension in lowercase
				Format.toLowerCase();
					
				System.out.println("The extension of ontology is :\t"+Format.toLowerCase());
					
				if(!Format.toLowerCase().contains(".rdf")&& !Format.toLowerCase().contains(".n3")
						&& !Format.toLowerCase().contains(".ttl")&& !Format.toLowerCase().contains(".owl")
						&&!Format.toLowerCase().contains(".owl2")&& !Format.toLowerCase().contains(".nt")
						&& !Format.toLowerCase().contains("org/sioc/ns")){
					
					btnvaluerLontologieSelon.setEnabled(false);
					
				}
				else{
					btnvaluerLontologieSelon.setEnabled(true);
					
					//Here we retrieve the URI from the textfield
					owlFile=Ontologie;
					
					if(uri_ou_chemin==false) {		//That's mean ===> We have written a URI
						
						System.out.println("I am here ! ==> URI selected ");				
						
						if(Ontologie.isEmpty()||!Ontologie.contains("h")) {	
							// warning icon
							JOptionPane.showMessageDialog(frame,"Uri / Path of ontology Not specified !.",
								 "Warning",JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						//Here we retrieve the URI from the textfield
						owlFile=Ontologie;
						
						//Here we check if the URI is valid
						if(VerifierURI.EXPReg(owlFile)==false){
							// error icon
							JOptionPane.showMessageDialog(frame," Warning invalid ontology URI !.",
								    "Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						//Here we put ontology in the model
						try
						{
							FileManager.get().readModel(Modele, owlFile );
						}
						catch(Exception e1 )
						{
							// error icon
							JOptionPane.showMessageDialog(frame," Warning this ontology is incorrect !.",
								    "Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						return;
				}
					else /***************The ontology is taken from a file***************/
					{
						
						//Here we put ontology in the model
						try
						{	
						
						System.out.println("Path is :\t "+Path);
							owlFile = Path;
							
							FileManager.get().readModel(Modele, Path );
						}
						catch(Exception e1 )
						{
							// error icon
							JOptionPane.showMessageDialog(frame," Warning this ontology is incorrect !.",
								    "Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						//Extract URI from ontology
						String uri = P1.URI_Ontologie(Modele, owlFile);
						//Test if the URI is not null
						if (uri == null)
							
							// warning icon
							JOptionPane.showMessageDialog(frame,"The ontology has not an URI idetifiant !!.", 
									 "Warning",JOptionPane.WARNING_MESSAGE);
						return;
						
					}
					
					}		
			}
		});
		
		textField.setBounds(225, 27, 436, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblOntologie = new JLabel("URL or ontology path :");
		lblOntologie.setBounds(12, 20, 206, 50);
		frame.getContentPane().add(lblOntologie);
		
		btnvaluerLontologieSelon = new JButton("Evaluate ontology according to the principles of Linked Data");
		btnvaluerLontologieSelon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EvaluationGui eval=new EvaluationGui();
				eval.setVisible(true);
			}
		});
		btnvaluerLontologieSelon.setBounds(225, 469, 528, 25);
		frame.getContentPane().add(btnvaluerLontologieSelon);
		
		

		/* 		*****************************************  
		 		* Here is the button to choose ontology *
		 		*****************************************       */

		btnNewButton = new JButton("Open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File returnFile= new File("./Ontologies");
				fc.setCurrentDirectory(returnFile);
				
				UIManager.put("FileChooser.acceptAllFileFilterText", "All the files");
				
			
				//In response to a button click : The method below opens the file menu
				int returnVal = fc.showOpenDialog(frame);
				
				//If the user chooses an ontology
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
		            File file = fc.getSelectedFile();
		            //This is where a real application would open the file.
		            Ontologie = file.getName() ;
		            Path = file.getAbsolutePath();
		            
		            //We put the name of the file in the textfield 
		            textField.setText(Ontologie);
		            
		            //We return uri_ou_chemin to true and then the textfield will change the processing
		            uri_ou_chemin=true;
		           
		        } 
			}
		});
		btnNewButton.setBounds(667, 27, 80, 37);
		frame.getContentPane().add(btnNewButton);
		
		
		
		textArea = new JTextArea();
		textArea.setBounds(114, 149, 528, 291);
		frame.getContentPane().add(textArea);
		String contenuArea = textArea.getText();
		frame.setVisible(true);
		
		
		final String[] Types = {"Turtle(mimeType=application/x-turtle;ext=ttl)", 
								 "N-Triples(mimeType=text/plain;ext=nt)",
								 "RDF/XML(mimeType=application/rdf+xml;ext=rdf,rdfs,owl,xml)",""};
		
		comboBox = new JComboBox(Types);
		comboBox.setBounds(225, 100, 522, 37);
		comboBox.setSelectedIndex(3);
		frame.getContentPane().add(comboBox);
		
		scrollPane_3 = new JScrollPane(textArea);
		scrollPane_3.setBounds(225, 149, 528, 286);
		frame.getContentPane().add(scrollPane_3);
		
		JLabel lblTypeMimeDontologie = new JLabel("Ontology type mime :");
				
		lblTypeMimeDontologie.setBounds(22, 82, 195, 45);
		frame.getContentPane().add(lblTypeMimeDontologie);
		
		lblNewLabel_1 = new JLabel("Ontology Code :");
		lblNewLabel_1.setBounds(22, 150, 169, 37);
		frame.getContentPane().add(lblNewLabel_1);
			


		frame.setVisible(true);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
		        	
		        	if (event.getStateChange() == ItemEvent.SELECTED) {
		        		System.out.println(textArea.getText());
		        		Ontologie=textArea.getText();
		                Object item = event.getItem();
		                if (event.getItem()==Types[2]){
		                	owlFile="C:/Users/khadidja/eclipse-workspace/fichier.owl";
		                }
		                else{
			                if (event.getItem()==Types[1]){
			                	owlFile="C:/Users/khadidja/eclipse-workspace/fichier.nt";	                	
			                }
			                else{
				                if (event.getItem()==Types[0]){
				                	owlFile="C:/Users/khadidja/eclipse-workspace/fichier.ttl";
				                }
			                }
		                }
		                
		                try {
		                		PrintStream p = new PrintStream(owlFile);
		                		p.print(Ontologie);
		                }catch(FileNotFoundException e2){
		                		// TODO Auto-generated catch block
		                		System.out.println("File not found !");
		                		}
			        
		                //Here we put the ontology in the model
		                try{
		                	FileManager.get().readModel(Modele, owlFile );//********
		                	//FileManager.get().readModel(Modele, owlFile, "Turtle");
		                }catch(Exception e1 ){
		                	// error icon
		                	JOptionPane.showMessageDialog(frame," Warning ! Incorrect ontology.",
							    "Error",JOptionPane.ERROR_MESSAGE);
		                	return;
		                    }
		            }         	
		    }
		});

		
		
	}
}