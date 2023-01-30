package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo {
	
	
	private String originalFilename;
	private String fileDownloadUri;
	private String message;
	public FileInfo(String originalFilename, String fileDownloadUri) {
		super();
		this.originalFilename = originalFilename;
		this.fileDownloadUri = fileDownloadUri;
	}

	
}
