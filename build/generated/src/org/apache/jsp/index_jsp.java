package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


 String className= "com.mysql.jdbc.Driver";
 String url= "jdbc:mysql://localhost:3306/marks";
 String user= "root";
 String password= "";
 String n;

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

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title> JSP </title>\n");
      out.write("<script type=\"text/javascript\" src=\"myJs.js\">\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");

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

      out.write("\n");
      out.write("<center>\n");
      out.write("<br>\n");
      out.write("<form method=\"POST\" action=\"CRUD.bsr\" onSubmit=\"return frmValidate(this)\">\n");
      out.write(" <table align=\"center\" border=\"1px\" bgcolor=\"sky blue\">\n");
      out.write(" <tr> <td colspan=2 align=center>Marks of Student  <hr>  </td>\n");
      out.write(" </tr>\n");
      out.write(" \n");
      out.write(" <tr>  <td>Id : </td>\n");
      out.write("  <td><input type=\"text\" name=\"txtID\" value=");
      out.print(n);
      out.write(" readonly></td>\n");
      out.write(" </tr>\n");
      out.write(" \n");
      out.write("  <tr> <td>Enroll_Number:</td> <td><input type=\"text\" name=\"txtEroll\"/></td>\n");
      out.write("  </tr>\n");
      out.write(" \n");
      out.write("  <tr>  <td>Name : </td>  <td><input type=\"text\" name=\"txtName\"></td>\n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("  <tr> <td>Department:-</td> <td><input type=\"text\" name=\"txtDepart\" value=\"\" /></td>\n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("  <tr> <td>java</td> <td><input type=\"text\" name=\"txtjava\" value=\"\" onkeypress=\"return isNum(event)\" /></td>\n");
      out.write("  </tr>\n");
      out.write("       \n");
      out.write("  <tr> <td>Mern</td> <td><input type=\"text\" name=\"txtmern\" value=\"\" onkeypress=\"return isNum(event)\" /></td>\n");
      out.write("  </tr>\n");
      out.write("         \n");
      out.write("  <tr> <td>Cyber_security:</td> <td><input type=\"text\" name=\"txtcuber\" value=\"\" onkeypress=\"return isNum(event)\" /></td>\n");
      out.write("  </tr>\n");
      out.write("\n");
      out.write(" \n");
      out.write(" <tr>  <td colspan=2 align=center>   <hr>\n");
      out.write("   <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("   <input type=\"submit\" value=\"Insert\">\n");
      out.write("   <input type=\"reset\" value=\"Clear\">\n");
      out.write("   <input type=\"button\" value=\"Display\" onclick=\"doDisplay();\">\n");
      out.write("   <input type=\"button\" value=\"Search\" onclick=\"doSearch();\">\n");
      out.write("   \n");
      out.write("  </td> </tr>\n");
      out.write(" </table></form>\n");
      out.write("</div>\n");
      out.write("</center>\n");
      out.write("</body>\n");
      out.write("</html>");
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
