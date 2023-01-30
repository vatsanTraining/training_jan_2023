package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.services.ImageService;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Image;
import com.example.demo.model.FileInfo;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ImageController {

	 
	ImageService service;
	  
	      @PostMapping("/images")
	  	      public ResponseEntity<FileInfo> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
	  

	    	  String message = "";
	    	  try {
		    	  Image addedImage=this.service.save(file);
		    	  
		          String fileDownloadUri = ServletUriComponentsBuilder
		                  .fromCurrentContextPath()
		                  .path("/api/v1/images/")
		                  .path(addedImage.getFileName())
		                  .toUriString();


	    		   message = "Uploaded the file successfully: " ;
	    		   
	             return ResponseEntity.status(HttpStatus.OK).body(new FileInfo(file.getOriginalFilename(), fileDownloadUri, message));
	        } catch (Exception e) {
	          message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileInfo(file.getOriginalFilename(),null,message));
	        }

	  
	            
	  
	      }
	  

	      @GetMapping(path =  "/images/{imageName}" ,produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	  
	      public byte[] getImage(@PathVariable("imageName") String imageName) throws IOException {
	  
	  
		  	    byte[] data = null;
		  	    Image file = this.service.getFile(imageName);
		  	        if(file != null){
		  	        data = file.getPicByte();
		  	    }
		  	    return data;
	    	    
	  
	      }
	      
	    
	  
	      @GetMapping(path = "/images")
	      public ResponseEntity<List<FileInfo>> getAll(){
	    	  
	    	  List<FileInfo> files = this.service.getAllFiles().map(image -> {
		          String fileDownloadUri = ServletUriComponentsBuilder
		                  .fromCurrentContextPath()
		                  .path("/api/v1/images/")
		                  .path(image.getFileName())
		                  .toUriString();
		          
	    		    return new FileInfo(
	    		       image.getFileName(),fileDownloadUri,null
	    		        );
	    		  }).collect(Collectors.toList());

	    		  return ResponseEntity.status(HttpStatus.OK).body(files);
	    	  
	      }
	  
	  }







