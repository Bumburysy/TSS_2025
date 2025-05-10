/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.Zadanie2NykMichal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.SpringVersion;

@Controller
public class ApplicationController {
    
    @Autowired
    BuildProperties buildProperties;
    
    @Value("${myparams.jdkversion}")
    String myjdkversion;
    
    @Value("${myparams.springbootversion}")
    String springbootversion;
    
    @Value("${application.name}")
    String applicationName;
    
    @Value("${build.version}")
    String buildVersion;
    
    @Value("${build.timestamp}")
    String buildTimestamp;
    
    @RequestMapping("/")
    public String mainView(Model model){
        
        String artifactApp = buildProperties.getArtifact();
        String versionApp = buildProperties.getVersion();
        String springVersion = SpringVersion.getVersion();
        
        model.addAttribute("myjdkversion",myjdkversion);
        model.addAttribute("springbootversion",springbootversion);
        model.addAttribute("springVersion",springVersion);
        model.addAttribute("applicationName",applicationName);
        model.addAttribute("buildVersion",buildVersion);
        model.addAttribute("buildTimestamp",buildTimestamp);
        return "/views/index.jsp";
    }
}
