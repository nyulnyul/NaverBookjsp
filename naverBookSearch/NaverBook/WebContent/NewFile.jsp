<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, bookapi.NaverApi, bookapi.BookJsonParser, bookapi.Book" %>
<!DOCTYPE html>
<html>
<head>
<title>네이버 책 API 예제</title>
</head>
<body>
    <h1>Search Result</h1>
    <%
        NaverApi api = new NaverApi();
        BookJsonParser parser = new BookJsonParser();
        String json = api.searchBook("축구"); //검색되고자 하는 키워드
        List<Book> bookList = parser.parseJson(json);
    %>

    <table>
        <tr>
            <th>제목</th>
          
        </tr>
        <% for (Book book : bookList) { %>
        <tr>
            <td><%= book.getTitle() %></td>

        </tr>
        <% } %>
    </table>
</body>
</html>
