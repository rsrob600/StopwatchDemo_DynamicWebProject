<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  JSTL not specified so don't have to use  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<%@ page import="java.io.*,java.util.*" %>
<%@ page import = "com.codingdojo.web.models.Timer" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles.css">
	<title>Stopwatch</title>
</head>
<body>

	<div class='container'>
	
		<div id="menu">
			<a href="/StopwatchDemo/Stopwatch?action=start">Start</a>
			<a href="/StopwatchDemo/Stopwatch?action=stop">Stop</a>
			<a href="/StopwatchDemo/Stopwatch?action=reset">Reset</a>
		
			<!-- 
			<table>
				<tr>
					<th><a href="/StopwatchDemo/Stopwatch?action=start">Start</a></th>	
					<th><a href="/StopwatchDemo/Stopwatch?action=stop">Stop</a></th>
					<th><a href="/StopwatchDemo/Stopwatch?action=reset">Reset</a></th>
				</tr>
			</table>
			 -->
		</div>
				
		<div class="timeblock">
			<p>Start: <fmt:formatDate type="time" value="${start}"/></p>
			<p>Current time: <c:out value="${currentTime}"/></p>
			<p>Running time: <c:out value="${deltaTime}"/></p>
		</div>
		
		<div class="dataTable">
		<% 
		// Only for testing >> not recommended to include java code on the JSP (MVC model)
		//ArrayList<Timer> timeTable = (ArrayList<Timer>) Timer.getTimeTable();
		//pageContext.setAttribute("timeTable", timeTable);
		%>
		
			<table>
				<tr>
					<th>Start</th>	
					<th>Stop</th>
					<th>Total</th>
				</tr>
				<c:forEach var="time" items="${timeTable}">
					<tr>
						<td><fmt:formatDate pattern="hh:mm:ss a" value="${time.getStart()}" /></td>
						<td><fmt:formatDate pattern="hh:mm:ss a" value="${time.getStop()}" /></td>
						<td>${time.getDelta()}</td>
					</tr>
				</c:forEach>	
			</table>
		</div>	
		
	</div>
	

</body>
</html>