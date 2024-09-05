package com.example.springapiuser.departments;

import com.example.springapiuser.User.User;
import com.example.springapiuser.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable String id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }
    @GetMapping("/{id}/users")
    public List<User> getUsersByDepartmentId(@PathVariable String id) {
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            String[] users = department.getUsers();
            return userService.getUsersByIds(users);
        } else {
            return Collections.emptyList();
        }
    }
    @GetMapping("/user/{userId}")
    public List<Department> getDepartmentsByUserId(@PathVariable String userId) {
        return departmentService.getDepartmentsByUserId(userId);
    }
}
