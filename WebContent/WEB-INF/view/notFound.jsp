<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.error{
color:red;
}

.centered-form{
	margin-top: 60px;
}

.centered-form .panel{
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
.set-padding {
    padding-top: 10px;
    float:right;
    font-family:Comic Sans MS;
}

.title {
font-family:Comic Sans MS;
font-size:3.0em;
}

.footer{
    position: fixed;
    left: 0px;
    bottom: 0px;
    height: 35px;
    width: 100%;
   
}

.footer {
   position:fixed;
   left:0px;
   bottom:0px;
   height:30px;
   width:100%;
   
}

</style>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
.foot {
color:white;
text-align: center;
}

li a:hover:not(.active) {
    background-color: WhiteSmoke;
}

.active {
    background-color: #4CAF50;
}
</style>

<title>Home Page</title>
</head>


<body style="background-color: RoyalBlue">
<div class="navbar navbar-default navbar-fixed-top" >
 
 <ul>
   <li class="title"><a href="/Pioneer/home"><h4><b>Pioneer Consulting Services</b></h4></a></li>
   <div class="set-padding">
   <li><a  href="/Pioneer/home">Home</a></li>
   <li><a  href="/Pioneer/register">Register</a></li>
   <li><a  href="/Pioneer/login">Login</a></li>
   <li><a  href="/Pioneer/about">About us</a></li>
   </div>
</ul>
 </div>
 </br></br></br></br>
 
 
<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title"><center>Contact Info</center> </h3>
			 			</div>
			 			<div class="panel-body">

						<h3>Details Not Found</h3>
						
						<p> Please log-in with valid credentials </p>
					    </div>
	    		</div>
    		</div>
    	</div>
    </div>
 
 <div style="background-color: Black" class="footer">
  <div >
   <div class="foot">Copyrights@ Pioneer Consulting Services LLC.</div>
  </div>
 </div>
</body>
</html>