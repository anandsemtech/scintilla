<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>List Vendors</title>
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
					<a class="navbar-brand" href="#">VENDOR TRANSCATION</a>
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

		<div class="row">

			<div class="col-md-11 transact">
				<div class="tab-content clearfix">
					<div class="tab-pane active contact" id="3a">
						<h5>Vendor List <a href="addvendor" style="float:right;">Add Vendor</a></h5> 
						<div style="padding: 10px">
							<table class="table table-bordered table-hover">
								<tr class="success">
									<th>#</th>
									<th>Vendor Name</th>
									<th>Description</th>
									<th>Type</th>
									<th>Contact Number</th>
									<th>Email</th>
									<th>View More</th>
								</tr>
								<c:set var="count" value="0" scope="page" />
								<c:forEach items="${vendors}" var="vendor">
									<c:set var="count" value="${count + 1}" scope="page"/>
									<tr>
										<td>${count}</td>
										<td>${vendor.vendorname}</td>
										<td>${vendor.description}</td>
										<td>${vendor.type.name }</td>
										<td>${vendor.contactnumber}</td>
										<td>${vendor.email}</td>
										<td style="text-align: center;"><a href="viewvendordetail?vendorid=${vendor.vendorid }">View</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>
	<!-- <footer id="footer">&nbsp;</footer> -->
</body>
</html>