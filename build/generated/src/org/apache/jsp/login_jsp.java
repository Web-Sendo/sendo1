package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Log In | Uplon - Responsive Bootstrap 4 Admin Dashboard</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta content=\"Responsive bootstrap 4 admin template\" name=\"description\">\n");
      out.write("        <meta content=\"Coderthemes\" name=\"author\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <!-- App favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets\\images\\favicon.ico\">\n");
      out.write("\n");
      out.write("        <!-- App css -->\n");
      out.write("        <link href=\"bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" id=\"bootstrap-stylesheet\">\n");
      out.write("        <link href=\"icons.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"app.min.css\" rel=\"stylesheet\" type=\"text/css\" id=\"app-stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"authentication-bg\">\n");
      out.write("\n");
      out.write("        <div class=\"account-pages pt-5 my-5\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-md-8 col-lg-6 col-xl-5\">\n");
      out.write("                        <div class=\"account-card-box\">\n");
      out.write("                            <div class=\"card mb-0\">\n");
      out.write("                                <div class=\"card-body p-4\">\n");
      out.write("                                    \n");
      out.write("                                    <div class=\"text-center\">\n");
      out.write("                                        <div class=\"my-3\">\n");
      out.write("                                            <a href=\"index.html\">\n");
      out.write("                                                <span><img src=\"assets\\images\\logo.png\" alt=\"\" height=\"28\"></span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </div>\n");
      out.write("                                        <h5 class=\"text-muted text-uppercase py-3 font-16\">Sign In</h5>\n");
      out.write("                                    </div>\n");
      out.write("    \n");
      out.write("                                    <form action=\"#\" class=\"mt-2\">\n");
      out.write("    \n");
      out.write("                                        <div class=\"form-group mb-3\">\n");
      out.write("                                            <input class=\"form-control\" type=\"text\" required=\"\" placeholder=\"Enter your username\">\n");
      out.write("                                        </div>\n");
      out.write("    \n");
      out.write("                                        <div class=\"form-group mb-3\">\n");
      out.write("                                            <input class=\"form-control\" type=\"password\" required=\"\" id=\"password\" placeholder=\"Enter your password\">\n");
      out.write("                                        </div>\n");
      out.write("    \n");
      out.write("                                        <div class=\"form-group mb-3\">\n");
      out.write("                                            <div class=\"custom-control custom-checkbox\">\n");
      out.write("                                                <input type=\"checkbox\" class=\"custom-control-input\" id=\"checkbox-signin\" checked=\"\">\n");
      out.write("                                                <label class=\"custom-control-label\" for=\"checkbox-signin\">Remember me</label>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("    \n");
      out.write("                                        <div class=\"form-group text-center\">\n");
      out.write("                                            <button class=\"btn btn-success btn-block waves-effect waves-light\" type=\"submit\"> Log In </button>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <a href=\"pages-recoverpw.html\" class=\"text-muted\"><i class=\"mdi mdi-lock mr-1\"></i> Forgot your password?</a>\n");
      out.write("    \n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                    <div class=\"text-center mt-4\">\n");
      out.write("                                        <h5 class=\"text-muted py-2\"><b>Sign in with</b></h5>\n");
      out.write("\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-12\">\n");
      out.write("                                                <button type=\"button\" class=\"btn btn-facebook waves-effect font-14 waves-light mt-3\">\n");
      out.write("                                                    <i class=\"fab fa-facebook-f mr-1\"></i> Facebook\n");
      out.write("                                                </button>\n");
      out.write("            \n");
      out.write("                                                <button type=\"button\" class=\"btn btn-twitter waves-effect font-14 waves-light mt-3\">\n");
      out.write("                                                    <i class=\"fab fa-twitter mr-1\"></i> Twitter\n");
      out.write("                                                </button>\n");
      out.write("            \n");
      out.write("                                                <button type=\"button\" class=\"btn btn-googleplus waves-effect font-14 waves-light mt-3\">\n");
      out.write("                                                    <i class=\"fab fa-google-plus-g mr-1\"></i> Google+\n");
      out.write("                                                </button>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("    \n");
      out.write("                                </div> <!-- end card-body -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- end card -->\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"row mt-3\">\n");
      out.write("                            <div class=\"col-12 text-center\">\n");
      out.write("                                <p class=\"text-white-50\">Don't have an account? <a href=\"pages-register.html\" class=\"text-white ml-1\"><b>Sign Up</b></a></p>\n");
      out.write("                            </div> <!-- end col -->\n");
      out.write("                        </div>\n");
      out.write("                        <!-- end row -->\n");
      out.write("\n");
      out.write("                    </div> <!-- end col -->\n");
      out.write("                </div>\n");
      out.write("                <!-- end row -->\n");
      out.write("            </div>\n");
      out.write("            <!-- end container -->\n");
      out.write("        </div>\n");
      out.write("        <!-- end page -->\n");
      out.write("\n");
      out.write("        <!-- Vendor js -->\n");
      out.write("        <script src=\"assets\\js\\vendor.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- App js -->\n");
      out.write("        <script src=\"assets\\js\\app.min.js\"></script>\n");
      out.write("        \n");
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
