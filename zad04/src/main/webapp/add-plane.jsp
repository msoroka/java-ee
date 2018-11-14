<%--
  Created by IntelliJ IDEA.
  User: msoroka
  Date: 14/11/2018
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add plane</title>
</head>
<body>
<h2>Add plane:</h2>
<form action='store-plane'>
    Producer: <input type='text' name='producer' /> <br />
    Production date: <input type='text' name='productionDate' /> <br />
    Combustion: <input type='text' name='combustion' /> <br />
    Price: <input type='text' name='price' /> <br />
    Quantity: <input type='number' name='quantity' /> <br />
    Vip Status: <select name='vipStatus'>
        <option value='true'>Yes</option>
        <option value='false'>No</option>
        </select><br />
    <input type='submit' value=' Add ' />
    </form>
</body>
</html>
