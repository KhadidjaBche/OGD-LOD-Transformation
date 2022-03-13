package myPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class QueryComposer
 */
@WebServlet("/QueryComposer")
@MultipartConfig
public class QueryComposer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String GeneratedQuery="";
    private String prefixes = "";
    private String subject = "";
    private String predicate = "";
    private String object = "";
    private String subjectName = "";
    private String predicateName = "";
    private String objectName = "";
    private String filterProperty="";
    private String typeFiltering="";
    private String valueFiltering="";
    private String operationFiltering="";
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/* bring all the selected values from the QueryComposer.jsp*/
		/* Generate the query according to the selected values */
		
		response.setContentType("text/html");
		PrintWriter out=null;
		
		out = response.getWriter();
		
		prefixes = request.getParameter("prefix");
		
		subject = request.getParameter("subject");
		predicate = request.getParameter("predicate");
		object = request.getParameter("object");
		
		subjectName = request.getParameter("subjectName");
		predicateName = request.getParameter("predicateName");
		objectName = request.getParameter("objectName");
		
		filterProperty = request.getParameter("filterProperty");
		typeFiltering = request.getParameter("typeFiltering");
		valueFiltering = request.getParameter("valueFiltering");
		operationFiltering = request.getParameter("operationFiltering");
		
		
		GeneratedQuery = prefixes+ "\r\n"
				+ "Select ?"+subjectName+" ?"+predicateName+" ?"+objectName+"\r\n"
						+ "Where {"
						+ "?x "+subject+" ?"+subjectName+"\r\n"
						+ "?x "+predicate+" ?"+predicateName+"\r\n"
						+ "?x "+object+" ?"+objectName+"\r\n"
								+ "filter("+typeFiltering+"(?"+filterProperty+")"+operationFiltering+""+valueFiltering+"\r\n"
										+ "}";
		
		out.println("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\" %>\r\n"
				+ "<%@page import=\"java.util.List\"%>\r\n"
				+ "<%@page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\r\n"
				+ "\r\n"
				+ "<%@page import=\"java.sql.DriverManager\"%>\r\n"
				+ "<%@page import=\"java.sql.ResultSet\"%>\r\n"
				+ "<%@page import=\"java.sql.Statement\"%>\r\n"
				+ "<%@page import=\"java.sql.Connection\"%>\r\n"
				+ "<%@page import=\"java.io.OutputStream\"%>\r\n"
				+ "<%@page import=\"java.io.InputStream\"%>\r\n"
				+ "<%@page import=\"java.sql.Blob\"%>\r\n"
				+ "<%@page import=\"java.io.*\"%>\r\n"
				+ "<%@page import=\"java.sql.*\"%>\r\n"
				+ "<!DOCTYPE html>\r\n"
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
				+ "		</div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "		<br> <br> <br> <br> <br>\r\n"
				+ "\r\n"
				+ "      \r\n"
				+ "       \r\n"
				+ "       \r\n"
				+ "       \r\n"
				+ "     </center>  \r\n"
				+ "       <label><FONT size=\"5pt\"><b><h1 style=\"background-color:powderblue;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SPARQL query composer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </h1></b></FONT></label>\r\n"
				+ "       <center>\r\n"
				+ "       <textarea class=\"form-control\" id=\"exampleFormControlTextarea1\" rows=\"20\" cols=\"40\">\r\n"
				+ "   \r\n"
				+ "\r\n"
				+ "\r\n"
				+ GeneratedQuery+""
				+ "    </textarea> <br><br> br><br><br>\r\n"
				+ "<button type=\"button\" class=\"btn btn-primary\" onclick=\"document.location='http://localhost:3030/'\">Query the dataset</button>\r\n"
				+ " </center>" );
	}

}
