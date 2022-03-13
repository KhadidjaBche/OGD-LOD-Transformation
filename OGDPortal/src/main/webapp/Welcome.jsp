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
	float: center;
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

	</center>
	<label><FONT size="5pt"><b><h1
					style="background-color: powderblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Open Government
					Data&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</h1></b></FONT></label>
	<center>
		<br> <br>
		<div class="container">


              <table>
				<tr>
				        <td>
				        
				        <div class="list-group">

					<a href="Society.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Society</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes population, births, deaths and jobs</p>
					</a> <a href="Geography.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Geography</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes terrain and cartography</p>
					</a> <a href="Government.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Government</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes administration, authority, governance
							and regime</p>
					</a> <a href="Health.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Health</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes fitness, diseases and vaccination</p>
					</a>
				</div>
				        
				          
				        </td>
				          
				        <td>
				        
				        <div class="list-group">
					<a href="Education.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Education</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes schooling, culture and functional
							illiteracy</p>
					</a> <a href="Environment.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Environment</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes climate and pollution</p>
					</a> <a href="Crime.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Crime and justice</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes legal processes, courts and the
							police</p>
					</a> <a href="Social.jsp"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Social Networking</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes shares and publications</p>
					</a>
				</div>
				        
				        </td>
				</tr>
				
			 </table>
			 
			 	<br> <br> <br>
	</center>
	<label><FONT size="5pt"><b><h1
					style="background-color: powderblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Published Linked Open
					Data&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</h1></b></FONT></label>
	<center>
		<br> <br>



		<%
		/*************************************************************************/
        /*                                                                       */
        /*                       Connect to the database                         */
        /*   Select all the datasets of all topics from the database          */
        /*************************************************************************/
        
        /**** add loop ( for each dataset), fill the following card   *********/
		%>
		
		<div class="card" style="width: 60rem;">
			<div class="card-body">
				<h5 class="card-title"><% /*insert the title of the dataset*/%>&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted"><% /*insert the topic*/%> topic</h6>
				<p class="card-text"><% /*insert the description of the dataset*/%></p>
				<p class="card-text">
					<small class="text-muted">&#9746;&nbsp;&nbsp;<% /*insert the update state*/%></small>
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;Openness of the
						licence: &#128275; <% /*insert the licence*/%></small>
				</p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation <% /*insert the date of creation*/%></small>
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;File formats: <% /*insert the file*/%></small>
				</p>
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#9776;&nbsp;&nbsp;
						Access the datasets</button>
				</div>
			</div>

		</div>
		
		
</center>

	<label><FONT size="5pt"><b><h1
					style="background-color: powderblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Linked Open Data
					services&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</h1></b></FONT></label>
	<center>
		<br> <br> <br>
		
		
		
		<%
		/*************************************************************************/
        /*                                                                       */
        /*                       Connect to the database                         */
        /*              Select all the services from the database                */
        /*************************************************************************/
        
        /**** add loop ( for each service), fill the following card   *********/
		%>
		
		
		       <div class="card" style="width: 60rem;">
			<div class="card-body">

				<h5 class="card-title"><% /*insert the title of the service*/%>&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted"></h6>
				<p class="card-text"><% /*insert the description of the service*/%> </p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation <% /*insert the date of creation*/%></small>
						
						
				</p>
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#128172;&nbsp;&nbsp;See
						all feedbacks</button>
				</div>
				<div class="rate bg-success py-3 text-white mt-3">
					<div class="rating">
						<input type="radio" name="rating1" value="5" id="5"><label
							for="5">&#128544;</label> 
							<input type="radio" name="rating1"
							value="4" id="4"><label for="4">&#128545;</label> 
							<input
							type="radio" name="rating1" value="3" id="3"  checked="checked"><label
							for="3">&#128528;</label> 
							<input type="radio" name="rating1"
							value="2" id="2"><label for="2">&#128578;</label> <input
							type="radio" name="rating1" value="1" id="1"><label
							for="1">&#128522;</label>
					</div>

				</div>



				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#9776;&nbsp;&nbsp;
						Launch the service</button>
				</div>

			</div>
		</div>

		

			
		
	</center>
</body>
</html>
