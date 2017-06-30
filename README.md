# TASK_USING_SPRING_INTEGRATION
Spring Integration is a framework enabling a collection of individual applications to integrate together to deliver a business enterprise system. It is lightweight messaging system that enables spring based applications to communicate with one another. It has mainly three components MESSAGES, CHANNELS AND ENDPOINTS.
## Task Detail: 
There are number of files placed into the directory (C:\SITA_TEST_TASK\IN) with a number on each line.
The application is responsible for 
1. To sum all the numbers in the file and create a new file containing the resulting value in the directory (C:\SITA_TEST_TASK\OUT). 
2. The output file will have the same name as the input file with .PROCESSED (C:\SITA_TEST_TASK\PROCESSED) appended to the end of the filename. 
3. Only process files with a .txt extension. 
4. For invalid file, the input file should be put into the following directory (C:\SITA_TEST_TASK\ERROR).

## Dependencies
* spring integration framework 4.1.2.RELEASE
* spring framework 4.1.4.RELEASE
* spring-web
* log4j 1.2.17
* junit 4.10
* apache commons 1.3.2


## Maven repository to download dependencies
https://repo.maven.apache.org/maven2/


## Build process
1. Use command "mvn clean install"

## Note
1.Input files should be placed under C:\SITA_TEST_TASK\IN, however we can configure this value in application.properties which is available at src/main/resources

## Testing the application.
1. Make sure before running the application, place the input files under C:\SITA_TEST_TASK\IN.
2. Deploy the war file(SITA_TEST_TASK-1.0-SNAPSHOT.war) on Tomcat server.
3. After successful deployment of war file hit the local URL "http://localhost:8080/SITA_TEST_TASK-1.0-SNAPSHOT/".
4. Then after click on "Start Spring Integration" button.
3. Verify the results in C:\SITA_TEST_TASK\OUT, C:\SITA_TEST_TASK\PROCESSED and C:\SITA_TEST_TASK\ERROR.

## Process Flow
1. At the time when we launch the application, the inbound-channel-adapter will start automatically since we have configured auto-startup value to true.
2. Since the poller configured it wll poll for messages from the given input directory.
3. All the messages one by one enter to router and the router will do the message validation. The validation will pass if the lines in the file contains numbers. If the validation fails then router will send the message to errorChannel.
Otherwise the message will send to outputChannel.
4. On the errorChannel we have outbound-channel-adapter and this is responsible to put message into the directory specified in configuration.
5. On the outputChannel we have service-activator and the bean referred for this channel is responsible to generate the file content (sum of numbers) and will send to writeOutputChannel.
6. On the writeOutputChannel we have outbound-channel-adapter which is responsible to generate the output in the configured directory. Since we have used configured file-name-generator then the application is having the control to decide the name of the file. This generator will add ".PROCESSED" at the end of original file name.
 
