<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:directive.page isELIgnored="false" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTS EXERCISE</title>
</head>
<body>
	<h1 align="center">Vehicle log</h1>

	<div align="center">
		<table border="1">
			<thead>
				<tr>
					<td>id</td>
					<td>Type</td>
					<td>Plate</td>
					<td>Entry</td>
					<td>Exit</td>
					<td>Stayed</td>
					<td>Fee</td>
				</tr>
			</thead>

			<c:forEach var="vehicle" items="${vehicles}">

				<tr>
					<td>${vehicle.id}</td>
					<td>${vehicle.vehicle_type}</td>
					<td>${vehicle.license_plate}</td>
					<td>${vehicle.entry_time}</td>
					<td>${vehicle.exit_time}</td>
					<td>${vehicle.timeStayed}mins</td>
					<td>${vehicle.fee}euro</td>

				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>