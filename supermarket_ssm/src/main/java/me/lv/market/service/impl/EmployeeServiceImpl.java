package me.lv.market.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.lv.market.dao.EmployeeDao;
import me.lv.market.dao.EmployeeLimitDao;
import me.lv.market.pojo.Employee;
import me.lv.market.service.EmployeeService;
import me.lv.market.util.Utils;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeLimitDao employeeLimitDao;

	public List<Employee> getEmployees() {
		List<Employee> employees = employeeDao.selectEmployees();
		return employees;
	}

	public Employee getEmployeeById(String employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	public int updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Transactional
	public int deleteEmployee(Employee employee) {
		employee.setIsdelete("Y");
		return employeeDao.updateEmployee(employee);
	}

	public int insertEmployee(Employee employee) {
		return employeeDao.insertEmployee(employee);
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		String limit = request.getParameter("limit");
		String employeeId = request.getParameter("employeeId");

		Employee employee = getEmployeeById(employeeId);
		if (employee == null || !employee.getPassword().equals(password)) {
			Utils.printScript(response, "ID或密码不正确");
		} else if (employee.getEmployeeLimit().getLevel().equals(limit)) {
			request.getSession().setAttribute("employee", employee);
			return "index";
		} else {
			Utils.printScript(response, "类别不正确");
		}
		return null;
	}

	@Transactional
	public void updatePersonalInfo(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("newName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Employee employee = (Employee) request.getSession().getAttribute("employee");

		employee.setName(name);
		employee.setEmail(email);
		employee.setPhone(phone);
		updateEmployee(employee);
		request.getSession().setAttribute("employee", employee);
	}

	@Transactional
	public String chPassword(HttpServletRequest request, HttpServletResponse response) {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String secondPassword = request.getParameter("secondPassword");
		Employee employee = (Employee) request.getSession().getAttribute("employee");

		if (oldPassword == null || oldPassword.trim().equals("")) {
			return "请输入密码";
		}
		if (newPassword == null || newPassword.trim().equals("")) {
			return "请输入新密码";
		}
		if (secondPassword == null || secondPassword.trim().equals("")) {
			return "请再次输入密码";
		}
		if (!employee.getPassword().equals(oldPassword)) {
			return "密码不正确";
		} else {
			if (newPassword.equals(secondPassword)) {
				employee.setPassword(newPassword);
				employeeDao.updateEmployee(employee);
				return "修改成功";
			} else {
				return "密码不一致";
			}
		}

	}

	public int deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		String employeeId = request.getParameter("id");
		return deleteEmployee(employeeDao.getEmployeeById(employeeId));
	}

	public int chEmployee(HttpServletRequest request, HttpServletResponse response) {

		String employeeId = request.getParameter("employeeId");
		String employeeName = request.getParameter("employeeName");
		String employeePhone = request.getParameter("employeePhone");
		String employeeEmail = request.getParameter("employeeEmail");
		String employeeLimit = request.getParameter("employeeLimit");

		Employee employee = getEmployeeById(employeeId);

		if (employee != null) {
			employee.seteID(employeeId);
			employee.setName(employeeName);
			employee.setPhone(employeePhone);
			employee.setEmail(employeeEmail);
			employee.setEmployeeLimit(employeeLimitDao.getEmployeeLimitByValue(employeeLimit));
			return updateEmployee(employee);
		} else {
			Employee employee2 = new Employee(employeeId, employeeName, employeePhone, employeeEmail,
					employeeLimitDao.getEmployeeLimitByValue(employeeLimit));
			return insertEmployee(employee2);
		}

	}

}
