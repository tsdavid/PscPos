package com.psc.pos.web;


import com.psc.pos.service.items.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ItemsService itemsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("items", this.itemsService.findAllDesc());
        return "register/index";
    }

    @GetMapping("/register/save")
    public String register_save() {
        return "register/save";
    }

    @GetMapping("/sales")
    public String sales() {
        return "sales/index";
    }
}
