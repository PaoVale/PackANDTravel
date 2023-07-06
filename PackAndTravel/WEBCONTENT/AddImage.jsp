<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Image</title>
</head>
<body>
<h1>Add Image</h1>
<form action="AddImageServlet" method="post" enctype="multipart/form-data">
	SElect Image:
	<input type="file" name="image">
	select codice:
	<input type="number" name="codice">
	<input type="submit" value="add image">
	
</form>
</body>
</html>