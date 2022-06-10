package com.alamin.dto;

import com.alamin.model.Attachment;
import lombok.Data;


import java.util.List;

@Data
public class StatusDto {

    private Long id;
    private String title;
    private String description;
    private String privacy;
    private boolean isDeleted;
    private Long user;
    private Long location;

}
