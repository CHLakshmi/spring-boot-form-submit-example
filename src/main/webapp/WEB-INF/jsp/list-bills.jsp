<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-3">
			<input type="button" value="Students"
				onclick="window.location.href='/list'; return false;"
				class="btn btn-primary" /> <br />
		</div>
		<div class="col-sm-3">
			<input type="button" value="bills"
				onclick="window.location.href='listBills'; return false;"
				class="btn btn-primary" /> <br />
		</div>
		<div class="col-sm-3">
			<input type="button" value="Match bills"
				onclick="window.location.href='matchBills'; return false;"
				class="btn btn-primary" /> <br />
		</div>
		<div class="col-sm-3">
			<input type="button" value="Download"
				onclick="window.location.href='download'; return false;"
				class="btn btn-primary" /> <br />
		</div>
	</div>

	<div class="container">
		<h2>Bills list</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>student_id</th>
					<th>amount</th>
				</tr>
			</thead>
			<!-- loop over and print our customers -->
			<c:forEach var="tempbill" items="${bills}">
				<tr>
					<td>${tempbill.bill_id}</td>
					<td>${tempbill.student_id}</td>
					<td>${tempbill.bill_amount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>
