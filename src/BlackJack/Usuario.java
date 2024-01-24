package BlackJack;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

import org.fp.dam.naipes.blackjack.Blackjack;

public class Usuario {

	public static void main(String[] args) throws Exception {
		Blackjack blackjack = new Blackjack();
		blackjack.repartir();
		System.out.println(blackjack);
		blackjack.pedir();
		System.out.println(blackjack);
	}


   
	

}
