package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Employee;

@Repository("employeeDAO")
public class EmployeeDAO {
	
	@Autowired
	@Qualifier("jt")  
	private JdbcTemplate jt;
	
	public void save(Employee e){
		String sql = 
				"INSERT INTO t_emp "
			+ "VALUES(t_emp_seq.nextval,?,?)";
		Object[] args = 
			{e.getName(),e.getAge()};
		jt.update(sql, args);
	}
	
	public List<Employee> findAll(){
		String sql = "SELECT * FROM t_emp";
		return jt.query(sql, 
				new EmpRowMapper());
	}
	
	public Employee findById(int id){
		String sql = "SELECT * FROM t_emp "
				+ "WHERE id=?";
		Object[] args = {id};
		Employee e = null;
		try{
			e = jt.queryForObject(
					sql, args, 
					new EmpRowMapper());	
		}catch(EmptyResultDataAccessException e1){
			e1.printStackTrace();
			return null;
		}
		return e;
	}
	
	public void modify(Employee e){
		String sql = "UPDATE t_emp SET "
				+ "name=?,age=? WHERE id=?";
		Object[] args =
			{e.getName(),e.getAge(),e.getId()};
		jt.update(sql, args);
	}
	
	public void delete(int id){
		String sql = "DELETE FROM t_emp "
				+ "WHERE id=?";
		Object[] args = {id};
		jt.update(sql, args);
	}
	
	
	//封装了对ResultSet的处理
	class EmpRowMapper 
		implements RowMapper<Employee>{
		/*
		 * 告诉JdbcTemplate,如何将一条记录
		 * 转换成一个实体对象。
		 * index: 正在被处理的记录的下标
		 */
		public Employee mapRow(
				ResultSet rs, int index)
						throws SQLException {
			Employee e = new Employee();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setAge(rs.getInt("age"));
			return e;
		}
	}
}




