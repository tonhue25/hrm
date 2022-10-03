package com.amls.application.controllers;

import com.amls.application.config.bean.GlobalConfig;
import com.amls.application.config.bean.MenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private GlobalConfig globalConfig;

    @Autowired
    private MenuConfig menuConfig;

    @RequestMapping("/home")
    public String index(Model model) {
        model.addAttribute("name", globalConfig.getName());
        model.addAttribute("menus", menuConfig.getMenus());
        return "index";
    }
}
