package cn.tedu.note.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tedu.note.dao.NotebookDao;

@Repository("notebookDao")
public class NotebookDaoImpl implements NotebookDao {

	public List<Map<String, Object>> findNotebooksByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int countNotebookById(String notebookId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Map<String, Object>> findNotebooksByPage(String userId, int start, int pageSize, String table) {
		// TODO Auto-generated method stub
		return null;
	}

}
