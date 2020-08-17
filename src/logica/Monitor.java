package logica;

import java.util.ArrayList;

public class Monitor {
	private Cola[] colas = new Cola[4];
	@SuppressWarnings("unused")
	private int tiempo;

	public Monitor() {
		// inicializacion variables del monitor
		tiempo = 0;
		colas[0] = new Cola_RoundRobin(0, "RoundRobin", 0, 4);
		colas[1] = new Cola_SFJ(1, "SFJ", 10);
		colas[2] = new Cola_FCFS(2, "FCFS", 20);
		colas[3] = new Cola_Bloqueados(3);
	}

	// metodo para actualizar el tiempo
	public void actualizarTiempo(int tiempo) {
		this.tiempo = tiempo;
		for (Cola cola : colas) {
			cola.setTiempo(this.tiempo);
		}
		this.verificarPE();
		this.verificarBloquados();

	}

	// Insertar Proceso segun idCola
	public void InsertarProceso(int rafaga, int tllegada, int idCola) {
		if (idCola > 3 || idCola < 0 || rafaga < 0 || tllegada < 0) {
			System.out.println("Datos incorrectos, no es posible añadir proceso");
			return;
		}
		colas[idCola].insertar(rafaga, tllegada);
	}

	// Retorna un proceso segun la prioridad y si hay procesos
	public Proceso ObtenerProceso() {
		Proceso p = null;
		for (int id = 0; id < 3; id++) {
			Cola cola = colas[id];
			if (cola.colaVacia())
				continue;
			p = cola.atender();
			return p;
		}
		return null;
	}

	// metodo para verificar politica de envejecimiento y cambiar procesos de cola
	// si es necesario
	public void verificarPE() {
		for (int c = 2; c > 0; c--) {
			Cola cola = colas[c];
			ArrayList<Proceso> procesosEnvejecidos = cola.procesosPoliticaEnvejecimiento();
			if (procesosEnvejecidos == null)
				continue;
			Cola nuevaCola = colas[c - 1];
			System.out.println("Cola " + cola.NombreCola + " con " + procesosEnvejecidos.size()
					+ " procesos para pasar a la Cola " + nuevaCola.NombreCola + " al tiempo: " + this.tiempo);
			for (Proceso proceso : procesosEnvejecidos) {
				nuevaCola.insertar(proceso, this.tiempo);
				System.out.println("Proceso " + proceso.id + " pasa de la cola " + cola.NombreCola + " a la cola "
						+ nuevaCola.NombreCola);
			}
		}

	}

	// Revisa si hay bloqueados para reingresar a su cola
	public void verificarBloquados() {
		Cola_Bloqueados colaBloqueados = (Cola_Bloqueados) colas[3];
		Proceso proceso = colaBloqueados.desbloquear();
		if (proceso != null) {
			System.out.println("Reinsertando proceso bloqueado " + proceso.id + " a la cola " + proceso.NombreCola);
			Cola cola = colas[proceso.IdCola];
			cola.insertar(proceso, this.tiempo);
		}
	}

	// bloquear un proceso
	public void bloquearProceso(Proceso p) {
		System.out.println("bloqueado" + p.toString());
		Cola_Bloqueados colaBloqueados = (Cola_Bloqueados) colas[3];
		colaBloqueados.bloquear(p);
	}

	// retorna el Quantum de la cola Round Robin
	public int QuantumColaRR() {
		Cola_RoundRobin cola = (Cola_RoundRobin) colas[0];
		return cola.getQuantum();
	}

	public void reinsertarProcesoRR(Proceso p) {
		colas[0].insertar(p);
	}

	public void mostrarColasConsola() {
		for (int id = 0; id < 4; id++) {
			Cola cola = colas[id];
			if (cola.colaVacia())
				continue;
			System.out.println("\nCola: " + cola.NombreCola + "| numero de procesos: " + cola.getNumProcesos());
			cola.mostrarConsola();
		}
	}
}
