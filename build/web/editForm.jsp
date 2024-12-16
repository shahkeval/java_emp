<html>
<head>
<LINK REL="STYLESHEET" HREF="myCss.css" TYPE="text/css">
<script type="text/javascript" src="myJs.js" >
</script>

</head>

<%@page import="java.sql.*"%>
<%!
 String className= "com.mysql.jdbc.Driver";
 String url= "jdbc:mysql://localhost:3306/marks";
 String user= "root";
 String password= "";
 String f1,f2,f3,f4,f5,f6,f7;
 Connection con;
  Statement stm;
  ResultSet rs;
%>
<body>

<%
  
 
  try
  {
   Class.forName(className);
   con= DriverManager.getConnection(url, user, password);
   
   String sql= "SELECT * FROM students "
           + "where id="+request.getParameter("eId");
  // out.println(sql);
   stm=con.createStatement();
   rs= stm.executeQuery(sql);
   
   rs.next();
   f1=String.valueOf(rs.getInt(1));
   f2=rs.getString(2);
   f3=rs.getString(3);
   f4=rs.getString(4);
   f5=String.valueOf(rs.getInt(5));
   f6=String.valueOf(rs.getInt(6));
   f7=String.valueOf(rs.getInt(7));
  }
  catch(Exception e)
  {
   out.println(""+e);
  }
%>
<center>
<br>
<form method="POST" action="CRUD.bsr">
 <table align="center" border="1px" bgcolor="sky blue" >
 <tr>
  <td colspan=2 align=center>
   Marks of Student
   <hr>
  </td>
 </tr>

  <tr>
                    <td>Id:</td>
                    <td><input type="text" name="txtID" value=<%=f1%> readonly/></td>  
                </tr>
                 <tr>
                    <td>Enroll_Number:</td>
                    <td><input type="text" name="txtEroll" value=<%=f2%> /></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="txtName" value=<%=f3%> /></td>
                </tr>
                <tr>
                    <td>Department:-</td>
                    <td><input type="text" name="txtDepart" value=<%=f4%>  /></td>
                </tr>
                <tr>
                    <td>java</td>
                    <td><input type="text" name="txtjava" value=<%=f5%>/></td>
                </tr>
                <tr>
                    <td>Mern</td>
                    <td><input type="text" name="txtmern" value=<%=f6%>  /></td>
                </tr>
                <tr>
                    <td>Cyber_security:</td>
                    <td><input type="text" name="txtcuber" value=<%=f7%> /></td>
                </tr>
 
 <tr>
  <td colspan=2 align=center>
   <hr>
   <input type="hidden" name="action" value="update">
   <input type="submit" value="Update">
   <input type="button" value="Display" onclick="doDisplay();">
   <input type="button" value="Search" onclick="doSearch();">
   <input type="button" value="Home" onclick="doHome();">
   
  </td>
 </tr>
 </table>
</form>
</div>
</center>
</body>
</html>