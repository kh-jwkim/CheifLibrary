package org.kh.library.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.kh.library.model.vo.Book;

public class BookDAO implements BookStore{
	
	private final String FILE_NAME = "resources/query.properties";
	private Properties prop;
	private String selectOneBook_query;
	private String selectBookList_query;
	private String insertBook_query;
	private String updateBook_query;
	private String deleteBook_query;
	
	public BookDAO() {
		try {
			prop = new Properties();
			Reader reader = new FileReader(FILE_NAME);
			prop.load(reader);
			selectOneBook_query		= prop.getProperty("selectOneBook");
			selectBookList_query	= prop.getProperty("selectBookList");
			insertBook_query		= prop.getProperty("insertBook");
			updateBook_query		= prop.getProperty("updateBook");
			deleteBook_query		= prop.getProperty("deleteBook");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Book> selectAllBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> allList = new ArrayList<Book>();
		try {
			pstmt = conn.prepareStatement(selectBookList_query);
			rset = pstmt.executeQuery();
			while(rset.next())
				allList.add(rsetToBook(rset));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allList;
	}

	@Override
	public Book selectBookOne(int bookNo, Connection conn) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book book = null;
		try {
			pstmt = conn.prepareStatement(selectOneBook_query);
			pstmt.setInt(1, bookNo);
			rset = pstmt.executeQuery();
			if(rset.next())
				book = rsetToBook(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int insertBook(Book book, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(insertBook_query);
			pstmt.setInt(1, book.getBOOK_NO());
			pstmt.setString(2, book.getBOOK_NAME());
			pstmt.setString(3, book.getBOOK_WRITER());
			pstmt.setInt(4, book.getBOOK_PRICE());
			pstmt.setString(5, book.getPUBLISHER());
			pstmt.setString(6, book.getGENRE());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int deleteBook(int bookNo, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(deleteBook_query);
			pstmt.setInt(1, bookNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private Book rsetToBook(ResultSet rset) {
		Book book = new Book();
		try {
			book.setBOOK_NO(rset.getInt("BOOK_NO"));
			book.setBOOK_NAME(rset.getString("BOOK_NAME"));
			book.setBOOK_WRITER(rset.getString("BOOK_WRITER"));
			book.setBOOK_PRICE(rset.getInt("BOOK_PRICE"));
			book.setPUBLISHER(rset.getString("PUBLISHER"));
			book.setGENRE(rset.getString("GENRE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

}
