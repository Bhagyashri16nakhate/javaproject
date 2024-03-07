package com.softronix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.softronix.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
    Employee emp;   
	Connection con;
	Statement st;
	ResultSet rs;
	String status="";
	private String eid;
	private int rowCount;
	
	
	
	@Override
	public String add(Employee emp) {
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st=con.createStatement();
			
			rs=st.executeQuery("select * from emp1 where eid="+emp.getEid()+"");
			boolean b=rs.next();
			
			if(b==true)
			{
				status="Existed";
			}
			else
			{
				int rowCount=st.executeUpdate("insert into emp1 values("+emp.getEid()+",'"+emp.getEname()+"',"+emp.getEsal()+",'"+emp.getEaddr()+"')");
				if(rowCount==1)
				{
					status="success";
				}
				else
				{
					status="failure";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public Employee search(int eid) {
		
       try {
    	   
    	    Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st=con.createStatement();
			
			rs=st.executeQuery("select * from emp1 where eid="+eid+"");
			boolean b=rs.next();
			
			if(b==true)
			{
				Employee emp=new Employee();
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEsal(rs.getFloat("esal"));
				emp.setEaddr(rs.getString("eaddr"));
				
			}
			else
			{
				emp=null;
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return emp;
	}

	@Override
	public String update(Employee emp) {
		
        try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st=con.createStatement();
			
			
			int rowCount=st.executeUpdate("update emp1  set ename='"+emp.getEname()+"',esal="+emp.getEsal()+",eaddr='"+emp.getEaddr()+"' where eid="+emp.getEid()+" ");
				if(rowCount==1)
				{
					status="success";
				}
				else
				{
					status="failure";
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	

	@Override
	public Employee delete(int emp) {
	       
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st=con.createStatement();
			
			rs=st.executeQuery("select * from emp1 where delete eid="+eid+"");
			boolean b=rs.next();
			
			if(rowCount==1)
			{
				status="Sucessfuly";
			}
			else
			{
				status="Failuer";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return null;
	
	}}

