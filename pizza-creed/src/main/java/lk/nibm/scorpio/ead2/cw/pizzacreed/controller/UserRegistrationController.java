package lk.nibm.scorpio.ead2.cw.pizzacreed.controller;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.User;
import lk.nibm.scorpio.ead2.cw.pizzacreed.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistrationController {

    @Autowired
    IUserService service;

    //request for load registration page
    @GetMapping("/Registration")
    public String showRegistration(){
        return "Registration";
    }


    //request for registration form
    @RequestMapping(value="/register", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user)
    {
        service.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
