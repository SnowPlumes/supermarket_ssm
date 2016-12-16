package me.lv.market.dao;

import me.lv.market.pojo.Customer;

public interface CustomerDao {
	Customer getCustomerById(int customerId);
}
