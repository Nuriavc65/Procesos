package BlackJack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.fp.dam.naipes.blackjack.Blackjack;

public class Hilos implements Runnable{

	private Socket socket;
	
	Hilos(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		Blackjack blackjack = new Blackjack();
		String linea;
		boolean jugar = true;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			try {
				out.write("escribe:");
				while(jugar) {
					linea = in.readLine();
					switch (linea) {
					case "R": 
						blackjack.repartir();
						out.write(blackjack.toString());
						break;
					case "P":
						blackjack.pedir();
						out.write(blackjack.toString());
						break;
					case "PL":
						blackjack.plantarse();
						out.write(blackjack.toString());
						break;
					case "E":
						jugar = false;
						out.write("Partida terminada");
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + linea);
					}
				}
			}catch (Exception e) {}
		}catch (Exception e) {}
		
	}
	
}
