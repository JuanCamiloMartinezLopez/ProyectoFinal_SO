package logica;

public class Procesador implements Runnable {
	private int tiempo = 0;
	private Thread runThread;
	private boolean stop;
	private Monitor monitor;
	private Proceso procesoEjecutar = null;

	public Procesador() {
		this.monitor = new Monitor();
	}

	public void iniciar() {
		this.runThread = new Thread(this);
		this.stop = false;
		this.runThread.start();
	}

	public void reiniciar() {
		this.tiempo = 0;
		// this.runThread= new Thread(this);
		// this.runThread.start();
	}

	public void detener() {
		this.stop = true;
	}

	public int getTiempo() {
		return tiempo;
	}

	// inserta un proceso en la cola segun la id
	public void insertarProcesoCola(int rafaga, int tllegada, int idCola) {
		this.monitor.InsertarProceso(rafaga, tllegada, idCola);
	}

	// Ejecuta la rafaga del proceso, si hay, si no, solicita un proceso
	public void EjecutarProceso() {
		this.mostrarColas();
		if (this.procesoEjecutar == null) {
			System.out.println("No hay proceso para ejecutar, obteniendo Proceso....");
			this.procesoEjecutar = this.monitor.ObtenerProceso();
		}
		if(this.procesoEjecutar!=null) {
			System.out.println("Ejecutando el proceso " + this.procesoEjecutar.id +" con rafaga restante "+this.procesoEjecutar.rafaga+" de la cola "+this.procesoEjecutar.NombreCola);
			this.procesoEjecutar.rafaga--;
			if (this.procesoEjecutar.rafaga <= 0) {
				System.out.println("Proceso "+this.procesoEjecutar.id+" de la cola "+this.procesoEjecutar.NombreCola +" ejecutado con exito");
				this.procesoEjecutar = null;
			}
		}else {
			System.out.println("No hay mas procesos en las colas");
			this.detener();
		}
	}

	// muestra en consola la informacion de las colas
	public void mostrarColas() {
		this.monitor.mostrarColasConsola();
	}

	@Override
	public void run() {
		System.out.println("\nProcesador iniciado\n");

		while (!this.stop) {
			System.out.println("\n------------------------------");
			System.out.println("tiempo: " + this.tiempo);
			try {
				this.monitor.actualizarTiempo(this.tiempo);
				this.EjecutarProceso();
				this.tiempo++;
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n------------------------------");
		}
		System.out.println("\nProcesador terminado al tiempo: " + this.tiempo);
	}

}
