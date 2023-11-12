package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeMapper employeeMapper;

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        var employees = employeeMapper.selectAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping()
    public String getEmployeeById(int id, Model model) {
        var employee = employeeMapper.selectById(id);
        model.addAttribute("employee", employee);
        return "employee";
    }
}
