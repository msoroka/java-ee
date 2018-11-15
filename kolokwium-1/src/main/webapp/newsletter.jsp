<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Newsletter</title>
</head>
<body>

<h1>Witaj w mojej aplikacji, zapisz się do newslettera:</h1>
<form action="sign-newsletter">
    <label for="name">Nick:</label>
    <input type="text" name="name" id="name" required="required" value="${sess_news.name}"><br>

    <label for="from">Od daty:</label>
    <input type="text" name="from" id="from" required="required" value="${sess_news.from}"><br>

    <label for="to">Do daty:</label>
    <input type="text" name="to" id="to" required="required" value="${sess_news.to}"><br>

    <br><label>Częstotliwość:</label><br>
    <input type="radio" name="frequency" value="codziennie">Codziennie<br>
    <input type="radio" name="frequency" value="co tydzien">Co tydzień<br>
    <input type="radio" name="frequency" value="co miesiac">Co miesiąc<br>

    <br><label >Twoje zainteresowania:</label><br>
    <input type="checkbox" name="subjects" value="samoloty">Samoloty<br>
    <input type="checkbox" name="subjects" value="samochody">Samochody<br>
    <input type="checkbox" name="subjects" value="skarpetki">Skarpetki<br><br>

    <input type="submit" value="Zapisz się">
</form>

</body>
</html>