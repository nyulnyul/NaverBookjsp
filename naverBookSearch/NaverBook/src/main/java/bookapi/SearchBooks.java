package bookapi;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchBooks extends HttpServlet {
    private static final int BOOKS_PER_PAGE = 10; // 한 페이지당 표시할 책의 수

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchKeyword = request.getParameter("searchKeyword");
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            searchKeyword = "%";
        } else {
            searchKeyword = "%" + searchKeyword.trim() + "%";
        }
        
        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1; // 기본 페이지 번호는 1
        }

        List<Book> bookList = searchBooksInDatabase(searchKeyword, page);
        request.setAttribute("bookList", bookList);
        request.setAttribute("currentPage", page);
        request.setAttribute("searchKeyword", searchKeyword.replace("%", "")); // 검색어에서 % 기호 제거

        RequestDispatcher dispatcher = request.getRequestDispatcher("/NewFile.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private List<Book> searchBooksInDatabase(String searchKeyword, int page) throws ServletException {
        List<Book> bookList = new ArrayList<>();
        int offset = (page - 1) * BOOKS_PER_PAGE;

        // 데이터베이스 연결 정보
        String url = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
        String dbUser = "root"; // MySQL 사용자 이름
        String dbPass = "1234"; // MySQL 사용자 비밀번호

        // MySQL JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("MySQL JDBC driver not found", e);
        }

        // 데이터베이스 연결 및 쿼리 실행
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM books WHERE title LIKE ? LIMIT ? OFFSET ?")) {
            
            pstmt.setString(1, searchKeyword);
            pstmt.setInt(2, BOOKS_PER_PAGE);
            pstmt.setInt(3, offset);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setPrice(rs.getString("price"));
                    book.setDescription(rs.getString("description"));
                    bookList.add(book);
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database access error", e);
        }

        return bookList;
    }
}