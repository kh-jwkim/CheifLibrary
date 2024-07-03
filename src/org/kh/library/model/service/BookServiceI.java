package org.kh.library.model.service;

import java.util.ArrayList;

import org.kh.library.model.vo.Book;

public interface BookServiceI {
	public ArrayList<Book> selectAllBook();
	public Book selectBookOne(int bookNo);
	public int insertBook(Book book);
	public int deleteBook(int bookNo);
}
