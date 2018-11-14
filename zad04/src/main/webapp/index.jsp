<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Plane shop</title>
</head>
<body>
<jsp:useBean id="user_session" class="pl.msoroka.javaee.zad04.domain.User" scope="session" />

<h2>Welcome to my shop ${user_session.firstName} ${user_session.lastName} (${user_session.email})</h2>
<p><a href='add-plane'>Add Plane</a></p>
<p><a href='all-planes'>List of Planes</a></p>
<p><a href='cart'>Cart</a></p>
</body>
</html>