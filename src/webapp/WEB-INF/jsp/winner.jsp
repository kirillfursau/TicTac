<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Winner</title>
</head>
<body>
The winner is ${winner}
<br/>
<input type="button"
       onclick="location.href='http://localhost:8085/TicTac_war_exploded/draw';"
       value="Restart"/>
</body>
</html>
