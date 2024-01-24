package servidorHash;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Objects;

public class HashServ {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println(" -- aceptando socket --");
			Socket socket = ss.accept();
			PrintWriter output = new PrintWriter(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			MessageDigest message = MessageDigest.getInstance("md5");
			System.out.println("--servidor listo--");
			while(true) {
				Object objeto = input.readObject();
				byte[] keyHash;     
				try {
					keyHash = message.digest((byte []) objeto);
				}catch (Exception e) {
					keyHash = desrizable(objeto);
				}
				StringBuilder resultado = new StringBuilder();
				for(int i=0;i<keyHash.length;i++){
					resultado.append(String.format("%02X", keyHash[i]));
				}
				System.out.println(resultado.toString());
				output.write(resultado.toString());
				output.flush();
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private static byte[] desrizable(Object objeto) {
		try {
			ByteArrayOutputStream ot = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(ot);
			os.writeObject(objeto);
			os.flush();
			return ot.toByteArray();
		}catch (Exception e) {}
		return null;
	}
}
