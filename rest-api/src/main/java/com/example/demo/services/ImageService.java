package com.example.demo.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Image;
import com.example.demo.repository.ImageRepository;


import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ImageService {


	private  ImageRepository repo;



	  
	  public Image save(MultipartFile file) throws IOException {
		  
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    Image imageRef = new Image(fileName,  file.getBytes());

		   
          return repo.save(imageRef);
  
	    	
	    	

	  }
	  public Image getFile(String fileName) {
		    return repo.findByFileName(fileName).get();
		  }
		  
		  public Stream<Image> getAllFiles() {
		    return repo.findAll().stream();
		  }

}