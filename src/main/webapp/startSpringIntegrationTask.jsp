
<%@page import="aero.sita.asl.testTasks.SpringIntegrationTask.SpringIntegrationTaskClient"%><html>
   <head>
      <title>SITA_TEST_TASK</title>
   </head>
   
   <body>
      <%
      
      		String filesPath = request.getParameter("filesPath");
      		
      		SpringIntegrationTaskClient integrationTaskClient = new SpringIntegrationTaskClient();
      		integrationTaskClient.main(null);
       %>
       
       <h3> <font color=blue>Thanks for using Spring Integration Task..Your file integration is completed. Please check files.</font></h2>
       
   </body>
   
</html>