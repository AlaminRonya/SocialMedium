package com.alamin.dto;

import com.alamin.model.Attachment;
import lombok.Data;


import java.util.List;

@Data
public class StatusDto {

    private String title;
    private String description;
    private String privacy;
    private String location;

}
