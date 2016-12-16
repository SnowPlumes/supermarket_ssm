package me.lv.market.dao;

import me.lv.market.pojo.EmployeeLimit;

public interface EmployeeLimitDao {

	EmployeeLimit getLimitById(int id);

	EmployeeLimit getEmployeeLimitByValue(String level);
}
