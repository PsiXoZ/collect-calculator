package ru.psixoz.lineage2.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }
}
