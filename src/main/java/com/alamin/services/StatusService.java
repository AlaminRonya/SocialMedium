package com.alamin.services;

import com.alamin.dao.AttachmentDAO;
import com.alamin.dao.LocationDAO;
import com.alamin.dao.StatusDAO;
import com.alamin.dto.StatusDto;
import com.alamin.model.Attachment;
import com.alamin.model.Location;
import com.alamin.model.Status;
import com.alamin.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusDAO statusDAO;
    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private AttachmentDAO attachmentDAO;


    public Long addStatus(StatusDto statusDto, MultipartFile[] files, String path) throws IOException {
        final Location locationByName = locationDAO.getByName(statusDto.getLocation());
        List<Attachment> attachmentList = new ArrayList<>();

        for (MultipartFile file : files) {
            Attachment attachment = Utils.saveFile(file,path);
            if (attachment != null) {
                attachmentList.add(attachment);
            }
        }
        attachmentDAO.insertList(attachmentList);

        Status status = new Status();
        status.setTitle(statusDto.getTitle());
        status.setDescription(statusDto.getDescription());
        status.setPrivacy(statusDto.getPrivacy());
        status.setLocation(locationByName);
        status.setStatusAttachmentList(attachmentList);

        return statusDAO.insert(status);


//        locationByName.getStatuses().add(status);
//        locationDAO.update(locationByName);


    }
}
