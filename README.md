To run the project in Eclipse:
	-Right click on the JewelApplication.java file.
	-Run as java application
	-The application will run on tomcat server on port 9090 (Configured in applicaton.properties)
	-Decomplier : https://stackoverflow.com/questions/48396661/eclipse-enhanced-class-decompiler-plugin-does-not-decompile-when-debugging
	-Package heiraichal structure : https://bugs.eclipse.org/bugs/show_bug.cgi?id=500823
	
To run in intellij:
	-After build.
	-Copy the war file to tomcat server intalled locally
	-Prefer tomcat to run on 9090 port by changing the port in server.xml in tomcat conf directory
	-Copy the app in webapps and rename the app to ROOT.war for test runs
	
To run solr for application:
	-Extract solr.zip
	-Run cmd in extracted solr directory
	-Run bin\solr create -c Product
	-Run bin\solr start -p 8983 (It is also set in application.properties telling the application to connect on this port for solr)
	
Imports:
	-Works using spring batch
	-application.properties has values for source file and archive directory.
	-BatchConfig.java is the entry point

Spring books:
	-https://github.com/arifhasnatnstucsteonGit/ProgrammingBooks
DB Initialization:
	-The queries written in data.sql run only when the tables are created.
	-Delete the existing tables in DB manually and then restart aapplication to make them run via startup.
	
Spring Security Config:
	-http://websystique.com/spring-security/spring-security-4-password-encoder-bcrypt-example-with-hibernate/
	
JSP Handling:
	-https://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier#comment-1127458

Site Template:
	-https://w3layouts.com/womens-fashion-e-commerce-category-flat-bootstrap-responsive-web-template/
	
Form Validation
	-http://websystique.com/springmvc/spring-4-mvc-form-validation-with-hibernate-jsr-validator-resource-handling-using-annotations/

Spring SOLR
	-https://dzone.com/articles/crud-application-using-spring-data-solr-and-spring
	-https://www.baeldung.com/spring-data-solr
	-Facets : https://www.mscharhag.com/spring/spring-data-solr-getting-started
	
Spring Batch
	-https://www.youtube.com/watch?v=1XEX-u12i0A&t=2138s