package BlackJack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class serve {

	public static void main(String[] args) {
		ServerSocket serversockets;
		ArrayList<Socket> sockets = new ArrayList<Socket>();
		ExecutorService es = Executors.newCachedThreadPool();
		Socket aux;
		try {
			serversockets = new ServerSocket(9999);
			while (true){
				System.out.println("---esperando por clientes---");
				aux = serversockets.accept();
				sockets.add(aux);
				es.submit(new Hilos(aux));
				System.out.println("----conexion establecida----");
			}
		} catch (IOException e) {}
	}

}
