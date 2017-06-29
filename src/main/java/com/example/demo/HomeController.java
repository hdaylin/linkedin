package com.example.demo;

import com.example.demo.Models.Education;
import com.example.demo.Models.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by student on 6/28/17.
 */

@Controller
public class HomeController {
@Autowired


EducationRepository educationRepository;

    @RequestMapping("/")
        public String index(){
        return "index";
    }

    @GetMapping("/create")
    public String getDish(Model model){
        model.addAttribute(new Education());
        return "build";
    }
    @PostMapping("/build")
        public String resumeBuild(@Valid Education education, Model model, BindingResult bindingResult){
            model.addAttribute("education", new Education());
            educationRepository.save(education);
            return "result";
    }



}


