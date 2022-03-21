<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%-- <%@ page import="com.nagarro.model.Book,java.util.List"%> --%>
<%@ page import="com.nagarro.model.Book,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>

	<div class="container">
		<div class="jumbotron">
			<div class="card">
				<form action="logout">
					<div class="card-header text-end" style="text-align: center">
						Welcome ${username}
						<button style="width: 80px;"
							class="btn btn-primary badge bg-light text-dark float-right">Logout</button>
					</div>
				</form>
			</div>
				<div class="card-body">
					<h5 class="card-title" style="text-align: center;">
						Books Listing &nbsp;&nbsp;&nbsp;&nbsp;
						<button
							class="btn btn-primary badge bg-light bg-primary float-right">
							<a href="add">Add a book</a>
						</button>
					</h5>
					<table class="table table-light table-hover table-bordered">
						<caption style="text-align: center;"></caption>
						<thead>
							<tr>
								<th scope="col">Book Code</th>
								<th scope="col">Book Name</th>
								<th scope="col">Author</th>
								<th scope="col">Data Added</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						
						<tbody>

							<c:forEach var="item" items="${list}">
								<tr>
									<td>${item.getBookCode()}</td>
									<td>${item.getBookName()}</td>
									<td>${item.getAuthor().getName()}</td>
									<td>${item.getDate()}</td>


									<td>
										<button
											class="btn btn-primary badge bg-light text-dark rounded-pill float-right"
											style="width: 80px;">
											<a href="editBook?parameter=${item.getBookCode()}">EDIT </a>
										</button>
										<button
											class="btn btn-danger badge bg-light rounded-pill float-right"
											style="width: 80px;">
											<a href="deleteBook?param=${item.getBookCode()}">DELETE</a>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
		</div>
	</div>
</body>
</html>

