package EjemploHilos11;

public class Almacen extends Thread{
	private int almacenados = 0;
	private String [] productos;
	public Almacen(int capacidad) {
	productos = new String[capacidad];
	}
	public synchronized void almacenar(String producto) {
		while (almacenados == productos.length) // almacén lleno
		try {
			wait(); //parada y espera de un hilo 
		} catch (InterruptedException e) {}
		productos[almacenados++] = producto;
		notify(); //Solo despirta uno notifyAll despierta a todos
	}
	
	public synchronized String retirar() {
		while (almacenados == 0) // almacén vacío
		try {
			wait();
		} catch (InterruptedException e) {}
		String producto = productos[--almacenados];
		notify();
		return producto;
	}
}
