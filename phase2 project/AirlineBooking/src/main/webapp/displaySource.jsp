<%@page import="org.entities.Source"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Source</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

	<%
		List<Source> sources = (List<Source>)request.getAttribute("sources");
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
			
		</tr>
		<%
		
		int i=1;
			for(Source source : sources)
			{
		%>
				<tr>
					<td><%=i%></td>
					<td><%=source.getSourceName() %></td>
					
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