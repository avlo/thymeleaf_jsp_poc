<%--
  Created by IntelliJ IDEA.
  User: M259408
  Date: 1/25/2024
  Time: 5:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <title>First Web Application</title>
</head>

<body>
<font color="red">${errorMessage}</font>
<form method="post">
  Name : <input type="text" name="name" />
  Password : <input type="password" name="password" />
  <input type="submit" />
</form>
</body>

</html>
