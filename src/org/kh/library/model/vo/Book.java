package org.kh.library.model.vo;

public class Book {
	private int BOOK_NO;
	private String BOOK_NAME;
	private String BOOK_WRITER;
	private int BOOK_PRICE;
	private String PUBLISHER;
	private String GENRE;
	
	public Book() {
		super();
	}

	public Book(int bOOK_NO, String bOOK_NAME, String bOOK_WRITER, int bOOK_PRICE, String pUBLISHER, String gENRE) {
		super();
		BOOK_NO = bOOK_NO;
		BOOK_NAME = bOOK_NAME;
		BOOK_WRITER = bOOK_WRITER;
		BOOK_PRICE = bOOK_PRICE;
		PUBLISHER = pUBLISHER;
		GENRE = gENRE;
	}

	public int getBOOK_NO() {
		return BOOK_NO;
	}

	public void setBOOK_NO(int bOOK_NO) {
		BOOK_NO = bOOK_NO;
	}

	public String getBOOK_NAME() {
		return BOOK_NAME;
	}

	public void setBOOK_NAME(String bOOK_NAME) {
		BOOK_NAME = bOOK_NAME;
	}

	public String getBOOK_WRITER() {
		return BOOK_WRITER;
	}

	public void setBOOK_WRITER(String bOOK_WRITER) {
		BOOK_WRITER = bOOK_WRITER;
	}

	public int getBOOK_PRICE() {
		return BOOK_PRICE;
	}

	public void setBOOK_PRICE(int bOOK_PRICE) {
		BOOK_PRICE = bOOK_PRICE;
	}

	public String getPUBLISHER() {
		return PUBLISHER;
	}

	public void setPUBLISHER(String pUBLISHER) {
		PUBLISHER = pUBLISHER;
	}

	public String getGENRE() {
		return GENRE;
	}

	public void setGENRE(String gENRE) {
		GENRE = gENRE;
	}

	@Override
	public String toString() {
		return "Book [BOOK_NO=" + BOOK_NO + ", BOOK_NAME=" + BOOK_NAME + ", BOOK_WRITER=" + BOOK_WRITER
				+ ", BOOK_PRICE=" + BOOK_PRICE + ", PUBLISHER=" + PUBLISHER + ", GENRE=" + GENRE + "]";
	}
	
}
