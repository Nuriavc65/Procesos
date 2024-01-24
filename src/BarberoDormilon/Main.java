package BarberoDormilon;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("introduce nSillas y nClientes");
		int nSillas = scanner.nextInt();
		int nClientes = scanner.nextInt();
		
		Barberia barberia = new Barberia(nSillas);
		Barbero barbero = new Barbero(barberia);
		barbero.start();
		for(int i =1;i<nClientes;i++) {
			Cliente cliente = new Cliente(barberia);
			cliente.start();
		}
	}

}



