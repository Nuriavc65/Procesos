package EjercioFumadores;

public class Mesa {
	
	private Ingrediente ingrediente1;
	private Ingrediente ingrediente2;
	
	public synchronized void retirar (Ingrediente ingrediente) {
		while(ingrediente == ingrediente1 || ingrediente == ingrediente2) 
			try {
				this.wait(); //liberamos el cerrojo pero seguimos en la seccion critica / this es porque pertence a clase mesa 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		ingrediente1 = ingrediente2 = null;
		notifyAll();
	}
	public synchronized void colocar (Ingrediente ingrediente1, Ingrediente ingrediente2) {
		while(this.ingrediente1 != null & this.ingrediente2 != null)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.ingrediente1 = ingrediente1;
		this.ingrediente2 = ingrediente2;
		notifyAll();
	}
}
