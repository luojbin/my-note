package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//1.接收参数
		req.setCharacterEncoding("utf-8");
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//2.保存员工数据
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(Double.valueOf(sal));
		new EmpDao().save(e);
		//3.发送响应
//		res.setContentType(
//			"text/html;charset=utf-8");
//		PrintWriter w = res.getWriter();
//		w.println("<p>保存成功</p>");
//		w.close();
		//重定向到查询页面,即
		//建议浏览器自己去访问查询页面.
		//当前: /EmpManager/addEmp
		//目标: /EmpManager/findEmp
		res.sendRedirect("findEmp");
	}

}






