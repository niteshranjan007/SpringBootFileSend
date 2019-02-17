package com.file.send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.send.service.FileSendService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "upload", description = "Rest API for Uploading Files", tags = "Upload API")
public class FileSendController {
	
	@Autowired
	FileSendService fileSendService;
	
    @PostMapping("/fileUpload")
    @ApiOperation(value = "Make a POST request to upload the file",
    produces = "application/json", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
@ApiResponses(value = {
    @ApiResponse(code = 200, message = "The POST call is Successful"),
    @ApiResponse(code = 500, message = "The POST call is Failed"),
    @ApiResponse(code = 404, message = "The API could not be found")
})
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
    	fileSendService.uploadFile(file);
		return "Upload Successfully";
    } 

}
