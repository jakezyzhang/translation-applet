package com.zzy.translation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/Pages")
@CrossOrigin
public class PagesController {
    @ResponseBody
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("pages/login.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/register")
    public ModelAndView register(ModelAndView modelAndView){
        modelAndView.setViewName("pages/register.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/queryTable")
    public ModelAndView queryTable(ModelAndView modelAndView){
        modelAndView.setViewName("pages/queryTable.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/queryTableEditor")
    public ModelAndView queryTableEditor(ModelAndView modelAndView){
        modelAndView.setViewName("pages/queryTableEditor.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/increaseOrEditor")
    public ModelAndView increaseOrEditor(ModelAndView modelAndView){
        modelAndView.setViewName("pages/increaseOrEditor.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("pages/index.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/fileTree")
    public ModelAndView fileTree(ModelAndView modelAndView){
        modelAndView.setViewName("pages/fileTree.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/error")
    public ModelAndView error(ModelAndView modelAndView){
        modelAndView.setViewName("pages/error.html");
        return modelAndView;
    }
}
