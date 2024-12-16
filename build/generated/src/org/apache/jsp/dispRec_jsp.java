package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dispRec_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<HTML>  \n");
      out.write("<HEAD>    \n");
      out.write("</HEAD>  \n");
      out.write("<BODY>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<center>\n");
      out.write("\n");
      out.write("\n");
      out.write("<FORM METHOD=\"get\" ACTION=\"CRUD.bsr\">\n");

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

      out.write("\n");
      out.write("<br>\n");
      out.write("value : <input type=TEXT name = \"fldVal\" >\n");
      out.write("<input type=\"hidden\" name = \"action\" value=\"display\">\n");
      out.write("<BR><BR><input type=\"submit\" value=\"Show Result\">\n");
      out.write("</FORM>\n");
      out.write("</div>\n");
      out.write("</BODY>\n");
      out.write("</HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
