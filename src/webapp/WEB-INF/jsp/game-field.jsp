<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TicTacToe</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">
    </script>
</head>
<body>
<div class="container" style="padding-top: 20%; margin: auto">
    <c:forEach var="i" begin="0" end="2" step="1">
        <div class="row" style="display: flex; justify-content: center;align-items: center;">
            <c:forEach var="j" begin="0" end="2" step="1">
                <c:choose>
                    <c:when test="${fields[i][j] == null}">
                        <div class="col-md-1">
                            <input type="button" class="btn btn-secondary"
                                   onclick="location.href='http://localhost:8085/TicTac_war_exploded/step/${i}/${j}';"
                                   value="Move"/>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-1" style="text-align: center"> <c:out value="${fields[i][j]}"/></div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </c:forEach>
</div>
</body>
</html>
