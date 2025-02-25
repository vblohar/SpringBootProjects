<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Location</title>
</head>
<body>
	<form action="updateLoc" method="post">	
		<div style="display: flex; flex-direction: column; width: 200px;">
		Id: <input type="text" name="id" value="${location.id}" readonly="true"/>
		Code: <input type="text" name="code" value="${location.code}"/>
		Name: <input type="text" name="name" value="${location.name}"/>
		<div>
		Type: Urban <input type="radio" name="type" value="Urban" ${location.type =='Urban'?'checked':''}/>
			Rural <input type="radio" name="type" value="Rural" ${location.type =='Rural'?'checked':''}/>
			</div>
		<input type="submit" value="update"/>
		</div>
	</form>
	${msg}
	<a href="displayLocations">View All</a>
</body>
</html>