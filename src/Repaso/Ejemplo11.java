package Repaso;

public class Ejemplo11 {
	public static void main(String[] args) {
			Almacen almacen = new Almacen(10);
			Productor productor = new Productor(almacen, 100);
			Consumidor consumidor = new Consumidor(almacen, 1000);
			productor.start();
			consumidor.start();
		
	}
}
class Almacen {
	private int almacenados = 0; //numero de productos almacendos
	private String [] productos;	//capacidad del almacen 
	
	public Almacen (int capacidad) {
		this.productos = new String[capacidad];
	}
	public synchronized void almacenar(String producto) {
		if(almacenados == productos.length) { //Si el numero de productos almacenados es igual a la capacidad
			try {
				wait(); // el hilo espera a que exista espacio para almacenar
			}catch (Exception e) {}
		}				//cuando la capacidad del almacen aumenta quiere decir que se ha guardado un producto
		productos[almacenados] = producto; 
		almacenados++; // el numero de productos almacenados aumenta
		notify(); //se notifica al resto de hilos que el hay productos en el almacen 
	}
	public synchronized String retirar() {
		if(almacenados == 0) { //si el numero de productos en el almacen es igual
			try {
				wait(); //el hilo espera a que exista un producto en el almacen 
			}catch (Exception e) {}
		}
		almacenados--;
		String producto = productos[almacenados]; // se retira un producto por lo que el numero de productos almacenados se resta
		notify(); //se notifica al resto de  hilos que se ha retirado productos 
		return producto;
	}
}
class Consumidor extends Thread{
	private long retardo;
	private Almacen almacen;
	
	public Consumidor (Almacen almacen, long retardo) {
		this.retardo = retardo;
		this.almacen = almacen;
	}
	@Override
	public void run() {
		while(true) {   //mientas exista 
			String producto = almacen.retirar(); //llamamos al metodo retirar de almacen
			System.out.println("producto" +producto+"retirado"); //mensaja por consola del producto almacenado
			try {
				Thread.sleep(retardo);
			} catch (Exception e) {}
		}
	}
}
class Productor extends Thread{
	private long retardo = 0; //tiempo que va a dormir el hilo
	private long contador = 0; //
	private Almacen almacen; //se crea el objeto Almacen 
	
	public Productor(Almacen almacen, long retardo) {
		this.retardo = retardo;
		this.almacen = almacen;
	}
	@Override
	public void run() {
		while(true) {
			String producto = String.format("%d", ++contador); //++contador -> primero lo suma y despues lo guarda
			almacen.almacenar(producto); //llamamos al metodo almacenar y se almacena un producto
			System.out.println("producto" +producto +"almacenado"); // mensaje por consola de que el producto ha sido almacenado
			try {
				Thread.sleep(retardo);
			} catch (Exception e) {}
		}
	}
}

