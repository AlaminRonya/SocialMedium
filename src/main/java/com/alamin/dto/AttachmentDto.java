package com.alamin.dto;

import lombok.Data;

@Data
public class AttachmentDto {
    private Long id;
    private String attachmentName;
    private String attachmentPath;
    private String getAttachmentType;
}
