<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script>
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}    
</script>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="">
			<nav class="navbar nav-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">VENDOR TRANSCATION</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">

					<ul class="nav navbar-nav pull-right">

						<li class=""><a href="login">Login</a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>

	<div class="container">

		<div class="reg-form">
			<h2>Registration</h2>
			<form style="padding: 2% 10%;" action="registerUser" method="post">
				<div style="padding-top: 10px;padding-bottom:10px;">
					<span style="color: #dbde4d;">${registered}</span>
				</div>
				<div class="form-inline">

					<label for="select"> Account Type </label> 
					<select class="form-control" id="userType" name="userType">
						<option value="" label="---Select Account Type---"></option>
						<c:forEach items="${types}" var="type">
							<option value="${type.typeid}">${type.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-inline">

					<label for="name"> Name</label> <input type="text"
						class="form-control" placeholder=" Name" required id="fullName" name="fullName">
				</div>

				<div class="form-inline">

					<label for="user_name"> User Name</label> <input type="text"
						class="form-control" placeholder=" User Name" required id="userName" name="userName" >
				</div>
				<div class="form-inline">

					<label for="pwd"> Password</label> <input type="password"
						class="form-control" placeholder=" password" required id="password" name="password">
				</div>
				<div class="form-inline">

					<label for="confirm_pwd"> Confirm Password</label> <input
						type="password" class="form-control"
						placeholder=" Confirm password" required id="confirmPassword" name="confirmPassword">
				</div>
				<div class="form-inline">
					<label for="address">Address</label>
					<textarea class="form-control" placeholder="address" id="address" name="address"></textarea>
				</div>
				<div class="form-inline">
					<label for="number">Contact Number</label> <input type="text"
						class="form-control" placeholder="Contact Number"
						onkeypress="return isNumberKey(event)" id="contactNumber" name="contactNumber">
				</div>
				<div class="form-inline">
					<label for="email">Email</label> <input type="text"
						class="form-control" placeholder="Email" required id="email" name="email">
				</div>
				<div class="form-inline">
					<label for="website">Website</label> <input type="text"
						class="form-control" placeholder="Website" id="website" name="website" >
				</div>
				<div style="margin: auto 45%">
					<button type="submit" class="btn btn-primary">Register</button>

				</div>
			</form>
		</div>
	</div>
	<!-- <footer id="footer">&nbsp;</footer> -->
</body>
</html>
