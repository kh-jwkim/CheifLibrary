package org.kh.library.model.vo;

import java.sql.Date;

public class Customer {
	
	private int USER_NO;
	private String USER_ID;
	private String USER_NAME;
	private int USER_AGE;
	private String ADDR;
	private String GENDER;
	private Date ENROLL_DATE;
	
	public Customer() {
		super();
	}

	public Customer(int uSER_NO, String uSER_ID, String uSER_NAME, int uSER_AGE, String aDDR, String gENDER,
			Date eNROLL_DATE) {
		super();
		USER_NO = uSER_NO;
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_AGE = uSER_AGE;
		ADDR = aDDR;
		GENDER = gENDER;
		ENROLL_DATE = eNROLL_DATE;
	}

	public int getUSER_NO() {
		return USER_NO;
	}

	public void setUSER_NO(int uSER_NO) {
		USER_NO = uSER_NO;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public int getUSER_AGE() {
		return USER_AGE;
	}

	public void setUSER_AGE(int uSER_AGE) {
		USER_AGE = uSER_AGE;
	}

	public String getADDR() {
		return ADDR;
	}

	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public Date getENROLL_DATE() {
		return ENROLL_DATE;
	}

	public void setENROLL_DATE(Date eNROLL_DATE) {
		ENROLL_DATE = eNROLL_DATE;
	}

	@Override
	public String toString() {
		return "Customer [USER_NO=" + USER_NO + ", USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME + ", USER_AGE="
				+ USER_AGE + ", ADDR=" + ADDR + ", GENDER=" + GENDER + ", ENROLL_DATE=" + ENROLL_DATE + "]";
	}
	
}
