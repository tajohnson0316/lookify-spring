<%--
  Created by IntelliJ IDEA.
  User: arman
  Date: 6/16/2023
  Time: 1:26 PM
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
  <div class="d-flex justify-content-between align-items-baseline">
    <div class="d-flex justify-content-start gap-3 fs-3">
      <a href="/songs/new">Add Song</a>
      <span> | </span>
      <a href="/dashboard/top10">Top 10</a>
    </div>
    <form action="/dashboard/search" method="GET" class="d-flex justify-content-center gap-3 fs-3">
      <input name="q" class="form-control" placeholder="Search" value="${q}"/>
      <button type="submit" class="btn btn-primary">Search</button>
    </form>
  </div>
  <div class="d-flex justify-content-center">
    <div class="card w-100">
      <div class="card-header">
        <div class="d-flex justify-content-between align-items-center">
          <h2>Listings - ${listingTitle}</h2>
          <a href="/dashboard">All Songs</a>
        </div>
      </div>
      <div class="card-body">
        <table class="table table-striped table-bordered">
          <thead>
          <tr>
            <th scope="col">Title</th>
            <th scope="col">Artist(s)</th>
            <th scope="col">Rating [1 - 10]</th>
            <th scope="col">Actions</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="song" items="${allSongs}">
            <tr>
              <td>${song.title}</td>
              <td>${song.artist}</td>
              <td>${song.rating}</td>
              <td>
                <div class="d-flex justify-content-center">
                  <form action="/songs/delete/${song.id}" method="post">
                    <div class="btn-group" role="group">
                      <a href="/songs/${song.id}" class="btn btn-primary">
                        View
                      </a>
                      <a href="/songs/edit/${song.id}" class="btn btn-warning">
                        Edit
                      </a>
                      <input type="hidden" name="_method" value="delete">
                      <button type="submit" class="btn btn-danger">Delete</button>
                    </div>
                  </form>
                </div>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
</body>
</html>