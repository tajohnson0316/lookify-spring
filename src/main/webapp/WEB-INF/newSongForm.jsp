<%--
  Created by IntelliJ IDEA.
  User: arman
  Date: 6/16/2023
  Time: 2:05 PM
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
  <h1>Add Song</h1>
  <form:form action="/songs/new/create" method="post" modelAttribute="song">
    <div class="mb-3">
      <form:label path="title" class="form-label">Title:</form:label>
      <form:input path="title" class="form-control"/>
      <p class="text-danger">
        <form:errors path="title"/>
      </p>
    </div>
    <div class="mb-3">
      <form:label path="artist" class="form-label">Artist(s):</form:label>
      <form:input path="artist" class="form-control"/>
      <p class="text-danger">
        <form:errors path="artist"/>
      </p>
    </div>
    <div class="mb-3">
      <form:label path="rating" class="form-label">Rating:</form:label>
      <form:input path="rating" type="number" class="form-control" min="1" max="10"/>
      <p class="text-danger">
        <form:errors path="rating"/>
      </p>
    </div>
    <div class="d-flex justify-content-end gap-3">
      <a href="/dashboard" class="btn btn-danger" role="button">Cancel</a>
      <button type="submit" class="btn btn-primary">Add Song</button>
    </div>
  </form:form>
</div>
</body>
</html>