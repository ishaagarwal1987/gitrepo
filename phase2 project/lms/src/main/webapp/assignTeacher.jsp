<%@page import="org.entities.Grade"%>
<%@page import="org.entities.Subject"%>
<%@page import="org.entities.Teacher"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>


	<%
	List<Grade> grades = (List<Grade>) request.getAttribute("grades");
	List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
	%>
	<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
					<h3 class="center-align">Assign Teacher to Subject to Classes</h3>
						<div class="form">
							<form action="AssignteacherController" method="Post">
								<table border="1">
								
								<tr>
										<td>Teacher</td>
										<td><select class="browser-default" name="teacher"
											id="grade">

												<option value="" disabled selected>Choose your
													option</option>
												<%
												for (Teacher teacher : teachers) {
												%>

												<option value="<%=teacher.getT_id()%>"><%=teacher.getName()%></option>

												<%
												}
												%>

										</select></td>

									</tr>

									<tr>
										<td>Grade</td>
										<td><select class="browser-default" name="grade"
											id="grade">

												<option value="" disabled selected>Choose your
													option</option>
												<%
												for (Grade grade : grades) {
												%>

												<option value="<%=grade.getId()%>"><%=grade.getName()%></option>

												<%
												}
												%>

										</select></td>

									</tr>
									<tr>
										<td>Choose Subjects</td>
										<td>
											<%
											for (Subject subject : subjects) {
											%> <label><input class="filled-in" type="checkbox" id="<%=subject.getName()%>"
											name="subject" value="<%=subject.getSub_id()%>">
											<span> <%=subject.getName()%></span></label><br>

											<%
											}
											%>
										</td>

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