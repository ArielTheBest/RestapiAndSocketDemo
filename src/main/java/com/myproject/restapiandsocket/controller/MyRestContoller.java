package com.myproject.restapiandsocket.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.restapiandsocket.handler.ClientHandler;
import com.myproject.restapiandsocket.model.MyObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class MyRestContoller {
	
	private ResponseEntity<String> responseEntity;
	
	@Autowired
	private ClientHandler clientHandler;
	
	@RequestMapping(value = "restapiandsocket/update", method = RequestMethod.POST, consumes="application/json", produces="text/plain")
    public ResponseEntity<String> getDetails(@RequestBody MyObject myObject)
    {
		String data = myObject.getData();
		if(data == null)
			return new ResponseEntity<String>("ERROR: Data is empty", HttpStatus.BAD_REQUEST);
		responseEntity = clientHandler.connect(data);
		return responseEntity;
    }
	
}
