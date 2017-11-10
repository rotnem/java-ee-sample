<%@page import="java.sql.*" %>
<%@page import="java.text.*" %>
<%@page import="java.util.Date" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <%!
        public class MyPosts{
                   String URL = "jdbc:mysql://localhost:3306/notes";
                   String USERNAME = "root";
                   String PASSWORD = "root";
                    
                   Connection conn = null;
                   PreparedStatement prepPost  = null;
                   ResultSet fetchData = null;
                   
                    public MyPosts(String query){
                        try {
                             conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);   
                             prepPost = conn.prepareStatement(query);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    public int setActors(String title, String subtitle, String description, String author, String date){
                        int result = 0;
                        try {
                              prepPost.setString(1, title);
                              prepPost.setString(2, subtitle);
                              prepPost.setString(3, description);
                              prepPost.setString(4, author);
                              prepPost.setString(5, date);
                              result = prepPost.executeUpdate();
                        } catch (SQLException e) {
                              e.printStackTrace();
                        }
                        
                        return result;
                    }
                    
                    public ResultSet getPosts(){
                            
                        try{
                            fetchData = prepPost.executeQuery();
                        }catch(SQLException e){
                            e.printStackTrace();
                        }

                        return fetchData;
                    }
            }
            
    %>
    
    <%
        MyPosts mp;
        Date date;
        SimpleDateFormat ft;
        
        int result =0;
        String title = new String();
        String description = new String();
        String subtitle = new String();
        String author = new String();
        
        
        if(request.getParameter("title") != null && request.getParameter("description") != null){
            title = request.getParameter("title");
            description = request.getParameter("description");
            subtitle = request.getParameter("subtitle");
            author = "Fortesa Thaqi";
            mp = new MyPosts("Insert into post(p_title,p_subtitle,p_description,p_author,p_date) values(?,?,?,?,?)");
            date = new Date();
            ft = new SimpleDateFormat ("E dd, yyyy");
            result = mp.setActors(title,subtitle,description,author,ft.format(date)+"");
        }
        
        mp = new MyPosts("Select * From post order by p_id desc");
        ResultSet posts = mp.getPosts();
    
    %>
    
    
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
         
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="index.jsp">Start</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                        <a href="contact.html">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('img/home-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1>Fortesa's Blog</h1>
                        <hr class="small">
                        <span class="subheading">A Personal Blog made with Bootstrap and Java</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
		
	
        <div class="row">
			<div class=" col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 form-group">
				<form action="index.jsp" mehtod="post">
				<input class="form-control"  type="text" name="title" placeholder="Title" required/>
				<input class="form-control"  type="text" name ="subtitle" placeholder="Subtitle"/>
				<textarea class="form-control" name= "description" placeholder="Description..." required></textarea>
				<input type="submit" value="Post" class="btn btn-info"/>
				</form>
			</div>
		
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <% while(posts.next()){ %>
                    <div class="post-preview">
                        <a href="post.jsp?post_id=<%= posts.getString("p_id") %>">
                            <h2 class="post-title">
                                <%= posts.getString("p_title") %>
                            </h2>
                            <% if(posts.getString("p_subtitle") != ""){%>
                                <h3 class="post-subtitle">
                                 <%= posts.getString("p_subtitle") %>
                                </h3>
                            <% }%>
                            
                        </a>
                         <p class="post-meta">Posted by <a href="#"><%= posts.getString("p_author") %></a> on <%= posts.getString("p_date") %></p>
                    </div>
                    <hr>
                <% }%>
            </div>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <ul class="list-inline text-center">
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy; Fortesa Thaqi 2017</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/clean-blog.min.js"></script>

</body>

</html>
