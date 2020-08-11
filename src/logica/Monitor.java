package logica;

public class Monitor {
	private Cola[] colas= new Cola[4];
	@SuppressWarnings("unused")
	private int tiempo;
	
	public Monitor() {
		//inicializacion variables del monitor
		tiempo=0;
		colas[0] = new Cola_RoundRobin(0,"RoundRobin",0);
		colas[1] = new Cola_SFJ(1,"SFJ",10);
		colas[2] = new Cola_FCFS(2,"FCFS",20);
		colas[3] = new Cola_Bloqueados(3);
	}
	
	//metodo para actualizar el tiempo
	public void actualizarTiempo(int tiempo) {
		this.tiempo=tiempo;
		
	}
	
	//Insertar Proceso segun idCola
	public void InsertarProceso(int rafaga, int tllegada, int idCola) {
		if(idCola>3 || idCola<0 || rafaga<0 || tllegada<0) {
			System.out.println("Datos incorrectos, no es posible añadir proceso");
			return;
		}
		colas[idCola].insertar(rafaga, tllegada);
	}

	//Retorna un proceso segun la prioridad y si hay procesos
	public Proceso ObtenerProceso() {
		Proceso p=null;
		for(int id= 0; id <3; id++) {
			Cola cola=colas[id];
			if(cola.colaVacia())continue;
			p=cola.atender();
			return p;
		}
		return null;
	}
	
	//metodo para verificar politica de envejecimiento y cambiar procesos de cola si es necesario
	public void verificarPE() {
		
	}
	
	public void mostrarColasConsola() {
		for(int id= 0; id <3; id++) {
			Cola cola=colas[id];
			if(cola.colaVacia())continue;
			System.out.println("\nCola "+cola.NombreCola);
			cola.mostrarConsola();
		}
	}
}
