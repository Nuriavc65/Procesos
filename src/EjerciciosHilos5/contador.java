package EjerciciosHilos5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class contador implements Runnable {
	

	private File archivo;
	
	public contador(File archivo) {
		this.archivo = archivo;
	}
	
	@Override
	public void run() {
		int contador = 0,palabras = 0,lineas = 0;
		Pattern pattern = Pattern.compile("\\P{L}+");
		try (BufferedReader in = new BufferedReader(new FileReader(archivo))){ //no se pone throws porque se implementa runnable
			String linea;
			while((linea = in.readLine())!=null) {
				contador += linea.length();
				Matcher matcher = pattern.matcher(linea);
				while(matcher.find()) {
					palabras++;
					}
				}lineas++;
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
			System.out.println(archivo.getName());
			System.out.println("contador: " +contador);
			System.out.println("palabras: " +palabras);
			System.out.println("lineas: "+lineas);
	}

}
