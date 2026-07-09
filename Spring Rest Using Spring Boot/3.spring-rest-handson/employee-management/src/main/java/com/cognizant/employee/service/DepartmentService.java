package com.cognizant.employee.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.employee.dao.DepartmentDao;
import com.cognizant.employee.model.Department;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public ArrayList<Department> getAllDepartments() {

        return departmentDao.getAllDepartments();

    }

}
