package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.CostDao;
import entity.Admin;
import entity.Cost;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取访问路径
		String path = req.getServletPath();
		//根据规范(图)处理路径
		if("/findCost.do".equals(path)) {
			findCost(req,res);
		} else if("/toAddCost.do".equals(path)) {
			toAddCost(req,res);
		} else if("/addCost.do".equals(path)) {
			addCost(req,res);
		} else if("/toLogin.do".equals(path)) {
			toLogin(req,res);
		} else if("/toIndex.do".equals(path)) {
			toIndex(req,res);
		} else if("/login.do".equals(path)) {
			login(req,res);
		} else {
			throw new RuntimeException("没有这个页面");
		}
	}
	
	//登录
	protected void login(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//接收参数
		String adminCode = 
			req.getParameter("adminCode");
		String password = 
			req.getParameter("password");
		//验证
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode(adminCode);
		if(a == null) {
			//账号错误
			req.setAttribute("error", "账号错误");
			req.getRequestDispatcher(
				"WEB-INF/main/login.jsp")
				.forward(req, res);
		} else if(!a.getPassword().equals(password)) {
			//密码错误
			req.setAttribute("error", "密码错误");
			req.getRequestDispatcher(
				"WEB-INF/main/login.jsp")
				.forward(req, res);
		} else {
			//将账号存入cookie
			Cookie cookie = 
				new Cookie("user",adminCode);
			res.addCookie(cookie);
			//验证通过
			res.sendRedirect("toIndex.do");
		}
	}
	
	//打开登录页
	protected void toLogin(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher(
			"WEB-INF/main/login.jsp")
			.forward(req, res);
	}
	
	//打开主页
	protected void toIndex(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher(
			"WEB-INF/main/index.jsp")
			.forward(req, res);
	}
	
	//查询资费
	protected void findCost(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//查询所有的资费
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//将请求转发到jsp
		req.setAttribute("costs", list);
		//当前:/netctoss/findCost.do
		//目标:/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/find.jsp").forward(req, res);
	}
	
	//打开增加资费
	protected void toAddCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher(
			"WEB-INF/cost/add.jsp").forward(req, res);
	}
	
	//增加资费数据
	protected void addCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//接收传入的参数
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String costType = 
			req.getParameter("costType");
		String baseDuration = 
			req.getParameter("baseDuration");
		String baseCost = 
			req.getParameter("baseCost");
		String unitCost = 
			req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		//保存该数据
		Cost c = new Cost();
		c.setName(name);
		c.setCostType(costType);
		if(baseDuration != null 
			&& baseDuration.length()>0) {
			c.setBaseDuration(
				Integer.valueOf(baseDuration));
		}
		if(baseCost != null
			&& baseCost.length()>0) {
			c.setBaseCost(
				Double.valueOf(baseCost));
		}
		if(unitCost != null
			&& unitCost.length()>0) {
			c.setUnitCost(
				Double.valueOf(unitCost));
		}
		c.setDescr(descr);
		CostDao dao = new CostDao();
		dao.save(c);
		//重定向到查询
		//当前: /netctoss/addCost.do
		//目标: /netctoss/findCost.do
		res.sendRedirect("findCost.do");
	}

}






