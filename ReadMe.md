Clone the Repository:

Github URL- https://github.com/laukik97/CriketTeamValidations

Bitbucket Repo - https://Laukik502@bitbucket.org/myrepo2/cricketteamvalidations.git

Repo URL - https://bitbucket.org/myrepo2/cricketteamvalidations/src/master/

git clone https://Laukik502@bitbucket.org/myrepo2/cricketteamvalidations.git

IDE Specific Plugin and Libraries:

1.Install Cucumber plugin (Just to avoid ant IDE specific error, Test case can be executed through maven command even in the absence of the plugin

2.Make sure that Junit Library is present (if IDE is eclipse)

Execution Options:

Option 1: (Recommended)
    
Make sure all the dependence are resolved or else update the maven project so that all the dependencies will be downloaded
    
    Using Maven test goal: 
    IDE:
    1.Eclipse --> Right click on the projet and select Run As --> Maven Test
    2.IntelliJ --> Right click on the projet and select Run Maven --> test
    3.IntelliJ --> Right click on the projet and select Run --> All Tests

    Using CLI to execute maven goal
         Open the project in file explorer and open command prompt(Make sure command prompt is open where pom.xml is present) 
         type --> mvn test
        
        If IntelliJ is the IDE then go to terminal and type mvn test

    
Option 2:

    Using Test Runner File :
    Go to src/test/java/testRunner --> Right Click on testRunner.java file and run as --> Junit Test

Some Additional Details:

    Executing A particular Test:
        To exceute the selected test add tag name of the scenario from feature file to the 
        cucumber options added in testRunner.java. e.g tag="@TestCase1"
    
    Logging:
        For Logging slf4J is used and the current log level is Info
        Logs will be generated in the console and as well in the file 
        Log file location is "test-output/Logs" and file name is "app.log"
        To change the Log Level go to --> src/main/resources/logback.xml
        and change root level.

    Reporting:
        For reporting extent report are used.
        Reports will be generated in "test-output/SparkReport/Spark.html"
        Apart from extent report cucumber reports are also integrated
        at 'target/CucumberReports' (three types of reports will be generate html,json and xml) 

Name - Laukik Parashurami

Email - parashruami.laukik@gmail.com

