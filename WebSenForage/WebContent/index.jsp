<%--
  Created by IntelliJ IDEA.
  User: simplon
  Date: 21-10-2020
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SenForage</title>

    <!-- Custom styles for this template-->
    <link href="public/css/style_log.css" rel="stylesheet">
    <link href="public/css/sb-admin-2.min2.css" rel="stylesheet">
</head>
<body>
    <div class="login-box">
        <h2>Login</h2>
        <form method="post" action="Login">
            <div class="user-box">
                <input type="email" name="email" required="required">
                <label>Email</label>
            </div>
            <div class="user-box">
                <input type="password" name="password" required="required">
                <label>Password</label>
            </div>

                <input class="btn btn-primary" type="submit" value="Valider"/>

            ${erreur}

        </form>
    </div>
</body>
</html>
