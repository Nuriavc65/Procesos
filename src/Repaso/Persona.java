package Repaso;

import java.util.Random;

public class Persona extends Thread{
	Random tiempo;
	public void run() {
		System.out.println(getName()+"esta pensando");
		try {
			Thread.sleep(tiempo.nextLong(2001)+1000);
		} catch (Exception e) {
			System.out.println(getName()+"ha llegado al banco");
		}
	}

}
