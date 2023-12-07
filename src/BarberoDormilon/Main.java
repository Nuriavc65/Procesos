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
class Barbero extends Thread{
	Barberia barberia;
	
	Barbero(Barberia barberia){ 
		this.barberia = barberia;
	}
	
	@Override
	public void run() {
		while(true) {
            System.out.println("Barbero se duerme");
            try {
            	Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Cliente extends Thread{
	private Barberia barberia;
	
	Cliente (Barberia barberia){
		this.barberia = barberia;
	}
	@Override
	public void run() {
		barberia.LlegadaCliente();
        barberia.atenderCliente();
	}
	
}
class Barberia{
	private Semaphore salaEspera;
	private Semaphore barberoDespierto;
	
	Barberia(int nSillas){
		this.salaEspera = new Semaphore(nSillas);
		this.barberoDespierto = new Semaphore(1);
	}
	public void LlegadaCliente() {
		System.out.println("cliente "+Thread.currentThread().getName() + "ha entrado");
		if(salaEspera.tryAcquire()) {
			System.out.println("cliente "+Thread.currentThread().getName() + "entra a la sala de espera");
			try {
				barberoDespierto.acquire();
				System.out.println("cliente "+Thread.currentThread().getName() + "va a cortarse el pelo");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Sala llena el cliente " + Thread.currentThread().getName() + "se va");
		}
	}
	public void atenderCliente() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("barbero "+Thread.currentThread().getName() + "ha terminado de afitar");
		barberoDespierto.release();
        salaEspera.release();
	}
}
