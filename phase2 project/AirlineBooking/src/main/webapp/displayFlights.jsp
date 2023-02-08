<%@page import="org.entities.Flight"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flights</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

	<%
		List<Flight> flights = (List<Flight>)request.getAttribute("flights");
	%>
	<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
	<table border="1">
		<tr>
			<td>S.No.</td>
			<td>Source Stations</td>
			<td>Destination Stations</td>
			<td>Airline No</td>
			<td>Airline Name</td>
			<td>Take Off Date</td>
			
		</tr>
		<%
		int i =1;
			for(Flight flight : flights)
			{
		%>
				<tr>
					<td><%=i %></td>
					<td><%=flight.getRoute().getSource().getSourceName() %></td>
					<td><%=flight.getRoute().getDestination().getDestinationName() %></td>
					<td><%=flight.getAirline().getAirline_no() %></td>
					<td><%=flight.getAirline().getAirlineName() %></td>
					<td><%=flight.getTakeoffDate() %></td>
				</tr>
		<%	
			i++;
			}
		%>
		
		<a href="home.jsp">Go to Home Page</a>
		</table>
</div></div></div></div></div>


</body>
</html>