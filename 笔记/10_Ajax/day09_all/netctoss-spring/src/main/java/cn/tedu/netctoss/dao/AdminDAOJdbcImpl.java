package cn.tedu.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.netctoss.entity.Admin;

/**
 * 持久层实现
 */

//@Repository("adminDAO")
public class AdminDAOJdbcImpl implements 
AdminDAO{
	
	@Resource(name="ds")
	private DataSource ds;
	
	
	public Admin findByAdminCode(
			String adminCode) {
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = 
					"select * from admin_info_lhh "
					+ "where admin_code=?";
			PreparedStatement ps = 
					conn.prepareStatement(
							sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEmail(rs.getString("email"));
				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
			}
		} catch (SQLException e) {
			//step1. 记日志（保留现场）
			e.printStackTrace();
			/*
			 * step2.看异常能否恢复,如果
			 * 不能够恢复(比如数据库服务
			 * 暂停，网络中断，这样的异常
			 * 一般我们称之为系统异常)，
			 * 则提示用户稍后重试。如果能够
			 * 恢复，则立即恢复。
			 * 
			 */
			throw new RuntimeException(e);
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return admin;
	}

}
