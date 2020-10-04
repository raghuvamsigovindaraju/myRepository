<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VisitorPage updated</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Visitor Page of Vamsi</h2>
<nav>
<a href="index.jsp">Home</a>
</nav>

<%-- <%String message=(String)request.getAttribute("message"); %>
<%String age=(String)request.getAttribute("age"); %>

<% if(message!=null && age!=null) {%>
   <p><strong><%=message %><em><%=age %>></em></strong>
   <%} %> --%>

<c:choose>
 <c:when test="${message==null}">
 <p>Welcome All!</p>
 </c:when>
 <c:otherwise>
     <p><strong>${message} <em>${age}</em></strong></p>
 </c:otherwise>
</c:choose>
 
<form action="vs">
<Label>Title:
   <select name="title" required>
   <option value="">----Select-----</option>
   <option value="Mr.">Mr</option>
   <option value="Mrs.">Mrs</option>
   <option value="Dr.">Dr</option>
   <option value="Mis">Miss</option>
   </select>
   </Label><br/>
<Label>Full Name: <input type="text" name="fullName" required/></Label><br/>
<Label>Date Of Birth: <input type="date" name="dataOfBirth" required/></Label><br/>
<Button>Submit</Button>
</form>
</body>
</html>