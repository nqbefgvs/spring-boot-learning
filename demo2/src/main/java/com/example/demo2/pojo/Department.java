package com.example.demo2.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {

    private Integer id;
    private String departmentName;

    public Department(Integer id, String departmentName){
        this.id = id;
        this. departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
