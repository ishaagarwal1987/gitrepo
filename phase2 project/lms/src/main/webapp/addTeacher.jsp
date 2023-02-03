<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>

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
						<h3 class="center-align">Hi  ${sessionScope.user.firstName},</h3>
						<div class="form">
							<form action="AddTeacher" method="Post">
								<table>
								
									<tr>
										<td>Teacher Name</td>
										<td><input type="text" name="t_name"></td>
										
									</tr>

																		
									<tr>
										<td>Address</td>
										<td><input type="text" name="address"></td>
										
									</tr>
									
									<tr>
										<td>Email</td>
										<td><input type="text" name="email"></td>
										
									</tr>
									
									<tr>
										<td>Qualification</td>
										<td>
										<input type="text" name="qualification"></td>
										
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