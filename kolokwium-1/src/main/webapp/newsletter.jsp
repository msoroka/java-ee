<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Plane shop</title>
</head>
<body>
<%--<jsp:useBean id="user_session" class="pl.msoroka.javaee.kolokwium1.domain.User" scope="session" />--%>

<h1>Witaj w mojej aplikacji, zapisz się do newslettera:</h1>
<form action="sign-newsletter">
    <label for="name">Imię:</label>
    <input type="text" name="name" id="name" required="required"><br>

    <label for="from">Od daty:</label>
    <input type="text" name="from" id="from" required="required"><br>

    <label for="to">Do daty:</label>
    <input type="text" name="to" id="to" required="required"><br>

    <br><label>Częstotliwość:</label><br>
    <input type="radio" name="frequency" value="day">Codziennie<br>
    <input type="radio" name="frequency" value="week">Co tydzień<br>
    <input type="radio" name="frequency" value="month">Co miesiąc<br>

    <br><label >Twoje zainteresowania:</label><br>
    <input type="checkbox" name="planes">Samoloty<br>
    <input type="checkbox" name="cars">Samochody<br>
    <input type="checkbox" name="socks">Skarpetki<br><br>

    <input type="submit" value="Zapisz się">
</form>

</body>
</html>