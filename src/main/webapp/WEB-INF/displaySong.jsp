<%--
  Created by IntelliJ IDEA.
  User: arman
  Date: 6/16/2023
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<html>
<head>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <script type="text/javascript" src="/js/app.js"></script>
  
  <title>Lookify</title>
</head>
<body>
<div class="container p-5">
  <div class="card w-100 mb-3">
    <div class="card-header text-center fs-3">
      <c:out value="${song.title}"/>
    </div>
    <div class="card-body">
      <div class="d-flex justify-content-start align-items-center fs-3 gap-3">
        <span class="fw-bold">Arist(s):</span>
        <span><c:out value="${song.artist}"/></span>
      </div>
      <div class="d-flex justify-content-start align-items-center fs-3 gap-3">
        <span class="fw-bold">Rating:</span>
        <span><c:out value="${song.rating}"/>/10</span>
      </div>
    </div>
  </div>
  <div class="d-flex justify-content-end fs-3">
    <a href="/dashboard">Go back</a>
  </div>
</div>
</body>
</html>