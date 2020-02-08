package dao;

import java.util.List;

import entity.Employee;

/**
 *  Mapper映射器
 *
 */
public interface EmployeeDAO {
	public void save(Employee e);
	public List<Employee> findAll();
	public Employee findById(int id);
	
	
}



