<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bookapi.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>네이버 책 API 예제</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th {
            background-color: #f2f2f2;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .paging {
            margin-top: 20px;
        }
        .paging a {
            padding: 8px 16px;
            margin-right: 4px;
            border: 1px solid #ddd;
            color: #000;
            text-decoration: none;
        }
        .paging a.active {
            background-color: #6c757d;
            color: white;
            border: 1px solid #6c757d;
        }
        .paging a:hover:not(.active) {
            background-color: #ddd;
        }
        input[type="submit"] {
    background-color: #FFFFE0; /* 옅은 노란색 */
    border: none;
    color: black; /* 옅은 배경에 대비되는 색상 */
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 10px; /* 둥근 모서리 */
    box-shadow: 0 4px #ccc; /* 그림자 효과 */
}

input[type="submit"]:hover {
    background-color: #FFFACD; /* 마우스 오버 시 색상 변경 */
}

input[type="submit"]:active {
    background-color: #FAFAD2;
    box-shadow: 0 2px #ccc;
    transform: translateY(2px); /* 버튼을 눌렀을 때 약간 아래로 이동 */
 input[type="text"] {
        width: 300px; /* 너비 설정 */
        padding: 12px 20px; /* 상하, 좌우 패딩 설정 */
        margin: 8px 0; /* 위아래 마진 설정 */
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px; /* 테두리 둥글게 설정 */
        box-sizing: border-box; /* 박스 사이즈 설정 */
        font-size: 16px; /* 글씨 크기 설정 */
        font-family: Arial, sans-serif; /* 글꼴 설정 */
    }
    
    </style>
</head>
<body>
    <h1>도서 오픈API</h1>
    
    <form method="post" action="SearchBooks">
        검색어 : <input type="text" name="searchKeyword" />
        <input type="submit" value="검색" />
    </form>
    <table>
        <tr>
            <th>책명</th>
            <th>저자</th>
            <th>출판사</th>
            <th>일련번호</th>
            <th>판매가격</th>
            <th>책소개</th>
        </tr>
        <%
            List<Book> bookList = (List<Book>) request.getAttribute("bookList");
            if (bookList != null) {
                for (Book book : bookList) {
        %>
        <tr>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPublisher() %></td>
            <td><%= book.getIsbn() %></td>
            <td><%= book.getPrice() %></td>
            <td><%= book.getDescription() %></td>
        </tr>
        <% 
                }
            }
        %>
    </table>
    <div class="paging">
       <% for(int i = 1; i <= 10; i++) { 
    String currentPageStr = request.getParameter("page");
    String iStr = String.valueOf(i);
    String activeClass = (currentPageStr != null && currentPageStr.equals(iStr)) ? "active" : "";
%>
    <a href="?page=<%= iStr %>" class="<%= activeClass %>"><%= iStr %></a>
<% } %>
    </div>
</body>
</html>