package cn.tedu.note.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.note.service.NoteService;
import cn.tedu.note.util.JsonResult;

@Controller
@Scope("prototype")
public class NoteAction extends AbstractAction{
	
	@Resource
	private NoteService noteService;
	
	private String notebookId;
	public String getNotebookId() {
		return notebookId;
	}
	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}
	
	public String list(){
		jsonResult = new JsonResult(
			noteService.listNotes(notebookId));
		return JSON;
	}
	
}






