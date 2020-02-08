package cn.tedu.note.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.entity.Note;

@Repository("noteDao")
public class NoteDaoImpl implements NoteDao {

	public List<Map<String, Object>> findNotesByNotebookId(String notebookId) {
		// TODO Auto-generated method stub
		return null;
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

	public List<Map<String, Object>> findNotes(String userId, String notebookId, String statusId) {
		// TODO Auto-generated method stub
		return null;
	}

}
