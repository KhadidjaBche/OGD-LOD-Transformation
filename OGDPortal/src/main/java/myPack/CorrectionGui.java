package myPack;

import java.awt.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.apache.http.HttpException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


import java.awt.Color;

import javax.swing.JTextPane;

public class CorrectionGui extends JFrame {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	String mom,mon, lien;
	private JLabel Lab; 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorrectionGui frame = new CorrectionGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean chiffree(String chaine){
		int i =0;
		boolean b = false;
			while(i < chaine.length() && b == false){
				if(chaine.indexOf(i) >= '0' && chaine.indexOf(i) <= '9'){
					b = true;
				}
				
				i++;
			}
			return b;		
	}
	
	public static String Separateur(String element, String separateur){
		
		StringTokenizer stringTokenizer = new StringTokenizer(element,separateur); 
		   
		String[] items = new String[stringTokenizer.countTokens()] ; 
	   
		int k= 0;
	   //This loop is used in order to separate the ^^ from a String 
		while ( stringTokenizer.hasMoreTokens() ){ 
			items[k] = stringTokenizer.nextToken(); 
			k++;
		}

		//We take the first substring ; i,e. the first string befor the ==> ^^
		String id=items[0] ;
		return id;
	}
	
	private void appendToPane(JTextPane tp, String msg, Color c)
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
	public CorrectionGui() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1301, 795);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/correction-error.jpg")).getImage(); // LE CHEMIN
		//label.setIcon(new ImageIcon(img));
		label.setBounds(346, 12, 375, 76);
		contentPane.add(label);
		
		JButton button1 = new JButton("Principle 1");
		button1.setBackground(new Color(250, 250, 210));
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				appendToPane(textPane,"\n\t*********************************************\n \t   *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 1                     ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);
				Lab.setText("Correction Principle 1 : Primitives not represented by a URI");
				
				if (P1.nbliteral==0)
				{	System.out.println("P1.nbliteral"+P1.nbliteral);
				     
					appendToPane(textPane,"No primitive to correct",Color.PINK);
				    JOptionPane.showMessageDialog(null,"No correction required", "Warning !", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else 
				{
					try {
							Correction.Corriger_Principe1(ApplicationGui.Modele, ApplicationGui.owlFile,EvaluationGui.primitif);
							
							appendToPane(textPane,"________________________________________________________________________________________________________________________________________________________\n",Color.DARK_GRAY);
							appendToPane(textPane,"|                                                                                            \n|",Color.DARK_GRAY);
							appendToPane(textPane,"  Wrong primitive       ",Color.GREEN);
							appendToPane(textPane,"       ",Color.PINK);
							appendToPane(textPane,"Corrected Primitive                   \n",Color.BLUE);
							appendToPane(textPane,"|___________________________________________________________________________________________________________________________________________________________\n",Color.DARK_GRAY);
							int i=1;
							while(!Correction.primitives.split("\n").equals("")&&!Correction.primitivesCor.split("\n").equals("")&& i<=P1.nbliteral)
							{
								mom=Correction.primitives.split("\n")[i];
								mon=Correction.primitivesCor.split("\n")[i];
								if(mom.contains("^^")) mom = Separateur(mom, "^^");//-----------------------HERE---------
								appendToPane(textPane,"|",Color.DARK_GRAY);
								appendToPane(textPane, mom ,Color.GREEN);
										
								appendToPane(textPane, "       ",Color.PINK);
								
								appendToPane(textPane,   mon  +"\n",Color.BLUE);
							    appendToPane(textPane,"|____________________________________________________________________________________________________________________________________________________________\n",Color.DARK_GRAY);
								i++;
							}
	
						}catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
						}	
				}
				/****************     P1 file generation             ***********/
				try{
					BufferedReader in = new BufferedReader(new FileReader("jadid.owl"));
					String line = in.readLine();
					String prim[] = Correction.primitivesCor.split("\n");
					
					while(line != null){
						int i =1; 
						boolean b = false;
						while(i< prim.length && b == false){
							if(line.contains(prim[i])){
								b = true;
							}
						 i++;
						}
						if( b == true)
							appendToPane(textPane,line+ "\n",Color.BLUE);
						else
							appendToPane(textPane,line+ "\n",Color.BLACK);
						
						line = in.readLine();
					}
				  }catch (IOException e10) {
					// TODO Auto-generated catch block
					e10.printStackTrace();
				} 
			}
		});
		button1.setBounds(27, 134, 117, 25);
		contentPane.add(button1);
		
		JButton button2 = new JButton("Principle 2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendToPane(textPane,"\n\t*********************************************\n \t  *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 2                    ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);
				
				Lab.setText("Correction Principle 2 : Primitives represented by non-dereferenceable URIs");
				
				if (P2.nbnondereferençable==0)
				{
					 JOptionPane.showMessageDialog(null,"No correction required", "Warning !", JOptionPane.INFORMATION_MESSAGE);
						return;
				}
				else 
				{
					try {
						
						Correction.Correction_P2(ApplicationGui.Modele,EvaluationGui.Code_Reponse,EvaluationGui.primitif);
						appendToPane(textPane," \t\t Principle 2                    ",Color.PINK);
						appendToPane(textPane,"________________________________________________________________________________________________________________________________________________________\n",Color.DARK_GRAY);
						appendToPane(textPane,"|                                                                                            \n|",Color.DARK_GRAY);
						appendToPane(textPane,"  Wrong primitive  ",Color.RED);
						appendToPane(textPane," ===========>  ",Color.PINK);
						appendToPane(textPane,"Corrected Primitive                 \n",Color.magenta);
						appendToPane(textPane,"|___________________________________________________________________________________________________________________________________________________________\n",Color.DARK_GRAY);
						
						String mom,mon;int i=0;
						
						while(!Correction.primitives2.split("\n").equals("")&&!Correction.primitivesCor2.split("\n").equals("")&& i<=Correction.nbprimacorrige){	
							mom=Correction.primitives2.split("\n")[i];
							mon=Correction.primitivesCor2.split("\n")[i];
							
							appendToPane(textPane,"|",Color.DARK_GRAY);
							appendToPane(textPane, mom ,Color.red);
									
							appendToPane(textPane, "  ===========>   ",Color.PINK);
							
							appendToPane(textPane,   mon  +"\n",Color.magenta);
						    appendToPane(textPane,"|____________________________________________________________________________________________________________________________________________________________\n",Color.DARK_GRAY);
							i++;
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					try{
						BufferedReader in = new BufferedReader(new FileReader("jadid.owl"));
						String line = in.readLine();
						String prim[] = Correction.primitivesCor2.split("\n");
						
						while(line != null){
							int i =1; 
							boolean b = false;
							while(i< prim.length && b == false){
								if(line.contains(prim[i])){
									b = true;
								}
							 i++;
							}
							if( b == true)
								appendToPane(textPane,line+ "\n",Color.magenta);
							else
								appendToPane(textPane,line+ "\n",Color.BLACK);
							
							line = in.readLine();
						}
					  }catch (IOException e10) {
						// TODO Auto-generated catch block
						e10.printStackTrace();
					} 
					
					
					
					
				}
			}
		});
		button2.setBounds(27, 195, 117, 25);
		contentPane.add(button2);
		
		JButton button3 = new JButton("Principle 3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendToPane(textPane,"\n\t*********************************************\n \t  *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 3                     ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);
				
				Lab.setText(" Correction Principle 3 : Ontology contains information not useful to the machine");
				if(P3.Erreurs == 0){
					JOptionPane.showMessageDialog(null,"No correction required", "Warning !", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("What are you thinking you are doing !");
					
					return;
				}
				else{
					try {
						Correction.Corriger_Principe3(new File("./exec.txt"), new File("./Erreurs_syntaxique.txt"), "Corriger7"); // LE CHEMIN
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try{
						BufferedReader in = new BufferedReader(new FileReader("Corriger7"));
						String line = in.readLine();
						while(line != null){
						
							if(line.contains("=")){
								appendToPane(textPane, "\n",Color.BLUE);
								String ligne [] = line.split("=");
								
								System.out.println("Ligne[0] "+ ligne[0]+" Ligne[1] "+ ligne[1]);
								appendToPane(textPane, ligne[0], Color.RED);
						        appendToPane(textPane, " "+ligne[1]+"\n", Color.MAGENTA);
							}
							else {
								appendToPane(textPane,line+"\n" , Color.DARK_GRAY);
							}
							line = in.readLine();
						  }
					}catch (IOException e10) {
						// TODO Auto-generated catch block
						e10.printStackTrace();
					} 
	
				}	
			}
		});
		button3.setBounds(27, 250, 117, 25);
		contentPane.add(button3);
		
		JButton button4 = new JButton("Principle 4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendToPane(textPane,"\n\t*********************************************\n \t  *",Color.CYAN);
				appendToPane(textPane," \t\t Principle 4                     ",Color.PINK);
				appendToPane(textPane,"*\n\t*********************************************\n\n",Color.CYAN);
				
				Lab.setText("Correction Principle 4 : Ontology does not contain links to other data sources");
				
				String res;
				if(P4.link > 0)
				{
					 JOptionPane.showMessageDialog(null,"No correction required", "Warning !", JOptionPane.INFORMATION_MESSAGE);
						return;
				}
				else
				{
					//Show all ontology classes
					Correction.Recuperer_classe(ApplicationGui.Modele);
					if (chiffree(Correction.classe) == true){
						appendToPane(textPane,Correction.classe,Color.BLUE);
					}
					else{ //Encrypted class
						if (P1.nbliteral > 0){ 
							//textArea.setText(P1.literal);
							appendToPane(textPane,P1.literal,Color.BLUE);
						}
						else{// No proposal nor class nor literal.
							
							appendToPane(textPane,"No term to propose for this ontology",Color.MAGENTA);
							res=JOptionPane.showInputDialog(null,"No terms to propose ! \n Submit your own term\n",
									"Correction Principle 4!", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
					}
					res=JOptionPane.showInputDialog(null,"Enter a term among those presented without typing the type after ^^ \n", "Correction Principle 4!", JOptionPane.INFORMATION_MESSAGE);
					 //Links of the chosen class
					try {
						Correction.Sparql_Requete(ApplicationGui.Modele, res);
					} catch (HttpException e2) {
						// TODO Auto-generated catch block
						System.out.println("503 Name or service not known: Unexpected error making the query");
					}
					res=Correction.resr+"";
					appendToPane(textPane,Correction.bos.toString(),Color.GRAY);
					/******************************************** ICI *************************************************************/
				   //Test if there is no link after choosing a term the request does not send a link
					System.out.println("Nbre==== "+Correction.nbres);
					if(Correction.nbres == 0){	
						JOptionPane.showMessageDialog(null,"No links found for your selection", "Warning !", JOptionPane.INFORMATION_MESSAGE);
						 int k=JOptionPane.showConfirmDialog(getParent(), "Re-enter another term? ", "Link search", JOptionPane.YES_NO_OPTION);
					    	
					    	if (k==JOptionPane.YES_OPTION){
					    		 res=JOptionPane.showInputDialog(null,"Please enter another term\n", "Correction Principle 4!", JOptionPane.INFORMATION_MESSAGE);
					    		
					    		 try {
										Correction.Sparql_Requete(ApplicationGui.Modele, res);
									} catch (HttpException e2) {
										// TODO Auto-generated catch block
										System.out.println("Name or service not known: Unexpected error making the query");
									}
									res=Correction.resr+"";
									appendToPane(textPane,Correction.bos.toString(),Color.GRAY);
					    		 
					    		 //The user is asked to give a link
									res=JOptionPane.showInputDialog(null," Please choose a link \n", "Correction Principle 4!", JOptionPane.INFORMATION_MESSAGE);
									//Here we add the link  
					    	}else{
					    		return;
					    	}
					}else{// the query returns the result.
						//The user is asked to give a link
						res=JOptionPane.showInputDialog(null," Please choose a link \n", "Correction Principle 4!", JOptionPane.INFORMATION_MESSAGE);
						lien = res;
						// Here we add the link 
						try{
							Correction.ajout_lien(ApplicationGui.Modele, res);
							return;
						}catch (IOException e1) {
							e1.printStackTrace();
						}
					}						
				}	
			}
		});
		button4.setBounds(27, 334, 117, 25);
		contentPane.add(button4);
		
		JButton button5 = new JButton("View file");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P4.link == 0){
					try{
						BufferedReader in = new BufferedReader(new FileReader("new.owl"));
						String line = in.readLine();
						while(line != null){
							try{
								if(line.contains(lien))
									appendToPane(textPane,line+ "\n",Color.red);
								
								else
									appendToPane(textPane,line+ "\n",Color.black);
								
								line = in.readLine();
							}catch(NullPointerException error){
								JOptionPane.showMessageDialog(null,"No files to generate", "Warning !", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("What are you thinking you are doing !");
								
								return;
							}
						 }
					}catch (IOException e10) {
						// TODO Auto-generated catch block
						System.out.println("What are you thinking you are doing !");
						//e10.printStackTrace();
					 }  
				}
				else{

					 JOptionPane.showMessageDialog(null,"No files to regenerate", "Warning !", JOptionPane.INFORMATION_MESSAGE);
					 return;
				}
				
				
				
			}
		});
		button5.setBounds(27, 396, 146, 81);
		contentPane.add(button5);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 100, 1068, 535);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		Lab = new JLabel("");
		Lab.setBounds(318, 657, 603, 75);
		contentPane.add(Lab);

	}
}
