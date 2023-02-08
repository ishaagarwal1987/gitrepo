<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airline Booking Window</title>
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
						<h3 class="center-align">Hi  ${sessionScope.user.firstName}, Welcome to Airline Booking Window</h3>
						<div class="form">
							<form action="" method="Post">
								<table>
								<tr>
										<td colspan="2"><p style="color:red;">${requestScope.msg}</p></td>
										
									</tr>
									<tr>
										<td>1.</td>
										<td><a href="addSource.jsp">Add Source Stations</a></td>
										
									</tr>
									<tr>
										<td>2.</td>
										<td><a href="addDestination.jsp">Add Destination Stations</a></td>
										
									</tr>
									<tr>
										<td>3.</td>
										<td><a href="AddRoute">Add Routes</a></td>
										
									</tr>

									<tr>
										<td>4.</td>
										<td><a href="addAirline.jsp">Add Airlines</a></td>
										
									</tr>
									
									<tr>
										<td>5.</td>
										<td><a href="AddFlight">Add Flights</a></td>
										
									</tr>
									
									<tr>
										<td>6.</td>
										<td><a href="DisplaySource">Display All Source Stations</a></td>
										
									</tr>
									
									<tr>
										<td>7.</td>
										<td><a href="DisplayDestination">Display All Destination Stations</a></td>
										
									</tr>
									
									<tr>
										<td>8.</td>
										<td><a href="DisplayRoutes">Display all routes</a></td>
										
									</tr>
									
									<tr>
										<td>9.</td>
										<td><a href="DisplayAirlines">Display all Airlines</a></td>
										
									</tr>
									
									<tr>
										<td>10.</td>
										<td><a href="DisplayFlights">Display all Flights</a></td>
										
									</tr>
																	
									
									<tr>
										<td>11.</td>
										<td><a href="changePassword.jsp">Change Password</a></td>
										
									</tr>
									<tr>
										<td>12.</td>
										<td><a href="LogoutController">Logout</a></td>
										
									</tr>
									
								</table>
							</form>
						</div>
						
					</div>
			  </div>
			</div>
		</div>
		</div>
		

</body>
</html>