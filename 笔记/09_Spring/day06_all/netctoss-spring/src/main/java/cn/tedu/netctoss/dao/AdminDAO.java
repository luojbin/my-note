package cn.tedu.netctoss.dao;

import cn.tedu.netctoss.entity.Admin;
/**
 * 持久层接口
 */
public interface AdminDAO {
	public Admin findByAdminCode(
			String adminCode);
	
}


