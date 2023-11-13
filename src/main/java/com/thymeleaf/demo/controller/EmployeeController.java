package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.mapper.EmployeeMapper;
import com.thymeleaf.demo.model.Employee;
import com.thymeleaf.demo.model.EmployeeDataTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @PostMapping("/list")
    @ResponseBody
    public EmployeeDataTable postEmployeeDataTable(@RequestBody MultiValueMap<String, String> formData) {
        int draw = Integer.parseInt(formData.get("draw").get(0));
        int start = Integer.parseInt(formData.get("start").get(0));
        int length = Integer.parseInt(formData.get("length").get(0));
        int orderColumnKey = Integer.parseInt(formData.get("order[0][column]").get(0));
        String orderColumnName = formData.get("columns[" + orderColumnKey + "][data]").get(0);
        String orderDir = formData.get("order[0][dir]").get(0);
        String searchValue = "%" + formData.get("search[value]").get(0) + "%";

        int recordsTotal = employeeMapper.selectCount();
        int recordsFiltered = employeeMapper.selectCountFiltered(searchValue);
        List<Employee> data = employeeMapper.selectEmployees(searchValue, orderColumnName, orderDir, start, length);

        return EmployeeDataTable.builder()
                .draw(draw)
                .recordsTotal(recordsTotal)
                .recordsFiltered(recordsFiltered)
                .data(data).build();
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
