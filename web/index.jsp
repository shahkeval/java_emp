<html>
<head>
<title> JSP </title>
<script type="text/javascript" src="myJs.js">
</script>
</head>

<%@page import="java.sql.*"%>
<%!
 String className= "com.mysql.jdbc.Driver";
 String url= "jdbc:mysql://localhost:3306/marks";
 String user= "root";
 String password= "";
 String n;
%>
<body>

<%
  Connection con;
  Statement stm;
  ResultSet rs;
  try
  {
   Class.forName(className);
   con= DriverManager.getConnection(url, user, password);
   
   String sql= "SELECT max(id)+1 FROM students";
   stm=con.createStatement();
   rs= stm.executeQuery(sql);
   rs.next();
   n=String.valueOf(rs.getInt(1));
   }
  catch(Exception e)
  {
   out.println(""+e);
  }
%>
<center>
<br>
<form method="POST" action="CRUD.bsr" onSubmit="return frmValidate(this)">
 <table align="center" border="1px" bgcolor="sky blue">
 <tr> <td colspan=2 align=center>Marks of Student  <hr>  </td>
 </tr>
 
 <tr>  <td>Id : </td>
  <td><input type="text" name="txtID" value=<%=n%> readonly></td>
 </tr>
 
  <tr> <td>Enroll_Number:</td> <td><input type="text" name="txtEroll"/></td>
  </tr>
 
  <tr>  <td>Name : </td>  <td><input type="text" name="txtName"></td>
  </tr>
  
  <tr> <td>Department:-</td> <td><input type="text" name="txtDepart" value="" /></td>
  </tr>
  
  <tr> <td>java</td> <td><input type="text" name="txtjava" value="" onkeypress="return isNum(event)" /></td>
  </tr>
       
  <tr> <td>Mern</td> <td><input type="text" name="txtmern" value="" onkeypress="return isNum(event)" /></td>
  </tr>
         
  <tr> <td>Cyber_security:</td> <td><input type="text" name="txtcuber" value="" onkeypress="return isNum(event)" /></td>
  </tr>

 
 <tr>  <td colspan=2 align=center>   <hr>
   <input type="hidden" name="action" value="add">
   <input type="submit" value="Insert">
   <input type="reset" value="Clear">
   <input type="button" value="Display" onclick="doDisplay();">
   <input type="button" value="Search" onclick="doSearch();">
   
  </td> </tr>
 </table></form>
</div>
</center>
</body>
</html>