package org.example.controller;

import jakarta.validation.Valid;
import org.example.models.User;
import org.example.service.UserRepository;
import org.example.service.dto.UserDTO;
import org.example.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String index(){
        return "index";
    }
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
        return "redirect:/hello";
    }

    @PostMapping("/hello")
    public String hello(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "hello";
    }
    @GetMapping("/hello")
    public String listUsers(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "hello";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(name = "id") Integer id, Model model){
        User user = userRepository.getReferenceById(id);
        model.addAttribute("user",user);
        return "update";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdate( @ModelAttribute("user") UserDTO userDTO, Model model){
       userService.UpdateUser(userDTO);
       return "redirect:/hello";
    }
}
