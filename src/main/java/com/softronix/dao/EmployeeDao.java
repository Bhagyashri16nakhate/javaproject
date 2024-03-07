package com.softronix.dao;

import com.softronix.bean.Employee;

public interface EmployeeDao {
     
     public String add(Employee emp);
     public Employee search(int eid);
     public String update(Employee emp);
     public Employee delete(int eid);
}
