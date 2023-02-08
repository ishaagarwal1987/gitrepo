<%@page import="org.entities.Route"%>
<%@page import="org.entities.Airline"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flights</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

<%
		List<Route> routes = (List<Route>) request.getAttribute("routes");
		List<Airline> airlines = (List<Airline>) request.getAttribute("airlines");
	%>

<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
						<h3 class="center-align">Hi  ${sessionScope.user.firstName}, Add Flights</h3>
						<div class="form">
							<form action="AddFlightController" method="Post">
								<table>
								
									<tr>
										<td>Choose a Route</td>
										<td><select class="browser-default" name="route"
											id="route">

												<option value="" disabled selected>Choose your
													option</option>
												<%
												for (Route route : routes) {
												%>

												<option value="<%=route.getId() %>"><%=route.getSource().getSourceName() %> To <%=route.getDestination().getDestinationName() %></option>

												<%
												}
												%>

										</select></td>
										
									</tr>
									
									<tr>
										<td>Choose an Airline</td>
										<td><select class="browser-default" name="airline"
											id="airline">

												<option value="" disabled selected>Choose your
													option</option>
												<%
												for (Airline airline : airlines) {
												%>

												<option value="<%=airline.getId() %>"><%=airline.getAirline_no() %> - <%=airline.getAirlineName() %> </option>

												<%
												}
												%>

										</select></td>
										
									</tr>
									
									<tr>
										<td>Takeoff Date</td>
										<td><input type="date" name="date"></td>
										
									</tr>
									<tr>
										<td>Takeoff Time</td>
										<td><input type="time" name="time" min="00:00" max="23:59"></td>
										
									</tr>
									
									<tr>
										<td><a href="home.jsp">Go to Home Page</a></td>
										<td><button class="btn" type="submit">Submit</button></td>
									</tr>
									
									<tr>
										<td colspan="2"><p style="color:red;">${requestScope.msg}</p></td>
										
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