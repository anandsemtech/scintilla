<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Add New Vendor</title>
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
<script type="text/javascript">
function showPercentageDiv() {
	var type = $('#userType').val();
	if (type == 1) {
		$('#storePercentageDiv').show();
		$('#customerPercentageDiv').hide();
	} else if (type == 2) {
		$('#storePercentageDiv').hide();
		$('#customerPercentageDiv').show();
	} else {
		$('#storePercentageDiv').hide();
		$('#customerPercentageDiv').hide();
	}
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

		<div class="row">

			<div class="col-md-11 transact">
				<div class="tab-content clearfix">
					<div class="tab-pane active contact" id="3a">
						<h5>Add Vendor</h5> 
						<div>
							<form style="padding: 2% 15%;" action="addNewVendor" method="post">
								<div style="padding-top: 10px;padding-bottom:10px;">
									<span style="color: #b32400;">${errormsg}</span>
								</div>
								<div class="form-inline">
									<label for="vendorname">Vendor Name</label> <input type="text" style="width: 450px;margin: 5px;" class="form-control" placeholder="Vendor Name" required id="vendorname" name="vendorname">
								</div>
				
								<div class="form-inline">
									<label for="user_name">Description</label> <textarea  style="width: 450px;margin: 5px;" class="form-control" placeholder="Vendor Description" required id="description" name="description"></textarea></textarea>
								</div>
								<div class="form-inline">
									<label for="select">Vendor Type </label> 
									<select class="form-control" id="userType" name="userType" required onchange="showPercentageDiv()">
										<option value="" label="---Select Vendor Type---"></option>
										<c:forEach items="${types}" var="type">
											<option value="${type.typeid}">${type.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-inline">
									<label for="number">Contact Number</label> <input type="text" style="width: 450px;margin: 5px;" class="form-control" placeholder="Contact Number" onkeypress="return isNumberKey(event)" id="contactNumber" name="contactNumber">
								</div>
								<div class="form-inline">
									<label for="email">Email</label> <input type="text" style="width: 450px;margin: 5px;" class="form-control" placeholder="Email" required id="email" name="email">
								</div>
								<div class="form-inline">
									<label for="website">Website</label> <input type="text" style="width: 450px;margin: 5px;" class="form-control" placeholder="Website" id="website" name="website" >
								</div>
								<div class="form-inline">
									<label for="address">Address</label>
									<textarea style="width: 450px;margin: 5px;" class="form-control" placeholder="Address" id="address" name="address"></textarea>
								</div>
								<div class="form-inline" style="display: none;" id="storePercentageDiv">
									<label for="email">Store Percentage</label> <input type="number" min="0" style="width: 450px;margin: 5px;" class="form-control" placeholder="Store Percentage (i.e. 2)" id="storepercentage" name="storepercentage">
								</div>
								<div class="form-inline" style="display: none;" id="customerPercentageDiv">
									<label for="email">Customer Percentage</label> <input type="number" min="0" style="width: 450px;margin: 5px;" class="form-control" placeholder="Customer Percentage (i.e. 1)" id="customerpercentage" name="customerpercentage">
								</div>
								<div class="form-inline">
									<label for="balance">Initial Balance</label>
									<input type="number" min="0" style="width: 450px;margin: 5px;" class="form-control" placeholder="Initial Balance" id="initialBalance" name="initialBalance"/>
								</div>
								<div style="margin: auto 45%">
									<button type="submit" class="btn btn-primary">Add</button>
								</div>
							</form>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>
	<!-- <footer id="footer">&nbsp;</footer> -->
</body>
</html>