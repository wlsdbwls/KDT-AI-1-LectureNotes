package com.example.demo.lectureClass.vue.files.controller;

import com.example.demo.lectureClass.vue.files.controller.form.FileInfoRequestForm;
import com.example.demo.lectureClass.vue.files.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/file-test")
public class FilesTestController {

    final private FileService fileService;
    @PostMapping(value = "/uploadImgsWithText",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    public Boolean fileRegisterRequestHandler (
            @RequestPart(value = "imageFileList") List<MultipartFile> fileList,
            @RequestPart(value = "fileInfo") FileInfoRequestForm info)
    {
        log.info("fileRegisterRequestHandler(): " + info);

        return fileService.register(fileList, info);
    }
}


