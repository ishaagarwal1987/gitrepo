package com.example.demo.Controller;


import java.io.*;
import java.nio.file.*;
 
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void saveFile(String uploadDir, String fileName, MultipartFile file) throws IOException {
		Path uploadPath = (Path) Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try {
			
			Files.copy(file.getInputStream(), Paths.get(uploadDir + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}

}
