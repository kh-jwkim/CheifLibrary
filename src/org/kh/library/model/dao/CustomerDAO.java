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

import org.kh.library.model.vo.Customer;

public class CustomerDAO implements CustomerStore {
	
	private final String FILE_NAME = "resources/query.properties";
	private Properties prop;
	private String selectCustomerByName_query;
	private String selectCustomerById_query;
	private String selectCustomerList_query;
	private String insertCustomer_query;
	private String updateCustomer_query;
	private String deleteCustomer_query;

	public CustomerDAO() {
		super();
		try {
			prop = new Properties();
			Reader reader = new FileReader(FILE_NAME);
			prop.load(reader);
			selectCustomerByName_query	= prop.getProperty("selectCustomerByName");
			selectCustomerById_query	= prop.getProperty("selectCustomerById");
			selectCustomerList_query	= prop.getProperty("selectCustomerList");
			insertCustomer_query		= prop.getProperty("insertCustomer");
			updateCustomer_query		= prop.getProperty("updateCustomer");
			deleteCustomer_query		= prop.getProperty("deleteCustomer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Customer> selectAllCustomer(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Customer> allList = new ArrayList<Customer>();
		try {
			pstmt = conn.prepareStatement(selectCustomerList_query);
			rset = pstmt.executeQuery();
			while(rset.next())
				allList.add(rsetToCustomer(rset));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allList;
	}

	private Customer rsetToCustomer(ResultSet rset) {
		Customer customer = new Customer();
		try {
			customer.setUSER_NO(rset.getInt("USER_NO"));
			customer.setUSER_ID(rset.getString("USER_ID"));
			customer.setUSER_NAME(rset.getString("USER_NAME"));
			customer.setUSER_AGE(rset.getInt("USER_AGE"));
			customer.setADDR(rset.getString("ADDR"));
			customer.setGENDER(rset.getString("GENDER"));
			customer.setENROLL_DATE(rset.getDate("ENROLL_DATE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer selectNameSearch(String CName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = null;
		try {
			pstmt = conn.prepareStatement(selectCustomerByName_query);
			pstmt.setString(1, CName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				customer = rsetToCustomer(rset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer selectIdSearch(String CId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = null;
		try {
			pstmt = conn.prepareStatement(selectCustomerById_query);
			pstmt.setString(1, CId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				customer = rsetToCustomer(rset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int insertCustomer(Customer customer, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(insertCustomer_query);
			pstmt.setInt(1, customer.getUSER_NO());
			pstmt.setString(2, customer.getUSER_ID());
			pstmt.setString(3, customer.getUSER_NAME());
			pstmt.setInt(4, customer.getUSER_AGE());
			pstmt.setString(5, customer.getADDR());
			pstmt.setString(6, customer.getGENDER());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateCustomer(Customer customer, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			System.out.println(customer.toString());
			pstmt = conn.prepareStatement(updateCustomer_query);
			pstmt.setString(1, customer.getUSER_NAME());
			pstmt.setString(2, customer.getADDR());
			pstmt.setString(3, customer.getUSER_ID());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteCustomer(String CId, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(deleteCustomer_query);
			pstmt.setString(1, CId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
