<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Winner</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">

    </script>
</head>
<body>
<div class="row" style="padding-top: 20%;display: flex; justify-content: center;align-items: center;">
    <c:choose>
        <c:when test="${winner != null}">
            <h1><fmt:message key="label.winner"/> ${winner}</h1>
        </c:when>
        <c:otherwise>
            <h1><fmt:message key="label.no_winner"/></h1>
        </c:otherwise>
    </c:choose>
</div>
<div class="row" style="display: flex; justify-content: center;align-items: center;">
    <input type="button" class="btn btn-secondary"
           onclick="location.href='http://localhost:8085/TicTac_war_exploded/draw';"
           value=" <fmt:message key="label.restart" />"/>
</div>
</div>
<li><a href="?lang=en_US"><fmt:message key="label.lang.en"/></a></li>
<li><a href="?lang=ru_RU"><fmt:message key="label.lang.ru"/></a></li>
</body>
</html>
