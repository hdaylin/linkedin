package com.example.demo;

import com.example.demo.Models.Education;
import com.example.demo.Models.EducationRepository;
import com.example.demo.Models.Experience;
import com.example.demo.Models.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
ExperienceRepository experienceRepository;


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/create")
    public String getEdu(Model model){
        model.addAttribute(new Education());
        model.addAttribute("row", educationRepository.findAll());
        return "build";
    }
    @PostMapping("/show")
    public String resumeBuild(@Valid Education education,  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
        return "build";
    }
        educationRepository.save(education);
        return "result";
    }

    @RequestMapping("/all")
    public String getAllEdu(Model model)
    {
        model.addAttribute("row", educationRepository.findAll());
        return "result";
    }


    @GetMapping("/exp")
    public String getExp(Model model){
        model.addAttribute(new Experience());
        model.addAttribute("row", experienceRepository.findAll());
        return "experience";



    }




}


