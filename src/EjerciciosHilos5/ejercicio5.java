package EjerciciosHilos5;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ejercicio5 {

	public static void main(String[] args) {
		if(args.length != 2 || !(args[1].equalsIgnoreCase("c")||args[1].equalsIgnoreCase("s"))) {
			System.out.println("parametros erroneos");
			System.exit(-1);
		}
		File[]directorio = new File(args[0]).listFiles();
		List<File> lista = List.of(directorio)
				.stream()
				.filter(file -> file.isFile())
				.collect(Collectors.toList());
		long t0 = System.nanoTime();
		if(args[1].equalsIgnoreCase("c")) {
			LinkedList<Thread>listaHilos = new LinkedList<>();
			lista.forEach(file ->{
				listaHilos.add(new Thread(new contador(file)));
			});
			listaHilos.forEach(h -> h.start());
			listaHilos.forEach(h->{
				try {
					h.join();
				}catch (InterruptedException e) {
				}
			});
		}
		else {
			lista.forEach(file -> new contador(file).run());
		}
		System.out.println("Tiempo empleado: " +(System.nanoTime()));
	}

}
