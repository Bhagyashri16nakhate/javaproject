package com.softronix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronix.bean.Employee;
import com.softronix.dao.EmployeeDao;
import com.softronix.dao.EmployeeDaoImpl;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object status;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int eid=Integer.parseInt(request.getParameter("eid"));
		
		EmployeeDao  empdao=new EmployeeDaoImpl();
		Employee emp= empdao.delete(eid);
		if(emp==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/deleteform.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("<tr><td> Employee Id      : </td><td>"+emp.getEid()+"</td></tr>");
			
		}
	}

}
