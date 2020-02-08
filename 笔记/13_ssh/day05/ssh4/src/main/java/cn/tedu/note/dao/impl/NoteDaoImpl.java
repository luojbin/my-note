package cn.tedu.note.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.entity.Note;

@Repository("noteDao")
public class NoteDaoImpl implements NoteDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Map<String, Object>> 
		findNotesByNotebookId(String notebookId) {
		//sql:
		// select cn_note_id, cn_note_title
		// from cn_note
		// where cn_notebook_id =?
		// order by cn_note_last_modify_time desc
		//HQL:
		// select new map(id as id, title as title)
		// from Note
		// where notebookId = ?
		// order by lastModifyTime desc
		String hql="select new map(id as id, title as title) "
				+ "from Note "
				+ "where notebookId = ? "
				+ "order by lastModifyTime desc";
		return hibernateTemplate.find(hql, notebookId);
	}

	public Note findNoteById(String noteId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateNote(Note note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addNote(Note note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Map<String, Object>> findDeleteNotesByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteNoteById(String noteId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteNotes(String... ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Map<String, Object>> 
		findNotes(
		String userId, 
		String notebookId, 
		String statusId) {
		
		String hql="select new map(id as id, title as title) "
				+ "from Note where 1=1 ";
		if(userId!=null){
			hql += "and userId=? ";
		}
		if(notebookId != null){
			hql += "and notebookId=? ";
		}
		hql += "and statusId=? ";
		hql += "order by lastModifyTime desc";
		
		if(userId !=null){
			return hibernateTemplate.find(
					hql, userId, statusId);
		}
		if(notebookId !=null){
			return hibernateTemplate.find(
					hql, notebookId, statusId);
		}
		
		return new ArrayList<Map<String,Object>>();
	}

}
