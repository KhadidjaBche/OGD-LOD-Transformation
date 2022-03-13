<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>

<%@page import="java.awt.Color"%>
<%@page import="java.awt.EventQueue"%>
<%@page import="java.awt.ItemSelectable"%>
<%@page import="java.awt.event.ActionEvent"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@page import="java.awt.event.ItemListener"%>
<%@page import="java.io.File"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.util.Locale"%>

<%@page import="javax.swing.JButton"%>
<%@page import="javax.swing.JComboBox"%>
<%@page import="javax.swing.JFileChooser"%>
<%@page import="javax.swing.JFrame"%>
<%@page import="javax.swing.JLabel"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="javax.swing.JScrollPane"%>
<%@page import="javax.swing.JTextArea"%>
<%@page import="javax.swing.JTextField"%>
<%@page import="javax.swing.JTextPane" %>
<%@page import="javax.swing.UIManager"%>
<%@page import="javax.swing.JFrame"%>

<%@page import="javax.swing.*"%>
<%@page import="javax.swing.text.AttributeSet"%>
<%@page import="javax.swing.text.SimpleAttributeSet"%>
<%@page import="javax.swing.text.StyleConstants"%>
<%@page import="javax.swing.text.StyleContext"%>

<%@page import="org.apache.jena.ontology.OntModel"%>
<%@page import="org.apache.jena.rdf.model.ModelFactory"%>
<%@page import="org.apache.jena.rdf.model.Model"%>
<%@page import="org.apache.jena.util.FileManager"%>


<%@page import="java.awt.event.ActionListener"%>
<%@page import="java.awt.event.ActionEvent"%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>

<%@page import="myPack.Triplet" %>
<%@page import="myPack.Triple" %>
<%@page import="myPack.TripleCode" %>
<%@page import="myPack.P1" %>
<%@page import="myPack.P2" %>
<%@page import="myPack.P3" %>
<%@page import="myPack.P4" %>
<%@page import="myPack.VerifierURI" %>
<%@page import="myPack.Tests" %>
<%@page import="myPack.Support" %>
<%@page import="myPack.Correction" %>
<%@page import="myPack.CorrectionGui" %>
<%@page import="myPack.ApplicationGui" %>
<%@page import="myPack.EvaluationGui" %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
.btn {
	background-color: Teal;
	border: none;
	color: white;
	padding: 12px 16px;
	font-size: 16px;
	cursor: pointer;
}

/* Darker background on mouse-over */
.btn:hover {
	background-color: RoyalBlue;
}

.icon-block {
	display: inline-block;
	width: 10em;
	float: left;
	text-align: center;
}

.icon-block i, .icon-block span {
	display: block;
	width: 100%;
	clear: both;
}

body, html {
	background-image:
		url('C:/Users/Khadidja/Desktop/ESI/Article1/cover.jpg');
	background-size: cover;
	background-position: center center;
	width: 100%;
	height: 100%;
	margin: 0;
}

.container {
	width: 100%;
	height: 100%;
}

.middlepane {
	width: 100%;
	height: 30%;
	float: center;
	border-collapse: collapse;
}

.downpane {
	width: 100%;
	height: 30%;
	position: relative;
	float: right;
	border-collapse: collapse;
}

.toppaneleft {
	width: 35%;
	height: 40%;
	float: left;
	border-collapse: collapse;
}

.toppaneright {
	width: 35%;
	height: 40%;
	float: left;
	border-collapse: collapse;
}

.form-control {
	border-color: transparent;
}

.input-group>.form-control:focus {
	border-color: transparent;
	box-shadow: inset 0 0 0 1px transparent;
}

.btn-link:hover {
	background-color: rgba(0, 0, 0, .05);
}

.btn-link:active, .btn-link.active {
	background-color: rgba(0, 0, 0, .05);
}

.btn-link:focus, .btn-link.focus {
	background-color: rgba(0, 0, 0, .05);
}

.btn-link:active:focus, .btn-link.active:focus {
	background-color: rgba(0, 0, 0, .05);
}

