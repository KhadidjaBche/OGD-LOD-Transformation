<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!--  <link type="text/css" rel="stylesheet" href="style.css"/> -->

<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
<style>
   
     /* body {
      background-image: url('C:/Users/Khadidja/Desktop/ESI/Article1/background.jpg');
      }*/
      
      
      
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
        display:inline-block;
        width:10em;
        float:left;
        text-align:center;
    }

    .icon-block i,
    .icon-block span {
        display:block;
        width:100%;
        clear:both;
    }
    
    body, html {
    background-image: url('C:/Users/Khadidja/Desktop/ESI/Article1/cover.jpg');
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
  float: center;
  border-collapse: collapse;
}

.toppaneleft {
  width: 100%;
  height: 40%;
  float: center;
  border-collapse: collapse;
}

.toppaneright {
  width: 45%;
  height: 70%;
  float: center;
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
  background-color: rgba(0,0,0,.05);
}
.btn-link:active, .btn-link.active {
  background-color: rgba(0,0,0,.05);
}
.btn-link:focus, .btn-link.focus {
  background-color: rgba(0,0,0,.05);
}
.btn-link:active:focus, .btn-link.active:focus {
  background-color: rgba(0,0,0,.05);
}

.card{
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
       <label><FONT size="5pt"><b><h1 style="background-color:powderblue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SPARQL query composer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </h1></b></FONT></label>
       <center>
       <br> <br>
       <div class="container">
       
       
        
  <div class="toppaneleft">
  
  <form method=post action=QueryComposer enctype="multipart/form-data">
  <table>
				<tr>
				        <td>
				         
				         
				          <div class="form-group">
    <label for="exampleFormControlSelect2"><h4>Select the needed prefixes</h4></label>
    <br><br>
    <select multiple class="form-control" id="prefix">
      <option>dbo: &lt;http://dbpedia.org/ontology/&gt;</option>
      <option>owl: &lt;https://www.w3.org/2002/07/owl#&gt;</option>
      <option>sdx: &lt;https://www.epimorphics.com/vocab/sdx#&gt;</option>
      <option>scv: &lt;https://purl.org/NET/scovo#&gt;</option>
      <option>rdfs: &lt;https://www.w3.org/2000/01/rdf-schema#&gt;</option>
      <option>ckan: &lt;https://ckan.net/ns#&gt;</option>
      <option>foaf: &lt;https://xmlns.com/foaf/0.1/&gt;</option>
      <option>dc: &lt;https://purl.org/dc/elements/1.1/&gt;</option>
      <option>xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt;</option>
      <option>rdf: &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt;</option>
      <option>ex: &lt;http://data.example.org/&gt;</option>
     



    </select>
  </div>
    
  
    
    <div class="mb-3">
    <br><br>
      <label for="subject" class="form-label">Select the first property</label>
      <select id="subject" class="form-select">
        <option>ex:value</option>
        <option>ex:year</option>
        <option>ex:code</option>
      </select>
    </div>
    
    <div class="mb-3">
      <label for="predicate" class="form-label">Select the second property</label>
      <select id="predicate" class="form-select">
        <option>ex:value</option>
        <option>ex:year</option>
        <option>ex:code</option>
      </select>
    </div>
    
    <div class="mb-3">
      <label for="object" class="form-label">Select the third property</label>
      <select id="object" class="form-select">
        <option>ex:value</option>
        <option>ex:year</option>
        <option>ex:code</option>
      </select>
    </div>
    
    <div class="mb-3">
    <br><br>
    <label for="disabledSelect" class="form-label"><h4>Name the columns of the resulted triples</h4></label>
      <br><br>
    
      <label for="subjectName" class="form-label">Name the Subject column</label>
      <input type="text" id="subjectName" class="form-control" placeholder="None">
      
    </div>
    
    <div class="mb-3">
      <label for="predicateName" class="form-label">Name the Property column</label>
      <input type="text" id="predicateName" class="form-control" placeholder="None">
     
    </div>
    
    <div class="mb-3">
      <label for="objectName" class="form-label">Name the Object column</label>
     <input type="text" id="objectName" class="form-control" placeholder="None">
    </div>
    
    <div class="mb-3">
    <br><br>
      <label for="disabledSelect" class="form-label"><h4>Select the option to apply functions on your properties</h4></label>
      <br><br>
      </select>
      <label for="disabledSelect" class="form-label">Select the function </label>
      <select id="disabledSelect" class="form-select">
        <option>None</option>
      </select>
      <br>
       <label for="disabledSelect" class="form-label">Select the corresponding property</label>
      <select id="disabledSelect" class="form-select">
        <option>None</option>
      </select>
      <br><br>
      <label for="disabledSelect" class="form-label">Select the condition to apply on the property of function</label>
      <br><br>
      <label for="disabledSelect" class="form-label">Select the operation</label>
      <br>
      <select id="disabledSelect" class="form-select">
        <option>None</option>
      </select>
      <br>
       <label for="disabledSelect" class="form-label">Select the corresponding value or property</label>
      <select id="disabledSelect" class="form-select">
        <option>None</option>
      </select>
      
    </div>
				         
				        </td>
				           <td>
				        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        </td>
				        <td>
				          
				          
				           <div class="mb-3">
   
      <label for="disabledSelect" class="form-label"><h4>Select the condition option to apply on your properties</h4></label>
      <br><br>
      </select>
      <label for="disabledSelect" class="form-label">Select the operation for the condition </label>
      <select id="disabledSelect" class="form-select">
        <option>None</option>
      </select>
       <label for="disabledSelect" class="form-label">Select the properties for the condition</label>
      <select id="disabledSelect" class="form-select">
        <option>None</option>
      </select>
    </div>
    
    <div class="mb-3">
    <br><br>
    <label for="disabledSelect" class="form-label"><h4>Select the filtering option to apply on your data</h4></label>
      <br><br>
      
      <label for="filterProperty" class="form-label">Select the property to be filtered</label>
      <select id="filterProperty" class="form-select">
        <option>ex:value</option>
        <option>ex:year</option>
        <option>ex:code</option>
      </select>
      <br>
      <label for="typeFiltering" class="form-label">Select the property type for filtering your data</label>
      <select id="typeFiltering" class="form-select">
        <option>xsd:integer</option>
      </select>
      <br>
      <label for="valueFiltering" class="form-label">Insert the corresponding value for filtering your data</label>
      <input type="text" id="valueFiltering" class="form-control" placeholder="None">
      <br>
       <label for="operationFiltering" class="form-label">Select the operation for filtering your data</label>
      <select id="operationFiltering" class="form-select">
       <option>=</option>
       <option>&gt;</option>
        <option>&gt;=</option>
        <option>&lt;</option>
        <option>&lt;=</option>
      </select>
    </div>
    
     <div class="mb-3">
    
    <label for="disabledSelect" class="form-label"><h4>Select the option for aggregating your result</h4></label>
      <br><br>
      
      <label for="disabledSelect" class="form-label">Select the corresponding properties</label>
      <select id="disabledSelect" class="form-select">
        <option>None</option>
      </select>

    </div>
    
    <div class="mb-3">
    <label for="disabledSelect" class="form-label"><h5>Limit the result</h5></label>
      <br><br>
      <label for="disabledTextInput" class="form-label">Enter the maximum number of triples in the result</label>
      <input type="text" id="disabledTextInput" class="form-control" placeholder="None">
    </div>
    
    <div class="mb-3">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="disabledFieldsetCheck" abled>
        <label class="form-check-label" for="disabledFieldsetCheck">
          order the result
        </label>
      </div>
    </div>
    
 
    
  
</form>
				         
				        </td>
				                         
				      
				           
				  </tr>
	   </table>
  
  <form>
 
    
  
    
   



       
       <br> <br> <br>
       

      
      </div>
      
      
       <div class="toppaneright">
        <button type="button" class="btn btn-primary" >Generate the query</button>
        
        </form>
    
  </fieldset>
</form>
  </div>
  
      
  
  <div class="middlepane">
   <br><br><br>
   
  
 
 
 
 
           
           
           

  
  </div>
  
   
  <div class="downpane">
  <br><br><br>
     
    <br> <br> <br>
    
    
   
  
    
    
    </div>
    </div>
     </center>
</body>
</html>
