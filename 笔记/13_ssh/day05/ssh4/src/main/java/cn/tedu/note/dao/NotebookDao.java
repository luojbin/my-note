package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

public interface NotebookDao {

	List<Map<String, Object>>
		findNotebooksByUserId(
		String userId);

	int countNotebookById(String notebookId);
	
	List<Map<String, Object>>
		findNotebooksByPage(
		String userId,
		int start,
		int pageSize,
		String table);

}



