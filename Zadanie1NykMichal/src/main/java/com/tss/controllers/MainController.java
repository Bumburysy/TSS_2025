/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Michau
 */
@Controller
public class MainController {
    
    @RequestMapping("/")
    public String page(Model model){
        model.addAttribute("attribute", "Nyk Michał IO2");
        return "/views/index.jsp";
    }
}
