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
    public String resumeBuild(@Valid Education education, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
        return "build";
    }

        educationRepository.save(education);
        model.addAttribute("education", educationRepository.findAll());
        return "result";
    }

   /*  End of Education Repository   */


    @RequestMapping("/experience")
    public String index(Model model) {
        model.addAttribute("row", new Experience());
        return "experience";
    }
    @RequestMapping("/add")
    public String addlinks(@Valid Experience experience, BindingResult bindingResult, Model model){

        model.addAttribute("experience", new Experience());
      /*  model.addAttribute("link", new Experience());

        if (bindingResult.hasErrors()){
            model.addAttribute("row", experienceRepository.findAll());
            return "index";
        }

        experienceRepository.save(experience);

        model.addAttribute("links", experienceRepository.findAll());
        return "experience";*/


            if (bindingResult.hasErrors()){
                return "build";
            }
            experienceRepository.save(experience);
            return "experience";

    }

}


