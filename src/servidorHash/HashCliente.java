package servidorHash;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;

public class HashCliente {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9999);
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String string ="holi";
			output.writeObject(string.getBytes());
			output.flush();
			System.out.println("hash del String que acabas de enviar: " +in.readLine());
			Thread.sleep(1000);
			
			File file = new File("btes\\data.dat");
			byte[] fileData = Files.readAllBytes(file.toPath());
			output.writeObject(fileData);
			output.flush();
			System.out.println("hash del fichero enviado: " +in.readLine());
			Thread.sleep(1000);
			
			Objeto prueba = new Objeto("seguro que no funciona", 6);
			output.writeObject(prueba);
			output.flush();
			System.out.println("hash del objeto enviado: " +in.readLine());
			
		}catch (Exception e) {}
	}
}

