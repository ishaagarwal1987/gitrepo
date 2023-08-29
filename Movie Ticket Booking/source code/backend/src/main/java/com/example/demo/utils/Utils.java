package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
	static String uploadDir = "D:\\eclipse workspace\\MovieTicketBooking\\src\\main\\resources\\static\\movieImages";
	
	private Utils()
	{
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
		return new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
	}
	
	public static void saveFile(String fileName, MultipartFile file) throws IOException {
		Path uploadPath = (Path) Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try {

			Files.copy(file.getInputStream(), Paths.get(uploadDir + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}

	public static boolean deleteFile(String fileName) {
		try {
			File myObj = new File(uploadDir + File.separator + fileName);
			if (myObj.delete()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


}
