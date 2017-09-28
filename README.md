------------------------------------------------------------
WareHouse Management System : 
-------------------------------------------------------------

Requirement FullfillMent:
-------------------------

Skipped the following which is part of best practises (Due to time constraints)

1. Junit testcases are not written as part of the time constraints
2. Logging is not handled. 

Technical approach / Best Practises:
-------------------------------------

1. 5-10-20 rule followed (5 classes in a package, 10 Methods in a class, 20 Lines per Method)
2. Interface to hide the service agreements.
3. Custom exception thrown by wrapping the original exception 
4. Code is ran through SonarLint, to ensure no major deviations from coding principles.
5. Adopted SPR principles.

Technology Stack:
------------------

1. Basic JAVA 8 features.
2. Spring Boot.(1.5.3)
3. Spring Web Services
4. Spring WS Security
5. Spring JPA
6. HSQL Database
7. Maven


Default data set:
-------------------------

ROLE_ADMIN

User Name : dillip
password  : password1
Allowed Operations : getAllArticles,  getArticleById, addArticle, updateArticle, deleteArticle

ROLE_USER

User Name : kumar
password  : password2
Allowed Operations : getAllArticles,  getArticleById


How to Run the Program:
------------------------

1.  Copy the jar to any folder.
2.  Issue the following command from the windows command prompt. 

	a). To start the following  
		1.	Tomcat Server
		2.	In Memory Database (HSQL)
		3. 	Load and execute the database with Default data
		
	Command to issue from the Project Root Folder.	
		
	mvn spring-boot:run 

3. To access/submit the request from the Browser to the application.

	(EX:-) To get the article by ID.
	
		http://localhost:8080/user/article/1
				
	
Sample Output:
-------------------

As a JASON output (Can be changed to any output format by changing ResponseEntity)

{"articleId":1,"title":"Shirts","volume":"10"}


