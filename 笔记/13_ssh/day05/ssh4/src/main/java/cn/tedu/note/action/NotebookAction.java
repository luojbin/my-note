package cn.tedu.note.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.note.service.NotebookService;
import cn.tedu.note.util.JsonResult;

@Controller
@Scope("prototype")
public class NotebookAction 
	extends AbstractAction {
	
	@Resource
	private NotebookService notebookService;

	private String userId;
	private Integer page;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	public String page(){
		List<Map<String, Object>> list=
		notebookService.listNotebooks(userId, page);
		jsonResult = new JsonResult(list);
		return JSON;
	}
	 
	public String list(){
		List<Map<String, Object>> list=
		notebookService.listNotebooks(userId);
		jsonResult = new JsonResult(list);
		return JSON;
	}
	
}







