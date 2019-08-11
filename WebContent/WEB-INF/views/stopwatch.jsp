<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  JSTL not specified so don't have to use  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<%@ page import = "com.codingdojo.web.models.Timer" %>
<!DOCTYPE html>

<!--testing array data presentation in html table -->
<%
String[][] timeData = {
{"10:00 a.m.", "10:19 a.m.", "19m 20s"},
{"10:30 a.m.", "10:34 a.m.", "4m 8s"},
{"10:52 a.m.", "11:02 a.m.", "10m 20s"},
{"12:00 p.m.", "12:01 p.m", "1m 3s"},
{"1:32 p.m.", "1:34 p.m", "2m 5s"}
};
request.setAttribute("arrTime", timeData);
%>


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
			<p>Running time: <c:out value="${delta}"/></p>
		</div>
		
		
		<!--  using testing array data from Timer model and Controller  -->
		<div class="dataTable">
			<table>
				<tr>
					<th>Start</th>	
					<th>Stop</th>
					<th>Total</th>
				</tr>
				<c:forEach var="time" items="${timeTable}">
					
					<tr>
						<td>"${time[0]}"</td>
						<td>"${time[1]}"</td>
						<td>"${time[2]}"</td>
					</tr>
						
				</c:forEach>	
			</table>
		</div>
			
		

		<fmt:formatDate type="time" value="${newTR.getStart()}"/>
		<fmt:formatDate type="time" value="${newTR.getStop()}"/>
		<c:out value="${newTR.getDelta()}"/>
		<!--  using testing array data from above  
		<table>
			<tr>
				<th>Start</th>	
				<th>Stop</th>
				<th>Total</th>
			</tr>
			<c:forEach var="time" items="${arrTime}">
			
				<tr>
					<td>"${time[0]}"</td>
					<td>"${time[1]}"</td>
					<td>"${time[2]}"</td>
				</tr>
				
			</c:forEach>	
		</table>
		-->
	
	
	</div>
	

</body>
</html>