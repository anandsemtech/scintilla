<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Transaction List</title>
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
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<style>
label {
	margin-left: 20px;
}

#datepicker {
	width: 180px;
	margin: 0 20px 20px 20px;
}

#datepicker>span:hover {
	cursor: pointer;
}
</style>
<script>
	$(function() {
		$("#from_date").datepicker({
			autoclose : true,
			todayHighlight : true
		}).datepicker('update', new Date());
		;
		$("#to_date").datepicker({
			autoclose : true,
			todayHighlight : true
		}).datepicker('update', new Date());
		;
	});
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

						<li class=""><a href="logout">Logout</a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-md-3 ">

				<section class="transact">
				<h5>Welcome ${currentUser.fullname }</h5>
				<p>Last Login : ${currentUser.lastLogin }</p>

				</section>
				<section class="active transact"> <a href="#1a"
					data-toggle="tab">My Account</a> </section>
				<c:choose>
	    			<c:when test="${currentUser.type.name=='Customer'}">
						<section class="transact"> <a href="#2a" data-toggle="tab">Fund Transfer</a> </section>
					</c:when>    
				</c:choose>
				<section class="transact"> <a href="#3a" data-toggle="tab">My
					Profile</a> </section>


			</div>

			<div class="col-md-8 transact">
				<div class="tab-content clearfix">
					<div class="tab-pane active" id="1a">
						<h5>Account Statement</h5>
						<div style="padding: 10px">
							<div class="pull-left">
								<h6> Account No  :  ${currentUser.bcaddress}</h6>
							</div>
							<div class="pull-right">
								<h4 style="text-align: right">
									USD ${currentUser.balance}
								</h4>

							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
							<div class="filter form-inline">
								<form action="" method="post">
									<label>From Date </label>
									<div id="from_date" class="input-group date"
										data-date-format="mm-dd-yyyy">
										<input class="form-control" type="text" readonly
											style="width: 100px; background: #fff;" /> <span
											class="input-group-addon"><i class="fa fa-calendar"></i></span>
									</div>
									<label>To Date </label>
									<div id="to_date" class="input-group date"
										data-date-format="mm-dd-yyyy">
										<input class="form-control" type="text" readonly
											style="width: 100px; background: #fff;" /> <span
											class="input-group-addon"><i class="fa fa-calendar"></i></span>
									</div>
									<button type="submit" class="btn btn-danger">Search</button>
								</form>
							</div>
							<table class="table table-bordered table-hover">
								<tr class="success">
									<th>#</th>
									<th>Date</th>
									<c:if test="${currentUser.type.typeid == 2}">
										<th>Vendor Address</th>
										<th>Debited Amount</th>
									</c:if>
									<c:if test="${currentUser.type.typeid == 1}">
										<th>Customer Address</th>
										<th>Credited Amount</th>
									</c:if>
									
								</tr>
								<c:set var="count" value="0" scope="page" />
								<c:forEach items="${myTransactions}" var="transaction">
									<c:set var="count" value="${count + 1}" scope="page"/>
									<tr>
										<td>${count}</td>
										<td>${transaction.transactiondate}</td>
										<c:if test="${currentUser.type.typeid == 2}">
											<td>${transaction.cutomeraddress}</td>
										</c:if>
										<c:if test="${currentUser.type.typeid == 1}">
											<td>${transaction.user.bcaddress}</td>
										</c:if>
										<td>${transaction.transactionamount}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="tab-pane" id="2a">
						<h5>Transfer Now</h5>
						<div style="padding: 10px">
							<div class="pull-left">
								<h6> Account No  :  ${currentUser.bcaddress}</h6> 
							</div>
							<div class="pull-right">
								<h4 style="text-align: right">
									USD ${currentUser.balance}
								</h4>

							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
							<div class="filter">
								<form action="sendCurreny" method="post">
									<div class="row">
										<div class="col-md-6 form-inline">
											<!-- <select class="form-control">
	
												<option>USD</option>
												<option>CAD</option>
												<option>INR</option>
											</select>  --> USD <input type="text" name="amount" class="form-control" required />
										</div>
										<div class="col-md-6">
											<input type="hidden" name="userid" value="${currentUser.userid }"/>
											<div class="input-group add-on">
												<select class="form-control" id="storeName" name="storeName" required style="width: 350px;">
													<option value="" label="---Select Store---"></option>
													<c:forEach items="${stores}" var="store">
														<option value="${store.bcaddress}">${store.fullname}</option>
													</c:forEach>
												</select>
											</div>
											<div class="clearfix">&nbsp;</div>
											<textarea class="form-control"
												placeholder="Description Maximun no.of characters is 35" name="description" required></textarea>
										</div>
									</div>
									<div class="note">
										<h4>Note</h4>
										<ul>
											<li>1.Daily funds transferlimits-
												<ul>
													<li>Minimum amount 1</li>
													<li>Maximun amount 100000</li>
												</ul>
											</li>
	
										</ul>
									</div>
									<button class="btn btn-danger pull-right">Submit</button>
								</form>
							</div>
						</div>
					</div>
					<div class="tab-pane  contact" id="3a">
						<h5>My Profile</h5>
						<div style="padding: 10px">
							
							<div class="pull-right">
								<h4 style="text-align: right">
									Balance : $${currentUser.balance}
								</h4>
								<img src="${qrcode }" style="height: 150px;">
							</div>
						
							<div class="form-inline">
								<label for="name">Name</label> : <label for="name"> ${currentUser.fullname }</label> 
							</div>
			
							<div class="form-inline">
								<label for="user_name">User Name</label> : <label for="name"> ${currentUser.username }</label> 
							</div>	
							
							<div class="form-inline">
								<label for="user_name">Account Type</label> : <label for="name"> ${currentUser.type.name }</label> 
							</div>
							<div class="form-inline">
								<label for="user_name">Linked Vendor</label> : <label for="name"> ${currentUser.vendor.vendorname }</label> 
							</div>
							<div class="form-inline">
								<label for="user_name">Public Address</label> : <label for="name"> ${currentUser.bcaddress }</label> 
							</div>
							
							<div class="form-inline">
								<label for="number">Contact Number</label> : <label for="name"> ${currentUser.contactnumber }</label> 
							</div>
							<div class="form-inline">
								<label for="email">Email</label> : <label for="name"> ${currentUser.email }</label> 
							</div>
							<div class="form-inline">
								<label for="website">Website</label> : <label for="name"> ${currentUser.website }</label> 
							</div>
							<div class="form-inline">
								<label for="address">Address</label> : <label for="name"> ${currentUser.address }</label> 
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>
		<!-- <footer id="footer">&nbsp;</footer> -->
</body>
</html>