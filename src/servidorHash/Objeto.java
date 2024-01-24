package servidorHash;

import java.io.Serializable;

public class Objeto implements Serializable{
	String d;
	int numero;
	
	public Objeto(String nuevo , int n) {
		d = nuevo;
		numero = n;
	}
}
