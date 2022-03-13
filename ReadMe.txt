/*********************************** GePEX Approach ********************************/

/****************************************************************************************************************************************/ 
/** The developer name : Bouchelouche Khadidja, under the supervision of : Pr. Ghomari Abdessamad Réda and Dr. Ghomari-Zemmouchi Leila **/
/****************************************************************************************************************************************/

To run this web Application you have to follow the folllowing steps:

1/ you have to create the database and the following tables using mysql:
 
a/
Table: administrator
Columns:
idadministrator bigint AI PK 
administratorname varchar(50) 
administratorpassword varch

b/
Table: datasets
Columns:
iddataset bigint AI PK 
datasettitle varchar(100) 
datasetdescription varchar(500) 
datasetlicence varchar(100) 
datasettimecreation datetime 
iddomain bigint 
idadministrator bigint

c/
Table: domain
Columns:
iddomain bigint AI PK 
namedomain varchar(50)

d/
Table: files
Columns:
idfile bigint AI PK 
filestore longblob 
filename varchar(100) 
filesize double 
fileformat varchar(45) 
updatefrequency varchar(45)
iddataset bigint

e/
Table: users
Columns:
iduser bigint AI PK 
username varchar(50) 
userpassword varchar(50)

f/
Table: services
Columns:
idservice bigint AI PK 
servicetitle varchar(100) 
servicedescription varchar(500) 
servicetimecreation datetime 
feedback varchar(800)
rate int
iddomain bigint 
iddataset bigint

then, make the necessary update in the java and jsp files to can connect the the database.

2/Download and run the Apache jena Fuseki server in localhost://3030

3/Download the needed packages to run the four principles validator from the readMe file 
of the Validator application in the following link: https://sourceforge.net/projects/evaluate-ontology-ldprinciples/

3/Download TomCat server, and run it in eclipse.

4/Run the Web application on TomcatServer. 