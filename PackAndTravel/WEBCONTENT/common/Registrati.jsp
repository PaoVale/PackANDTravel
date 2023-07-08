<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Registrazione - Pack &amp; Travel</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Registrati.css">
</head>
<body>
    <div class="container">
        <h1>Registrazione</h1>
        <form action="registarsi" method="post">
        <input type="hidden" name="action" value="insert">
           
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
             <div class="form-group">
                <label for="name">Nome:</label>
                <input type="text" id="name" name="name" required>
            </div>
             <div class="form-group">
                <label for="cognome">Cognome:</label>
                <input type="text" id="cognome" name="cognome" required>
            </div>
             <div class="form-group">
                <label for="indirizzo">Indirizzo:</label>
                <input type="text" id="indirizzo" name="indirizzo" required>
            </div>
           <a> <button type="submit">Registrati</button></a>
        </form>
    </div>
</body>
</html>
