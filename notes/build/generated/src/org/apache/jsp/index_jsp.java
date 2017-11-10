package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public class Actor{
                   String URL = "jdbc:mysql://localhost:3306/sakila";
                   String USERNAME = "root";
                   String PASSWORD = "";
                    
                   Connection conn = null;
                   PreparedStatement insertActors  = null;
                   ResultSet resultSet = null;
                   
                    public Actor(){
                        try {
                             conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);   
                             insertActors = conn.prepareStatement("Insert into actor(actor_name) values(?)");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    public int setActors(String first){
                        int result = 0;
                        try {
                              insertActors.setString(1, first);
                              result = insertActors.executeUpdate();
                        } catch (SQLException e) {
                              e.printStackTrace();
                        }
                        
                        return result;
                    }
            }
            
    
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

      out.write('\n');
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Clean Blog</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Theme CSS -->\n");
      out.write("    <link href=\"css/clean-blog.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");
      out.write("\n");
      out.write("    \n");
      out.write("    ");

        int result =0;
        String name = new String();
        
        if(request.getParameter("first") != null){
            name = request.getParameter("first");
            Actor actor = new Actor();
            result = actor.setActors(name);
        }
    
    
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!-- Navigation -->\n");
      out.write("    <nav class=\"navbar navbar-default navbar-custom navbar-fixed-top\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"navbar-header page-scroll\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    Menu <i class=\"fa fa-bars\"></i>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\">Start Bootstrap</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.jsp\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"about.html\">About</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"post.html\">Sample Post</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"contact.html\">Contact</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <!-- Page Header -->\n");
      out.write("    <!-- Set your background image for this header on the line below. -->\n");
      out.write("    <header class=\"intro-header\" style=\"background-image: url('img/home-bg.jpg')\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1\">\n");
      out.write("                    <div class=\"site-heading\">\n");
      out.write("                        <h1>Clean Blog</h1>\n");
      out.write("                        <hr class=\"small\">\n");
      out.write("                        <span class=\"subheading\">A Clean Blog Theme by Start Bootstrap</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <!-- Main Content -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("\t\t\n");
      out.write("\t\n");
      out.write("        <div class=\"row\">\n");
      out.write("\t\t\t<div class=\" col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 form-group\">\n");
      out.write("\t\t\t\t<form action=\"index.jsp\" mehtod=\"post\">\n");
      out.write("\t\t\t\t<input class=\"form-control\"  type=\"text\" name=\"first\" placeholder=\"Title\"/>\n");
      out.write("\t\t\t\t<input class=\"form-control\"  type=\"text\" name =\"subtitle\" placeholder=\"Subtitle\"/>\n");
      out.write("\t\t\t\t<textarea class=\"form-control\" name= \"description\" placeholder=\"Description...\"></textarea>\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Post\" class=\"btn btn-info\"/>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\n");
      out.write("            <div class=\"col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1\">\n");
      out.write("                <div class=\"post-preview\">\n");
      out.write("                    <a href=\"post.html\">\n");
      out.write("                        <h2 class=\"post-title\">\n");
      out.write("                            Man must explore, and this is exploration at its greatest\n");
      out.write("                        </h2>\n");
      out.write("                        <h3 class=\"post-subtitle\">\n");
      out.write("                            Problems look mighty small from 150 miles up\n");
      out.write("                        </h3>\n");
      out.write("                    </a>\n");
      out.write("                    <p class=\"post-meta\">Posted by <a href=\"#\">Start Bootstrap</a> on September 24, 2014</p>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <div class=\"post-preview\">\n");
      out.write("                    <a href=\"post.html\">\n");
      out.write("                        <h2 class=\"post-title\">\n");
      out.write("                            I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.\n");
      out.write("                        </h2>\n");
      out.write("                    </a>\n");
      out.write("                    <p class=\"post-meta\">Posted by <a href=\"#\">Start Bootstrap</a> on September 18, 2014</p>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <div class=\"post-preview\">\n");
      out.write("                    <a href=\"post.html\">\n");
      out.write("                        <h2 class=\"post-title\">\n");
      out.write("                            Science has not yet mastered prophecy\n");
      out.write("                        </h2>\n");
      out.write("                        <h3 class=\"post-subtitle\">\n");
      out.write("                            We predict too much for the next year and yet far too little for the next ten.\n");
      out.write("                        </h3>\n");
      out.write("                    </a>\n");
      out.write("                    <p class=\"post-meta\">Posted by <a href=\"#\">Start Bootstrap</a> on August 24, 2014</p>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <div class=\"post-preview\">\n");
      out.write("                    <a href=\"post.html\">\n");
      out.write("                        <h2 class=\"post-title\">\n");
      out.write("                            Failure is not an option\n");
      out.write("                        </h2>\n");
      out.write("                        <h3 class=\"post-subtitle\">\n");
      out.write("                            Many say exploration is part of our destiny, but itâs actually our duty to future generations.\n");
      out.write("                        </h3>\n");
      out.write("                    </a>\n");
      out.write("                    <p class=\"post-meta\">Posted by <a href=\"#\">Start Bootstrap</a> on July 8, 2014</p>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <!-- Pager -->\n");
      out.write("                <ul class=\"pager\">\n");
      out.write("                    <li class=\"next\">\n");
      out.write("                        <a href=\"#\">Older Posts &rarr;</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1\">\n");
      out.write("                    <ul class=\"list-inline text-center\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <span class=\"fa-stack fa-lg\">\n");
      out.write("                                    <i class=\"fa fa-circle fa-stack-2x\"></i>\n");
      out.write("                                    <i class=\"fa fa-twitter fa-stack-1x fa-inverse\"></i>\n");
      out.write("                                </span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <span class=\"fa-stack fa-lg\">\n");
      out.write("                                    <i class=\"fa fa-circle fa-stack-2x\"></i>\n");
      out.write("                                    <i class=\"fa fa-facebook fa-stack-1x fa-inverse\"></i>\n");
      out.write("                                </span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <span class=\"fa-stack fa-lg\">\n");
      out.write("                                    <i class=\"fa fa-circle fa-stack-2x\"></i>\n");
      out.write("                                    <i class=\"fa fa-github fa-stack-1x fa-inverse\"></i>\n");
      out.write("                                </span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <p class=\"copyright text-muted\">Copyright &copy; Your Website 2016</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Contact Form JavaScript -->\n");
      out.write("    <script src=\"js/jqBootstrapValidation.js\"></script>\n");
      out.write("    <script src=\"js/contact_me.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Theme JavaScript -->\n");
      out.write("    <script src=\"js/clean-blog.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
