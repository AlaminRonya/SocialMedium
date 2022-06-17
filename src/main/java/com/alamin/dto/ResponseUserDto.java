package com.alamin.dto;

import com.alamin.model.Attachment;
import com.alamin.model.Location;
import lombok.Data;

import javax.persistence.*;

@Data
public class ResponseUserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Location location;
    private Attachment attachment;
//    private String imgPath;
}
