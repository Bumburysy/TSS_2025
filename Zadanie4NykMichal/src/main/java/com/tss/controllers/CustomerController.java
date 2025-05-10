/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.controllers;

import com.tss.entities.Customer;
import com.tss.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    
    private final CustomerRepository customerRepository;
    
    @Autowired
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @RequestMapping("/")
    public String showCustomerList(Model model){
        model.addAttribute("customers",customerRepository.findAll());
        return "index.html";
    }
    
    @GetMapping("/addCustomer")
    public String addUser(){
        Customer customer = new Customer("uzupelnij", "uzupelnij");
        customerRepository.save(customer);
        return "redirect:/";
    }
    
    @GetMapping("editCustomer/{id}")
    public String editUser(@PathVariable("id") long id, Customer customer, BindingResult result, Model model){
        if (result.hasErrors()){
            return "";
        }
        customer.setFirstName("zmodyfikowany");
        customer.setLastName("zmodyfikowany");
        customerRepository.save(customer);
        return "redirect:/";
    }
    
    @GetMapping("/deleteCustomer/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        customerRepository.delete(customer);
        return "redirect:/";
    }
}
