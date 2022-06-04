package com.spring.iasfex2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @RequestMapping(path = "admin", method = RequestMethod.GET)
//    @ResponseBody
    public String saveOrUpdate( @RequestParam("name") String name,
                                @RequestParam("slug") String slug,
                                Model model) {
        return "admin/admin";
    }
}
