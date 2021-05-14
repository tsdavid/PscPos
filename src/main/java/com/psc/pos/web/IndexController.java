package com.psc.pos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String registerMode(){
        return "register-mode";
    }

    @GetMapping("/sales")
    public String salesMode() {
        return "sales-mode";

    }

    @GetMapping("/items/save")
    public String itemsSave() {
        return "items-save";
    }
}
