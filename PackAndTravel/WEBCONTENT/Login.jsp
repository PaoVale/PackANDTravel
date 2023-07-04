<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Accesso - Pack &amp; Travel</title>
<link rel="stylesheet" href="styles/Login.css"> <!-- Collega il tuo file CSS per lo stile della pagina -->

</head>
<body>
<header>
   <!-- Includi qui l'header della pagina -->
   <%@ include file="Header.jsp" %>
</header>

<main>
   <section class="login-section">
      <h2>Accesso</h2>
      <form>
         <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
         </div>
         <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
         </div>
         <button type="submit">Accedi</button>
      </form>
      <br>
      Non sei registrato? <a href="Registrati.jsp">Iscriviti!</a>
   </section>
</main>

<hr>
<hr>
<footer>
   
   <%@ include file="Footer.jsp" %>
</footer>
</body>
</html>
