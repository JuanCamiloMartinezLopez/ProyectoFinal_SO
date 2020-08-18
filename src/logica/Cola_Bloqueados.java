package logica;

public class Cola_Bloqueados extends Cola {
	private int tiempoBloqueo;
	@SuppressWarnings("unused")
	private int numProcesosBloqueados;

	public Cola_Bloqueados(int tiempoBloqueo) {
		this.IdCola=3;
		this.NombreCola = "Bloqueados";
		this.tiempoBloqueo = tiempoBloqueo + 1;
		this.numProcesosBloqueados = 0;
	}

	// insertar un proceso para bloquear
	public void bloquear(Proceso p) {

		if (p == null) {
			return;
		}
		System.out.println("llego un proceso para bloquear: " + p.id);
		p.rafaga = p.rafagaRestante();
		p.rafagaEjecutada = 0;
		p.tbloqueo = this.tiempo + 1;
		System.out.println("tiempo Bloqueado: " + p.tbloqueo);
		if (this.raiz.sig == this.raiz) {
			this.raiz.sig = p;
			p.sig = this.raiz;
			p.padre = this.raiz;
			this.raiz.padre = p;
		} else {
			Proceso aux = this.raiz.padre;
			aux.sig = p;
			p.sig = this.raiz;
			this.raiz.padre = p;
			p.padre = aux;
		}
		this.numProcesosBloqueados++;
	}

	// retorna un proceso desbloqueado
	public Proceso desbloquear() {
		if (this.colaVacia()) {
			return null;
		}
		Proceso aux = this.raiz.sig;
		int tiempoEnCola = this.tiempo - aux.tbloqueo + 1;
		System.out.println("tiempo en la cola de bloqueados: " + tiempoEnCola);
		if (tiempoEnCola >= this.tiempoBloqueo) {
			Proceso sig = aux.sig;
			Proceso padre = this.raiz;
			padre.sig = sig;
			sig.padre = padre;
			this.calcularTiemposProcesos();
			return aux;
		}
		return null;
	}
}
