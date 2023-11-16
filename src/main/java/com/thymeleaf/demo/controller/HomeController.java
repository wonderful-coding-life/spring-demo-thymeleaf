package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.model.ExtraUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.Principal;

@Controller
@Slf4j
public class HomeController {
    @GetMapping(value = {"/", "index"})
    public String getHome(Principal principal, Model model
    ) {
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            var extraUserDetails = (ExtraUserDetails)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
            log.info("displayName {}, profileImage {}", extraUserDetails.getDisplayName(), extraUserDetails.getProfileImage());
            model.addAttribute("extraUserDetails", extraUserDetails);
        }
        return "home";
    }
}
