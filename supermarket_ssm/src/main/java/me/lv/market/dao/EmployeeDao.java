package me.lv.market.dao;

import java.util.List;

import me.lv.market.pojo.Employee;

public interface EmployeeDao {
	int insertEmployee(Employee employee);

	int deleteEmployee(Employee employee);

	Employee getEmployeeById(String employeeId);

	List<Employee> selectEmployees();

	int updateEmployee(Employee employee);
}
