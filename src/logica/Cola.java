package logica;

import java.util.ArrayList;

public class Cola {
	@SuppressWarnings("unused")
	private int numProcesos;
	public Proceso raiz;
	@SuppressWarnings("unused")
	private int rafagaTotal;
	public int tiempo;
	@SuppressWarnings("unused")
	private Proceso cabeza;
	@SuppressWarnings("unused")
	private int espera;
	private int caracter;
	@SuppressWarnings("unused")
	private String idcola;
	public int tiempoPE;
	public int IdCola;
	public String NombreCola;

	Cola() {
		// inicializacion variables de Cola
		this.numProcesos = 0;
		this.rafagaTotal = 0;
		this.tiempo = -1;
		this.caracter = 65;

		// inicializacion raiz
		this.raiz = new Proceso();
		this.raiz.rafaga = -1;
		this.raiz.id = "-1";
		this.raiz.sig = raiz;
		this.raiz.padre = raiz;
		cabeza = raiz.sig;
	}

	// insertar un proceso nuevo
	public void insertar(int rafaga, int tiempo) {
		if (rafaga <= 0 || tiempo < 0) {
			return;
		}
		Proceso nuevo = new Proceso();
		nuevo.id = String.valueOf((char) this.caracter);
		this.caracter++;
		nuevo.rafaga = rafaga;
		nuevo.tllegada = tiempo;
		nuevo.IdCola=this.IdCola;
		nuevo.NombreCola=this.NombreCola;
		if (nuevo.IdCola == 1) {
			nuevo.ColaProviene = "RR";
		}else if(nuevo.IdCola == 2 ) {
			nuevo.ColaProviene = "SJF";
		}else if(nuevo.IdCola == 3) {
			nuevo.ColaProviene = "FCFS";
		}
		if (raiz.sig == raiz) {
			raiz.sig = nuevo;
			cabeza = nuevo;
			nuevo.sig = raiz;
			nuevo.padre = raiz;
			raiz.padre = nuevo;
		} else {
			Proceso aux = raiz.padre;
			aux.sig = nuevo;
			nuevo.sig = raiz;
			raiz.padre = nuevo;
			nuevo.padre = aux;
		}
		this.numProcesos++;
		this.rafagaTotal += rafaga;
		this.Ordenamiento();
	}

	// insertar un proceso existente
	public void insertar(Proceso p) {
		if (p == null) {
			return;
		}
		Proceso nuevo = new Proceso();
		nuevo.rafaga = p.rafaga;
		nuevo.tllegada = p.tllegada;
		nuevo.IdCola=this.IdCola;
		nuevo.NombreCola=this.NombreCola;
		nuevo.rrejecutada = p.rrejecutada;
		nuevo.ColaProviene = p.ColaProviene;
		int tamañoId = p.id.length();
		if (tamañoId == 1) {
			nuevo.id = p.id + "1";
		} else {
			char id = p.id.charAt(0);
			int numeroId = Integer.parseInt(String.valueOf(p.id.charAt(1))) + 1;
			nuevo.id = String.valueOf(id) + String.valueOf(numeroId);
		}
		if (raiz.sig == raiz) {
			raiz.sig = nuevo;
			cabeza = nuevo;
			nuevo.sig = raiz;
			nuevo.padre = raiz;
			raiz.padre = nuevo;
		} else {
			Proceso aux = raiz.padre;
			aux.sig = nuevo;
			nuevo.sig = raiz;
			raiz.padre = nuevo;
			nuevo.padre = aux;
		}
		this.numProcesos++;
		this.rafagaTotal += nuevo.rafaga;
		this.Ordenamiento();
	}

	// insertar un proceso existente con nuevo tiempo de llegada
	public void insertar(Proceso p, int tiempo) {
		if (p == null || tiempo < 0) {
			return;
		}
		Proceso nuevo = new Proceso();
		nuevo.rafaga = p.rafaga;
		nuevo.id = p.id;
		nuevo.IdCola=this.IdCola;
		nuevo.NombreCola=this.NombreCola;
		nuevo.tllegada = tiempo;
		nuevo.ColaProviene = p.ColaProviene;
		
		if (raiz.sig == raiz) {
			raiz.sig = nuevo;
			cabeza = nuevo;
			nuevo.sig = raiz;
			nuevo.padre = raiz;
			raiz.padre = nuevo;
		} else {
			Proceso aux = raiz.padre;
			aux.sig = nuevo;
			nuevo.sig = raiz;
			raiz.padre = nuevo;
			nuevo.padre = aux;
		}
		this.numProcesos++;
		this.rafagaTotal += nuevo.rafaga;
		this.Ordenamiento();
	}

	// atender el primer proceso en la cola
	public Proceso atender() {
		Proceso proceso= raiz.sig;
		if(proceso==this.raiz) {
			System.out.println("Cola Vacia");
			return null;
		}
		Proceso sig= proceso.sig;
		Proceso padre= raiz;
		padre.sig=sig;
		sig.padre=padre;
		cabeza=sig;
		this.numProcesos--;
		this.calcularTiemposProcesos();
		return proceso;
	}

	// Cola vacia
	public boolean colaVacia() {
		if (raiz.sig == raiz) {
			return true;
		}
		return false;
	}
	
	// Retorna los procesos que deben cambiar de cola por politica de envejecimiento 
	public ArrayList<Proceso> procesosPoliticaEnvejecimiento() {
		ArrayList<Proceso> procesosPE = new ArrayList<Proceso>();
		Proceso aux = this.raiz.sig;
		while (aux != this.raiz) {
			int tiempoEnCola = this.tiempo - aux.tllegada+1;
			if (tiempoEnCola >= this.tiempoPE) {
				Proceso auxp = aux.padre;
				auxp.sig = aux.sig;
				aux.sig.padre = auxp;
				aux.padre = null;
				procesosPE.add(aux);
			}

			aux = aux.sig;
		}
		if (procesosPE.isEmpty()) {
			return null;
		}
		return procesosPE;
	}

	// Actualizacion del tiempo
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
		this.calcularTiemposProcesos();
	}
	
	//Ordenamiento para sobreescribir segun politica en las clases hijas
	public void Ordenamiento() {
		
	}
	
	public void calcularTiemposProcesos() {
		Proceso aux= this.raiz.sig;
		aux.tcomienzo=this.tiempo+1;
		if (aux.tcomienzo < aux.tllegada) {
			aux.tcomienzo = aux.tllegada;
		}
		aux.tfinal=aux.rafaga+aux.tcomienzo;
		aux.tretorno=aux.tfinal-aux.tllegada;
		aux.tespera=aux.tretorno-aux.rafaga;
		aux=aux.sig;
		while(aux!=this.raiz) {
			//tiempo comienzo
			aux.tcomienzo=aux.padre.tfinal;
			//tiempo final
			aux.tfinal=aux.rafaga+aux.tcomienzo;
			//tiempo retorno
			aux.tretorno=aux.tfinal-aux.tllegada;
			//tiempo espera
			aux.tespera=aux.tretorno-aux.rafaga;
			aux=aux.sig;
		}
	}

	// muestra en consola los procesos en cola con su informacion
	public void mostrarConsola() {
		Proceso aux = this.raiz;
		// int i=this.numProcesos;
		while (aux.sig != this.raiz /* i>0 */) {
			// i--;
			aux = aux.sig;
			System.out.println(aux.toString());
		}
	}

	public int getNumProcesos() {
		return numProcesos;
	}
}
