package com.alamin.controller;

import com.alamin.dto.StatusDto;
import com.alamin.services.LocationService;
import com.alamin.services.StatusService;
import com.alamin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class StatusController {
    @Autowired
    private StatusService statusService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/status/create")
    public String getStatus(Model model, @ModelAttribute("statusDto")StatusDto statusDto){
        model.addAttribute("locationList", locationService.getAllLocation());
        model.addAttribute("privacyList", Arrays.asList("Public", "Private"));
        return "status/status_create";
    }

    @PostMapping("/status/add")
    public String postStatus(Model model, @ModelAttribute("statusDto") StatusDto statusDto, @RequestParam("images") MultipartFile[] files, HttpSession session) throws IOException {
        String path = session.getServletContext().getRealPath("/")+ Constant.USER_UPLOAD_LOCATION;
        final Long aLong = statusService.addStatus(statusDto, files, path);
        if (aLong !=null){
            return "";
        }

        return "redirect:/status/create";
    }

}
