package in.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.book.service.Fileservice;

@RestController
@RequestMapping("api/v1/upload")
public class S3Controller {
	
	@Autowired
	private Fileservice fileservice;
	
	@PostMapping
	public String upload(@RequestParam ("file") MultipartFile file)
	
	{
    fileservice.saveFile(file);
    
    return "save image";
	}

}
