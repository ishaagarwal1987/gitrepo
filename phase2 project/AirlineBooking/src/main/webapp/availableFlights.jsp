<%@page import="org.entities.Flight"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Flights</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

<%
HashMap<Flight,Integer> map = (HashMap<Flight,Integer>)request.getAttribute("availableFlights");
	%>
	<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
	<table border="1">
	<tr>
										<td colspan="2"><p style="color:red;">${requestScope.msg}</p></td>
										
									</tr>
		<tr>
			<td>S.No.</td>
			<td>Airline No</td>
			<td>Airline Name</td>
			<td>Price</td>
			<td>Seats Available</td>
			<td>TakeOff Time</td>
			<td>Book Your Ticket</td>
			
		</tr>
		<%
		int i =1;
		for(Map.Entry m : map.entrySet())
			{
		%>
				<tr>
					<td><%=i %></td>
					<td><%=((Flight)m.getKey()).getAirline().getAirline_no() %></td>
					<td><%=((Flight)m.getKey()).getAirline().getAirlineName() %></td>
					<td><%=((Flight)m.getKey()).getRoute().getTicketPrice() %></td>
					<td><%=m.getValue() %></td>
					<td><%=((Flight)m.getKey()).getTakeoffTime() %></td>
					<td><a href ="BookTicket?flightId=<%=((Flight)m.getKey()).getId() %>">Book your Ticket</a></td>
				</tr>
		<%	
			i++;
			}
		%>
		
		<a href="index.jsp">Go to Home Page</a>
		</table>
</div></div></div></div></div>



</body>
</html>