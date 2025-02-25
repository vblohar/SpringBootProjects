<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>
<h3>Complete Reservation:  </h3>
Airline: ${flight.operatingAirlines}<br/>
From: ${flight.departureCity}<br/>
To: ${flight.arrivalCity}<br/>

<form action="completeReservation" method="post">
<pre>
<h3>Passenger Details</h3>
First Name: <input type="text" name="passengerFirstName">
Last Name: <input type="text" name="passengerLastName">
Email: <input type="text" name="passengerEmail">
Phone: <input type="text" name="passengerPhone">

<h3>Card Details</h3>
Name on the card: <input type="text" name="nameOnTheCard">
Card Number: <input type="text" name="cardNumber">
Expiry Date: <input type="text" name ="expiryDate">
Three Digit Sec Code: <input type="text" name="securityCode">
<input type="hidden" name="flightId" value="${flight.id}">
<input type="submit" value="confirm"> 
</pre>
</form>
</body>
</html>