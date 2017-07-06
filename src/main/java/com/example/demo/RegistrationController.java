package com.example.demo;

import com.example.demo.Models.Role;
import com.example.demo.Models.User;
import com.example.demo.Models.UserService;
import com.example.demo.Models.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by daylinhenry on 7/6/17.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registration";
        } else {


            String x = user.getMyrole();
            if (x.equals("user")) {
                userService.saveUser(user);
                model.addAttribute("message", "User Account Successfully Created");
            }else if(x.equals("recruiter")){
                userService.saveRecruiter(user);
                model.addAttribute("message", "Recruiter Account Successfully Created ");
            }else if(x.equals("admin")){
                userService.saveAdmin(user);
                model.addAttribute("message", "Admin Account Successfully Created ");
            }
        }

        return "login";
    }


    @GetMapping("/welcome")
    public String welomepage(Model model){
        model.addAttribute("role ", new Role());
        return "welcome";
    }


    public UserValidator getUserValidator() {
        return userValidator;
    }
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }





}


