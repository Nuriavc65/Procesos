package Repaso;

import java.util.ArrayList;
import java.util.Random;

public class CadenaMontaje {

	public static void main(String[] args) {
		Cadena cadena = new Cadena(10);
		RobotC colocador = new RobotC(cadena);
		RobotE empaquetador1 = new RobotE("tipo1", cadena);
		RobotE empaquetador2 = new RobotE("tipo2", cadena);
		RobotE empaquetador3 = new RobotE("tipo3", cadena);
		colocador.start();
		empaquetador1.start();
		empaquetador2.start();
		empaquetador3.start();
	}

}
class RobotC extends Thread{
	
	protected String [] objetos = {"tipo1","tipo2","tipo3"};
	protected Cadena cadena;
	protected Random random = new Random(); 
	
	
	RobotC(Cadena cadena){
		this.cadena = cadena;
	}
	
	@Override
	public void run() {
		while(true) {
			String objeto = objetos[random.nextInt(3)]; 
			cadena.colocar(objeto);
			System.out.println("el robot" +" "+Thread.currentThread().getName() +" ha colocado");
			
		}
	}
}
class Cadena{
	protected int productosMaximos;
	protected ArrayList <String> posiciones;
	int productosEmpaquetados = 0;
	
	Cadena(int productosMaximos){
		this.posiciones = new ArrayList <>();
		this.productosMaximos = productosMaximos;
	}
	public synchronized void colocar(String producto) {
		if(productosMaximos == posiciones.size()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		posiciones.add(producto);
		notify();
	}
	public synchronized void Empaquetar(String producto) {
		if(posiciones.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(posiciones.contains(producto)) {
			posiciones.remove(producto);
			System.out.println("el robot" +" "+Thread.currentThread().getName() +" ha retirado");
			productosEmpaquetados++;
			System.out.println("numero de productos empaqutados: "+productosEmpaquetados);
			notify();
		}
	}
}
class RobotE extends Thread{
	protected String tipo;
	protected Cadena cadena;
	
	RobotE(String tipo, Cadena cadena) {
		this.tipo = tipo;
		this.cadena = cadena;
	}
	@Override
	public void run() {
		while (true) {
			cadena.Empaquetar(tipo);

		}
	}
}
