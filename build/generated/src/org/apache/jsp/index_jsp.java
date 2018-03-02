package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"w3.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .w3-sidebar {\n");
      out.write("                z-index: 3;\n");
      out.write("                width: 200px;\n");
      out.write("                top: 43px;\n");
      out.write("                bottom: 0;\n");
      out.write("                height: inherit;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"w3-light-grey\">\n");
      out.write("        <!-- Navbar on top-->\n");
      out.write("        <div class=\"w3-top\">\n");
      out.write("            <div class=\"w3-bar w3-top w3-black w3-left-align w3-large\">\n");
      out.write("                <a class=\"w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large\" href=\"javascript:void(0)\" onclick=\"w3_open()\">\n");
      out.write("                    <i class=\"fa fa-bars w3-xlarge\"></i>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-button\">NoodlesWiki</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("        <nav class=\"w3-sidebar w3-bar-block w3-collapse w3-large w3-animate-left\" id=\"sidebar\">\n");
      out.write("            <a href=\"javascript:void(0)\" onclick=\"w3_close()\" class=\"w3-right w3-padding-large w3-hover-black w3-hide-large\" title=\"Close Menu\">\n");
      out.write("                <i class=\"fa fa-close\"></i>\n");
      out.write("            </a>\n");
      out.write("            <h4 class=\"w3-bar-item\"><b>Menu</b></h4>\n");
      out.write("            <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\n");
      out.write("            <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\n");
      out.write("            <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\n");
      out.write("            <a class=\"w3-bar-item w3-button w3-hover-black\" href=\"#\">Link</a>\n");
      out.write("        </nav>\n");
      out.write("        <!-- Overlay effect when opening sidebar on small screens -->\n");
      out.write("        <div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n");
      out.write("\n");
      out.write("        <!-- shift 200px when sidebar visible -->\n");
      out.write("        <div class=\"w3-main\" style=\"margin-left:200px; margin-top:43px;\">\n");
      out.write("            <!-- First Photo Grid-->\n");
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
      out.write("\n");
      out.write("        <script>\n");
      out.write("// Get the Sidebar\n");
      out.write("            var mySidebar = document.getElementById(\"sidebar\");\n");
      out.write("\n");
      out.write("// Get the DIV with overlay effect\n");
      out.write("            var overlayBg = document.getElementById(\"myOverlay\");\n");
      out.write("\n");
      out.write("// Toggle between showing and hiding the sidebar, and add overlay effect\n");
      out.write("            function w3_open() {\n");
      out.write("                if (mySidebar.style.display === 'block') {\n");
      out.write("                    mySidebar.style.display = 'none';\n");
      out.write("                    overlayBg.style.display = \"none\";\n");
      out.write("                } else {\n");
      out.write("                    mySidebar.style.display = 'block';\n");
      out.write("                    overlayBg.style.display = \"block\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("// Close the sidebar with the close button\n");
      out.write("            function w3_close() {\n");
      out.write("                mySidebar.style.display = \"none\";\n");
      out.write("                overlayBg.style.display = \"none\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
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
