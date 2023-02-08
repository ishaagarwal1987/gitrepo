<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airline Booking Window</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
						<h3 class="center-align">Welcome to Airline Booking Portal</h3>
						<div class="form">
							<form action="TicketAvailability" method="Post">
								<table>
									<tr>
										<td colspan="2"><p style="color:red;">${requestScope.msg}</p></td>
										
									</tr>
									<tr>
										<td>Source Station</td>
										<td><input type="text" name="source"></td>
									</tr>

									<tr>
										<td>Destination Station</td>
										<td><input type="text" name="destination" /></td>
									</tr>
									
									<tr>
										<td>Date of travel</td>
										<td><input type="date" name="travelDate" /></td>
									</tr>

									<tr>
										<td></td>
										<td><button class="btn" type="submit">Submit</button></td>
									</tr>
									
									<tr>
										
										<td><a href="adminLogin.jsp">Admin Login</a></td>
										<td></td>
									</tr>
									
									
									

								</table>
							</form>
						</div>
						<div class="loader center-align" style="margin: 5px; display:none;">
						
						<h6>Please Wait...</h6>
							<div class="preloader-wrapper big active">
								<div class="spinner-layer spinner-blue-only">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>
							</div>
							
							

						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script>
		
		$(document).ready(function(){console.log("Page is ready..");})
		
		
		</script>

</body>
</html>