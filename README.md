Category and Collections Concept:
	-We need user specific access to our products
	-For this we have created a Collection Model that will have name of the collection and code. It is like a category of products.
	-For every user we will attach a Collection Group which will contain a list of collections.
	-The logged in user will only be able to see the items from the collection group assigned to the user + default collection items that are made public.
	-We will handle this on the product listing page and product details page.
	-We need to make assignment of the collection to a user time based for which we will create a collection assignment model which will have an expiration time, collection group or list of collections and a user.

Data Import Using Spring Integration and Spring Batch
	-Java based configuration used for spring batch
	-XML based configuration used for spring integration
	-Spring integration triggers spring batch jobs and moves files to processed directory
	
To run the project in Eclipse:
	-Right click on the JewelApplication.java file.
	-Run as java application
	-The application will run on tomcat server on port 9090 (Configured in applicaton.properties)
	-Decomplier : https://stackoverflow.com/questions/48396661/eclipse-enhanced-class-decompiler-plugin-does-not-decompile-when-debugging
	-Package heiraichal structure : https://bugs.eclipse.org/bugs/show_bug.cgi?id=500823
	-Install lombok : https://stackoverflow.com/questions/35842751/lombok-not-working-with-sts
	-Install ObjectAis for UMLs : https://www.objectaid.com/install-objectaid
	
To run in intellij:
	-After build.
	-Copy the war file to tomcat server intalled locally
	-Prefer tomcat to run on 9090 port by changing the port in server.xml in tomcat conf directory
	-Copy the app in webapps and rename the app to ROOT.war for test runs
	
To debug
	-jvm args needs to be added to run configuration: -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000
	-Run application as spring boot or java application
	-Remote debug on port 8080
	-https://rieckpil.de/howto-remote-debug-spring-boot-applications-intellij-idea-eclipse/	
	
To run solr for application:
	-Extract solr.zip
	-Run cmd in extracted solr directory
	-Run bin\solr create -c Product
	-Run bin\solr start -p 8983 (It is also set in application.properties telling the application to connect on this port for solr)
	
Very Important:
	-Security config is parent of web config in spring. So beans if web config are not found in security config. To resolve this, I added all componet scans in Security config. Other option was to create one more config class and add componnet scan there. Then this calls must be added to WebInitializer : getRootConfigClasses()
	-https://stackoverflow.com/questions/35344135/custom-userdetailsservice-it-seems-to-be-not-autowired
	

Spring books:
	-https://github.com/arifhasnatnstucsteonGit/ProgrammingBooks

Basic eCommerce App:
	-https://o7planning.org/en/10683/create-a-shopping-cart-web-application-with-spring-boot-hibernate#a14223413
	
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
	
Sprin Integrration
	-Pro Spring 5 (fifth edition), Chapter 18
	-Spring Inegration in Action, Chapter 16

Spring Session
	-https://www.javadevjournal.com/spring/spring-session-with-jdbc/ : Don’t use @EnableJdbcHttpSession and let Spring Boot handle it through auto configuration.
	-https://www.baeldung.com/spring-session-jdbc
	-https://dzone.com/articles/spring-jdbc-session
	
	

	