package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import wiki.Category;

public final class categories_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/template.jsp");
  }

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Categories - NoodlesWiki</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"w3.css\" type=\"text/css\">\n");
      out.write("        <!--import icons-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"nav.css\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"w3-light-grey\">\n");
      out.write("        ");
      wiki.Category cList = null;
      synchronized (session) {
        cList = (wiki.Category) _jspx_page_context.getAttribute("cList", PageContext.SESSION_SCOPE);
        if (cList == null){
          cList = new wiki.Category();
          _jspx_page_context.setAttribute("cList", cList, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Navbar on top-->\r\n");
      out.write("<div class=\"w3-top\">\r\n");
      out.write("    <div class=\"w3-bar w3-top w3-black w3-large\">\r\n");
      out.write("        <a href=\"index.jsp\" class=\"w3-bar-item w3-button\" title=\"Home page\">NoodlesWiki</a>\r\n");
      out.write("        <a class=\"w3-bar-item w3-button w3-right w3-hide-large w3-hover-white\" href=\"javascript:void(0)\" onclick=\"openBar()\">\r\n");
      out.write("            <!--menu icon-->\r\n");
      out.write("            <i class=\"fa fa-bars w3-xlarge\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a class =\"w3-bar-item w3-button w3-right w3-hover-white\">\r\n");
      out.write("            <!--user icon-->\r\n");
      out.write("            <i class=\"fa fa-user w3-xlarge\" title=\"Log in/Register\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"w3-right\">\r\n");
      out.write("            <button class=\"w3-bar-item w3-button w3-black w3-right\" type=\"submit\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("            <input id=\"search_input\" class=\"w3-border\" type=\"text\" placeholder=\"Search..\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Sidebar -->\r\n");
      out.write("<nav class=\"w3-sidebar w3-bar-block w3-collapse w3-large w3-animate-left\" id=\"sidebar\">\r\n");
      out.write("    <a href=\"javascript:void(0)\" onclick=\"closeBar()\" class=\"w3-right w3-padding-large w3-hover-black w3-hide-large\" title=\"Close Menu\">\r\n");
      out.write("        <i class=\"fa fa-close\"></i>\r\n");
      out.write("    </a>\r\n");
      out.write("    <h4 class=\"w3-bar-item\"><b>Menu</b></h4>\r\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"categories.jsp\">Categories</a>\r\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\r\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\r\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"sandbox.jsp\">Sandbox</a>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- Overlay effect when opening sidebar on small screens -->\r\n");
      out.write("<div class=\"w3-overlay w3-hide-large\" onclick=\"closeBar()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\r\n");
      out.write("\r\n");
      out.write("<!-- shift 200px when sidebar visible -->\r\n");
      out.write("<div class=\"w3-main\" style=\"margin-left:200px; margin-top:43px;\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"nav.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("        <h1 class=\"w3-container\">Hello World!</h1>\n");
      out.write("        <ul>\n");
      out.write("            <li>");
 out.println("ttttt");
      out.write("</li>\n");
      out.write("\n");
      out.write("            <li>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((wiki.Category)_jspx_page_context.findAttribute("cList")).getName())));
      out.write("</li>\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
