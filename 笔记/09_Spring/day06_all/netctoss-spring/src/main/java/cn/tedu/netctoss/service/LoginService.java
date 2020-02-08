package cn.tedu.netctoss.service;

import cn.tedu.netctoss.entity.Admin;

/**
 * 业务层接口
 *
 */
public interface LoginService {
	public Admin checkLogin(String adminCode,
			String pwd);
}









