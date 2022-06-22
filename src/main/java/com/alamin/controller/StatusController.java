package com.alamin.controller;

import com.alamin.dto.StatusDto;
import com.alamin.model.Status;
import com.alamin.services.LocationService;
import com.alamin.services.StatusService;
import com.alamin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
            final String id = String.valueOf(aLong);
            return "redirect:/status/show/"+id;
        }

        return "redirect:/status/create";
    }

    @GetMapping(value = "/status/show/{id}")
    public String show(Model model, @PathVariable("id")String id){
        final Status check = statusService.check(id);
        System.out.println("********************"+check.getTitle());
        System.out.println("********************"+check.getLocation().getId());
        System.out.println("********************");
        System.out.println("******"+check.getStatusAttachmentList().get(0).getAttachmentName());


        return "status/status_show";
    }

}
