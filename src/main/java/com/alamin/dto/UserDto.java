package com.alamin.dto;

import com.alamin.model.Attachment;
import com.alamin.model.Location;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String location;
}
