package com.alamin.services;

import com.alamin.converter.UserConverter;
import com.alamin.dao.AttachmentDAO;
import com.alamin.dao.LocationDAO;
import com.alamin.dao.UserDAO;
import com.alamin.dto.ResponseUserDto;
import com.alamin.dto.UserDto;
import com.alamin.model.Attachment;
import com.alamin.model.Location;
import com.alamin.model.User;
import com.alamin.utils.Constant;
import com.alamin.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

@Service
public class UserService {
    private static String uploadDir = System.getProperty("user.dir")+"/src/main/webapp/WEB-INF/resources/images/";

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private AttachmentDAO attachmentDAO;

    private UserConverter userConverter;

    public UserService() {
        userConverter = new UserConverter();
    }

    public UserDto insert(UserDto userDto, MultipartFile file, String path) throws IOException {
        Location location = locationDAO.getByName(userDto.getLocation());
//        System.out.println(location);

//        var dir = getClass().getResource("/../resources/images").getFile();
//        System.out.println(dir+"   ============ " +file.getOriginalFilename());

        Attachment attachment = Utils.saveFile(file,path);


        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLocation(location);
        user.setAttachment(attachment);

        final Long id = userDAO.insert(user);
        user.setId(id);
//        userDto.setLocation(String.valueOf(location.getId()));


//        location.getUsers().add(user);
//        locationDAO.update(location);

        userDto.setId(id);

        return userDto;

    }

    public UserDto getUserById(String id) throws FileNotFoundException {

        User user = userDAO.getById(Long.parseLong(id));
//        BeanUtils.copyProperties(user, new UserDto());
//        UserDto userDto = new UserDto();
        File file = FileUtils.getFile(user.getAttachment().getAttachmentPath());
        FileInputStream fl = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length()];
        String imgUrl = Base64.getEncoder().encodeToString(arr);

//        userDto.setLocation(imgUrl);
//        userDto.setLocationName(user.getLocation().getLocationName());
//        userDto.setImage(imgUrl);

        return null;
    }


    public ResponseUserDto getUserById(Long id){
        final User userById = userDAO.getById(id);
        final Location locationById = locationDAO.getById(userById.getLocation().getId());
        final Attachment attachmentById = attachmentDAO.getById(userById.getAttachment().getId());
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(userById.getId());
        responseUserDto.setName(userById.getName());
        responseUserDto.setEmail(userById.getEmail());
        responseUserDto.setPassword(userById.getPassword());
        responseUserDto.setLocation(locationById);
        responseUserDto.setAttachment(attachmentById);


//        File file = FileUtils.getFile(attachmentById.getAttachmentPath());
//        byte[] arr = new byte[(int)file.length()];
//        String imgUrl = Base64.getEncoder().encodeToString(arr);
//        responseUserDto.setImgPath(imgUrl);

        return  responseUserDto;
    }


}
