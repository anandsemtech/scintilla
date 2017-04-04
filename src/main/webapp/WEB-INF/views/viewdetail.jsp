<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>View Detail</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
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
					<a class="navbar-brand" href="#">Scintilla</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">

					<ul class="nav navbar-nav pull-right">
						 <li class=""><a href="listvendors">Vendors</a></li><li class=""><a href="#">|</a></li><li class=""><a href="listusers">Users</a></li><li class=""><a href="#">|</a></li><li class=""><a href="logout">Logout</a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>

	<div class="container">

			<div class="col-md-11 transact">
				<div class="tab-content clearfix">
					<div class="tab-pane active contact" id="3a">
						<h5>${user.fullname} Profile</h5>
						<div style="padding: 10px">
							
							<div class="pull-right">
								<h4 style="text-align: right">
									Balance : $${user.balance}
								</h4>
								<img src="${qrcode }" style="height: 180px;">
							</div>
						
							<div class="form-inline">
								<label for="name">Name</label> : <label for="name"> ${user.fullname }</label> 
							</div>
			
							<div class="form-inline">
								<label for="user_name">User Name</label> : <label for="name"> ${user.username }</label> 
							</div>
							
							<div class="form-inline">
								<label for="user_name">Account Type</label> : <label for="name"> ${user.type.name }</label> 
							</div>
							
							<div class="form-inline">
								<label for="user_name">Linked Vendor</label> : <label for="name"> ${user.vendor.vendorname }</label> 
							</div>
							
							<div class="form-inline">
								<label for="user_name">Public Address</label> : <label for="name"> ${user.bcaddress }</label> 
							</div>
							
							<div class="form-inline">
								<label for="number">Contact Number</label> : <label for="name"> ${user.contactnumber }</label> 
							</div>
							<div class="form-inline">
								<label for="email">Email</label> : <label for="name"> ${user.email }</label> 
							</div>
							<div class="form-inline">
								<label for="website">Website</label> : <label for="name"> ${user.website }</label> 
							</div>
							<div class="form-inline">
								<label for="address">Address</label> : <label for="name"> ${user.address }</label> 
							</div>
							<br>
							
						</div>
					</div>

				</div>

			</div>

		</div>
		<!-- <footer id="footer">&nbsp;</footer> -->
</body>
</html>