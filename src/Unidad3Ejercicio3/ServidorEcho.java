package Unidad3Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEcho {

	public static void main(String[] args) throws IOException {
		ServerSocket serverScocket = new ServerSocket(9999);
		while(true) {
			Socket socket = serverScocket.accept();
			try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))){
				String linea;
				while((linea = in.readLine()) != null) {
					out.println(linea);
				}
			}
		}
	}

}
