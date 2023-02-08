<%@page import="org.entities.Flight"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Ticket</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

<%
		Flight flight = (Flight)request.getAttribute("Flight");
%>

<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
						<h3 class="center-align">Hi  ${sessionScope.clientUser.firstName}, Ticket</h3>
						<div class="form">
							<form action="BookTicketController" method="Post">
								<table>
								<tr>
										<td colspan="2"><p style="color:red;">${requestScope.msg}</p></td>
										
									</tr>
									<tr>
										<td>Source </td>
										<td><%= flight.getRoute().getSource().getSourceName() %></td>
										
									</tr>
									<tr>
										<td>Destination </td>
										<td><%= flight.getRoute().getDestination().getDestinationName() %></td>
										
									</tr>
									
									<tr>
										<td>Airline No. </td>
										<td><%= flight.getAirline().getAirline_no() %></td>
										
									</tr>
									<tr>
										<td>Airline Name </td>
										<td><%= flight.getAirline().getAirlineName() %></td>
										
									</tr>
									<tr>
										<td>Take off Date </td>
										<td><%= flight.getTakeoffDate() %></td>
				
									</tr>
									<tr>
										<td>Take off Time </td>
										<td><%= flight.getTakeoffTime() %></td>
				
									</tr>
									
									<tr>
										<td>No. of persons </td>
										<td><input type="text" name="persons"></td>
				
									</tr>
									<tr>
										<td></td>
										<td><button class="btn" type="submit">Book the Ticket</button></td>
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