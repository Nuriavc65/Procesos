package Repaso;


 public class Main {
	private static Contador contador = new Contador(100); // el numero por el que va a empezar el cotador
	private static void run() { 	//el funcion/metodo que va a hacer el hilo
		for(int i=0;i<100;i++){
			contador.incrementar();	//llamo a la funcion incrementar del objeto contador
			try {
				Thread.sleep(10);	//el hilo se duerme durante 10 nanosegundos
			} catch (Exception e) {}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread hilo1 = new Thread(Main :: run);
		Thread hilo2 = new Thread(Main :: run); // creamos el hilo y le damos la referencia de la funcion run de Main == runable
		hilo1.start();	//el hilo comienza a hacer su funcion
		hilo2.start();	
		hilo1.join();	//una vez cumlida su tarea el hilo vuele a la linea temporal del main
		hilo2.join();
		System.out.println("Contador =" +contador.get()); //imprime el restultado del contador 
	}
}
 class Contador {
		private int numero;
		
		 public Contador(int numero){
			this.numero = numero;
		}
		 public synchronized void incrementar() { //le ponemsp sycronized para que los hilos funcionen y hagn sus tarea en un orden concret
			 numero++;
		 }
		 public int get() {
			 return numero;
		 }
	}
