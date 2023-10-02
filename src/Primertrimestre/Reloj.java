package Primertrimestre;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Reloj extends JFrame implements Runnable{

	private static final long SerialVersionUID = 1L;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	private JLabel hora;
	
	public Reloj() {
		super("Reloj");
		hora = new JLabel(formatter.format(LocalDateTime.now()));
		hora.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(70, 70, 70, 70),hora.getBorder()));
		hora.setFont(hora.getFont().deriveFont(30f));
		hora.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(hora);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		Runnable actualizarHora = new Runnable() {
			
			public void run() {
				hora.setText(formatter.format(LocalDateTime.now()));
			}
		};
		while(true) {
			SwingUtilities.invokeLater(actualizarHora);
			try {
				Thread.sleep(100);
			}catch (Exception e) {}
		}
	}
	public void start() {
		setVisible(true);
		new Thread(this,"seconds").start(); // la clase reloj implementa runnable 
	}
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable(){//se utiliza para ejecutar una tarea dentro de un hil ya existente
			public void run () {
				new Reloj().start();
			}
		});
			
	}

}
