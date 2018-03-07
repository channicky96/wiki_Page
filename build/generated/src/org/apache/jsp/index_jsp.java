package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Noodles Wiki</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"w3.css\" type=\"text/css\">\n");
      out.write("        <!--import Font Awesome Icons-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"nav.css\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"w3-light-grey\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Navbar on top-->\n");
      out.write("<div class=\"w3-top\">\n");
      out.write("    <div class=\"w3-bar w3-top w3-black w3-large\">\n");
      out.write("        <a href=\"index.jsp\" class=\"w3-bar-item w3-button\" title=\"Home page\">NoodlesWiki</a>\n");
      out.write("        <a class=\"w3-bar-item w3-button w3-right w3-hide-large w3-hover-white\" href=\"javascript:void(0)\" onclick=\"openBar()\">\n");
      out.write("            <!--menu icon-->\n");
      out.write("            <i class=\"fa fa-bars w3-xlarge\"></i>\n");
      out.write("        </a>\n");
      out.write("        <a class =\"w3-bar-item w3-button w3-right w3-hover-white\">\n");
      out.write("            <!--user icon-->\n");
      out.write("            <i class=\"fa fa-user w3-xlarge\" title=\"Log in/Register\"></i>\n");
      out.write("        </a>\n");
      out.write("        <div class=\"w3-right\">\n");
      out.write("            <button class=\"w3-bar-item w3-button w3-black w3-right\" type=\"submit\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("            <input id=\"search_input\" class=\"w3-border\" type=\"text\" placeholder=\"Search..\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- Sidebar -->\n");
      out.write("<nav class=\"w3-sidebar w3-bar-block w3-collapse w3-large w3-animate-left\" id=\"sidebar\">\n");
      out.write("    <a href=\"javascript:void(0)\" onclick=\"closeBar()\" class=\"w3-right w3-padding-large w3-hover-black w3-hide-large\" title=\"Close Menu\">\n");
      out.write("        <i class=\"fa fa-close\"></i>\n");
      out.write("    </a>\n");
      out.write("    <h4 class=\"w3-bar-item\"><b>Menu</b></h4>\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"categories.jsp\">Categories</a>\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"sandbox.jsp\">Sandbox</a>\n");
      out.write("</nav>\n");
      out.write("<!-- Overlay effect when opening sidebar on small screens -->\n");
      out.write("<div class=\"w3-overlay w3-hide-large\" onclick=\"closeBar()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n");
      out.write("\n");
      out.write("<!-- shift 200px when sidebar visible -->\n");
      out.write("<div class=\"w3-main\" style=\"margin-left:200px; margin-top:43px;\">\n");
      out.write("\n");
      out.write("<script src=\"nav.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- First Photo Grid-->\n");
      out.write("            <div class=\"w3-row-padding\">\n");
      out.write("                <div class=\"w3-third w3-container w3-margin-bottom\">\n");
      out.write("                    <img src=\"https://i.imgur.com/OvMZBs9.jpg\" alt=\"\" style=\"width:100%\" class=\"w3-hover-opacity\">\n");
      out.write("                    <div class=\"w3-container w3-white\">\n");
      out.write("                        <p><b>Lorem Ipsum</b></p>\n");
      out.write("                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-third w3-container w3-margin-bottom\">\n");
      out.write("                    <img src=\"https://i.imgur.com/OvMZBs9.jpg\" alt=\"\" style=\"width:100%\" class=\"w3-hover-opacity\">\n");
      out.write("                    <div class=\"w3-container w3-white\">\n");
      out.write("                        <p><b>Lorem Ipsum</b></p>\n");
      out.write("                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-third w3-container w3-margin-bottom\">\n");
      out.write("                    <img src=\"https://i.imgur.com/OvMZBs9.jpg\" alt=\"\" style=\"width:100%\" class=\"w3-hover-opacity\">\n");
      out.write("                    <div class=\"w3-container w3-white\">\n");
      out.write("                        <p><b>Lorem Ipsum</b></p>\n");
      out.write("                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Pagination -->\n");
      out.write("        <div class=\"w3-center w3-padding-32\">\n");
      out.write("            <div class=\"w3-bar\">\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-button w3-hover-black\">«</a>\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-black w3-button\">1</a>\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-button w3-hover-black\">2</a>\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-button w3-hover-black\">3</a>\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-button w3-hover-black\">4</a>\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-button w3-hover-black\">»</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
