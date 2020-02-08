package cn.tedu.note.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.tedu.note.dao.NotebookDao;

@Repository("notebookDao")
public class NotebookDaoImpl implements NotebookDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Map<String, Object>> 
		findNotebooksByUserId(String userId) {
		final String hql=
				"select new map(id as id, name as name) "+
				"from Notebook "+
				"where userId=? "+
				"order by createtime desc";
		List<Map<String, Object>> list= 
			hibernateTemplate.find(
			hql, userId);
		return list;
	}

	public int countNotebookById(
			String notebookId) {
		//sql:
		// select count(*) 
		// from cn_notebook
		// where cn_notebook_id=?
		//hql:
		// select count(*) 
		// from Notebook
		// where id=?
		String hql = "select count(*) "
				+ "from Notebook where id=?";
		List<Number> list=hibernateTemplate.
				find(hql, notebookId);
		return list.isEmpty()? 0:
			list.get(0).intValue();
	}

	public List<Map<String, Object>> 
		findNotebooksByPage(
				final String userId, 
				final int start, 
				final int pageSize, 
				final String table) {
		//sql: select cn_notebook_id, cn_notebook_name 
		//  from cn_notebook 
		//  where cn_user_id=?
		//  order by cn_notebook_createtime desc
		//HQL:
		//  select new map(id as id, name as name)
		//  from Notebook
		//  where userId=?
		//  order by createtime desc
		final String hql="select new map(id as id, name as name) "+
				"from Notebook "+
				"where userId=? "+
				"order by createtime desc";
		List<Map<String, Object>> list=
		hibernateTemplate.execute(
		new HibernateCallback
			<List<Map<String, Object>>>() {
			public List<Map<String, Object>> 
				doInHibernate(Session session) 
				throws HibernateException, 
				SQLException {
				//利用session创建查询对象
				Query query=session.createQuery(hql);
				//绑定 查询参数
				query.setString(0, userId);
				//绑定分页参数:
				query.setFirstResult(start);
				query.setMaxResults(pageSize);
				//query.list() 执行查询
				//返回查询结果
				return query.list();
			}
		});
		
		return list;
	}

}



