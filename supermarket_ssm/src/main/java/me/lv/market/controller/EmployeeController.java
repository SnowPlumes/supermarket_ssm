package me.lv.market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.lv.market.pojo.Employee;
import me.lv.market.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employeeManager")
	public String showEmployees(HttpServletRequest request, HttpServletResponse response) {
		List<Employee> employees = employeeService.getEmployees();
		request.setAttribute("employees", employees);
		return "employee";
	}

	@RequestMapping("/personalInfo")
	public String updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		employeeService.updatePersonalInfo(request, response);
		return "personal-info";
	}

	@RequestMapping("/chPassword")
	public String chPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String status = employeeService.chPassword(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(status);
		out.close();
		return "password";
	}

	@RequestMapping("/chEmployee")
	public void chEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int change = employeeService.chEmployee(request, response);
		PrintWriter out = response.getWriter();
		out.println(change);
		out.close();
	}

	@RequestMapping("/deleteEmployee")
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int result = employeeService.deleteEmployee(request, response);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}

}