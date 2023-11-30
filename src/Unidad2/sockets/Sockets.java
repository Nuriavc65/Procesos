package Unidad2.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Sockets {

	public static void main(String[] args) throws IOException {
		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in)); //leer por consola
		String linea =keyboardIn.readLine();
		System.out.print("> ");
		while ( linea != null) {
			Socket socket = new Socket("localhost", 9999);
			try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
				out.println(linea);
				out.flush();
				System.out.println(in.readLine());
				System.out.print("> ");
			}
		}
	
	}

}
