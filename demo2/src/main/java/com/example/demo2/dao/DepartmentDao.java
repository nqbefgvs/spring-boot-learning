package com.example.demo2.dao;

import com.example.demo2.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<Integer, Department>();

        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "市场部"));
        departmentMap.put(103, new Department(103, "教研部"));
        departmentMap.put(104, new Department(104, "运营部"));
        departmentMap.put(105, new Department(105, "后勤部"));
    }

    public Collection<Department> getDepartments(){
        return  departmentMap.values();
    }

    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
