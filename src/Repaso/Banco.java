
package Repaso;

public class Banco extends Thread{
	int plazas;
	int ocupadas;
	
	Banco(int plazos){
		this.plazas = plazas;
		this.ocupadas = ocupadas;
	}
	public  void run() {
		while(ocupadas == plazas) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ocupadas++;
			System.out.println(Thread.currentThread().getName() + "se ha sentado"); //al aumntar el numero de sadientos ocupados quiere decir que alguien se ha sentado
			ocupadas--;
			System.out.println(Thread.currentThread().getName()+"se ha puesto a caminar");
		}
	}
}

