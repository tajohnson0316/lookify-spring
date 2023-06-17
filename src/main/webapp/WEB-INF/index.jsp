<%--
  Created by IntelliJ IDEA.
  User: arman
  Date: 6/15/2023
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<html>
<head>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <script type="text/javascript" src="/js/app.js"></script>
  <title>Lookify</title>
</head>
<body>
  <div class="container">
    <div class="d-flex flex-column align-items-center position-absolute top-50 start-50 translate-middle gap-3">
      <h1>Welcome to Lookify!</h1>
      <a href="/dashboard">Start Looking!</a>
    </div>
  </div>
</body>
</html>