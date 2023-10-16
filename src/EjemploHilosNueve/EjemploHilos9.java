package EjemploHilosNueve;

public class EjemploHilos9 {
	public int n;
	
	public EjemploHilos9(int n) {
		this.n = n;
	}
	//bloque de codigo sincronizado
	public  synchronized void inc() { //pasa a ser una seccion critica es decir solo va a pasar un hilo
		//EjemploHilos9.class --> monitor gestiona el cerrojo
		//sychronize (this) {
		n++;							
	}
	public int get() {
		return n;
	}
}
