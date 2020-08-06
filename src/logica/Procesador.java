package logica;

public class Procesador implements Runnable{
	private int tiempo=0;
	private Thread runThread;
	private boolean stop;
	private Monitor monitor;
	
	public Procesador() {
		this.monitor= new Monitor();
	}
	
	public void iniciar() {
		this.runThread= new Thread(this);
		this.stop=false;
		this.runThread.start();
	}
	
	public void reiniciar() {
		this.tiempo=0;
	}
	
	public void detener() {
		this.stop=true;
	}

	public int getTiempo() {
		return tiempo;
	}
	
	@Override
	public void run() {
		System.out.println("Procesador iniciado");
		while(!this.stop) {
			try {
				Thread.sleep(1000);
				this.tiempo++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Procesador terminado al tiempo: "+this.tiempo);
	}

}
