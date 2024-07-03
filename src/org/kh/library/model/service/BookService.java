package org.kh.library.model.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.common.JDBCTemplate;
import org.kh.library.model.dao.BookDAO;
import org.kh.library.model.vo.Book;

public class BookService implements BookServiceI{

	BookDAO bDAO;
	
	public BookService() {
		super();
		bDAO = new BookDAO();
	}

	@Override
	public ArrayList<Book> selectAllBook() {
		// TODO Auto-generated method stub
		ArrayList<Book> allList = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			allList = bDAO.selectAllBook(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allList;
	}

	@Override
	public Book selectBookOne(int bookNo) {
		// TODO Auto-generated method stub
		Book book = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			book = bDAO.selectBookOne(bookNo, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = JDBCTemplate.getConnection();
			result = bDAO.insertBook(book, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteBook(int bookNo) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = JDBCTemplate.getConnection();
			result = bDAO.deleteBook(bookNo, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
