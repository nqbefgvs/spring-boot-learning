package com.example.demo2.dao;

import com.example.demo2.pojo.Department;
import com.example.demo2.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employeeMap = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<>();

        employeeMap.put(1001, new Employee(1001, "AA", "389179622@qq.com", 1, new Department(101, "教学部")));
        employeeMap.put(1002, new Employee(1002, "BB", "389179622@qq.com", 1, new Department(102, "市场部")));
        employeeMap.put(1003, new Employee(1003, "CC", "389179622@qq.com", 1, new Department(103, "教研部")));
        employeeMap.put(1004, new Employee(1004, "DD", "389179622@qq.com", 1, new Department(104, "运营部")));
        employeeMap.put(1005, new Employee(1005, "EE", "389179622@qq.com", 1, new Department(105, "后勤部")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employeeMap.values();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    public void deleteEmployeeById(Integer id){
        employeeMap.remove(id);
    }
}
