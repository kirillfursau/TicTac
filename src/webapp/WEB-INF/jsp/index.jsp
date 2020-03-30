<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<html>
<head><title>Welcome page</title></head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">

</script>
<body>
<div class="row" style="padding-top: 20%;display: flex; justify-content: center;align-items: center;">
    <h2><fmt:message key="label.welcome"/></h2>
</div>
<div class="row" style="display: flex; justify-content: center;align-items: center;">
    <input type="button" class="btn btn-secondary"
           onclick="location.href='${pageContext.request.contextPath}/draw';"
           value="<fmt:message key="label.start_game"/>"/>
</div>
</body>

</html>
