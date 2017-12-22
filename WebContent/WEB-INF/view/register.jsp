<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Registration Page</title>
<style type="text/css">
.error{
color:red;
}
body{
    background-color: #525252;
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
.set-center {
text-align:center;
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
</head>
<body style="background-color: RoyalBlue" ng-app="myApp">
 <div class="navbar navbar-default navbar-fixed-top" >
 
  <ul>
   <li class="title"><a href="/Pioneer/home"><h4><b>Pioneer Consulting Services</b></h4></a></li>
   <div class="set-padding">
   <li><a  href="/Pioneer/home">Home</a></li>
   <li><a  href="/Pioneer/login">Login</a></li>
   <li><a  href="/Pioneer/contact">Contact us</a></li>
   <li><a  href="/Pioneer/about">About us</a></li>
   
   </div>
  </ul>
 </div>
 <br/><br/><br/></br>
 
           
   <div class="container" ng-controller="UserController as ctrl">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title"><center>Please sign up</center> </h3>
			 			</div>
			 			<div class="panel-body">
			 			<input type="hidden" ng-model="ctrl.user.id" />
	
	<form:form action="/Pioneer/registerSuccess" ng-submit="ctrl.submit()" name="myForm"
		method="post" modelAttribute="pioneer">
		<table align="center" class="table">
		
			
<tbody>
			<tr>
				<td>FirstName:</td>
				<td><form:input path="firstname" class="form-control" /></td>
				<td><form:errors path="firstname" cssClass="error"/></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input path="lastname" class="form-control"/></td>
				<td><form:errors path="lastname" cssClass="error"/></td>
			</tr>
<tr>
				<td>Street:</td>
				<td><form:input path="address" class="form-control" /></td>
				<td><form:errors path="address" cssClass="error"/></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:select path="state" class="form-control">
						<form:options items="${stateList}" />
					</form:select></td>
				<td><form:errors path="state" cssClass="error" /></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><form:input path="city" class="form-control"/></td>
				<td><form:errors path="city" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><form:input path="zip" class="form-control"/></td>
				<td><form:errors path="zip" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><form:input path="phone" class="form-control" ng-model="ctrl.user.phone"/></td>
				<td><form:errors path="phone" cssClass="error"/></td>

			</tr>
			

			
			<tr>
				<td>Email:</td>
				<td><form:input path="email" class="form-control" ng-model="ctrl.user.email"/></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" class="form-control"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
			<div class="set-center">
				<td><input type="submit" value="Register"  class="btn btn-primary btn-sm"></td>
			</div>
			</tr>
			</tbody>
		</table>

	</form:form>
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