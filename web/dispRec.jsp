<HTML>  
<HEAD>    
</HEAD>  
<BODY>

<br>
<center>

<%@ page import="java.sql.*"%>
<FORM METHOD="get" ACTION="CRUD.bsr">
<%
  try
  {
   Class.forName("com.mysql.jdbc.Driver");
   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marks", "root","");
    
   Statement statement = connection.createStatement();
   
   // Send query to database and store results.
   ResultSet resultSet = statement.executeQuery(
           "select * from students where 1=2");
   
   ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
   int columnCount = resultSetMetaData.getColumnCount();
   
   out.println("search by  : <select name='fldName'>");
     
   for(int i=1; i <= columnCount; i++) //create Table heading with column name
   {
    out.print("<option value='"+resultSetMetaData.getColumnName(i) +"' >" 
            + resultSetMetaData.getColumnName(i)+"</option>");
   }
   out.println("</select>");
  }
  catch(Exception ex)
  {
   out.println("Error with input: " + ex);
  }
%>
<br>
value : <input type=TEXT name = "fldVal" >
<input type="hidden" name = "action" value="display">
<BR><BR><input type="submit" value="Show Result">
</FORM>
</div>
</BODY>
</HTML>