package com.file.send.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileSendService {
	
	public void uploadFile(MultipartFile file);

}
