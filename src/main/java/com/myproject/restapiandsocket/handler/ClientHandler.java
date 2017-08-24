package com.myproject.restapiandsocket.handler;

import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientHandler {
	
	public ResponseEntity<String> connect(String message) {
		try {      
			Socket socket = new Socket("localhost",10000);
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream()); 
			System.out.println("Inside TCP Client");
			dataOutputStream.writeUTF(message);  
			dataOutputStream.flush();  
			dataOutputStream.close();  
			socket.close();  
		}catch(SocketException socketException) {
			socketException.printStackTrace();
			return new ResponseEntity<String>("ERROR" + socketException, HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<String>("ERROR" + exception, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK); 	
	
	}	
	
}
