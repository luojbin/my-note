package cn.tedu.netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.netctoss.dao.AdminDAO;
import cn.tedu.netctoss.entity.Admin;

/**
 * 业务层实现
 *
 */
@Service("loginService")
public class LoginServiceImpl implements 
LoginService{
	
	@Resource(name="adminDAO")
	private AdminDAO aDAO;
	
	public Admin checkLogin(
			String adminCode, String pwd) {
		Admin admin = 
			aDAO.findByAdminCode(adminCode);
		if(admin == null){
			//帐号不存在,抛一个应用异常。
			//注：应用异常，指的是因为用户
			//不正确的操作引起的异常，比如
			//帐号、密码填写错误。需要明确
			//提示用户采取正确的操作。
			throw new ApplicationException(
					"帐号错误");
		}
		if(!admin.getPassword().equals(pwd)){
			//密码错误
			throw new ApplicationException(
					"密码错误");
		}
		//登录成功
		return admin;
	}
}
