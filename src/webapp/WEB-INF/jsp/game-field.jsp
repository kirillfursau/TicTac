<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="i" begin="0" end="2" step="1">
        <tr>
            <c:forEach var="j" begin="0" end="2" step="1">
                <c:choose>
                    <c:when test="${fields[i][j] == null}">
                        <td><input type="button"
                                   onclick="location.href='http://localhost:8085/TicTac_war_exploded/step/${i}/${j}';"
                                   value="Move"/></td>
                    </c:when>
                    <c:otherwise>
                        <td><c:out value="${fields[i][j]}"/></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
