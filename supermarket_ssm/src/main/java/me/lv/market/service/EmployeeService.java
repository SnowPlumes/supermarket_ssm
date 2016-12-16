package me.lv.market.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lv.market.pojo.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();

	Employee getEmployeeById(String employeeId);

	int updateEmployee(Employee employee);

	int deleteEmployee(Employee employee);

	int insertEmployee(Employee employee);

	/**
	 * 
	 * @param request
	 * @param response
	 * @return 跳转的页面
	 */
	String login(HttpServletRequest request, HttpServletResponse response);

	void updatePersonalInfo(HttpServletRequest request, HttpServletResponse response);

	String chPassword(HttpServletRequest request, HttpServletResponse response);

	int deleteEmployee(HttpServletRequest request, HttpServletResponse response);

	int chEmployee(HttpServletRequest request, HttpServletResponse response);

}
