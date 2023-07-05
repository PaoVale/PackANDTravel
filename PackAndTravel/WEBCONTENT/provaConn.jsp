<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.ConnectionDB" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connessione</title>
</head>
<body>
<h1>Connessione al DataBase</h1>

<% out.print(ConnectionDB.getConnection());  %>
<br>


<br>
 <h1>Homepage</h1>
    <p>Benvenuto nella pagina principale.</p>
    
    <form method="post" action="Login.jsp">
        <input type="submit" value="Vai al Login">
    </form>
</body>
</html>