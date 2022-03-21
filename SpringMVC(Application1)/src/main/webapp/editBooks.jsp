<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<form action="edit">
		<div class="card ">
			<div class="card-header text-end">
				<h5>
					Welcome SHIV &nbsp;
					<button type="button" class="btn btn-outline-info">Logout</button>
				</h5>
			</div>
			<div class="card-body">
				<h4 class="card-title text-center">Edit Book Details</h4>
			</div>


			<div style="margin-left: 25%;">

				<div class="mb-3 row">
					<label for="Book Code" class="col-sm-2 col-form-label">Book
						Code</label>
					<div class="col-sm-4">
						<input type="number" name="bookCode" class="form-control"
							value="${list.get(0).getBookCode()}" readonly>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="Book Name" class="col-sm-2 col-form-label">Book
						Name</label>
					<div class="col-sm-4">
						<input type="text" name="bookName" class="form-control"
							value="${list.get(0).getBookName()}" required>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="Author" class="col-sm-2 col-form-label">Author</label>
					<div class="col-sm-4">
						 <select id="Author" class="form-control" name="author" required>
							<c:forEach var="item" items="${authorList}">
								<option   <c:if test="${item.getID() == list.get(0).getAuthor().getID()}"> selected </c:if> value="${item.getName()}">${item.getName()}</option>
								
							</c:forEach> 
						</select>
						<div class="select-dropdown"></div>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="Added On" class="col-sm-2 col-form-label">Added
						On</label>
					<div class="col-sm-4">
						<input type="text" id="Added On" class="form-control" name="date"
							value="${list.get(0).getDate()}" readonly>
					</div>
				</div>
				<div style="margin-left: 20px; padding: 15px;">
					<button type="submit" value="update" class="btn btn-primary">Submit</button>
					<button type="reset" value="Clear" class="btn btn-danger">Cancel</button>
				</div>
			</div>
			<div style="background-color: rgb(179, 218, 241);"
				class="card-footer text-center">Footer goes here</div>
		</div>

	</form>
</body>
</html>
