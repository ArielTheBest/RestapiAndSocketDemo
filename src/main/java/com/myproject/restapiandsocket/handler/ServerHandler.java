package com.myproject.restapiandsocket.handler;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler {
	public static void main(String[] args) {
		try {  
			ServerSocket serverSocket = new ServerSocket(10000);  
			Socket socket = serverSocket.accept(); //establishes connection   
			System.out.println("Inside TCP Server");
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());  
			String str = dataInputStream.readUTF();  
			System.out.println("Message = " + str);  
			serverSocket.close();  
		} catch(Exception exception) {
			exception.printStackTrace();
		}		
	}
	
}
