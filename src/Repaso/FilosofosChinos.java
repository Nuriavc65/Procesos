package Repaso;

public class FilosofosChinos {

	public static void main(String[] args) {
		
	}	
}
class Filosofo extends Thread{
	
	protected String palilloI;
	protected String plato;
	protected String palilloD;
	
	Filosofo(String palillo, String plato, String palilloD){
		this.palilloI = palillo;
		this.plato = plato;
		this.palilloD = palilloD;
	}
}
class Mesa {
	
}

