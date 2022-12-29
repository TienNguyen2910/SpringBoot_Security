package org.example.controller;

import jakarta.validation.Valid;
import org.example.models.User;
import org.example.service.dto.UserDTO;
import org.example.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return "login";
    }
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        UserDTO user = new UserDTO();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping("/register/save")
    public String saveRegister(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result,Model model){
        Optional<User> exsitingUser = userService.findUserByEmail(userDTO.getEmail());
        if(exsitingUser.isPresent() && exsitingUser.get().getEmail() !=null && !exsitingUser.get().getEmail().isEmpty()){
            result.rejectValue("email",null,"There is already an account register with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user",userDTO);
            return "redirect:/register?fail";
        }
        userService.saveUser(userDTO);
        return "redirect:/login?success";
    }
    @PreAuthorize("hasRole('USER'),hasRole('ADMIN')")
    @PostMapping("/hello")
    public ModelAndView user(){
        return new ModelAndView("hello");
    }
}
