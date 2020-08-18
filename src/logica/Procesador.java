package logica;

import java.awt.Graphics;
import java.util.Scanner;

import GUI.Gui;

public class Procesador implements Runnable {
	private int tiempo = -1;
	private Thread runThread;
	private boolean stop;
	private Monitor monitor;
	private Proceso procesoEjecutar = null;
	public Cola_Final cola = new Cola_Final();
	private Graphics gantt;

	public Gui interfaz;
	private boolean pausa = false;

	public Procesador() {
		this.monitor = new Monitor();
	}

	public Procesador(Gui interfaz) {
		this.monitor = new Monitor();
		this.interfaz = interfaz;
	}

	public Cola[] procesosEnColas() {

		return this.monitor.getColas();
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

	public void pausar_despuasar() {
		this.pausa = !this.pausa;
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
		if (this.procesoEjecutar == null) {
			System.out.println("No hay proceso para ejecutar, obteniendo Proceso....");
			this.procesoEjecutar = this.monitor.ObtenerProceso();
			if (this.procesoEjecutar != null) {
				cola.InsertarProceso(this.procesoEjecutar.duplicar());
			}
		}
		if (this.procesoEjecutar != null) {

			this.procesoEjecutar.rafagaEjecutada++;
			System.out.println("Ejecutando el proceso " + this.procesoEjecutar.id + " con rafaga restante "
					+ this.procesoEjecutar.rafagaRestante() + " de la cola " + this.procesoEjecutar.NombreCola);
			// Ejecucion proceso Round Robin;
			if (this.procesoEjecutar.IdCola == 0) {
				this.ejecucionProcesoRoundRobin();
			}
			if (this.procesoEjecutar != null) {
				if (this.procesoEjecutar.rafagaRestante() <= 0) {
					System.out.println("Proceso " + this.procesoEjecutar.id + " de la cola "
							+ this.procesoEjecutar.NombreCola + " ejecutado con exito");
					this.procesoEjecutar = null;
				}
			}
		} else {
			System.out.println("No hay mas procesos en las colas");
			// this.detener();
		}

	}

	public Cola_Final getCola_final() {
		return cola;
	}

	// muestra en consola la informacion de las colas
	public void mostrarColas() {
		this.monitor.mostrarColasConsola();
	}

	// ejecucion para el quantum del round robin
	public void ejecucionProcesoRoundRobin() {
		int quantum = this.monitor.QuantumColaRR();
		if (this.procesoEjecutar.rafagaEjecutada % quantum == 0 && this.procesoEjecutar.rafagaRestante() > 0) {
			System.out.println(
					"Proceso " + this.procesoEjecutar.id + " retornado a la cola Round Robin por Quatum de " + quantum);

			this.procesoEjecutar.rafaga = this.procesoEjecutar.rafagaRestante();
			this.procesoEjecutar.rrejecutada = this.procesoEjecutar.rrejecutada + this.procesoEjecutar.rafagaEjecutada;
			this.monitor.reinsertarProcesoRR(procesoEjecutar.duplicar());
			cola.CambiarRafaga(this.procesoEjecutar.rafagaEjecutada);
			this.procesoEjecutar.rafagaEjecutada = 0;
			this.procesoEjecutar = null;
		}
	}

	public void bloquearProcesoEjecutar() {
		if (this.procesoEjecutar == null)
			return;
		System.out.println("Bloquando proceso " + this.procesoEjecutar.id + " al tiempo " + this.tiempo);
		Proceso p = new Proceso();
		p = this.procesoEjecutar.duplicar();
		this.monitor.bloquearProceso(p);
		cola.recalcularBloqueado(this.procesoEjecutar.rafagaEjecutada);
		this.procesoEjecutar = null;
	}
	
	public void dibujarGantt() {
		
	}

	@Override
	public void run() {
		System.out.println("\nProcesador iniciado\n");

		while (!this.stop) {
			System.out.println("\n------------------------------");
			if (!this.pausa) {
				this.tiempo++;
				System.out.println("tiempo: " + this.tiempo);
				this.monitor.actualizarTiempo(this.tiempo);
				this.EjecutarProceso();
				this.interfaz.setTiempo(this.tiempo);
				this.mostrarColas();
			} else {
				System.out.println("Procesador pausado");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n------------------------------");
		}
		System.out.println("\nProcesador terminado al tiempo: " + this.tiempo);
		this.cola.mostrarConsola();
	}

	public void setGantt(Graphics gantt) {
		this.gantt = gantt;
	}

}
