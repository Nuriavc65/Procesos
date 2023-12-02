package Unidad3.ServidorErmetico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Unidad3Ejercicio4 {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket();
		Socket socket = server.accept();
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		DataInputStream in = new DataInputStream(socket.getInputStream());
		while(true) {
			
		}
		
	}

}
