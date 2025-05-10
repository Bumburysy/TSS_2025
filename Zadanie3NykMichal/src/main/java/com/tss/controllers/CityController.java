package com.tss.controllers;

import com.tss.components.SessionComponent;
import com.tss.repositories.CityReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.tss.repositories.CityRepository;
import com.tss.repositories.ICityReport;
import java.util.List;

@Controller
public class CityController {
    
    private final CityRepository cityRepository;
    
    @Autowired
    SessionComponent sessionComponent;
    @Autowired
    public CityController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    
    @RequestMapping("/")
    public String showUserList(Model model){
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("citiesOrderAsc", cityRepository.findAllByOrderByNameAsc());
        sessionComponent.increaserCounter();
        List<CityReport> countCitiesPopulation=cityRepository.countCitiesPopulation();
        model.addAttribute("cityReport",countCitiesPopulation);
        sessionComponent.increaserCounter();
        List<ICityReport> countCitiesPopulation2=cityRepository.countCitiesPopulationNativeQuery();
        model.addAttribute("cityReport2", countCitiesPopulation2);
        sessionComponent.increaserCounter();
        model.addAttribute("counterValue", sessionComponent.getCounter());
        return "/views/index.jsp";
    }
}
