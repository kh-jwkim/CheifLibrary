package org.kh.library.model.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.common.JDBCTemplate;
import org.kh.library.model.dao.LibraryDAO;
import org.kh.library.model.vo.Library;

public class LibraryService implements LibraryServiceI {
	
	LibraryDAO lDAO;
	
	public LibraryService() {
		super();
		lDAO = new LibraryDAO();
	}

	@Override
	public ArrayList<Library> selectAll() {
		ArrayList<Library> allList = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			allList = lDAO.selectList(conn);
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
	public Library selectOne(String userId) {
		Library library = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			library = lDAO.selectOne(userId, conn);
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
		return library;
	}

	@Override
	public Library selectOneByName(String bookName) {
		Library library = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			library = lDAO.selectOneByName(bookName, conn);
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
		return library;
	}

	@Override
	public int insertLibrary(Library library) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
