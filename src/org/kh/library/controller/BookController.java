package org.kh.library.controller;

import java.util.ArrayList;

import org.kh.library.model.service.BookService;
import org.kh.library.model.vo.Book;

public class BookController implements BookControllerI {
	
	BookService bServ = new BookService();

	@Override
	public ArrayList<Book> selectAllBook() {
		// 1. 전체 책 조회
		ArrayList<Book> allList = null;
		allList = bServ.selectAllBook();
		return allList;
	}

	@Override
	public Book selectBookOne(int bookNo) {
		// TODO Auto-generated method stub
		Book book = null;
		book = bServ.selectBookOne(bookNo);
		return book;
	}

	@Override
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		int result = 0;
		result = bServ.insertBook(book);
		return result;
	}

	@Override
	public int deleteBook(int bookNo) {
		// TODO Auto-generated method stub
		int result = 0;
		result = bServ.deleteBook(bookNo);
		return result;
	}
	
}
