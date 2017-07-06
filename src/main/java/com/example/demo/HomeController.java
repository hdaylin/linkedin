package com.example.demo;

import com.example.demo.Models.*;
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

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillsRepository skillsRepository;



    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
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
        return "redirect:/create";
    }

   /*  End of Education Repository   */


    @GetMapping("/add")
    public String getExp(Model model){
        model.addAttribute(new Experience());
        model.addAttribute("item", experienceRepository.findAll());
        return "experience";
    }
    @PostMapping("/display")
    public String resumeExp(@Valid Experience experience, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "redirect:/add";
        }

        experienceRepository.save(experience);
        model.addAttribute("experience", experienceRepository.findAll());
        return "redirect:/add";
    }

    /*  End of Experience Repository   */


    @GetMapping("/skill")
    public String getSk(Model model){
        model.addAttribute(new Skills());
        model.addAttribute("list", skillsRepository.findAll());
        return "skills";
    }

    @PostMapping("/skills")
    public String resumeSk(@Valid Skills skills, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "skills";
        }
        skillsRepository.save(skills);
        model.addAttribute("skills", skillsRepository.findAll());
        return "redirect:/skill";
    }
  /* End of Skills Repository */

    @RequestMapping("/resume")
    public String listBooks(Model model){
        model.addAttribute("skills", skillsRepository.findAll());
        model.addAttribute("experience", experienceRepository.findAll());
        model.addAttribute("education", educationRepository.findAll());
        return "result";
    }


    @RequestMapping("/school")
    public String getSchools(@Valid Education education, Model model){
        model.addAttribute("college", educationRepository.findAllByCollege(""));
        return "school";
    }


}
