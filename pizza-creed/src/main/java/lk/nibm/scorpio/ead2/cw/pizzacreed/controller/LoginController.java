package lk.nibm.scorpio.ead2.cw.pizzacreed.controller;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.User;
import lk.nibm.scorpio.ead2.cw.pizzacreed.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //load index page
    @GetMapping("/")
    public String showLogin(){
        return "login";
    }

    //request for login form
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model)
    {
        User user = userService.findByUsername(username);

        if(user != null && user.getPassword().equals(password))
        {
            return "home";
        }
        else
        {
            model.addAttribute("error","Invalid username or password");
            return "login";
        }
    }

}
