package myPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.textrazor.TextRazor;
import com.textrazor.annotations.AnalyzedText;
import com.textrazor.annotations.Custom;
import com.textrazor.annotations.Entity;
import com.textrazor.annotations.Sentence;
import com.textrazor.annotations.Word;

import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/DataAccessibility")
@MultipartConfig
public class DataAccessibility extends HttpServlet {
		private static final long serialVersionUID = 1L;
		



		@SuppressWarnings({ "incomplete-switch", "resource", "rawtypes", "unchecked" })
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub


			double Access_option = 0;
			double Available_format = 0;
			double Licencing = 0;
			double Timeliness = 0;
			String category = null;

		response.setContentType("text/html");
		PrintWriter out=null;

		try {
			 out = response.getWriter();
			 category = request.getParameter("category");
			 
			 String nbtotal = request.getParameter("nbtotal");
			 double total_number_of_data = Double.parseDouble(nbtotal); 
		  
		     System.out.println("the category or the link of the data is : "+category);
		     System.out.println("the total number of data : "+total_number_of_data);
		     

			/************************Access option*************************/
			
			/************connect to the database and select count the number of file format existing ************/
			/************fill the followinf parameters*************/
		     //String nbaccess1 = request.getParameter("nbaccess1");
		     double nb_access1 = /*fill the number of turtle file*/; 
		     
		     //String nbaccess2 = request.getParameter("nbaccess2");
		     double nb_access2 = /*fill the number of rdf file*/; 
		     
		     //String nbaccess3 = request.getParameter("nbaccess3");
		     double nb_access3 = /*fill the number of JSON-LD file*/; 
		     /*
		     String praccess1 = request.getParameter("praccess1");
		     double pr_access1 = Double.parseDouble(praccess1); 
		     
		     String praccess2 = request.getParameter("praccess2");
		     double pr_access2 = Double.parseDouble(praccess2);
		     
		     String praccess3 = request.getParameter("praccess3");
		     double pr_access3 = Double.parseDouble(praccess3); */
		     
		     Access_option = (nb_access1*90+nb_access2*
		    		 80+nb_access3*85)/total_number_of_data;
		     
		     System.out.println("the percentage of access option metric is : "
		     		+ ""+Access_option);

		    /************************Available format*************************/
			
			
			
			/************connect to the database and select count the number of machine readable file,
			structured and unstructured  existing ************/
			/************fill the followinf parameters*************/
			
		     //String nbavailable1 = request.getParameter("nbavailable1");
		     double nb_available1 = /*fill the number of readable machine files*/;
		     
		     //String nbavailable2 = request.getParameter("nbavailable2");
		     double nb_available2 = /*fill the number of structured and unstructured files*/; 
			 
		
		     
		     Available_format = (nb_available1*80+nb_available2*23)/total_number_of_data;
		     
		     System.out.println("the percentage of available format metric is : "
		     +Available_format);
		            
		    /****************************Licencing****************************/
			
				/************connect to the database and select the licence of each datasets ************/
			/************fill the followinf parameters*************/
			
			
		     //String nblicence1 = request.getParameter("nblicence1");
		     double nb_licence1 = /*fill the number of datasets with CC BY licence*/;   
		     //System.out.println("par1: "+nb_licence1);
		     
			 //String nblicence2 = request.getParameter("nblicence2");
		     double nb_licence2 = /*fill the number of datasets with CC BY-SA licence*/;   
		     //System.out.println("par1: "+nb_licence2);
		     
			 //String nblicence3 = request.getParameter("nblicence3");
		     double nb_licence3 = /*fill the number of datasets with CC-BY-ND licence*/;   
		     //System.out.println("par1: "+nb_licence3);
		     
			 //String nblicence4 = request.getParameter("nblicence4");
		     double nb_licence4 = /*fill the number of datasets with CC-BY-NC licence*/;   
		     //System.out.println("par1: "+nb_licence4);
		     
			 //String nblicence5 = request.getParameter("nblicence5");
		     double nb_licence5 = /*fill the number of datasets with CC BY-NC-SA licence*/;   
		     //System.out.println("par1: "+nb_licence5);
		     
			 
			 //String nblicence6 = request.getParameter("nblicence6");
		     double nb_licence6 = /*fill the number of datasets with CC BY-NC-ND licence*/;  
		     //System.out.println("par1: "+nb_licence6);
		     
			 //String nblicence7 = request.getParameter("nblicence7");
		     double nb_licence7 = /*fill the number of datasets with no licence*/;  
		     //System.out.println("par1: "+nb_licence7);
		       
		     //System.out.println("par1: "+nb_licence8);
		     Licencing =(nb_licence1*100+nb_licence2*90+nb_licence3*80+
		    		 nb_licence4*70+nb_licence5*60+nb_licence6*40+nb_licence7*
		    		 20)/(nb_licence1+nb_licence2+nb_licence3+nb_licence4+
		    				 nb_licence5+nb_licence6+nb_licence7) ;
		     
		     System.out.println("the percentage of Licencing metric is : "
		     		+ ""+Licencing);
		            
		    /****************************Timeliness***************************/
			
			/************connect to the database and select the update frequency for each datasets ************/
			/************fill the followinf parameters*************/

		     //String nbTimeliness1 = request.getParameter("nbTimeliness1");
		     double nb_Timeliness1 = /*fill the number of datasets with daily update*/; 
		     
		     //String nbTimeliness2 = request.getParameter("nbTimeliness2");
		     double nb_Timeliness2 = /*fill the number of datasets with monthly update*/;
		     
		     //String nbTimeliness3 = request.getParameter("nbTimeliness3");
		     double nb_Timeliness3 = /*fill the number of datasets with yearly update*/;
		     
		     //String nbTimeliness4 = request.getParameter("nbTimeliness4");
		     double nb_Timeliness4 = /*fill the number of datasets with regularly update*/; 
		     
		     //String nbTimeliness5 = request.getParameter("nbTimeliness5");
		     double nb_Timeliness5 = /*fill the number of datasets with no upådate*/;
		     
		     /*String nbTimeliness6 = request.getParameter("nbTimeliness6");
		     double nb_Timeliness6 = Double.parseDouble(nbTimeliness6);*/
		     
		     Timeliness =  (nb_Timeliness1*100+nb_Timeliness2*80
		    		 +nb_Timeliness3*60+nb_Timeliness4*40+nb_Timeliness5
		    		 *10)/total_number_of_data;
		     
		     System.out.println("the percentage of Timeliness metric is : "
		     		+ ""+Timeliness);
		     

		     
		     
		     
		                               
		}
		catch(Exception e){
		out.println("Error : "+e.getMessage());
		}
		finally {
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\"> \r\n"
				+ "<title>Home Page</title>\r\n"
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n"
				+ "<!--  <link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\"/> -->\r\n"
				+ "\r\n"
				+ "<!--  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">-->\r\n"
				+ "<style>\r\n"
				+ "   \r\n"
				+ "     /* body {\r\n"
				+ "      background-image: url('C:/Users/Khadidja/Desktop/ESI/Article1/background.jpg');\r\n"
				+ "      }*/\r\n"
				+ "      \r\n"
				+ "      \r\n"
				+ "      \r\n"
				+ "     .btn {\r\n"
				+ "      background-color: Teal;\r\n"
				+ "      border: none;\r\n"
				+ "      color: white;\r\n"
				+ "      padding: 12px 16px;\r\n"
				+ "      font-size: 16px;\r\n"
				+ "      cursor: pointer;\r\n"
				+ "      \r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "     /* Darker background on mouse-over */\r\n"
				+ "     .btn:hover {\r\n"
				+ "      background-color: RoyalBlue;\r\n"
				+ "      }\r\n"
				+ "      .icon-block {\r\n"
				+ "        display:inline-block;\r\n"
				+ "        width:10em;\r\n"
				+ "        float:left;\r\n"
				+ "        text-align:center;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .icon-block i,\r\n"
				+ "    .icon-block span {\r\n"
				+ "        display:block;\r\n"
				+ "        width:100%;\r\n"
				+ "        clear:both;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    body, html {\r\n"
				+ "    background-image: url('C:/Users/Khadidja/Desktop/ESI/Article1/cover.jpg');\r\n"
				+ "    background-size: cover; \r\n"
				+ "    background-position: center center;\r\n"
				+ "  width: 100%;\r\n"
				+ "  height: 100%;\r\n"
				+ "  margin: 0;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "  width: 100%;\r\n"
				+ "  height: 100%;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ ".middlepane {\r\n"
				+ "    width: 100%;\r\n"
				+ "    height: 30%;\r\n"
				+ "    float: center;\r\n"
				+ "    border-collapse: collapse;\r\n"
				+ "    \r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".downpane {\r\n"
				+ "  width: 100%;\r\n"
				+ "  height: 30%;\r\n"
				+ "  position: relative;\r\n"
				+ "  float: center;\r\n"
				+ "  border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".toppaneleft {\r\n"
				+ "  width: 100%;\r\n"
				+ "  height: 40%;\r\n"
				+ "  float: center;\r\n"
				+ "  border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".toppaneright {\r\n"
				+ "  width: 45%;\r\n"
				+ "  height: 70%;\r\n"
				+ "  float: center;\r\n"
				+ "  border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ ".form-control {\r\n"
				+ "  border-color: transparent;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".input-group>.form-control:focus {\r\n"
				+ "  border-color: transparent;\r\n"
				+ "  box-shadow: inset 0 0 0 1px transparent;\r\n"
				+ "}\r\n"
				+ ".btn-link:hover {\r\n"
				+ "  background-color: rgba(0,0,0,.05);\r\n"
				+ "}\r\n"
				+ ".btn-link:active, .btn-link.active {\r\n"
				+ "  background-color: rgba(0,0,0,.05);\r\n"
				+ "}\r\n"
				+ ".btn-link:focus, .btn-link.focus {\r\n"
				+ "  background-color: rgba(0,0,0,.05);\r\n"
				+ "}\r\n"
				+ ".btn-link:active:focus, .btn-link.active:focus {\r\n"
				+ "  background-color: rgba(0,0,0,.05);\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".card{\r\n"
				+ "    margin-bottom: 10px;\r\n"
				+ "    margin-left: 80px;\r\n"
				+ "    float: center;\r\n"
				+ "  }\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "     <img src=\"C:/Users/Khadidja/Desktop/ESI/Article1/algerian_flag.jpg\"\r\n"
				+ "		width=\"100\" height=\"50\" />\r\n"
				+ "\r\n"
				+ "	<a href=\"NewPublish.jsp\" class=\"icon-block\"\r\n"
				+ "		style=\"position: absolute; top: 10px; left: 1118px;\"><i\r\n"
				+ "		class=\"icon-hom\"></i><span>Home</span></a>\r\n"
				+ "\r\n"
				+ "	<a href=\"/home\" class=\"icon-block\"\r\n"
				+ "		style=\"position: absolute; top: 10px; left: 1218px;\"><i\r\n"
				+ "		class=\"icon-hom\"></i><span>Login, register</span></a>\r\n"
				+ "\r\n"
				+ "	<a href=\"/home\" class=\"icon-block\"\r\n"
				+ "		style=\"position: absolute; top: 10px; left: 1318px;\"><i\r\n"
				+ "		class=\"icon-hom\"></i><span>Contact</span></a>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "	<center>\r\n"
				+ "		<label><FONT size=\"6pt\"><b>The Open Government Data\r\n"
				+ "					portal for Algeria </b></FONT></label> <br> <br> <br> <br> <br>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "		<div class=\"btn-group btn-group-lg\" role=\"group\"\r\n"
				+ "			aria-label=\"Button group with nested dropdown\">\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "			<button type=\"button\" class=\"btn btn-secondary\"\r\n"
				+ "				onclick=\"document.location='UploadDatasets.jsp'\"><b><font size=\"+2.5\">Upload\r\n"
				+ "				datasets</font></b></button>\r\n"
				+ "\r\n"
				+ "            \r\n"
				+ "			<button type=\"button\" class=\"btn btn-secondary\"\r\n"
				+ "			    onclick=\"document.location='LODService.jsp'\"><b><font size=\"+2.5\">Create LOD\r\n"
				+ "			    service</font></b></button>\r\n"
				+ "		\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "			<div class=\"btn-group\" role=\"group\">\r\n"
				+ "				<button id=\"btnGroupDrop1\" type=\"button\"\r\n"
				+ "					class=\"btn btn-secondary dropdown-toggle\" data-toggle=\"dropdown\"\r\n"
				+ "					aria-haspopup=\"true\" aria-expanded=\"false\"><b><font size=\"+2.5\">About us</font></b></button>\r\n"
				+ "				<div class=\"dropdown-menu\" aria-labelledby=\"btnGroupDrop1\">\r\n"
				+ "					<a class=\"dropdown-item\" href=\"#\">Dropdown link</a> <a\r\n"
				+ "						class=\"dropdown-item\" href=\"#\">Dropdown link</a>\r\n"
				+ "				</div>\r\n"
				+ "			</div>\r\n"
				+ "		</div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "		<img src=\"C:/Users/Khadidja/Desktop/ESI/Article1/alger.png\"\r\n"
				+ "			width=\"1460\" height=\"240\" />\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "		<div class=\"input-group\" style=\"padding: 20px 400px 10px;\">\r\n"
				+ "			<input type=\"search\" class=\"form-control rounded\"\r\n"
				+ "				placeholder=\"Search\" aria-label=\"Search\"\r\n"
				+ "				aria-describedby=\"search-addon\" />\r\n"
				+ "			<button type=\"button\" class=\"btn btn-outline-primary\">search</button>\r\n"
				+ "		</div>");
		out.println("The category or the link of the data is : "+category);
		out.println("<br><br>");
		out.println("The percentage of access option metric is : "
		 		+ ""+Access_option+"%");
		out.println("<br><br>");
		out.println("The percentage of availble format metric is : "
		 		+ ""+Available_format+"%");
		out.println("<br><br>");
		out.println("The percentage of licencing metric is : "
		 		+ ""+Licencing+"%");
		out.println("<br><br>");
		out.println("The percentage of timeliness metric is : "
		 		+ ""+Timeliness+"%");
		out.println("<br><br><br><br><br><br>");
		out.println("</center>");
		}
		}
}
