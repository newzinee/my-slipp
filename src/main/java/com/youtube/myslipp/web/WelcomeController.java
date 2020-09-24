package com.youtube.myslipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping("/helloworld")
    public String welcome(Model model) {
        List<MyModel> repos = Arrays.asList(new MyModel("yoojin"), new MyModel("myeonsoo"));

        model.addAttribute("name", "yoojin");
        model.addAttribute("value", 10000);
        model.addAttribute("taxed_value", 1000 - (1000 * 0.4));
        model.addAttribute("in_ca", true);

        model.addAttribute("company", "<b>Github</b>");

        model.addAttribute("repo", repos);
        return "welcome";
    }
}
