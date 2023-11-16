package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.mapper.EmployeeMapper;
import com.thymeleaf.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping("/add")
    public String getEmployeeAdd() {
        return "employee-add";
    }

    @PostMapping("/add")
    public String postEmployeeAdd(Employee employee) {
        employeeMapper.insert(employee);
        return "redirect:list";
    }

    @GetMapping("/edit")
    public String getEmployeeEdit(int id, Model model) {
        var employee = employeeMapper.selectById(id);
        model.addAttribute("employee", employee);
        return "employee-edit";
    }

    @PostMapping("/edit")
    public String postEmployeeEdit(Employee employee) {
        employeeMapper.update(employee);
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String getEmployeeDelete(int id, Model model) {
        if (employeeMapper.delete(id) == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "직원 정보가 없습니다.");
        }
        return "redirect:list";
    }
}
