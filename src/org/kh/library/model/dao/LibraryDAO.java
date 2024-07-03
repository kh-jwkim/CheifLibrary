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
import org.kh.library.model.vo.Library;

public class LibraryDAO implements LibraryStore {
	
	private final String FILE_NAME = "resources/query.properties";
	private Properties prop;
	private String selectLibraryByName;
	private String selectLibraryById;
	private String selectLibraryList_query;
	private String insertLibrary_query;
	private String updateLibrary_query;
	private String deleteLibrary_query;
	
	public LibraryDAO() {
		try {
			prop = new Properties();
			Reader reader = new FileReader(FILE_NAME);
			prop.load(reader);
			selectLibraryByName		= prop.getProperty("selectLibraryByName");
			selectLibraryById		= prop.getProperty("selectLibraryById");
			selectLibraryList_query	= prop.getProperty("selectLibraryList");
			insertLibrary_query		= prop.getProperty("insertLibrary");
			updateLibrary_query		= prop.getProperty("updateLibrary");
			deleteLibrary_query		= prop.getProperty("deleteLibrary");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Library> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Library> allList = new ArrayList<Library>();
		try {
			pstmt = conn.prepareStatement(selectLibraryList_query);
			rset = pstmt.executeQuery();
			while(rset.next())
				allList.add(rsetToLibrary(rset));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allList;
	}

	@Override
	public Library selectOne(String userId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Library library = null;
		try {
			pstmt = conn.prepareStatement(selectLibraryById);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next())
				library = rsetToLibrary(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return library;
	}

	@Override
	public Library selectOneByName(String bookName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Library library = null;
		try {
			pstmt = conn.prepareStatement(selectLibraryByName);
			pstmt.setString(1, bookName);
			rset = pstmt.executeQuery();
			if(rset.next())
				library = rsetToLibrary(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return library;
	}

	@Override
	public int insertLibrary(Library library, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Library rsetToLibrary(ResultSet rset) {
		Library library = new Library();
		try {
			library.setLEASE_NO(rset.getInt("LEASE_NO"));
			library.setBOOK_NO(rset.getInt("BOOK_NO"));
			library.setUSER_ID(rset.getString("USER_ID"));
			library.setLEASE_DATE(rset.getDate("LEASE_DATE"));
			library.setRETURN_DATE(rset.getDate("RETURN_DATE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return library;
	}

}
