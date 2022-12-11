package com.visonarycrafting.vs_mvc.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ErroreController implements ErrorController {

    @GetMapping("/error")
    public ModelAndView GetError(){
        return new ModelAndView("error");
    }

}
