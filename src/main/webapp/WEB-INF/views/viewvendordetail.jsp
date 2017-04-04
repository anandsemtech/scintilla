<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>View Vendor Detail</title>
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
						<h5>Vendor Profile</h5>
						<div style="padding: 10px">
							
							<div class="pull-right">
								<h4 style="text-align: right">
									Balance : $${vendor.balance}
								</h4>
								<img src="${qrcode }" style="height: 180px;">
							</div>
						
							<div class="form-inline">
								<label for="name">Vendor Name</label> : <label for="name"> ${vendor.vendorname }</label> 
							</div>
			
							<div class="form-inline">
								<label for="user_name">Description</label> : <label for="name" style="width: 250px;"> ${vendor.description }</label> 
							</div>
							
							<div class="form-inline">
								<label for="user_name">Type</label> : <label for="name" style="width: 250px;"> ${vendor.type.name }</label> 
							</div>
							
							<div class="form-inline">
								<label for="user_name">Public Address</label> : <label for="name"> ${vendor.bcaddress }</label> 
							</div>
							
							<div class="form-inline">
								<label for="number">Contact Number</label> : <label for="name"> ${vendor.contactnumber }</label> 
							</div>
							<div class="form-inline">
								<label for="email">Email</label> : <label for="name"> ${vendor.email }</label> 
							</div>
							<div class="form-inline">
								<label for="website">Website</label> : <label for="name"> ${vendor.website }</label> 
							</div>
							<div class="form-inline">
								<label for="address">Address</label> : <label for="name"> ${vendor.address }</label> 
							</div>
							<c:if test="${vendor.type.typeid == 1}">
								<div class="form-inline">
									<label for="address">Store Percentage</label> : <label for="name"> ${vendor.storepercentage } % </label> 
								</div>
							</c:if>
							<c:if test="${vendor.type.typeid == 2}">
								<div class="form-inline">
									<label for="address">Customer Percentage</label> : <label for="name"> ${vendor.customerpercentage } % </label> 
								</div>
							</c:if>
							<br>
							<h5 style="margin: 0">Users</h5>
							<table class="table table-bordered table-hover">
								<tr class="success">
									<th>#</th>
									<th>Username</th>
									<th>Type</th>
									<th>Contact Number</th>
									<th>Email</th>
									<th>View More</th>
								</tr>
								<c:set var="count" value="0" scope="page" />
								<c:forEach items="${users}" var="user">
									<c:set var="count" value="${count + 1}" scope="page"/>
									<tr>
										<td>${count}</td>
										<td>${user.fullname}</td>
										<td>${user.type.name}</td>
										<td>${user.contactnumber}</td>
										<td>${user.email}</td>
										<td style="text-align: center;"><a href="viewdetail?userid=${user.userid }">View</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>

				</div>

			</div>

		</div>
		<!-- <footer id="footer">&nbsp;</footer> -->
</body>
</html>