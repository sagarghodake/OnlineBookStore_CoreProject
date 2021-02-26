package com.shashank.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shashank.bookstore.dao.CustomerDao;
import com.shashank.bookstore.pojo.Customer;
import com.shashank.bookstore.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con = DBConnection.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sqlQuery;

	@Override
	public boolean save(Customer customer) {
		
		sqlQuery = "insert into customer_ct2425 (custFName,custLName,custEmailId,custMobileNo,custPassword,custAddress) values(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, customer.getCustFName());
			ps.setString(2, customer.getCustLName());
			ps.setString(3, customer.getCustEmailId());
			ps.setString(4, customer.getCustMobileNo());
			ps.setString(5, customer.getCustPassword());
			ps.setString(6, customer.getCustAddress());
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		sqlQuery="update customer_ct2425 set custFName=?,custLName=?,custEmailId=?,custMobileNo=?,custPassword=?,custAddress=? where custId=?";
		return false;
	}

	@Override
	public boolean delete(int custId) {
		sqlQuery="delete from customer_ct2425 where custId=?";
		return false;
	}

	@Override
	public List<Customer> getAll() {
		sqlQuery="select * from customer_ct2425";
		return null;
	}

	@Override
	public Customer getById(int custId) {
		sqlQuery="select * from customer_ct2425 where custId=?";
		return null;
	}

	@Override
	public Customer getByEmailId(String custEmailId) {
		sqlQuery="select * from customer_ct2425 where custEmailId=?";
		return null;
	}

}
