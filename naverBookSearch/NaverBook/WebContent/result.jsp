<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Book Search Results</title>
</head>
<body>
	<h1>Book Search Results</h1>
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