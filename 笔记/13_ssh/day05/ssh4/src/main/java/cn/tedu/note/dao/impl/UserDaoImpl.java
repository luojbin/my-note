package cn.tedu.note.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public User findUserByName(String name) {
		//HQL Hibernate Query Language
		// sql:
		//  select * from cn_note 
		//  where cn_user_name = #{name} 
		// HQL:
		//  from User 
		//  where name = ?
		String hql = 
			"from User where name = ?";
		List<User> list=
			hibernateTemplate.find(hql, name);
		return list.isEmpty()?null:list.get(0); 
	}

	public int addUser(User user) {
		Serializable id=
			hibernateTemplate.save(user);
		return id==null ? 0 : 1;
	}

	public User findUserById(String userId) {
		return hibernateTemplate.get(
				User.class, userId);	
	}

}



