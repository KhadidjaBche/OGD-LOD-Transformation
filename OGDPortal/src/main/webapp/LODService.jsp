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
<%@page import="java.awt.event.ActionListener"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@page import="java.awt.event.ItemListener"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileNotFoundException"%>
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
<%@page import="javax.swing.UIManager"%>


<%@page import="org.apache.jena.ontology.OntModel"%>
<%@page import="org.apache.jena.rdf.model.ModelFactory"%>
<%@page import="org.apache.jena.rdf.model.Model"%>
<%@page import="org.apache.jena.util.FileManager"%>
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

	<a href="NewPublish.jsp" class="icon-block"
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

		
		<table>
				<tr>
				        <td>
				          <form method=post action=User_Interface enctype="multipart/form-data">
				             <label><FONT size="4pt"><b>Describe your Dataset &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></FONT></label>
				               <br> <br> 
				               <label><FONT size="2pt"><b>Insert the title: </b></FONT></label> <input style="height:40px; width:250px;" type="text" name="title" />
				                 <br> <br> <br> <br>
				               <label><FONT size="2pt"><b>Describe the service: </b></FONT></label> <br><br> <input style="height:140px; width:300px;" type="text" name="description" /> <br> <br> <br> <br><br> <br>
				          </form>
				        </td>
				          
				        <td>
			
				          
				             <label><FONT size="4pt"><b>Select the needed Dataset &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></FONT></label>
							       <br>  <br> <br>
							   
							   
							   
							   <select name="dog-names" id="dog-names">
							      <option>Select file</option>
							      <%
							      /*************************************************************************/
							        /*                                                                       */
							        /*                       Connect to the database                         */
							        /*          Select all the linked data files from the database           */
							        /*************************************************************************/
        
                                  /**** fill the following options with the existing files  *********/
		                           %>
							      <option value="<% /*insert the name of the file*/%>"><% /*insert the file*/%></option>
                                 
							   </select>
							       
							   <!--    
				             <input style="height:30px; width:230px;" type="file" id="myfile" name="myfile" multiple class="btn btn-secondary"
				               onclick="document.location='QueryComposer.jsp'">
				               
				                --> 
				               
				               <br><br><br><br>
				               
				               
				             <label><FONT size="4pt"><b>Query the dataset with SPARQL</b></FONT></label> <br> <br> <button class="btn btn-secondary"
				               onclick="document.location='QueryComposer.jsp'">Query composer</button>
				               
				               <br><br><br><br>
				               
				               <label><FONT size="4pt"><b>Load the file of the query result </b></FONT></label> 
				                 <br><br> 
				                 <input style="height:30px; width:230px;" type="file" id="myfile" name="myfile" multiple>
				                 <br><br><br><br><br> <br><br> <br>
				         
				        </td>
				        
				       
				                         
				        <td>
				          <form method=post action=User_Interface enctype="multipart/form-data">
				              <label><FONT size="4pt"><b>Dataset Visualization </b></FONT></label>
							  <br> <br>  
				              <label for="dropdown"><FONT size="2pt"><b>Select the type of visualization: </b></FONT></label>
							  <br> <br> <br>
							  <input type=text list=browsers name=dropdown>
								 <datalist id=browsers>
								    <option> Bar chart
							        <option> Pie chart 
				                 </datalist> 
				                 <br> <br>
				                 <button type="button" class="btn btn-secondary" onclick="document.location='Visualization.jsp'">Apply</button><br><br><br><br>
				                 <label><FONT size="4pt"><b>Add Images </b></FONT></label> 
				                 <br><br> 
				                 <input style="height:30px; width:230px;" type="file" id="myimage" name="myimage" multiple>
				                 <br><br><br><br><br> <br><br> <br>
				
				           </form>
				         </td>
				           
				  </tr>
	   </table>
		

	</center>
</body>
</html>
