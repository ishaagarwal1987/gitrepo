<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning management System</title>
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
						<h3 class="center-align">Hi  ${sessionScope.user.firstName}, Welcome to Learning Management System</h3>
						<div class="form">
							<form action="" method="Post">
								<table>
								<tr>
										<td colspan="2"><p style="color:red;">${requestScope.msg}</p></td>
										
									</tr>
									<tr>
										<td>1.</td>
										<td><a href="AddStudent">Add Student</a></td>
										
									</tr>

									<tr>
										<td>2.</td>
										<td><a href="addClass.jsp">Add Class</a></td>
										
									</tr>
									
									<tr>
										<td>3.</td>
										<td><a href="addSubject.jsp">Add Subject</a></td>
										
									</tr>
									
									<tr>
										<td>4.</td>
										<td><a href="addTeacher.jsp">Add Teacher</a></td>
										
									</tr>
									
									<tr>
										<td>5.</td>
										<td><a href="DisplayStudents">Display Students</a></td>
										
									</tr>
									
									<tr>
										<td>6.</td>
										<td><a href="DisplayGrades">Display Classes</a></td>
										
									</tr>
									<tr>
										<td>7.</td>
										<td><a href="DisplaySubject">Display Subjects</a></td>
										
									</tr>
									
									<tr>
										<td>8.</td>
										<td><a href="DisplayTeacher">Display Teachers</a></td>
										
									</tr>
									
									<tr>
										<td>9.</td>
										<td><a href="AssignTeacher">Assign Teacher to a class for a subject</a></td>
										
									</tr>
									
									<tr>
										<td>10.</td>
										<td><a href="MapClassToSubject">Assign Subjects to Class</a></td>
										
									</tr>
									
									<tr>
										<td>11.</td>
										<td><a href="ClassReport">Class Report</a></td>
										
									</tr>
									
									<tr>
										<td>12.</td>
										<td><a href="changePassword.jsp">Change Password</a></td>
										
									</tr>
									<tr>
										<td>13.</td>
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