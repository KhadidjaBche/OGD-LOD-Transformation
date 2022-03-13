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

					<a href="#"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Society</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes population, births, deaths and jobs</p>
					</a> <a href="#"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Geography</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes terrain and cartography</p>
					</a> <a href="#"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Government</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes administration, authority, governance
							and regime</p>
					</a> <a href="#"
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
					<a href="#"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Education</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes schooling, culture and functional
							illiteracy</p>
					</a> <a href="#"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Environment</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes climate and pollution</p>
					</a> <a href="#"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 style="color: blue;" class="mb-1">
								<u>Crime and justice</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#10095;
							</h5>
						</div>
						<p class="mb-1">Includes legal processes, courts and the
							police</p>
					</a> <a href="#"
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


       <div class="card" style="width: 60rem;">
			<div class="card-body">
				<h5 class="card-title">World Development
					Indicators&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted">Society topic</h6>
				<p class="card-text">This dataset is composed of an algerian
					indicators statistics per years such as population according to
					ages, food imports, newborns protected against tetanus, children in
					employment ...etc.</p>
				<p class="card-text">
					<small class="text-muted">&#9746;&nbsp;&nbsp;Not updated</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;Openness of the
						licence: &#128275; Free use</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation <jsp:useBean id="now" scope="page" class="java.util.Date"/>
        ${now}</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;File formats: Turtle</small>
				</p>
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit" onclick="document.location='PublishedLOD.jsp'">&#9776;&nbsp;&nbsp;
						Access the datasets</button>
				</div>
			</div>
		</div>


		<div class="card" style="width: 60rem;">
			<div class="card-body">
				<h5 class="card-title">Unemployment rate in Algeria from 2012
					to 2026&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted">Government topic</h6>
				<p class="card-text">This statistic presents the evolution of
					the unemployment rate in Algeria from 2012 to 2020, with forecasts
					until 2026. Between 2010 and 2020, the unemployment rate in Algeria
					reached two peaks at around 14% in 2018 and 2020. According to
					According to the estimates of the International Monetary Fund, the
					unemployment rate in Algeria is expected to increase more sharply
					to reach around 19% by 2026.</p>
				<p class="card-text">
					<small class="text-muted">&#9746;&nbsp;&nbsp;Not updated</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;Openness of the
						licence: &#128275; Free use</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation Thur Dec 23 16:55:59 GMT+01:00 2021</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;File formats: Turtle</small>
				</p>
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#9776;&nbsp;&nbsp;
						Access the datasets</button>
				</div>
			</div>

		</div>



		<div class="card" style="width: 60rem;">
			<div class="card-body">
				<h5 class="card-title">Algeria mourns its
					Kabyle&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted">Society topic</h6>
				<p class="card-text">It is from these moments of great distress
					and exceptional solidarity that the true Algeria springs,
					unwavering, united. A new myth was born in Kabylia. It has just
					been sealed with unity and brotherhood.</p>
				<p class="card-text">
					<small class="text-muted">&#9746;&nbsp;&nbsp;Not updated</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;Openness of the
						licence: &#128275; Free use</small>
				</p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation Fri Oct 15 19:12:59 GMT+01:00 2021</small>
						
				</p>
				<p class="card-text">
					<small class="text-muted">&nbsp;&nbsp;File formats: Turtle,
						RDF</small>
				</p>
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#9776;&nbsp;&nbsp;
						Access the datasets</button>
				</div>
			</div>
		</div>


		<div class="card" style="width: 60rem;">
			<div class="card-body">
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">View
						more</button>
				</div>
			</div>
		</div>

		</div>
		
		
		<br> <br> <br>
	</center>


	<label><FONT size="5pt"><b><h1
					style="background-color: powderblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Linked Open Data
					services&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</h1></b></FONT></label>
	<center>
		<br> <br> <br>
		
		
		
		       <div class="card" style="width: 60rem;">
			<div class="card-body">

				<h5 class="card-title">Open Data Revolution to Fight Global
					Hunger&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted"></h6>
				<p class="card-text">Every day, people around the world use data
					to make decisions. When heading out of town, most of us use weather
					apps to check the forecast anywhere in the world before packing our
					bags. However, when we travel to far-flung places, we may find
					ourselves packing food from home because we don’t know what may be
					available when we arrive … Continued </p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation Mon Nov 15 19:40:05 GMT+01:00 2021</small>
						
						
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

		<div class="card" style="width: 60rem;">
			<div class="card-body">

				<h5 class="card-title">Serving the Needs of Data Practitioners
					with a New resources.data.gov&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted">By Crystal Carter</h6>
				<p class="card-text">We are excited to announce the relaunch of
					a new resources.data.gov , an online repository of policies, tools,
					case studies, and other resources to support data governance,
					management, exchange, and use throughout the federal government.
					The site is a joint effort … Continued</p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation Sat Oct 02 10:30:18 GMT+01:00 2021</small>
						
						
				</p>
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#128172;&nbsp;&nbsp;See
						all feedbacks</button>
				</div>
				<div class="rate bg-success py-3 text-white mt-3">
					<div class="rating">
						<input type="radio" name="rating2" value="5" id="5"><label
							for="5">&#128544;</label> <input type="radio" name="rating2"
							value="4" id="4"><label for="4">&#128545;</label> <input
							type="radio" name="rating2" value="3" id="3"><label
							for="3">&#128528;</label> <input type="radio" name="rating2"
							value="2" id="2"  checked="checked"><label for="2">&#128578;</label> <input
							type="radio" name="rating2" value="1" id="1"><label
							for="1">&#128522;</label>
					</div>

				</div>



				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#9776;&nbsp;&nbsp;
						Launch the service</button>
				</div>

			</div>
		</div>

		<div class="card" style="width: 60rem;">
			<div class="card-body">

				<h5 class="card-title">Algeria covid daily
					cases&nbsp;&nbsp;&nbsp;&nbsp;&#127757;</h5>
				<h6 class="card-subtitle mb-2 text-muted">Daily number of
					coronavirus (COVID-19) cases in Algeria as of September 12, 2021</h6>
				<p class="card-text">Daily number of coronavirus (COVID-19)
					cases in Algeria as of September 12, 2021 __Algeria
					Coronavirus__ update with statistics and graphs: total and new
					cases, deaths per day, mortality and recovery rates, current active
					cases, recoveries, … Continued</p>
				<p class="card-text">
					<small class="text-muted">&#128198;&nbsp;&nbsp;Date
						creation Sun Sep 12 20:17:33 GMT+01:00 2021</small>
						
						
				</p>
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#128172;&nbsp;&nbsp;See
						all feedbacks</button>
				</div>
				<div class="rate bg-success py-3 text-white mt-3">
					<div class="rating">
						<input type="radio" name="rating3" value="5" id="5"><label
							for="5">&#128544;</label> <input type="radio" name="rating3"
							value="4" id="4"><label for="4">&#128545;</label> <input
							type="radio" name="rating3" value="3" id="3"><label
							for="3">&#128528;</label> <input type="radio" name="rating3"
							value="2" id="2"><label for="2">&#128578;</label> <input
							type="radio" name="rating3" value="1" id="1"  checked="checked"><label
							for="1">&#128522;</label>
					</div>

				</div>



				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">&#9776;&nbsp;&nbsp;
						Launch the service</button>
				</div>

			</div>
		</div>
		
		     <div class="card" style="width: 60rem;">
			<div class="card-body">
				<div class="buttons px-4 mt-0">
					<button class="btn btn-warning btn-block rating-submit">View
						more</button>
				</div>
			</div>
		</div>

			<div class="toppaneleft">


             

				

				<br> <br> <br>

			</div>


			<div class="toppaneright">



				

           </div>
		    <div class="middlepane">
				



            </div>

		<div class="downpane">
			



		

	
		

		<br> <br> <br> <br>

		</div>
		</div>
	</center>
</body>
</html>
