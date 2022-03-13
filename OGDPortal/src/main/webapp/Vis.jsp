<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
          
<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>




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
<%@page import="myPack.BarChartDemo" %>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>

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
	float: right;
	border-collapse: collapse;
}

.bottompane {
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
	float: center;
}

body{
    margin-top:20px;
    background-color:#e9ebee;
}

.be-comment-block {
    margin-bottom: 50px !important;
    border: 1px solid #edeff2;
    border-radius: 2px;
    padding: 50px 70px;
    border:1px solid #ffffff;
}

.comments-title {
    font-size: 16px;
    color: #262626;
    margin-bottom: 15px;
    font-family: 'Conv_helveticaneuecyr-bold';
}

.be-img-comment {
    width: 60px;
    height: 60px;
    float: left;
    margin-bottom: 15px;
}

.be-ava-comment {
    width: 60px;
    height: 60px;
    border-radius: 50%;
}

.be-comment-content {
    margin-left: 80px;
}

.be-comment-content span {
    display: inline-block;
    width: 49%;
    margin-bottom: 15px;
}

.be-comment-name {
    font-size: 13px;
    font-family: 'Conv_helveticaneuecyr-bold';
    
}

.be-comment-content a {
    color: #383b43;
}

.be-comment-content span {
    display: inline-block;
    width: 49%;
    margin-bottom: 15px;
}

.be-comment-time {
    text-align: right;
}

.be-comment-time {
    font-size: 11px;
    color: #b4b7c1;
}

.be-comment-text {
    font-size: 13px;
    line-height: 18px;
    color: #7a8192;
    display: block;
    background: #f6f6f7;
    border: 1px solid #edeff2;
    padding: 15px 20px 20px 20px;
}

.form-group.fl_icon .icon {
    position: absolute;
    top: 1px;
    left: 16px;
    width: 48px;
    height: 48px;
    background: #f6f6f7;
    color: #b5b8c2;
    text-align: center;
    line-height: 50px;
    -webkit-border-top-left-radius: 2px;
    -webkit-border-bottom-left-radius: 2px;
    -moz-border-radius-topleft: 2px;
    -moz-border-radius-bottomleft: 2px;
    border-top-left-radius: 2px;
    border-bottom-left-radius: 2px;
}

.form-group .form-input {
    font-size: 13px;
    line-height: 50px;
    font-weight: 400;
    color: #b4b7c1;
    width: 100%;
    height: 50px;
    padding-left: 20px;
    padding-right: 20px;
    border: 1px solid #edeff2;
    border-radius: 3px;
}

.form-group.fl_icon .form-input {
    padding-left: 70px;
}

.form-group textarea.form-input {
    height: 150px;
}

</style>
</head>
<body>


	<img src="C:/Users/Khadidja/Desktop/ESI/Article1/algerian_flag.jpg"
		width="100" height="50" />

	<a href="Newservice.jsp" class="icon-block"
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

	</center>

		
<center>



<%
		
		

		
				// TODO Auto-generated method stub
				JFrame f=new JFrame("");  
			    JButton b=new JButton("Start");  
			    b.setBounds(50,100,95,30); 
			    b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						BarChartDemo eval=new BarChartDemo();
						eval.initFrame();
						eval.setVisible(true);
						
					}
				});
			    f.add(b);  
			    f.setSize(400,200);  
			    f.setLayout(null);  
			    f.setVisible(true);  %>

	</center>
</body>
</html>
