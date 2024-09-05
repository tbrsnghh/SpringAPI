package com.example.springapiuser.departments;

import com.example.springapiuser.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String id, Department department) {
        Department existingDepartment = getDepartmentById(id);
        if (existingDepartment != null) {
            existingDepartment.setNameDepartment(department.getNameDepartment());
            existingDepartment.setUsers(department.getUsers());
            return departmentRepository.save(existingDepartment);
        } else {
            return null;
        }
    }

    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }


    public List<Department> getDepartmentsByUserId(String userId) {
        return departmentRepository.findByUsersContains(userId);
    }
}
