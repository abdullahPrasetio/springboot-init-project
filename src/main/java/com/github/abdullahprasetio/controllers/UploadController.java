package com.github.abdullahprasetio.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/upload")
public class UploadController {

    private static String UPLOADED_FOLDER = "/Users/temancode/Project/learn/java/springboot/demo-api/storage/";

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping()
    public String upload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","Please select a file to upload");
            return "redirect:/upload/status";
        }

        System.out.println("FILE" + file.getOriginalFilename());
        System.out.println("UPLOADED_FOLDER" + UPLOADED_FOLDER);

        try {
            byte[] bytes = file.getBytes();

            System.out.println("BYTES" + bytes);
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "redirect:/upload/status";
    }

    @GetMapping("status")
    public String uploadStatus() {
        return "status";
    }
    
}
