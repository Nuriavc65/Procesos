package EjemploHilosNueve;

public class main {
		private static EjemploHilos9 c = new EjemploHilos9(100);
		private static void run() {
			for (int i = 0; i < 100; i++) {
				c.inc();
				try {
					Thread.sleep(10);
				}catch (InterruptedException e) {}
			}
		}
		public main(String[] args) throws InterruptedException {
			Thread t1 = new Thread(main::run);
			Thread t2 = new Thread(main::run);
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			System.out.println("Contador = " + c.get());
			}
	

}
