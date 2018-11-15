<%--
  Created by IntelliJ IDEA.
  User: msoroka
  Date: 15/11/2018
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks</title>
</head>
<body>
<jsp:useBean id="sess_news" class="pl.msoroka.javaee.kolokwium1.domain.Newsletter" scope="session" />

<h1>Dziękujemy za zapisanie do newslettera ${sess_news.name} </h1>
<p>Będziesz otrzymywał wiadomości od ${sess_news.from} do ${sess_news.to} (${sess_news.frequency})</p>
<p>Wybrane tematy: ${sess_news.subjects}</p>

<a href="newsletter.jsp"><button>Zmień ustawienia</button></a>

</body>
</html>
