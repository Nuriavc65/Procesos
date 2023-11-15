package Repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio5 {
	int nLineas;
	int nPalabras;
	int nCaracteres;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Iinserte ruta del fichero que quiera analizar");
		String ruta = in.readLine();
		File directorio = new File(ruta);
		System.out.println("inserte indicador: ");
		String indicador = in.readLine();
		switch (indicador) {
			case "C": 
				funcionC(directorio);
				break;
			case "S":
				funcionS(directorio);
				break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + indicador);
		}
	}
	public static void funcionC (File directorio) {
		int numeroArchivos = directorio.listFiles().length;
		for(int i=0;i<numeroArchivos;i++) {
			new tareaC(new File(directorio.getAbsolutePath()+'\\'+directorio.listFiles()[i].getName())).start();
		}
	}
	public static void funcionS (File directorio) {
		int nLineas = 0;
		int nPalabras = 0;
		int nCaracteres = 0;
		int numeroArchivos = directorio.listFiles().length;
		try {
			for(int i=0;i<numeroArchivos;i++) {
				Scanner contenido = new Scanner (new File(directorio.getAbsolutePath()+'\\'+directorio.listFiles()[i].getName()));
				while(contenido.hasNextLine()) {
					String linea = contenido.nextLine();
					nLineas++;
					nCaracteres = nCaracteres + linea.length();
					nPalabras += linea.split("\\W+").length; 
				}
				System.out.printf("numeroLinas:%d numeroCaracteres:%d numeroPalabras:%d \n",nLineas,nCaracteres,nPalabras );
				nLineas = nPalabras = nCaracteres = 0; 
			}
			
		}catch (Exception e) {
			}
		
	}
	
}
	class tareaC extends Thread{
		int nLineas = 0;
		int nPalabras = 0;
		int nCaracteres = 0;
		File fichero;
		
		public tareaC(File fichero) {
			this.fichero = fichero;
		}
		public void run() {
			try {
				Scanner contenido = new Scanner(fichero);
				while(contenido.hasNextLine()) {
					String linea = contenido.nextLine();
					nLineas++;
					nCaracteres = nCaracteres + linea.length();
					nPalabras += linea.split("\\W+").length;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.printf("numeroLinas:%d numeroCaracteres:%d numeroPalabras:%d \n",nLineas,nCaracteres,nPalabras );
		}
	}
