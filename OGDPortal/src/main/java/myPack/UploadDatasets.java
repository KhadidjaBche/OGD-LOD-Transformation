package myPack;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileInputStream;
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
import java.util.concurrent.ExecutionException;
import java.util.stream.*;

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
import org.camunda.bpm.application.ProcessApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
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


@WebServlet("/UploadDatasets")
@MultipartConfig
public class UploadDatasets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String content="";
	private String WholeSelectedText="";



	@SuppressWarnings({ "incomplete-switch", "resource", "rawtypes", "unchecked" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out=null;

		try {
			out = response.getWriter();
			String st = request.getParameter("dropdown");

			List<Part> fileParts = request.getParts().stream().filter(part -> "myfile".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">

			System.out.println("la taille de la liste de fichiers : "+fileParts.size());
			System.out.println("les elements de la liste de fichiers : ");


			for(Part filePart : fileParts) {
				String flName=Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				System.out.println("l'element : "+flName);
				if(flName.endsWith("pdf")) {
					try {
						InputStream fileContent = filePart.getInputStream();
						File file = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/google.txt");
						FileUtils.copyInputStreamToFile(fileContent, file);
						PDDocument doc = Loader.loadPDF(file);
						String text = new PDFTextStripper().getText(doc);
						WholeSelectedText = WholeSelectedText.concat("\n"+ text);
					} catch (IOException e) {

						e.printStackTrace();
					}

				}else {
					if(flName.endsWith("txt")) {
						try (InputStream fileContent = filePart.getInputStream();
								InputStreamReader isr = new InputStreamReader(fileContent,
										StandardCharsets.UTF_8);
								BufferedReader br = new BufferedReader(isr)) {

							br.lines().forEach(line -> WholeSelectedText = WholeSelectedText.concat("\n"+ line));

						}
					}else {
						if(flName.endsWith("xls")||flName.endsWith("xlsx")) {
							InputStream fileContent = filePart.getInputStream();
							File file = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/xls_xlsx_test.xls");
							FileUtils.copyInputStreamToFile(fileContent, file);
							FileInputStream inputStream = new FileInputStream(file);

							Workbook workbook = new XSSFWorkbook(inputStream);
							Sheet firstSheet = workbook.getSheetAt(0);
							Iterator<Row> iterator = firstSheet.iterator();

							while (iterator.hasNext()) {
								Row nextRow = iterator.next();
								Iterator<Cell> cellIterator = nextRow.cellIterator();

								while (cellIterator.hasNext()) {
									Cell cell = cellIterator.next();

									switch (cell.getCellType()) {

									case STRING:
										System.out.print(cell.getStringCellValue());
										break;
									case BOOLEAN:
										System.out.print(cell.getBooleanCellValue());
										break;
									case NUMERIC:
										System.out.print(cell.getNumericCellValue());
										break;
									}
								}
							}

							workbook.close();
							inputStream.close();
						}else {
							if(flName.endsWith("docx")) {
								InputStream fileContent = filePart.getInputStream();
								File file = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/google.txt");
								FileUtils.copyInputStreamToFile(fileContent, file);
								try {
									FileInputStream fis = new FileInputStream(file);
									XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
									XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
									WholeSelectedText = WholeSelectedText.concat("\n"+ extractor.getText());
								} catch(Exception ex) {
									ex.printStackTrace();
								}
							}else {
								if(flName.endsWith("html")) {
									try (InputStream fileContent = filePart.getInputStream();
											InputStreamReader isr = new InputStreamReader(fileContent,
													StandardCharsets.UTF_8);


											BufferedReader br = new BufferedReader(isr)) {
										br.lines().forEach(line -> content = content.concat("\n"+ line));

										Path fileName = Paths.get("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/google.txt");

										Files.write(fileName, content.getBytes(StandardCharsets.UTF_8));
										Document doc = Jsoup.parse(fileName.toFile(), "UTF-8", "http://siteweb.com/");

										String bd = doc.body().html();
										Document doc1 = Jsoup.parse(bd);
										String paragraph = doc1.text();
										WholeSelectedText = WholeSelectedText.concat("\n"+ paragraph);

									}
								}else {
									if(flName.endsWith("csv")) {

										try (InputStream fileContent = filePart.getInputStream();
												InputStreamReader isr = new InputStreamReader(fileContent,
														StandardCharsets.UTF_8);
												BufferedReader br = new BufferedReader(isr)) {

											ArrayList<String> myList = new ArrayList<String>();
											br.lines().forEach(line -> myList.add(line));

											ArrayList arList=null;
											ArrayList al=null;
											arList = new ArrayList();
											System.out.println("before while loop");
											System.out.println("myInput.readLine() :"+ br.readLine());
											for(int k = 0 ; k < myList.size(); k++)
											{

												al = new ArrayList();
												String strar[] = myList.get(k).split(",");
												for(int j=0;j<strar.length;j++)
												{
													System.out.println("inside boucle line by line:"+strar[j]);
													al.add(strar[j]);
												}
												arList.add(al);
												System.out.println();
											}

											try
											{
												HSSFWorkbook hwb = new HSSFWorkbook();
												HSSFSheet sheet = hwb.createSheet("new sheet");
												for(int k=0;k<arList.size();k++)
												{
													ArrayList ardata = (ArrayList)arList.get(k);
													HSSFRow row = sheet.createRow((short) 0+k);
													for(int p=0;p<ardata.size();p++)
													{
														HSSFCell cell = row.createCell((short) p);
														String data = ardata.get(p).toString();
														if(data.startsWith("=")){

															cell.setCellType(CellType.STRING);
															data=data.replaceAll("\"", "");
															data=data.replaceAll("=", "");
															cell.setCellValue(data);
														}else if(data.startsWith("\"")){
															data=data.replaceAll("\"", "");
															cell.setCellType(CellType.STRING);
															cell.setCellValue(data);
														}else{
															data=data.replaceAll("\"", "");
															cell.setCellType(CellType.NUMERIC);
															cell.setCellValue(data);
														}
													}
													System.out.println();
												}
												FileOutputStream fileOut = new FileOutputStream("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/CSVtest.xls");
												hwb.write(fileOut);
												fileOut.close();
												System.out.println("Your excel file has been generated");
											} catch ( Exception ex ) {
												ex.printStackTrace();
											} 
										}


									}else
										System.out.println("the input format is not accepted,"
												+ " try input file with these formats: txt, "
												+ "xls, docx, html, csv");
								}

							}
						}
					}
				}
			}
			
			
			if(WholeSelectedText.compareTo("")!=0){
				WholeSelectedText = WholeSelectedText.replaceAll("[^a-zA-Z0-9]", " "); 
				WholeSelectedText = WholeSelectedText.replace("\"", "");

				/****************WholeSelectedText to xls****************/
				Workbook workbook = new HSSFWorkbook();
				HSSFSheet sheet = (HSSFSheet) workbook.createSheet("nlp triples");

				Object[][] bookData = new Object[4000][10];

				Properties props = new Properties();
				//props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,depparse,natlog,openie");
				props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
				StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
				//edu.stanford.nlp.pipeline.Annotation result = pipeline.process("Joe ate some pizza.");

				// Annotate an example document.
				edu.stanford.nlp.pipeline.Annotation doc = pipeline.process(WholeSelectedText);

				/***************************************/

				TextRazor client = new TextRazor("fd1839209e34ef14aadd238360e224dd3adfac4f258c4b140e907f94");

				client.addExtractor("words");
				client.addExtractor("entities");
				client.addExtractor("topics");
				client.addExtractor("spelling");

				client.setClassifiers(Arrays.asList("textrazor_newscodes"));

				client.addExtractor("entity_companies");


				String rules = "entity_companies(CompanyEntity) :- entity_type(CompanyEntity, 'Company').";
				client.setRules(rules);

				AnalyzedText resp = client.analyze(WholeSelectedText);

				int j=0;
				ArrayList<String> l = new ArrayList<String>();
				for (Sentence sentence : resp.getResponse().getSentences()) {
					for (Word word : sentence.getWords()) {
						for (Entity entity : word.getEntities()) {
							if((entity.getEntityEnglishId().compareTo("") !=0) && (l.contains(entity.getEntityEnglishId().replace(" ", "_"))==false)) {
								bookData[j][3]=entity.getEntityEnglishId().replace(" ", "_");
								l.add(entity.getEntityEnglishId().replace(" ", "_"));
								j++;
							}

						}

					}
				}



				for (Custom custom : resp.getResponse().getCustomAnnotations()) {

					for (Custom.BoundVariable variable : custom.getContents()) {

						if (null != variable.getEntityValue()) {
							for (Entity entity : variable.getEntityValue()) {
								if((l.contains(entity.getEntityId())==false) && (entity.getEntityId().compareTo("")!=0)) {
									//System.out.println("Variable: " + variable.getKey() + " Value:" + entity.getEntityId());
									//System.out.println("Company entity: " +  entity.getEntityId());
									bookData[j][3]=entity.getEntityId().replace(" ", "_");
									l.add(entity.getEntityId().replace(" ", "_"));
									j++;
								}

							}


						}
					}
				}

				for(String s:l) {
					System.out.println(s);
				}

				/***************************************/


				int i=0;
				// Loop over sentences in the document
				for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
					// Get the OpenIE triples for the sentence
					Collection<RelationTriple> triples =
							sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
					// Print the triples




					for (RelationTriple triple : triples) {
						System.out.println(triple.confidence + "\t" +
								triple.subjectLemmaGloss() + "\t" +
								triple.relationLemmaGloss() + "\t" +
								triple.objectLemmaGloss());

						if(triple.confidence==1) {
							bookData[i][0]= triple.subjectLemmaGloss().replace(" ", "_");
							bookData[i][1]= triple.relationLemmaGloss().replace(" ", "_");
							bookData[i][2]= triple.objectLemmaGloss().replace(" ", "_");
							i++;
							System.out.println(i);
						}


					}


				}


				int rowCount = 0;

				for (Object[] aBook : bookData) {
					Row row = sheet.createRow(++rowCount);

					int columnCount = 0;

					for (Object field : aBook) {
						Cell cell = row.createCell(++columnCount);
						if (field instanceof String) {
							cell.setCellValue((String) field);
						} else if (field instanceof Integer) {
							cell.setCellValue((Integer) field);
						}
					}

				}

				try (FileOutputStream outputStream = new FileOutputStream("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/nlpTriples.xls")) {
					//try (FileOutputStream outputStream = new FileOutputStream("\\home\\khadidja\\eclipse-workspace\\testTomCatServer\\OGD_To_LOD\\nlpTriples.xls")) {
					workbook.write(outputStream);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/********************************/

			System.out.println("look here please domaine: "+st);
			if(st.compareTo("Cross Domain")==0) {
				CrossDomainXlsToRDF inst = new CrossDomainXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);
			}
			else { if(st.compareTo("Geography")==0) {

				GeographyXlsToRDF inst = new GeographyXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/GeographyXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output_test.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);
			}else { if(st.compareTo("Government")==0) {
				GovernmentXlsToRDF inst = new GovernmentXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);

			}else { if(st.compareTo("Life Sciences")==0) {
				LifeSciencesXlsToRDF inst = new LifeSciencesXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);

			}else { if(st.compareTo("Linguistics")==0) {
				LinguisticsXlsToRDF inst = new LinguisticsXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);

			}else { if(st.compareTo("Media")==0) {
				MediaXlsToRDF inst = new MediaXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);

			}else { if(st.compareTo("Publications")==0) {
				PublicationsXlsToRDF inst = new PublicationsXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);

			}else { if(st.compareTo("Social Networking")==0) {
				SocialNetworkingXlsToRDF inst = new SocialNetworkingXlsToRDF();

				String[] str = new String[2];
				//C:\Users\Khadidja\eclipse-workspace\myApp\OGD_To_LOD\src\main\java\myPack
				URI s = new File("C:/Users/Khadidja/eclipse-workspace/myApp/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				//URI s = new File("/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/CrossDomainXlsToRDF.trig").toURI();
				str[0]=s.toString();
				str[1]="C:/Users/Khadidja/Desktop/ESI/data_to_be_transformed/output_in_ttl_format/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.ttl";
				//str[1]="/home/khadidja/eclipse-workspace/testTomCatServer/OGD_To_LOD/src/main/java/myPack/output.rdf";

				inst.execute(str);

			}else
				System.out.println("The selected value does not exist in the drop-down list!");
			}
			}
			}
			}
			}
			}
			
			}

		}
		catch(Exception e){
			out.println("<html>\r\n"
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
					+ "			<button type=\"button\" class=\"btn btn-secondary\">Upload\r\n"
					+ "				datasets</button>\r\n"
					+ "			<button type=\"button\" class=\"btn btn-secondary\">Create LOD\r\n"
					+ "				service</button>\r\n"
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
					+ "		<br> <br> <br> <br> <br>");
			out.println("Error : "+e.getMessage());
		}
		finally {
			out.println("<html>\r\n"
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
					+ "			<button type=\"button\" class=\"btn btn-secondary\">Upload\r\n"
					+ "				datasets</button>\r\n"
					+ "			<button type=\"button\" class=\"btn btn-secondary\">Create LOD\r\n"
					+ "				service</button>\r\n"
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
					+ "		<br> <br> <br> <br> <br>");
			out.println("<br><br>");
			out.println("The datasets have been uploded and transformed to linked data successfully.");
			out.println("<br><br>");
			out.println("<form method=post action=ApplicationGui enctype=\"multipart/form-data\">"
					+ "<button type=\"button\" class=\"btn btn-secondary\" onclick=\"document.location='Validator.jsp'\""
					+ "	>Four principles validation</button></form>");
			out.println("</center>");
		}
	}

}