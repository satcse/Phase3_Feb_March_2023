package com.ecommerce.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

	@RequestMapping(value = "/")
	public String index() {
		return "index.html";
	}

	// File Upload REST API
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		String result = "File was uploaded successfully!";
		try {
			String path = "D:\\Personal\\Data\\";
			path = path.replace("\\", "/"); // The Path to upload the file
			File convertFile = new File(path + file.getOriginalFilename());
			convertFile.createNewFile(); // New Empty file created in the above path with file name.
			FileOutputStream fout = new FileOutputStream(convertFile); // Stream pointed towards empty file created
																		// above.
			fout.write(file.getBytes()); // Take the bytes from the file object and write it to empty file.
			fout.close();
			return result;
		} catch (IOException e) {
			result = "Error" + e.getMessage();
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
		String fileName = "static/data.txt";
		
		//Use ClassLoader to load the file into JVM from the system
		ClassLoader classLoader = new MainController().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		//Create a Stream to send the file contents to the browser.
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		//Add the metadata about the file we are going to send using HttpHeaders.
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length()).contentType(MediaType.parseMediaType("application/text")).body(resource);

		return responseEntity;
	}

}
