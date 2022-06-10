package com.alamin.controller;

import com.alamin.dto.LocationsDto;
import com.alamin.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/location/insert")
    public String location(@ModelAttribute("locationDto") LocationsDto locationsDto){
        return "location/createLocation";
    }

    @PostMapping("/location/insert")
    public String locationAdd(@ModelAttribute("locationDto") LocationsDto locationsDto){
        locationService.insert(locationsDto);
        return "location/createLocation";
    }


}
