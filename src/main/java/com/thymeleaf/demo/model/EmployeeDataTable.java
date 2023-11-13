package com.thymeleaf.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeDataTable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<Employee> data;
}
