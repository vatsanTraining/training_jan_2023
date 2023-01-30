package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "loan_images")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

	
		@Id
		@GeneratedValue(generator = "uuid")
		@GenericGenerator(name = "uuid", strategy = "uuid2")
		@Column(name = "id")
		String id;
	    
		
	    @Lob
	    @Column(name = "pic_byte")
	    byte[] picByte;
	    
	    @Column(name = "file_name")
	    String fileName;
	    
	    
		public Image(String fileName, byte[] picByte) {
			super();
			this.picByte = picByte;
			this.fileName = fileName;
		}

	    
	    
}

