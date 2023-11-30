package Unidad3Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteEcho {

	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String linea = keyboard.readLine();
		System.err.println(":) ->");
		while((linea = keyboard.readLine()) != null) {
			Socket socket = new Socket("localhost", 9999);
			try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))){
					out.println(linea);
					out.flush();
					System.out.println(in.readLine());
				}
		}
	}
}
