package com.niit.shoppingfront.controller;
/*
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

*//**
 * Handles requests  for the application file upload requests
 *//*  
@Controller
public class FileUploadController {

	*//**
	 * Upload single file using Spring Controller
	 *//*
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
            @RequestParam("file") MultipartFile file){
        String name = file.getOriginalFilename();
        String path = "C:/Users/durgesh/workspace/ShoppingFront/src/main/webapp/resources/fileupload";
        
        if (!file.isEmpty()) {
            try {
            	
            	File imgDirectory = new File(path);
            	if(!imgDirectory.exists())
            	{
            		imgDirectory.mkdir();
            	}
            	
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path+"/"+name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

	*//**
	 * Upload multiple file using Spring Controller
	 *//*
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
				message = message + "You successfully uploaded file=" + name
						+ "";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	
}*/
/*package com.niit.shoppingfront.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

*//**
 * Handles requests  for the application file upload requests
 *//*  
@Controller
public class FileUploadController {

	*//**
	 * Upload single file using Spring Controller
	 *//*
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
            @RequestParam("file") MultipartFile file){
        String name = file.getOriginalFilename();
       String path = "C:/Users/durgesh/workspace/ShoppingFront/src/main/webapp/resources/fileupload";
      byte[] bytes= file.getBytes();
      
        if (!file.isEmpty()) {
            try {
            	
            	File imgDirectory = new File(path);
            	if(!imgDirectory.exists())
            	{
            		imgDirectory.mkdir();
            	}
            	
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path+"/"+name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

	*//**
	 * Upload multiple file using Spring Controller
	 *//*
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
				message = message + "You successfully uploaded file=" + name
						+ "";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}
}*/

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	private static final String UPLOAD_DIRECTORY ="./images/";
	private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
	
	
	
	
	/*@RequestMapping("uploadFile")
	public ModelAndView uploadForm(){
		return new ModelAndView("uploadfile");	
	}*/
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,HttpSession session) throws Exception
	{
		System.out.println("uploadFile");
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setSizeThreshold(THRESHOLD_SIZE);
	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	ServletFileUpload upload = new ServletFileUpload(factory);
	ServletContext context = session.getServletContext();

	//String uploadPath = context(UPLOAD_DIRECTORY);
	System.out.println(context.getContextPath()+"......."+context.getRealPath(UPLOAD_DIRECTORY));	    

	byte[] bytes = file.getBytes();
	String path=context.getRealPath(UPLOAD_DIRECTORY) + file.getOriginalFilename();
	System.out.println(path);
	BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path)));
	
	stream.write(bytes);
	stream.flush();
	stream.close();
	     
	return new ModelAndView("uploadform","filesuccess","File successfully saved!");
	}
	
}
