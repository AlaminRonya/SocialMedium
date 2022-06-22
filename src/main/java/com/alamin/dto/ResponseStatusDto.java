package com.alamin.dto;

import com.alamin.model.Attachment;
import com.alamin.model.Location;
import com.alamin.model.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ResponseStatusDto {

    private Long id;
    private String title;
    private String description;
    private String privacy;
    private boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
    private User user;
    private Location location;
    private List<Attachment> statusAttachmentList;


}
