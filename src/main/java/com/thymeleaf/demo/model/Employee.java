package com.thymeleaf.demo.model;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private String phone;
    private String address;
}
