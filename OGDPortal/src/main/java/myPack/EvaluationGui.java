package myPack;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import uk.ac.manchester.cs.datadesc.validator.rdftools.VoidValidatorException;

import javax.swing.JScrollPane;

import javax.swing.JTextPane;

public class EvaluationGui extends JFrame {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel labelInfo; 
	public static JTextPane textPane;
	public static ArrayList <Triplet> primitifV;
	public static int code=0 ;
	static ArrayList <Triple> primitif;
	String tauxGeneral="";
	static ArrayList <TripleCode> Code_Reponse;
	public static ImageIcon loading;
	public static JPanel panel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluationGui frame = new EvaluationGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

	/**
	 * Create the frame.
	 */
	public EvaluationGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 784);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/eval2.png")).getImage();
		label.setIcon(new ImageIcon(img));				
		label.setBounds(412, 12, 235, 82);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Principle 1");
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setBackground(UIManager.getColor("OptionPane.questionDialog.border.background"));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				appendToPane(textPane,"\t*********************************************\n \t  *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 1                     ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);
				labelInfo.setText("Principle 1 : Use URIs as names for things.");			
				VerifierURI verif = new VerifierURI();
				if(ApplicationGui.owlFile.equals("")){
					// error icon
					JOptionPane.showMessageDialog(contentPane," No URI or path for an ontology !.",
						    "Fatal error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{
					//Extract: Subject, Predicate, Object
					 primitif = new ArrayList<Triple>();
			
					//Evaluate primitive of P1: subject, predicate, object
					 primitifV = new ArrayList<Triplet>();
					
					 primitif = P1.Extraire_Primitif(ApplicationGui.Modele, ApplicationGui.owlFile);
					
					try{
						// Test whether the concepts are URIs
						primitifV = P1.Evaluer_URI(primitif);
					}
					catch(Exception e2){
						// warning icon
						JOptionPane.showMessageDialog(contentPane,"Erroneous ontology !.",
								 "Warning",JOptionPane.WARNING_MESSAGE);
						return;
					}
					for (int i = 0; i< primitif.size(); i++){
						appendToPane(textPane," =========================================================================================================\n",Color.DARK_GRAY);
						appendToPane(textPane,"|TRIPLE N°"+i+"|SUBJECT :",Color.DARK_GRAY);
						
						//If the subject is an anonymous node
		         		if ((primitif.get(i).sujet.isAnon() == true)){
		         			appendToPane(textPane,primitif.get(i).sujet.toString()+"\n",Color.red);
		         		}
		         		else{
		         			//Otherwise, if the regular expression of the subject is false
		         			if (VerifierURI.EXPReg(primitif.get(i).sujet.toString()) == false){
		         				//PINK ON THE REGULAR EXPRESSION OF THE URI
		         				appendToPane(textPane,primitif.get(i).sujet.toString()+"\n",Color.MAGENTA);	
		         			}
		         			else{
		         				//If subject has no URI
		         				if (verif.URINull(primitif.get(i).sujet) == true){  
		    	         		
		         					appendToPane(textPane,primitif.get(i).sujet.toString()+"\n",Color.pink);
		         				}
		         				else{
		         					//Otherwise the primitive is correct (respect the first principle)
		         					appendToPane(textPane,primitif.get(i).sujet.toString()+"\n",Color.BLUE);

		         				}
		         			}
		         		}
						appendToPane(textPane," -------------------------------------------------------------------------------------------------------- \n",Color.DARK_GRAY);
						appendToPane(textPane,"|             |PREDICATE :",Color.DARK_GRAY);
						appendToPane(textPane,primitif.get(i).predicat.toString()+"\n",Color.ORANGE);
						appendToPane(textPane," -------------------------------------------------------------------------------------------------------- \n",Color.DARK_GRAY);
						appendToPane(textPane,"|             |OBJECT :",Color.DARK_GRAY);
						
						if (primitif.get(i).objet.isAnon() == true){
		             		//Object is anonymous
							appendToPane(textPane,primitif.get(i).objet.toString()+"\n",Color.red);
		         		}
		         		else{
		         			//If the object is not a literal
		         			if (primitif.get(i).objet.isLiteral()!= true){
		         				//And that he has a false reg expression!
		         				if (VerifierURI.EXPReg(primitif.get(i).objet.toString())== false){
		         					appendToPane(textPane,primitif.get(i).objet.toString()+"\n",Color.MAGENTA);	
		         				}
		         				else{
		         					appendToPane(textPane,primitif.get(i).objet.toString()+"\n",Color.BLUE);
		         				}
		         			}
		         			else{
		         				//If the object's URI is null
		         				if (verif.URINullO(primitif.get(i).objet) == true){
		    	         		
		         					appendToPane(textPane,primitif.get(i).objet.toString()+"\n",Color.pink);
		    	         		
		         				}
		    	         	
		         				else{//Object is literal
		         			 
		         					appendToPane(textPane,primitif.get(i).objet.toString()+"\n",Color.GREEN);		         				
		         				}
		         			}
		         		}							
						appendToPane(textPane," -------------------------------------------------------------------------------------------------------- \n",Color.DARK_GRAY);
					}
					
					appendToPane(textPane, "The URI of the ontology is : ", Color.DARK_GRAY);				
					if(P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile) == null || P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile) == "") 
						appendToPane(textPane,"null.\n", Color.RED);
					else
						appendToPane(textPane, P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile)+".\n", Color.BLUE);
						
					
					appendToPane(textPane, "This ontology contains ", Color.BLACK);
					appendToPane(textPane," "+ primitif.size()+" * 3 = "+ primitif.size() *3, Color.GRAY); 
					appendToPane(textPane, " of primitives \n", Color.BLACK);
					 
					appendToPane(textPane, "There is :", Color.BLACK);
					appendToPane(textPane," "+P1.nbliteral+" literals", Color.GREEN);
					appendToPane(textPane, " in this ontology \n", Color.BLACK);    
					    
					appendToPane(textPane, "There is : ", Color.BLACK);
					appendToPane(textPane," "+ P1.NoeudAnonyme+ " Anonymous nodes", Color.RED); 
					appendToPane(textPane, " in this ontology \n", Color.BLACK);
					
					appendToPane(textPane, "There is : ", Color.BLACK);
					appendToPane(textPane," "+ P1.NonURI+ " primitives that are not URIs", Color.MAGENTA); 
					appendToPane(textPane, " in this ontology \n\n", Color.BLACK);
					
					appendToPane(textPane, "There is  ", Color.BLACK);
					appendToPane(textPane," "+ P1.NombrePrimitiveCorrecte, Color.BLUE); 
					appendToPane(textPane, " primitives that respect Principle 1 \n", Color.BLACK);
					
					appendToPane(textPane,"\nThe primitive adequacy ratio with Principle 1 is : ",Color.BLACK);
					appendToPane(textPane,"(",Color.BLACK);
					appendToPane(textPane,P1.NombrePrimitiveCorrecte+" ",Color.BLUE);
					appendToPane(textPane," * 100)/",Color.BLACK);
					appendToPane(textPane,primitif.size() *3+" ",Color.GRAY);
					appendToPane(textPane," = ",Color.BLACK);
					appendToPane(textPane,Double.toString(P1.Taux)+"",Color.ORANGE);
					appendToPane(textPane, "  % \n", Color.BLACK);
					
					
					
					appendToPane(textPane, "\n\t\t\tBox-----------------------------\n", Color.DARK_GRAY);
					appendToPane(textPane, "\t\t\t  Anonymous node               \n", Color.red);
					appendToPane(textPane, "\t\t\t  False URI Syntax          \n", Color.MAGENTA);
					appendToPane(textPane, "\t\t\t  Correct primitive          \n", Color.BLUE);
					appendToPane(textPane, "\t\t\t  Predicate                    \n", Color.ORANGE);
					appendToPane(textPane, "\t\t\t  Literal                    \n", Color.GREEN);
					appendToPane(textPane, "\t\t\t -------------------------------\n\n", Color.DARK_GRAY);
	
					String taux1="Le taux d'adéquation de primitives avec princirpe 1 est : "+Double.toString(P1.Taux)+" %";
					tauxGeneral=tauxGeneral+taux1+"\n";
				
				}
				
			}
		});
		btnNewButton.setBounds(35, 146, 141, 31);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Principle 2");
		btnNewButton_1.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				appendToPane(textPane,"\n\t*********************************************\n \t  *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 2                     ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);
				
				labelInfo.setText("Principle 2 : Use HTTP URIs so that people can look up those names.");
				
				//Test if the URI of the ontology is dereferenceable 
				System.out.println(" Send Http GET request");
				if(P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile) == null) 
					appendToPane(textPane,"null.\n", Color.RED);
				else
					appendToPane(textPane, P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile)+".\n", Color.BLUE);
					
			if(P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile) == null || P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile) == ""){
				code =0;
				appendToPane(textPane, "This ontology ", Color.BLACK);
				appendToPane(textPane, "has no URI ", Color.RED);
				appendToPane(textPane, "==========> response code is : ", Color.black);
				appendToPane(textPane, code+"\n\n", Color.RED);
			}
			else{
				try{
					try{
						 code = P2.sendGet(P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile));
						System.out.println("Code = "+P2.sendGet(P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile)));
						if (code != 200){
							appendToPane(textPane, "Response code of the URI < ", Color.BLACK);
							appendToPane(textPane, P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile), Color.blue);
							appendToPane(textPane, "> is : ", Color.black);
							appendToPane(textPane, code +". \n\n", Color.RED);
						}
						else{
							appendToPane(textPane, "Response code of the URI < ", Color.BLACK);
							appendToPane(textPane, P1.URI_Ontologie(ApplicationGui.Modele, ApplicationGui.owlFile), Color.blue);
							appendToPane(textPane, "> is : ", Color.black);
							appendToPane(textPane, code +". \n\n", Color.magenta);
						}
						
					}catch(NullPointerException e2){System.out.println("Ontology has no URI! ");}
				}catch(Exception e3){System.out.println("No Internet connection on the network !");}
			}
							
				Code_Reponse = new ArrayList <TripleCode>();

		 		try {
					Code_Reponse = P2.Evaluation_Dereferencement(primitifV);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					for(int i=0; i< primitifV.size();i++)
					{
						System.out.println("I am at the position  = "+i);
						System.out.println("Size of primitifV = "+primitifV.size());
						System.out.println("response code of = "+primitifV.get(i).getS());
						
						appendToPane(textPane,"Response code of :"+primitifV.get(i).getS()+" is : ",Color.BLACK);
						if(Code_Reponse.get(i).sujet != 200)
							appendToPane(textPane,Code_Reponse.get(i).sujet+" \n",Color.RED);
						else
							appendToPane(textPane,Code_Reponse.get(i).sujet+" \n",Color.magenta);
						
						appendToPane(textPane,"Response code of :"+primitifV.get(i).getP()+" is : ",Color.BLACK);
						if(Code_Reponse.get(i).predicat != 200)
							appendToPane(textPane,Code_Reponse.get(i).predicat+" \n",Color.RED);
						else
							appendToPane(textPane,Code_Reponse.get(i).predicat+" \n",Color.magenta);
						
						
						appendToPane(textPane,"Response code of :"+primitifV.get(i).getO()+" is : ",Color.BLACK);
						if(Code_Reponse.get(i).objet !=200)
							appendToPane(textPane,Code_Reponse.get(i).objet+" \n",Color.RED);
						else
							appendToPane(textPane,Code_Reponse.get(i).objet+" \n",Color.magenta);
					}
					
					P2.CompterNbCorrecte(Code_Reponse);
					String taux1="The primitive adequacy ratio with Principle 2 is : "+Double.toString(P2.Taux)+" %";
					tauxGeneral=tauxGeneral+taux1+"\n";

					appendToPane(textPane, "\nThere is : ", Color.BLACK);
					appendToPane(textPane," "+ P2.nbnondereferençable+ " No dereferenceable primitives", Color.RED); 
					appendToPane(textPane, " in this ontology \n", Color.BLACK);					
					
					appendToPane(textPane, "There is : ", Color.BLACK);
					appendToPane(textPane," "+ P2.NombrePrimitiveP2+ " dereferenceable primitives", Color.magenta); 
					appendToPane(textPane, " in this ontology \n\n", Color.BLACK);
					
					appendToPane(textPane,"\nThe primitive adequacy ratio with Principle 2 is : ",Color.BLACK);
					appendToPane(textPane,"(",Color.BLACK);
					appendToPane(textPane,P2.NombrePrimitiveP2+" ",Color.magenta);
					appendToPane(textPane," * 100)/",Color.BLACK);
					appendToPane(textPane,P1.NombrePrimitiveCorrecte+" ",Color.BLUE);
					appendToPane(textPane," = ",Color.BLACK);
					appendToPane(textPane,P2.Taux+"",Color.ORANGE);
					appendToPane(textPane, "  % \n", Color.BLACK);
					
					tauxGeneral=tauxGeneral+taux1+"\n";
					System.out.println("here is the tauxGeneral "+tauxGeneral);
			}
		});
		
		btnNewButton_1.setBounds(35, 197, 141, 31);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Principle 3");
		btnNewButton_2.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String res;
				appendToPane(textPane,"\n\t*********************************************\n \t  *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 3                     ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);
				labelInfo.setText("Principle 3 : When someone looks up a URI, provide useful information, using the standards (RDF, SPARQL)");
				
				try{
					appendToPane(textPane, "\n Useful information\n\n", Color.BLACK);
					appendToPane(textPane," ---------------------------------------------------- \n",Color.DARK_GRAY);
					P3.Sparql_Test(ApplicationGui.Modele );
					
					res=P3.resr+"";
					
					appendToPane(textPane, P3.bos.toString(), Color.BLACK);
					
					if(P3.compteur > 0){
						appendToPane(textPane, P3.InfoUtiles, Color.BLACK);
						appendToPane(textPane," ---------------------------------------------------- \n",Color.DARK_GRAY);
					}
					
					appendToPane(textPane, "\nThere exist ", Color.BLACK);
					appendToPane(textPane, P3.compteur+" ", Color.magenta);
					appendToPane(textPane, "  exemples of useful information.\n", Color.BLACK);
					
					try {
						P3.Tester_Validation_Ontologie(ApplicationGui.owlFile);
					} catch (VoidValidatorException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
					String taux1="The primitive adequacy ratio with Principle 3 is : "+Double.toString(P3.Taux);
					
					tauxGeneral=tauxGeneral+taux1+"\n";
					System.out.println("here tauxGeneral "+tauxGeneral);
					
					BufferedReader in = new BufferedReader(new FileReader("./exec.txt")); // LE CHEMIN
					String line = in.readLine();					
					while(line != null){
						if(line.contains("Unable to validate")){
							String ligne [] = line.split("Unable to validate");
							ligne[0] = "Unable to validate";
							System.out.println("Ligne[0] "+ ligne[0]+" Ligne[1] "+ ligne[1]);
							appendToPane(textPane,"\n"+ ligne[0]+" ", Color.BLACK);
							String ligne2[] = ligne[1].split(" ");
					        appendToPane(textPane, ligne2[1]+" ", Color.BLACK);
					        for(int i =2 ; i< ligne2.length; i++){
					        	appendToPane(textPane, ligne2[i]+" ", Color.red);
					        }
						}
						line = in.readLine();
					}
				}catch (IOException e10) {
					
					e10.printStackTrace();
				}
				appendToPane(textPane, "\nThere exist ", Color.BLACK);
				appendToPane(textPane, P3.Erreurs+" errors ", Color.RED);
				appendToPane(textPane, "  detected by the validator program.\n", Color.BLACK);
											
				appendToPane(textPane,"(",Color.BLACK);
				appendToPane(textPane,P3.Erreurs+" ",Color.red);		
				appendToPane(textPane, "* 100) / "+P1.NombrePrimitiveCorrecte+" \n",Color.BLACK);
				
				appendToPane(textPane,"(",Color.BLACK);
				appendToPane(textPane,P3.compteur+" ",Color.magenta);
				appendToPane(textPane," * 100) /  "+P1.NombrePrimitiveCorrecte+"\n",Color.BLACK);
				
				appendToPane(textPane,"The primitive adequacy ratio with Principle 3 is : ",Color.BLACK);
				appendToPane(textPane," "+P3.Taux+"\n",Color.ORANGE);	
			}
		});
		btnNewButton_2.setBounds(35, 251, 141, 31);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Principle 4");
		btnNewButton_3.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				appendToPane(textPane,"\n\t*********************************************\n \t  *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 4                     ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);

				labelInfo.setText("Principle 4 : Include links to other URIs, so that people can discover more things");
				
				//File containing the vocabulary of the linked properties
				File Fichier_Vocabulaire = new File("./Vocabulaire.txt"); // LE CHEMIN  
				try {
					P4.Nombre_liens(Fichier_Vocabulaire, primitif);
				} catch (IOException e1) {
					System.out.println("Error interface");
					
				}
				appendToPane(textPane, "\nThere is : ", Color.BLACK);
				appendToPane(textPane," "+ P4.link+ " links", Color.MAGENTA); 
				appendToPane(textPane, " in this ontology \n\n", Color.BLACK);
				if(P4.link >0){
					appendToPane(textPane,"The link property (ies) that exists is (are) : \n",Color.BLACK);
					appendToPane(textPane, "\nLink property :-----------------------------\n", Color.DARK_GRAY);
					appendToPane(textPane,"\t"+P4.set+"\n",Color.MAGENTA);
					
					appendToPane(textPane, "---------------------------------------------\n\n", Color.DARK_GRAY);
					
				}
				else{
					appendToPane(textPane,"This ontology contains no links !\n",Color.MAGENTA);
				}
				
				
				appendToPane(textPane,"\nThe primitive adequacy ratio with Principle 4 is : ",Color.BLACK);
				appendToPane(textPane,"(",Color.BLACK);
				appendToPane(textPane,P4.link+" ",Color.magenta);
				appendToPane(textPane," * 100)/",Color.BLACK);
				appendToPane(textPane,P1.NombrePrimitiveCorrecte+" ",Color.BLUE);
				appendToPane(textPane," = ",Color.BLACK);
				appendToPane(textPane,P4.Taux+"",Color.ORANGE);
				appendToPane(textPane, "  % \n\n", Color.BLACK);			
				
				//Calculation of average rate of all rates of 4 principles
				double Moyenne_Taux = (P1.Taux + P2.Taux+ P3.Taux + P4.Taux) / 4;
				Moyenne_Taux = (double) Math.round(Moyenne_Taux * 100 ) /100;
				appendToPane(textPane,"The average rate of adequacy of the primitives with the 4 principles is : ",Color.BLACK);
				appendToPane(textPane,Moyenne_Taux+" %",Color.GRAY);
				
				ApplicationGui.btnvaluerOntologieSelon.setEnabled(true);
			}
		});
		btnNewButton_3.setBounds(35, 303, 141, 31);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Correction");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// warning icon 
				JComponent.setDefaultLocale(Locale.ENGLISH);
				int k=JOptionPane.showConfirmDialog(getParent(), "Want to make the correction ? ", "Correction ?", JOptionPane.YES_NO_OPTION);

		    	if (k==JOptionPane.YES_OPTION)
		    	{	
		    		CorrectionGui CI=new CorrectionGui();
		    		CI.setVisible(true);
		    	}
		    	else return; 
		    		
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(img5));
		btnNewButton_4.setBounds(12, 413, 195, 119);
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 106, 929, 536);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		labelInfo = new JLabel("");
		
		
		labelInfo.setBounds(210, 654, 950, 50);
		contentPane.add(labelInfo);
	}
}
