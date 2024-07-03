package org.kh.library.model.vo;

import java.sql.Date;

public class Library {
	private int LEASE_NO;
	private int BOOK_NO;
	private String USER_ID;
	private Date LEASE_DATE;
	private Date RETURN_DATE;
	
	public Library() {
		super();
	}

	public Library(int lEASE_NO, int bOOK_NO, String uSER_ID, Date lEASE_DATE, Date rETURN_DATE) {
		super();
		LEASE_NO = lEASE_NO;
		BOOK_NO = bOOK_NO;
		USER_ID = uSER_ID;
		LEASE_DATE = lEASE_DATE;
		RETURN_DATE = rETURN_DATE;
	}

	public int getLEASE_NO() {
		return LEASE_NO;
	}

	public void setLEASE_NO(int lEASE_NO) {
		LEASE_NO = lEASE_NO;
	}

	public int getBOOK_NO() {
		return BOOK_NO;
	}

	public void setBOOK_NO(int bOOK_NO) {
		BOOK_NO = bOOK_NO;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public Date getLEASE_DATE() {
		return LEASE_DATE;
	}

	public void setLEASE_DATE(Date lEASE_DATE) {
		LEASE_DATE = lEASE_DATE;
	}

	public Date getRETURN_DATE() {
		return RETURN_DATE;
	}

	public void setRETURN_DATE(Date rETURN_DATE) {
		RETURN_DATE = rETURN_DATE;
	}

	@Override
	public String toString() {
		return "Library [LEASE_NO=" + LEASE_NO + ", BOOK_NO=" + BOOK_NO + ", USER_ID=" + USER_ID + ", LEASE_DATE="
				+ LEASE_DATE + ", RETURN_DATE=" + RETURN_DATE + "]";
	}
	
}
