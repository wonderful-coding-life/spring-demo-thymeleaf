package com.thymeleaf.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping
    public String getHome(Model model) {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("principal {}", principal);
        model.addAttribute("principal", principal);
        return "home";
    }
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String getLogout() {
        return "logout";
    }
}
