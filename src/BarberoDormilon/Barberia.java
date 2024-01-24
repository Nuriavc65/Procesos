package BarberoDormilon;

import java.util.concurrent.Semaphore;

public class Barberia {
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
