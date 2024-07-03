package org.kh.library.controller;

import java.util.ArrayList;

import org.kh.library.model.service.LibraryService;
import org.kh.library.model.vo.Book;
import org.kh.library.model.vo.Library;

public class LibraryController implements LibraryControllerI {
	
	LibraryService lServ = new LibraryService();

	@Override
	public ArrayList<Library> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Library> allList = null;
		allList = lServ.selectAll();
		return allList;
	}

	@Override
	public Library selectOne(String userId) {
		// TODO Auto-generated method stub
		Library library = null;
		library = lServ.selectOne(userId);
		return library;
	}

	@Override
	public Library selectOneByName(String bookName) {
		Library library = null;
		library = lServ.selectOneByName(bookName);
		return library;
	}

	@Override
	public int insertLibrary(Library library) {
		// TODO Auto-generated method stub
		return 0;
	}

}
