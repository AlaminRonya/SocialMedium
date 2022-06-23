package com.alamin.controller;

import com.alamin.dao.AttachmentDAO;
import com.alamin.dao.LocationDAO;
import com.alamin.dao.UserDAO;
import com.alamin.dto.ResponseUserDto;
import com.alamin.dto.UserDto;
import com.alamin.model.Attachment;
import com.alamin.model.Location;
import com.alamin.model.User;
import com.alamin.services.LocationService;
import com.alamin.services.UserService;
import com.alamin.utils.Constant;
import net.bytebuddy.matcher.StringMatcher;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;


@Controller
@RequestMapping("/users/v1")
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;


    @GetMapping("/user/add")
    public String getUser(Model model, @ModelAttribute("userDto") UserDto userDto){
        model.addAttribute("locationList", locationService.getAllLocation());
        return "user/create";
    }


    @PostMapping("/user/add")
    public String userInsert(@ModelAttribute("userDto") UserDto userDto, @RequestParam("image") MultipartFile file, HttpSession session) throws IOException, IOException {
//        System.out.println(userDto+"k------------->"+System.getProperty("user.dir"));
//        final String originalFilename = file.getOriginalFilename();

        String path = session.getServletContext().getRealPath("/")+Constant.USER_UPLOAD_LOCATION;

        final UserDto insert = userService.insert(userDto, file, path);
        if (insert.getId() != null){
            return "redirect:/users/v1/show/"+insert.getId();
        }
//        model.addAttribute("user", user);
//        System.out.println(user.getId());
        return "redirect:/users/v1/user/add";
    }

    @GetMapping(value = "/show/{id}")
    public String show(Model model, @PathVariable("id")String id) throws FileNotFoundException {
        final ResponseUserDto responseUserDto = userService.getUserById(Long.parseLong(id));


//        System.out.println(id);


//        BeanUtils.copyProperties(user, userDto);



//        final User user = userDAO.getById(Long.parseLong(id));
//        final Location locationById = locationDAO.getById(user.getLocation().getId());

//        user.setLocation(locationById);



//        ResponseUserDto userDto = new ResponseUserDto();
//
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//
//        File file = FileUtils.getFile(user.getAttachment().getAttachmentPath());
//        byte[] arr = new byte[(int)file.length()];
//        String imgUrl = Base64.getEncoder().encodeToString(arr);
//        userDto.setLocation(imgUrl);



        model.addAttribute("userDto", responseUserDto);






        return "user/show";
    }


//    @GetMapping("/file/get/{id}")
//    public void getFile(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
//        final Attachment byId = attachmentDAO.getById(id);
//        File file = new File(byId.getAttachmentPath());
//        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//        if (mimeType == null) {
//            mimeType = "application/octet-stream";
//        }
//        response.setContentType(mimeType);
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
//        response.setContentLength((int) file.length());
//        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//        FileCopyUtils.copy(inputStream, response.getOutputStream());
//    }


//    @GetMapping("/file/get/{id}")
//    public void getFile(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
//        Attachment attachment = attachmentDao.findById(id);
//        File file = new File(attachment.getAttachmentPath());
//        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//        if (mimeType == null) {
//            mimeType = "application/octet-stream";
//        }
//        response.setContentType(mimeType);
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
//        response.setContentLength((int) file.length());
//        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//        FileCopyUtils.copy(inputStream, response.getOutputStream());
//    }

}
