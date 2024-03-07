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


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
    	int eid=Integer.parseInt(request.getParameter("eid"));
    	
    	EmployeeDao empDao=new EmployeeDaoImpl();
    	Employee emp=empDao.search(eid);
    	
    	if(emp==null)
    	{
    		RequestDispatcher rd=request.getRequestDispatcher("notexisted.html");
    		rd.forward(request, response);
    	}
    	else
    	{
    		out.println("<html>");
    		out.println("<body style='color : red;' aligin='center'>");
    		out.println("<center>");
    		out.println("<form method='post' action='./edit'>");
    		out.println("<table aligin='center'>");
    		out.println("<tr><td> Employee Update Form</td></tr>");
    		out.println("<tr><td> Employee Id      : </td><td><input type='hidden' name='eid' value='"+emp.getEid()+"'></td></tr>");
			out.println("<tr><td> Employee Name    : </td><td><input type='text' name='ename' value='"+emp.getEname()+"'></td></tr>");
			out.println("<tr><td> Employee Salary  : </td><td><input type='text' name='esal' value='"+emp.getEsal()+"'></td></tr>");
			out.println("<tr><td> Employee Address : </td><td><input type='text' name='eaddr' value='"+emp.getEaddr()+"'></td></tr>");
			out.println("<tr><td><input type='submit' valur='update'</td></tr>");
			out.println("<hr>");
			out.println("</table>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
    		
    	}
	}

}
