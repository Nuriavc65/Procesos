package Ejercicio14;

import java.nio.file.spi.FileSystemProvider;
import java.util.Random;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

public class Persona extends Thread{
	
	static final Random R = new Random();
	private Banco banco;
	
	public Persona(String nombre,Banco banco) {
		super(nombre);
		this.banco = banco;
	}
	@Override
	public void run() {
		System.out.println(getName()+"esta pensando");
		try {
			Thread.sleep(R.nextLong(2001)+1000);
		} catch (Exception e) {
			System.out.println(getName()+"ha llegado al banco");
		}
	}
}
