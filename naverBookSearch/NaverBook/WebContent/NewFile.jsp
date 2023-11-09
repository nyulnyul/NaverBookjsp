<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import ="java.util.List"%>


<!DOCTYPE html>

<html>
<head>
<title>네이버 책 API 예제</title>
</head>
<body>
	<h1>Search Result</h1>
	<%
	    List<String> titles = (List<String>) request.getAttribute("result");
	    if (titles != null) {
	        for (String title : titles) {
	%>
	            <p><%= title %></p>
	<%
	        }
	    } else {
	%>
	        <p>No results found.</p>
	<%
	    }
	%>
	
</body>
</html>
