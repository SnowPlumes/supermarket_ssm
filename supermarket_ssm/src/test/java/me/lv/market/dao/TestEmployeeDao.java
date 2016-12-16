package me.lv.market.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.lv.market.dao.EmployeeDao;
import me.lv.market.pojo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:springmvc.xml" })
public class TestEmployeeDao {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeLimitDao employeeLimitDao;

	@Test
	public void testUpdate() {
		Employee employee = new Employee();
		employee.setId(1);
		// employee.setName("小白");
		// employee.setEmail("233@163.com");
		// employee.setPhone("12312312332");
		// employee.setEmployeeLimit(new EmployeeLimit(2,"B"));
		employee.setPassword("123456");
		// employee.setIsdelete("N");
		int update = employeeDao.updateEmployee(employee);
		System.out.println(update);
	}

	@Test
	public void testSelectEmployee() {
		List<Employee> employees = employeeDao.selectEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void testInsertEmployee() {
		Employee employee = new Employee("004", "xiaobai", "12345565788", "qwe@163.com",
				employeeLimitDao.getEmployeeLimitByValue("B"));
		employeeDao.insertEmployee(employee);
	}

	@Test
	public void testGetEmployeeById() {
		Employee employee = employeeDao.getEmployeeById("001");
		System.out.println(employee);
	}

}