.card {
	margin-bottom: 10px;
	margin-left: 80px;
	float: left;
}
</style>
</head>
<body>


	<img src="C:/Users/Khadidja/Desktop/ESI/Article1/algerian_flag.jpg"
		width="100" height="50" />

	<a href="Welcome.jsp" class="icon-block"
		style="position: absolute; top: 10px; left: 1118px;"><i
		class="icon-hom"></i><span>Home</span></a>

	<a href="/home" class="icon-block"
		style="position: absolute; top: 10px; left: 1218px;"><i
		class="icon-hom"></i><span>Login, register</span></a>

	<a href="/home" class="icon-block"
		style="position: absolute; top: 10px; left: 1318px;"><i
		class="icon-hom"></i><span>Contact</span></a>


	<center>
		<label><FONT size="6pt"><b>The Open Government Data
					portal for Algeria </b></FONT></label> <br> <br> <br> <br> <br>



		<div class="btn-group btn-group-lg" role="group"
			aria-label="Button group with nested dropdown">


			<button type="button" class="btn btn-secondary"
				onclick="document.location='UploadDatasets.jsp'"><b><font size="+2.5">Upload
				datasets</font></b></button>

            
			<button type="button" class="btn btn-secondary"
			    onclick="document.location='LODService.jsp'"><b><font size="+2.5">Create LOD
			    service</font></b></button>
		


			<div class="btn-group" role="group">
				<button id="btnGroupDrop1" type="button"
					class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"><b><font size="+2.5">About us</font></b></button>
				<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
					<a class="dropdown-item" href="#">Dropdown link</a> <a
						class="dropdown-item" href="#">Dropdown link</a>
				</div>
			</div>
		</div>




		<img src="C:/Users/Khadidja/Desktop/ESI/Article1/alger.png"
			width="1460" height="240" />


		<div class="input-group" style="padding: 20px 400px 10px;">
			<input type="search" class="form-control rounded"
				placeholder="Search" aria-label="Search"
				aria-describedby="search-addon" />
			<button type="button" class="btn btn-outline-primary">search</button>
		</div>


		<br> <br> <br> <br> <br>


		<%
		
		JFrame f=new JFrame("");  
	    JButton b=new JButton("Start");  
	    b.setBounds(50,100,95,30); 
	    b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ApplicationGui eval=new ApplicationGui();
				
			}
		});
	    f.add(b);  
	    f.setSize(400,200);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	    
	  
		
	/*	JFrame frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 778, 700);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(); 
	    // Create JButton and JPanel
        JButton button = new JButton("Click here!");
        button.setBounds(50,100,95,30);  
        // Add button to JPanel
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.setVisible(true);*/
        
		
		/*public class ApplicationGui  {
			

			private JFrame frame;
			private JTextField textField;
			private JButton btnvaluerLontologieSelon;
			private JButton btnNewButton;
			private JTextArea textArea;
			JButton btnvaluerOntologieSelon;
			private String Ontologie="";
			public String owlFile = "";
			public OntModel Modele = ModelFactory.createOntologyModel(); 
			public boolean uri_ou_chemin=false;
			private String Path ;
			public int etoile = 0;
			//Create a file chooser
			JFileChooser fc;
			private JComboBox comboBox;
			private JScrollPane scrollPane_3;
			private JLabel lblNewLabel_1;

			String Format;

			/**
			 * Launch the application.
			 */
		/*	public void main(String[] args) {
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
			/*public ApplicationGui() {
				initialize();
			}
			/**
			 * To have the look of the current system.
			 */
		/*	public void setBestLookAndFeelAvailable(){
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
			 private String selectedString(ItemSelectable is) {
			    Object selected[] = is.getSelectedObjects();
			    return ((selected.length == 0) ? "null" : (String) selected[0]);
			  }
			
			
			/**
			 * Initialize the contents of the frame.
			 */
		/*	private void initialize() {
				frame = new JFrame();
				frame.getContentPane().setBackground(new Color(255, 250, 240));
				frame.setBounds(100, 100, 778, 700);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				
				JFileChooser.setDefaultLocale(new Locale("en","US"));
				fc = new JFileChooser();

				
				/* 		*************************************************  
		 				* Here the field of URI or path of the ontology *
		 				*************************************************       */
				
			/*	textField = new JTextField();
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
							/*{
								
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

				/*btnNewButton = new JButton("Open");
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
				String contenuArea = textArea.getText();*/
				/*frame.setVisible(true);
				
				
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

				
				
			}*/

		%>

  <button type="button" class="btn btn-secondary"
				onclick="document.location='LODPublishing.jsp'">Data accessibilty assessment</button>
	</center>
</body>
</html>
