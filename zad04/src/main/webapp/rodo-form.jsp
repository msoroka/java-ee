<%--
  Created by IntelliJ IDEA.
  User: msoroka
  Date: 08/11/2018
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rodo form</title>
</head>
<body>
<form action="rodo-check">
    <p>If you want to get to my shop, you have to accept privacy policy.</p>
    <label for="firstName">First name:</label>
    <input type="text" name="firstName" id="firstName" required="required"><br>

    <label for="lastName">Last name:</label>
    <input type="text" name="lastName" id="lastName" required="required"><br>

    <label for="email">E-mail:</label>
    <input type="text" name="email" id="email" required="required"><br>

    <label for="rodo">I accept privacy policy:</label>
    <input type="checkbox" name="rodo" id="rodo" required="required"><br>

    <input type="submit" value="Send">
</form>
</body>
</html>



<%--out.println("<html><body><h2>Add plane:</h2>" +--%>
<%--"<form action='store-plane'>" +--%>
<%--"Producer: <input type='text' name='producer' /> <br />" +--%>
<%--"Production date: <input type='text' name='productionDate' /> <br />" +--%>
<%--"Combustion: <input type='text' name='combustion' /> <br />" +--%>
<%--"Price: <input type='text' name='price' /> <br />" +--%>
<%--"Quantity: <input type='number' name='quantity' /> <br />" +--%>
<%--"Vip Status: <select name='vipStatus'>" +--%>
    <%--"<option value='true'>Yes</option>" +--%>
    <%--"<option value='false'>No</option>" +--%>
    <%--"</select><br />" +--%>
<%--"<input type='submit' value=' Add ' />" +--%>
<%--"</form>" +--%>
<%--"</body></html>");--%>
<%--out.close();--%>