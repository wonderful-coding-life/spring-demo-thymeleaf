package com.thymeleaf.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Employee {
    private int id;
    private String name;
    private String phone;
    private String address;
}
