/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.controllers;

import com.tss.entities.User;
import com.tss.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @RequestMapping("/")
    public String userList(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "index.html";
    }
    
    @GetMapping("/showAddUserForm")
    public String showAddForm(User user){
        return "addUserForm";
    }
    
    @PostMapping("/adduser")
    public String addUser(User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "addUserForm";
        }
        
        userRepository.save(user);
        return "redirect:/";
    }
    
    @GetMapping("/showEditUserForm/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user",user);
        return "editUserForm";
    }
    
    @PostMapping("edituser/{id}")
    public String editUser(@PathVariable("id") long id, User user, BindingResult resoult, Model model){
        if(resoult.hasErrors()){
            user.setId(id);
            return "editUserForm";
        }
        userRepository.save(user);
        return "redirect:/";
    }
    
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/";
    }
}
