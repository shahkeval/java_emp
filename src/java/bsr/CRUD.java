 package bsr;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/CRUD.bsr")
public class CRUD extends HttpServlet
{
 String className= "com.mysql.jdbc.Driver";
 String url= "jdbc:mysql://localhost:3306/marks";
 String user= "root";
 String password= "";
 
 Connection con;
 Statement ps;
 String sql;
 PrintWriter out;
 ServletContext context;
 RequestDispatcher rd;
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {     
  doPost(request, response);
 }
 public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
  //doGet(request, response);
  response.setContentType("text/html");
  out= response.getWriter(); 

  out.println("<html><head><LINK REL='STYLESHEET' HREF='myCss.css' TYPE='text/css'>");
  out.println("<script type='text/javascript' src='myJs.js'></script></head><body>");
  
  
  String action;
  try 
  {
   Class.forName(className);
   con= DriverManager.getConnection(url, user, password);  
   context= getServletContext();  

   action=request.getParameter("action").toString();
   if(action.equals("add"))
   {
    doAdd(request,response);
   }
   else if(action.equals("update"))
   {
    doUpdate(request,response);
   }
   else if(action.equals("delete"))
   {
    doDelete(request,response);
   }
   else if(action.equals("display"))
   {
    doDisplay(request,response);
   }
   else
   {
    response.sendRedirect("index.jsp");
   }
   ps.close();
   con.close(); 
  }
  catch(Exception e)
  {
   action="";
   out.println("error for doPost : "+e);
  }
  
  
  out.println("</body></html>");
 }
 
 public void doAdd(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
  String txtID= request.getParameter("txtID");
  String txtEroll= request.getParameter("txtEroll");
  String txtName= request.getParameter("txtName");
  String txtDepart= request.getParameter("txtDepart");
  String txtjava= request.getParameter("txtjava");
  String txtmern= request.getParameter("txtmern");
  String txtcuber= request.getParameter("txtcuber");
  
   
  try
  {
   sql= "INSERT INTO students VALUES("+txtID+",'"+txtEroll+"','"+txtName+"','"+txtDepart+"','"+txtjava+"','"+txtmern+"',"+txtcuber+")";       
   ps=con.createStatement();
   int ans=ps.executeUpdate(sql);
    
   if(ans!=0)
   {
    out.println("<div class=ghi>Record Successfully added</div>");    
   }
   else
   {
    out.println("<div class=errorR>Problem in insert</div>");    
   } 
   rd= context.getRequestDispatcher("/index.jsp");   
   rd.include(request, response);    
   
  }
  catch(Exception sx)
  {
   out.println(sx);
  }   
  

 }//doAdd
 
 public void doUpdate(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
  String txtID= request.getParameter("txtID");
  String txtEroll= request.getParameter("txtEroll");
  String txtName= request.getParameter("txtName");
  String txtDepart= request.getParameter("txtDepart");
  String txtjava= request.getParameter("txtjava");
  String txtmern= request.getParameter("txtmern");
  String txtcuber= request.getParameter("txtcuber");
   
  try
  {
  
    /*sql = "UPDATE students set enroll_number='"+txtEroll+"', "
           + "name='"+txtName+"', department='"+txtDepart+"',"
           + "java="+txtjava+",mern="+txtmern+",cybersecurity="+txtcuber+" where id="+txtID; */
    
    sql = "UPDATE students SET enroll_number='"+txtEroll+"',"
            + "name='"+txtName+"',"
            + "department='"+txtDepart+"',"
            + "java="+txtjava+","
            + "mern="+txtmern+","
            + "cybersecurity="+txtcuber+" WHERE id="+txtID ;
    
   ps=con.createStatement(); 
    
   int ans=ps.executeUpdate(sql);
    
   if(ans!=0)
   {
    out.println("<div class=msg>Record Successfully Updated</div>");   
   }
   else
   {
    out.println("<div class=errorR>Update Fail ...</div>");
   } 
   rd= context.getRequestDispatcher("/index.jsp");   
   rd.include(request, response);    
  }
  catch(Exception sx)
  {
   out.println(sx);
  }   
 }//doUpdate

 public void doDelete(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
  String txtID= request.getParameter("eId");
  try
  {
   sql= "DELETE FROM students WHERE id="+txtID;   
   ps=con.createStatement();
   int ans=ps.executeUpdate(sql);
   if(ans!=0)
   {
    out.println("<div class=msg>Record Successfully Deleted</div>");
   }
   else
   {
    out.println("<div class=errorR>Delete Fail ...</div>");    
   }  
   rd= context.getRequestDispatcher("/index.jsp");
   rd.include(request, response);
  }
  catch(Exception sx)
  {
   out.println(sx);
  }   
 }//doDelete 
 
 public void doDisplay(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
   String fldn=request.getParameter("fldName");
  String fldv=request.getParameter("fldVal");
  
  String query;  
  if( (fldn==null ||fldn.equals(' ') ) || (fldv==null ||fldv.equals(' ') ) )
  {
   query = "select * from students order by id";
  }
  else
  {
   query = "select * from students where "+fldn+"='"+fldv+"' order by id";
  }
  //out.println("SQL Query-> : "+query);
  showTable( query, out);
  
 }
 
 public void showTable(String query, PrintWriter out)
 {
  try
  {
     
   Statement statement = con.createStatement();
   
   // Send query to database and store results.
   ResultSet resultSet = statement.executeQuery(query);
   
   
   ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
   int columnCount = resultSetMetaData.getColumnCount();
   
   // Print results.
   out.println("<center>");
   out.println("<TABLE BORDER=0 cellpadding='5px'>");
   // Column index starts at 1 (a la SQL), not 0 (a la Java).
   out.println("<tr><th colspan="+(columnCount+2)+"><h1>Marks of Student</h1><hr></th></tr>");
   for(int i=1; i <= columnCount; i++) //create Table heading with column name
   {
    out.print("<TH bgcolor='#C4DFE6'>" + resultSetMetaData.getColumnName(i));
   }
   out.println();
   int row=0;
   String rowCol="";
   // Step through each row in the result set.
   while(resultSet.next())
   {
    out.println("<TR>");
    // Step across the row, retrieving the data in each
    // column cell as a String.
    row+=1;
    for(int i=1; i <= columnCount; i++)
    {
     if(row%2==0)
     {
      rowCol="#C4DFE6";
     }
     else
     {
      rowCol="#66A5AD";
     }
     out.print("<TD bgcolor='"+rowCol+"'>" + resultSet.getString(i));
    }
    out.print("<TD bgcolor='"+rowCol+"'>"
            + "<a href='editForm.jsp?action=edit&eId=" + resultSet.getString(1)+"'>Edit</a>");
    String aHref="<TD bgcolor='"+rowCol+"'>"
            + "<a href='CRUD.bsr?action=delete&eId=" + resultSet.getString(1) + "' onClick='return doConfirmDel();'>Delete</a>";    
    out.print(aHref);
    out.println();
   }
   if(row==0)
   {
   out.println("<tr><th colspan="+(columnCount+2)+">"
           + "<h1>No Record Found...!</h1></th></tr>");
   }
   out.println("<TR><TD colspan="+(columnCount+2)+" align='center'>");
   out.println("<hr><form><input type='button' "
           + "value='Home' onclick='doHome();'></form></td></tr>");
   
   out.println("</TABLE>");
   out.println("</center>");
  }
  catch(Exception ex)
  {
   System.err.println("Error with input: " + ex);
  }
 }//showTable
 
} // end of class