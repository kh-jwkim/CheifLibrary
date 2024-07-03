package org.kh.library.controller;

import java.util.ArrayList;

import org.kh.library.model.service.CustomerService;
import org.kh.library.model.vo.Customer;

public class CustomerController implements CustomerControllerI {
	
	CustomerService cServ = new CustomerService();

	@Override
	public ArrayList<Customer> selectAllCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Customer> allList = null;
		allList = cServ.selectAllCustomer();
		return allList;
	}

	@Override
	public Customer selectNameSearch(String CName) {
		// TODO Auto-generated method stub
		Customer customer = null;
		customer = cServ.selectNameSearch(CName);
		return customer;
	}

	@Override
	public Customer selectIdSearch(String CId) {
		// TODO Auto-generated method stub
		Customer customer = null;
		customer = cServ.selectIdSearch(CId);
		return customer;
	}

	@Override
	public int insertCustomer(Customer customer) {
		int result = cServ.insertCustomer(customer);
		return result;
	}

	@Override
	public int updateCustomer(Customer customer) {
		int result = cServ.updateCustomer(customer);
		return result;
	}

	@Override
	public int deleteCustomer(String CId) {
		int result = cServ.deleteCustomer(CId);
		return result;
	}

}
