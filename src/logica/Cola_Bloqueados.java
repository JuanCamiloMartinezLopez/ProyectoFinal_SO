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
	
	public void setTiempo(int tiempo) {
		this.tiempo=tiempo;
	}
	

	// insertar un proceso para bloquear
	public void bloquear(Proceso p) {

		if (p == null) {
			return;
		}
		System.out.println("llego un proceso para bloquear: " + p.id);
		Proceso nuevo= new Proceso();
		nuevo=p;
		nuevo.rafaga = p.rafagaRestante();
		//p.rafagaEjecutada=0;
		nuevo.tbloqueo = this.tiempo + 1;
		System.out.println("tiempo Bloqueado: " + nuevo.tbloqueo);
		
		if (this.raiz.sig == this.raiz) {
			this.raiz.sig = nuevo;
			nuevo.sig = this.raiz;
			nuevo.padre = this.raiz;
			this.raiz.padre = nuevo;
		} else {
			Proceso aux = this.raiz.padre;
			aux.sig = nuevo;
			nuevo.sig = this.raiz;
			this.raiz.padre = nuevo;
			nuevo.padre = aux;
		}
		//System.out.println("proceso insertado: " + nuevo.toString());
		this.mostrarConsola();
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
			this.numProcesosBloqueados--;
			return aux;
		}
		return null;
	}
	
	public Object[][] infoProcesos(){
		System.out.println("Numero de procesos Cola bloqueados:"+this.numProcesosBloqueados);
		Object[][] info= new Object[this.numProcesosBloqueados][3];
		Proceso aux = this.raiz;
		int i=0;
		while (aux.sig != this.raiz) {
			aux=aux.sig;

			info[i][0]=aux.id;
			info[i][1]=aux.NombreCola;
			info[i][2]=this.tiempo - aux.tbloqueo + 1;
			
			i++;
		}
		return info;
	}
	
	public int getNumProcesos() {
		return this.numProcesosBloqueados;
	}
}
