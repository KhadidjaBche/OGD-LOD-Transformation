package myPack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PublishingListener")
public class PublishingListener extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //new MyClass().print();
		response.setContentType("text/html");
		PrintWriter out=null;
		out = response.getWriter();
		out.println("\r\n"
				+ "\r\n"
				+ "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Home Page</title>\r\n"
				+ "<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n"
				+ "<style>\r\n"
				+ ".btn {\r\n"
				+ "	background-color: Teal;\r\n"
				+ "	border: none;\r\n"
				+ "	color: white;\r\n"
				+ "	padding: 12px 16px;\r\n"
				+ "	font-size: 16px;\r\n"
				+ "	cursor: pointer;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Darker background on mouse-over */\r\n"
				+ ".btn:hover {\r\n"
				+ "	background-color: RoyalBlue;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".icon-block {\r\n"
				+ "	display: inline-block;\r\n"
				+ "	width: 10em;\r\n"
				+ "	float: left;\r\n"
				+ "	text-align: center;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".icon-block i, .icon-block span {\r\n"
				+ "	display: block;\r\n"
				+ "	width: 100%;\r\n"
				+ "	clear: both;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "body, html {\r\n"
				+ "	background-image:\r\n"
				+ "		url('C:/Users/Khadidja/Desktop/ESI/Article1/cover.jpg');\r\n"
				+ "	background-size: cover;\r\n"
				+ "	background-position: center center;\r\n"
				+ "	width: 100%;\r\n"
				+ "	height: 100%;\r\n"
				+ "	margin: 0;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "	width: 100%;\r\n"
				+ "	height: 100%;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".middlepane {\r\n"
				+ "	width: 100%;\r\n"
				+ "	height: 30%;\r\n"
				+ "	float: center;\r\n"
				+ "	border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".downpane {\r\n"
				+ "	width: 100%;\r\n"
				+ "	height: 30%;\r\n"
				+ "	position: relative;\r\n"
				+ "	float: right;\r\n"
				+ "	border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".toppaneleft {\r\n"
				+ "	width: 35%;\r\n"
				+ "	height: 40%;\r\n"
				+ "	float: left;\r\n"
				+ "	border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".toppaneright {\r\n"
				+ "	width: 35%;\r\n"
				+ "	height: 40%;\r\n"
				+ "	float: left;\r\n"
				+ "	border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".form-control {\r\n"
				+ "	border-color: transparent;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".input-group>.form-control:focus {\r\n"
				+ "	border-color: transparent;\r\n"
				+ "	box-shadow: inset 0 0 0 1px transparent;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".btn-link:hover {\r\n"
				+ "	background-color: rgba(0, 0, 0, .05);\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".btn-link:active, .btn-link.active {\r\n"
				+ "	background-color: rgba(0, 0, 0, .05);\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".btn-link:focus, .btn-link.focus {\r\n"
				+ "	background-color: rgba(0, 0, 0, .05);\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".btn-link:active:focus, .btn-link.active:focus {\r\n"
				+ "	background-color: rgba(0, 0, 0, .05);\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".card {\r\n"
				+ "	margin-bottom: 10px;\r\n"
				+ "	margin-left: 80px;\r\n"
				+ "	float: left;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "	<img src=\"C:/Users/Khadidja/Desktop/ESI/Article1/algerian_flag.jpg\"\r\n"
				+ "		width=\"100\" height=\"50\" />\r\n"
				+ "\r\n"
				+ "	<a href=\"Welcome.jsp\" class=\"icon-block\"\r\n"
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
				+ "				onclick=\"document.location='UploadDatasets.jsp'\">Upload\r\n"
				+ "				datasets</button>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "			<button type=\"button\" class=\"btn btn-secondary\"\r\n"
				+ "				onclick=\"document.location='LODService.jsp'\">Create LOD\r\n"
				+ "				service</button>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "			<div class=\"btn-group\" role=\"group\">\r\n"
				+ "				<button id=\"btnGroupDrop1\" type=\"button\"\r\n"
				+ "					class=\"btn btn-secondary dropdown-toggle\" data-toggle=\"dropdown\"\r\n"
				+ "					aria-haspopup=\"true\" aria-expanded=\"false\">About us</button>\r\n"
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
				+ "		<center>\r\n"
				+ "			<br> <br> <br> <br> <br> <label><FONT\r\n"
				+ "				size=\"4pt\"><b>Select the Licence: </b></FONT></label> <SELECT name=\"nom\"\r\n"
				+ "				size=\"1\">\r\n"
				+ "				<OPTION>CC BY\r\n"
				+ "				<OPTION>CC BY-SA\r\n"
				+ "				<OPTION>CC-BY-ND\r\n"
				+ "				<OPTION>CC BY-NC\r\n"
				+ "				<OPTION>CC BY-NC-SA\r\n"
				+ "				<OPTION>CC BY-NC-ND\r\n"
				+ "				<OPTION>None\r\n"
				+ "			</SELECT> <br> <br> <br> <label><FONT size=\"4pt\"><b>Enter\r\n"
				+ "						the update frequency: </b></FONT></label> <SELECT name=\"nom\" size=\"1\">\r\n"
				+ "				<OPTION>None\r\n"
				+ "			</SELECT> <br> <br> <br> <input type=submit\r\n"
				+ "				value=\"Evaluate data accessibility\" onclick=\"myPack.PublishingListener\" > <br> <br> <br>\r\n"
				+ "		</center>\r\n"
				+ "\r\n"
				+ "	\r\n"
				+ "\r\n"
				+ "		<label><FONT size=\"6pt\"><b>The result of data\r\n"
				+ "					accessibility aspects: </b></FONT></label> <br> <br> <label><FONT\r\n"
				+ "			size=\"4pt\"><b>Access options: 35.0%</b></FONT></label> <br> <br> <label><FONT\r\n"
				+ "			size=\"4pt\"><b>Available formats: 83.5% </b></FONT></label> <br> <br>\r\n"
				+ "		<label><FONT size=\"4pt\"><b>Licencing: 100.0%</b></FONT></label> <br>\r\n"
				+ "		<br> <label><FONT size=\"4pt\"><b>Timeliness:\r\n"
				+ "					10.0%</b></FONT></label> <br> <br> <br> <br> <label><FONT\r\n"
				+ "			size=\"4pt\" style=\"color: #008000\"><b>the average of the\r\n"
				+ "					evaluation is: 57.12%</b></FONT></label> <br> <br> <br>\r\n"
				+ "\r\n"
				+ "		<button type=\"button\" class=\"btn btn-secondary\"\r\n"
				+ "			onclick=\"document.location='DataAccessibility.jsp'\">Publish the\r\n"
				+ "			generated LOD</button>\r\n"
				+ "\r\n"
				+ "	</center>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
    }
}

/*
public class PublishingListener {
private String text;
public String getText()
{
return text;
}
public PublishingListener()
{
 text="Hello World";
}
}

 <jsp:useBean id="bean" class="myPack.PublishingListener" />
Message is: <jsp:getProperty name="bean" property="text" /> 
*/

/*
import javax.faces.bean.ManagedBean;

//@ManagedBean(name = "publishingListener", eager = true)
public class PublishingListener {
   
   public PublishingListener() {
      System.out.println("HelloWorld started!");
   }
	
   public String getMessage() {
      return "Hello World!";
   }
}*/


/*
import java.awt.event.ActionEvent;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean @SessionScoped
public class PublishingListener {*/
   /*public void bindingMessage(ActionEvent actionEvent) {
     String message = "JSF Action Listener Test - Using Method Binding.";
     //<h:commandButton id="methodBindingBtn" value="Submit" actionListener="#{PublishingListener.bindingMessage}" />
   }*/
//}