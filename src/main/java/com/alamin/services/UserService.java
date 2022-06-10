package com.alamin.services;

import com.alamin.dao.LocationDAO;
import com.alamin.dao.UserDAO;
import com.alamin.dto.UserDto;
import com.alamin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LocationDAO locationDAO;

//    public User insert(@ModelAttribute("userDto") UserDto userDto, MultipartFile("profileImage") file){
//        Location location = locationDAO.getByName(userDto.getLocation());
//
//        Attachment attachment = Utils.saveFile(file, Constant.USER_FOLDER);
//
//        User user = new User();
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setLocation(location);
//        user.setAttachment(attachment);
//        userDAO.insert(user);
//
//        location.getUsers().add(user);
//        locationDAO.update(location);
//        return user;
//    }

    public User insert(UserDto userDto, MultipartFile file){
//        Location location = locationDAO.getByName(userDto.getLocation());
//
//        Attachment attachment = Utils.saveFile(file, Constant.USER_FOLDER);
//
//        User user = new User();
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setLocation(location);
//        user.setAttachment(attachment);
//        userDAO.insert(user);
//
//        location.getUsers().add(user);
//        locationDAO.update(location);
//        return user;

        System.out.println("--->"+userDto.getEmail());
        return  null;
    }

    public void insert(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLocation(user.getLocation());
        user.setAttachment(null);
        userDAO.insert(user);
    }

    public User getUserById(Long id){
        return userDAO.getById(id);
    }


}
