Pre-Requisites
1. Install Java 8
   . In Environment Variables (your PC)
       . Systems Variable, enter and add respectively:
           JAVA_HOME = path\path\jdk
           Path = %JAVA_HOME%\bin;

2. To test java installation, in command prompt, type:
   > java -version
   Note: You should see the Java 8 installed. 

3. Install maven 3 (any version 3, I used 3.2.5)
   . In Environment Variables (your PC)
       . Systems Variable, enter and add respectively:
           MAVEN_HOME = path\path\apache-maven-3.2.5
           Path = %MAVEN_HOME%\bin;

4. To test maven installation, in command prompt, type:
   > mvn -version
   Note: You should see the Maven 3 installed.

5. Install Eclipse IDE, go to https://www.eclipse.org/downloads/ and download the installer.



***************************************************
Set up the Project in Eclipse IDE as Maven Project

1. Go to GitHub and copy/download BuildItExercises (https://github.com/erances/BuildItExercises) in your local directory, 
   usually a workspace say, D:\workspace\.

   After copying to workspace you should see D:\workspace\BuildItExercises

2. In the command prompt go to directory where you copied BuildItExcercises, say D:\workspace\BuildItExercises

   You should see:
   D:\workspace\BuildItExercises>

3. Once you're in your directory where you copied the Project BuildItExercises, issue the following commands to make the project 
   eclipse-ready.
   
   D:\workspace\BuildItExercises>mvn eclipse:clean
   D:\workspace\BuildItExercises>mvn eclipse:eclipse
   
4. Open Eclipse IDE. In the Package Explorer, right click and choose Import.

5. In Import window, Select Import Existing Maven Projects. Click Next

6. In Import Maven Projects window, click Browse. Go to your directory where you copied the Project BuildItExercises say, 
   D:\workspace\BuildItExercises.  
   
   In Projects panel, select:
      /pom.xml com.builditexercises.crawler:BuildItExercises:1.0-SNAPSHOT:jar 
      
   Click Finish.

   Note: You should see the project BuildItExercises now imported to your eclise IDE.



***************************************************
How to Build the Application:

1. In command prompt, go to the directory where you copied the project BuildItExercises, say D:\workspace\BuildItExercises> 
   and issue the following command:

   D:\workspace\BuildItExercises>mvn clean install -DskipTests=true

   Note: Once build is successful, you can now run the application.



***************************************************
How to Run Unit Test:

1. If project has not been build yet, build it (please refer to 'How to Build the Application' section)

2. Open Eclipse IDE, and at the Package Explorer search for the BuildItExercises project.

3. Go to src/test/java and to package com.builditexercises.crawler, and you will see two classes:
   
   . BuildItWebCrawlerTentaclesUnitTest
   . BuildItWebCrawlerUnitTest

4. Run Unit Test on each classes.  Either right click on the class at Package Explorer or on the class name itself inside the class. 
   Then click Run As -> JUnit Test.

   You will see that it will run all the test methods inside the class.  At the Package Explorer side there will be another window 
   called JUnit and will show test results.  All test results should be in green.



***************************************************
How to Run Application:

1. If project has not been build yet, build it (please refer to 'How to Build the Application' section)

2. Open Eclipse IDE, and at the Package Explorer search for the BuildItExercises project.

3. Go to src/main/java and to package com.builditexercises.crawler, and you will see three classes:

   . BuildItWebCrawler
   . BuildItWebCrawlerTentacles
   . BuildItWebCrawlerTest

4. Double click on BuildItWebCrawlerTest to open it up in the right panel.

5. Right click on main() method and click Run As -> Java Application.  Click on the Console Tab below and it will show the result.

6. If you desire to change the parameters of the crawler.explore() method in main() method.  Build the application again 
   (please refer to 'How to Build the Application' section).



***************************************************
Trade-Offs:

1. This can be implemented in a much simpler way, a recursive type.  But just to show some best practices like separation of concerns, 
   it was implemented in different way to show such best practice.  It makes the code more readable, maintainable, testable, 
   and flexible.

2. Use jsoup package to make HTTP request and easily parse the page, instead of parsing it which is tedious. Using jsoup we just have 
   to write few lines of code.



***************************************************
Anything further to achieve with more time:

1. Create Unit Test further for using the Connection and Document objects with given url.

2. Create Unit Test, given the use of Connection and Document objects to achieve the perceived results using dummy data 
   (i.e. sample web page with numerous links and links to images inside at different levels).

3. Perhaps the sitemap result can be shown in a web page type.



