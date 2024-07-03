package org.kh.library.model.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.common.JDBCTemplate;
import org.kh.library.model.dao.CustomerDAO;
import org.kh.library.model.vo.Customer;

public class CustomerService implements CustomerServiceI {
	
	CustomerDAO cDAO;
	
	public CustomerService() {
		super();
		cDAO = new CustomerDAO();
	}

	@Override
	public ArrayList<Customer> selectAllCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Customer> allList = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			allList = cDAO.selectAllCustomer(conn);
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
	public Customer selectNameSearch(String CName) {
		Customer customer = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			customer = cDAO.selectNameSearch(CName, conn);
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
		return customer;
	}

	@Override
	public Customer selectIdSearch(String CId) {
		Customer customer = null;
		try {
			Connection conn = JDBCTemplate.getConnection();
			customer = cDAO.selectIdSearch(CId, conn);
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
		return customer;
	}

	@Override
	public int insertCustomer(Customer customer) {
		int result = 0;
		try {
			Connection conn = JDBCTemplate.getConnection();
			result = cDAO.insertCustomer(customer, conn);
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
	public int updateCustomer(Customer customer) {
		int result = 0;
		try {
			Connection conn = JDBCTemplate.getConnection();
			result = cDAO.updateCustomer(customer, conn);
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
	public int deleteCustomer(String CId) {
		int result = 0;
		try {
			Connection conn = JDBCTemplate.getConnection();
			result = cDAO.deleteCustomer(CId, conn);
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
