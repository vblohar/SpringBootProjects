<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight Registration</title>
</head>
<body>
<h3>Find Flights: </h3>
<form action="findFlights" method="post" >
From: <input type="text" name="from">
To: <input type="text" name="to">
Departure Date: <input type="text" name="departureDate">
<input type="submit" value="Search">

</form>

</body>
</html>