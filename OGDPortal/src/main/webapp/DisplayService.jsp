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


<div class="toppaneleft">

<%
		/*************************************************************************/
        /*                                                                       */
        /*                       Connect to the database                         */
        /*             Select the service to display from the database           */
        /*************************************************************************/
        
        /****                     fill the following card                *********/
		%> 


<div class="card" style="width: 60rem;">
			<div class="card-body">

				<h5 class="card-title"><% /*insert the title of the service*/%>&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted"></h6>
				<p class="card-text"><% /*insert the description of the service*/%></p>
				


			</div>
		</div>


<div class="card" style="width: 84rem;">
			<div class="card-body">

				
				
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
<div class="be-comment-block">

      <% 
	    /*************************************************************************/
        /*                                                                       */
        /*                             Select the number of                      */
        /*       the existing feedbacks for this service in the database         */
        /*************************************************************************/%>
        
        
	<h1 class="comments-title">Feedbacks (<% /*insert the number of existing feedbacks*/%>)</h1>
	<% 
	    /*************************************************************************/
        /*             Select the existing feedbacks from the database           */                                                  */
        /*      add loop ( for each feedback), fill the following card           */
        /*************************************************************************/
        %>
	
	<div class="be-comment">
		<div class="be-img-comment">	
			<a href="blog-detail-2.html">
				<img src="https://bootdey.com/img/Content/avatar/<% /*insert the avatar*/%> alt="" class="be-ava-comment">
			</a>
		</div>
		<div class="be-comment-content">
			<span class="be-comment-name">
				<a href="blog-detail-2.html"><% /*insert the name of the person who send the feedback*/%></a>
			</span>
			<span class="be-comment-time">
				<i class="fa fa-clock-o"></i>
				<jsp:useBean id="now" scope="page" class="java.util.Date" />
        <% /*insert the date of adding the of feedback*/%>
			</span>
			<p class="be-comment-text">
				<% /*insert the content of the feedback*/%>
			</p>
		</div>
	</div>
	
	<form class="form-block">
		<div class="row">
			<div class="col-xs-12 col-sm-6">
				<div class="form-group fl_icon">
					<div class="icon"><i class="fa fa-user"></i></div>
					<input class="form-input" type="text" placeholder="Your name">
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 fl_icon">
				<div class="form-group fl_icon">
					<div class="icon"><i class="fa fa-envelope-o"></i></div>
					<input class="form-input" type="text" placeholder="Your email">
				</div>
			</div>
			<div class="col-xs-12">									
				<div class="form-group">
					<textarea class="form-input" required="" placeholder="Your text"></textarea>
				</div>
			</div>
			
			<div class="buttons px-4 mt-0">
			<button class="btn btn-primary pull-right" onclick="document.location='SendFeedBack.jsp'">Submit</button>
		    </div>
		</div>
	</form>
</div>
</div>



				
				
				



			

			</div>
		</div>


</div>



<div class="toppaneright">

<%
		/*************************************************************************/
        /*                                                                       */
        /*                       Connect to the database                         */
        /*             Select the service to display from the database           */
        /*************************************************************************/
        
        /****                     fill the following card                *********/
		%> 

<div class="card" style="width: 20rem;">
			<div class="card-body">

				
				
				<p class="card-text">
					&nbsp;&nbsp;Openness of the
						licence: &#128275; <% /*insert the licence*/%>
				</p>
				<p class="card-text">
					&#128198;&nbsp;&nbsp;Date
						creation: <% /*insert the date of creation*/%>
				</p>

				<p class="card-text">
					&nbsp;&nbsp;Access the dataset: <a href="<% /*insert the dataset of the service*/%>" download="<% /*insert the name of the dataset*/%>"><% /*insert the format of the dataset*/%></a>
				</p>
				
				<p class="card-text">
					&nbsp;&nbsp;<a href="Vis.jsp" >Access the visualization</a>
				</p>
				
				<p class="card-text">
					&nbsp;&nbsp;<a href="<% /*insert the images of the service*/%>" >Display images</a>
				</p>
				
				
				
				<div class="rate bg-success py-3 text-white mt-3">
				<p class="card-text">
					&nbsp;&nbsp;Rate the service: 
				</p>
					<div class="rating">
						<input type="radio" name="rating1" value="5" id="5"><label
							for="5">&#128544;</label> 
							<input type="radio" name="rating1"
							value="4" id="4"><label for="4">&#128545;</label> 
							<input
							type="radio" name="rating1" value="3" id="3" ><label
							for="3">&#128528;</label> 
							<input type="radio" name="rating1"
							value="2" id="2"><label for="2">&#128578;</label> <input
							type="radio" name="rating1" value="1" id="1"><label
							for="1">&#128522;</label>
					</div>

				</div>



			</div>
		</div>



</div>

	</center>
</body>
</html>
