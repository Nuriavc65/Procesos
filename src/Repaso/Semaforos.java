package Repaso;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Semaforos {
	public static void main(String[] args) {
		
		Parque parque = new Parque(4, 20);
		
	}
}
class Parque{
	private Semaphore banco;
	private PersonaParque [] personas;
	private Random tiempoEspera = new Random();
	
	Parque(int numeroPlazas, int numeroPersonas){
		this.personas = new PersonaParque[numeroPersonas];
		this.banco = new Semaphore(numeroPlazas);
		for(int i=0;i<numeroPersonas;i++) {
			personas [i]= new PersonaParque(this);
			personas[i].start();
		}
	}
	public void sentarse() throws InterruptedException {
		banco.acquire();
		System.out.println("se ha sentado"+Thread.currentThread().getName());
		Thread.sleep(tiempoEspera.nextInt(3000-1000)+1000);
		System.out.println("se levanta" +Thread.currentThread().getName());
		banco.release();
	}
}



class PersonaParque extends Thread{
	private Parque parque;
	private Random tiempo= new Random();
	
	PersonaParque(Parque parque){
		this.parque = parque;
	}
	@Override
	public void run() {
		try {
			System.out.println("esta paseando" +Thread.currentThread().getName());
			Thread.sleep(tiempo.nextInt(3000-1000)+1000);
			parque.sentarse();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}

