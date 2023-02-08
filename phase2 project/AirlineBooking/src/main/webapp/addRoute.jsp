<%@page import="org.entities.Source"%>
<%@page import="org.entities.Destination"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Route</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

	<%
		List<Source> sources = (List<Source>) request.getAttribute("sources");
		List<Destination> destinations = (List<Destination>) request.getAttribute("destinations");
	%>


<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
					<h3 class="center-align">Add Route</h3>
						<div class="form">
							<form action="AddRouteController" method="Post">
								<table border="1">
								
								<tr>
										<td>Choose Source Station</td>
										<td><select class="browser-default" name="source"
											id="source">

												<option value="" disabled selected>Choose your
													option</option>
												<%
												for (Source source : sources) {
												%>

												<option value="<%=source.getSource_id() %>"><%=source.getSourceName() %></option>

												<%
												}
												%>

										</select></td>

									</tr>

									<tr>
										<td>Choose Destination Station</td>
										<td><select class="browser-default" name="destination"
											id="destination">

												<option value="" disabled selected>Choose your
													option</option>
												<%
												for (Destination destination : destinations) {
												%>

												<option value="<%=destination.getDestination_id() %>"><%=destination.getDestinationName() %></option>

												<%
												}
												%>

										</select></td>

									</tr>
									
									<tr>
										<td>Ticket Price</td>
										<td><input type="text" name="ticket_price"></td>
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