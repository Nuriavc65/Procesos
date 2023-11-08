package Repaso;

public class Ejemplo2 implements Runnable{
	public void run() {
		for(int i=1;i<=5;i++) { //repite la accion del hilo cinco veces
			try {
				Thread.sleep(100); //el hilo se duerme durante 100 milisegundos 
			}catch(Exception e) {}
			System.out.printf("%s, mensaje %d\n", Thread.currentThread().getName(),i); //muestra por pantalla el nombre del hilo actual
		}
	}
	public static void main(String[] args) {
		Runnable tarea = new Ejemplo2();
		for(int i=1;i<=3;i++) {
			new Thread(tarea,"hilo" +i).start(); //la tarea que realiza el hilo
		}
	}
}
