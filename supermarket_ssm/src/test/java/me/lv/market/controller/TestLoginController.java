package me.lv.market.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.lv.market.dao.EmployeeDao;
import me.lv.market.pojo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:springmvc.xml" })
public class TestLoginController {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void test() {
		Employee employee = employeeDao.getEmployeeById("003");
		System.out.println(employee);
	}
}
