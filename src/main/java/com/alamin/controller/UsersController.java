package com.alamin.controller;

import com.alamin.dao.LocationDAO;
import com.alamin.dao.UserDAO;
import com.alamin.dto.UserDto;
import com.alamin.services.LocationService;
import com.alamin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private UserDAO userDAO;


    @GetMapping("/user/add")
    public String getUser(Model model, @ModelAttribute("userDto") UserDto userDto){
        model.addAttribute("locationList", locationService.getAllLocation());
        return "user/create";
    }


    @PostMapping("/user/add")
    public String userInsert(@ModelAttribute("userDto") UserDto userDto, @RequestParam("profileImage") MultipartFile file) {
        System.out.println(userDto+"k------------->"+file);
//        userService.insert(userDto);
        return "redirect:/home";
    }

}
