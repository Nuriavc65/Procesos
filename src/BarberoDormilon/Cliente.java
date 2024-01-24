package BarberoDormilon;

public class Cliente extends Thread{
private Barberia barberia;
	
	Cliente (Barberia barberia){
		this.barberia = barberia;
	}
	public void run() {
		barberia.LlegadaCliente();
        barberia.atenderCliente();
	}
	
}
