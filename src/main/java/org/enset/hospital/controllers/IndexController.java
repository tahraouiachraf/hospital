package org.enset.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class IndexController {
    @GetMapping("/public/index")
    public String index() {
        return "index";
    }

    @GetMapping("/public/")
    public String home() {
        return "redirect:/index";
    }
}
