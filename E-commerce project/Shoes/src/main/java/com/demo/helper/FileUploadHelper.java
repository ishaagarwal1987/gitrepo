package com.demo.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR="D:\\eclipse workspace\\Shoes\\src\\main\\resources\\static\\img";
	
	public boolean uploadFile(MultipartFile file)
	{
		boolean status = false;
		
		try {
			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
}
