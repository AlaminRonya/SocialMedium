package com.alamin.utils;

import com.alamin.dto.UserDto;
import com.alamin.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Utils {
    @Autowired
    private static ServletContext servletContext;

    public static Attachment saveFile(MultipartFile file, String path) throws IOException {

        if (!file.isEmpty()){
//            String filePath = Constant.USER_UPLOAD_LOCATION + file.getOriginalFilename();
//            Path path = Paths.get(filePath);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            file.transferTo(new File(path));

            Attachment attachment = new Attachment();
            attachment.setAttachmentName(file.getOriginalFilename());
            attachment.setAttachmentPath(path);
            attachment.setAttachmentType(file.getContentType());
            return attachment;
        }else {
            return null;
        }


//        if (file.isEmpty()) {
//            throw new RuntimeException("Please load a file");
//        }
//
//        try {
//
//            // Get the file and save it uploads dir
//            byte[] bytes = file.getBytes();
//            Path path1 = Paths.get(path+file.getOriginalFilename());
//            System.out.println(path1);
//            Files.write(path1, bytes);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String imageUUID;
//        if (!file.isEmpty()){
//            imageUUID = file.getOriginalFilename();
//            Path fileNameAndPath = Paths.get(path, imageUUID);
//            System.out.println(fileNameAndPath);
//            Files.write(fileNameAndPath, file.getBytes());
//        }


//        Path rootLocation = Paths.get(path);
//        System.out.println("lllllllllllllllll---------->"+rootLocation.toFile());
//
//        if (!file.isEmpty()) {
//            String fileName = file.getOriginalFilename();
//            assert fileName != null;
//            Path destinationFile = rootLocation.resolve(fileName);
//            System.out.println("destinationFile.toFile().mkdirs()---------->"+destinationFile);
//
//            if (!destinationFile.toFile().exists()) destinationFile.toFile().mkdirs();
//            try (InputStream inputStream = file.getInputStream()) {
//                System.out.println("destinationFile.toFile().mkdirs()---------->"+destinationFile.toFile().mkdirs());
//                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
//
//                Attachment attachment = new Attachment();
////                attachment.setAttachmentName(fileName);
////                attachment.setAttachmentPath(path + fileName);
////                attachment.setAttachmentType(file.getContentType());
//
//                return attachment;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        return null;
    }



    public static byte[] getFile(String path) {
        Path rootLocation = Paths.get(Constant.READ_PATH + path);
        try {
            return Files.readAllBytes(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
