package Repaso;


public class Ejemplo1 extends Thread{
	
	public Ejemplo1 (int id) {
		super("hilo" +id);
	}
	public void run () {
		for(int i=0;i<=5;i++) { //repite la accion del hilo seis veces
			try {
				Thread.sleep(100); //el hilo se duerme durante 100 milisegundos 
			} catch (Exception e) {}
			System.out.println(getName() + ",mensaje" +i);
		}
	}
	public static void main(String[] args) {
		//tres hilos sin instacia 
		for(int i=0;i<=3;i++) {
			new Ejemplo1(i).start(); //crea el hilo y lo ejecuta
			
		}
		
		//tres hilos con instancia
		Ejemplo1 hilo = new Ejemplo1(988);
		Ejemplo1 hilo2 = new Ejemplo1(956);
		Ejemplo1 hilo3 = new Ejemplo1(345);
		hilo.start();
		hilo2.start();
		hilo3.start();
		
	}

}
