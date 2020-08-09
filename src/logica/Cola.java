package logica;

import java.util.ArrayList;


public class Cola {
	@SuppressWarnings("unused")
	private int numProcesos;
	private Proceso raiz;
	@SuppressWarnings("unused")
	private int rafagaTotal;
	public int tiempo;
	@SuppressWarnings("unused")
	private int barrera;
	@SuppressWarnings("unused")
	private Proceso cabeza;
	@SuppressWarnings("unused")
	private int espera;
	private int caracter;
	@SuppressWarnings("unused")
	private String idcola;
	
	Cola(){
		//inicializacion variables de Cola
		this.numProcesos=0;
		this.rafagaTotal=0;
		this.tiempo=0;
		this.caracter=65;
		
		//inicializacion raiz
		this.raiz = new Proceso();
		this.raiz.rafaga = -1;
		this.raiz.id = "-1";
		this.raiz.sig = raiz;
		this.raiz.padre = raiz;
		cabeza = raiz.sig;
	}

	//insertar un proceso nuevo
	public void insertar(int rafaga, int tiempo) {
		if (rafaga <= 0 || tiempo<0 ) {
			return;
		}
		Proceso nuevo = new Proceso();
		nuevo.id=String.valueOf((char)this.caracter);
		this.caracter++;
		nuevo.rafaga=rafaga;
		nuevo.tllegada=tiempo;
		if (raiz.sig == raiz) {
			raiz.sig = nuevo;
			cabeza=nuevo;
			nuevo.sig = raiz;
			nuevo.padre = raiz;
			raiz.padre = nuevo;
		}else {
			Proceso aux = raiz.padre;
			aux.sig = nuevo;
			nuevo.sig = raiz;
			raiz.padre = nuevo;
			nuevo.padre = aux;
		}
		this.numProcesos++;
		this.rafagaTotal+=rafaga;
	}
	
	//insertar un proceso existente
	public void insertar(Proceso p) {
		if (p==null) {
			return;
		}
		Proceso nuevo = new Proceso();
		nuevo.rafaga = p.rafaga;
		int tamañoId=p.id.length();
		if(tamañoId==1) {
			nuevo.id=p.id+"1";
		}else {
			char id=p.id.charAt(0);
			int numeroId=Integer.parseInt(String.valueOf(p.id.charAt(1)))+1;
			nuevo.id=String.valueOf(id)+String.valueOf(numeroId);
		} 
		nuevo.tllegada = p.tllegada;
		if (raiz.sig == raiz) {
			raiz.sig = nuevo;
			cabeza=nuevo;
			nuevo.sig = raiz;
			nuevo.padre = raiz;
			raiz.padre = nuevo;
		}else {
			Proceso aux = raiz.padre;
			aux.sig = nuevo;
			nuevo.sig = raiz;
			raiz.padre = nuevo;
			nuevo.padre = aux;
		}
		this.numProcesos++;
		this.rafagaTotal+=nuevo.rafaga;
	}
	
	//insertar un proceso existente con nuevo tiempo de llegada
	public void insertar(Proceso p, int tiempo) {
		if (p==null || tiempo<0) {
			return;
		}
		Proceso nuevo = new Proceso();
		nuevo.rafaga = p.rafaga;
		nuevo.id = p.id;
		nuevo.tllegada = tiempo;
		nuevo.tesperaRetorno = p.tesperaRetorno;
		if (raiz.sig == raiz) {
			raiz.sig = nuevo;
			cabeza=nuevo;
			nuevo.sig = raiz;
			nuevo.padre = raiz;
			raiz.padre = nuevo;
		}else {
			Proceso aux = raiz.padre;
			aux.sig = nuevo;
			nuevo.sig = raiz;
			raiz.padre = nuevo;
			nuevo.padre = aux;
		}
		this.numProcesos++;
		this.rafagaTotal+=nuevo.rafaga;
		
	}
	
	//atender el primer proceso en la cola
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
		return proceso;
	}
	
	//Atender cualquier proceso de la cola
	public Proceso[] validar_cambio_cola(int barrera) {
		ArrayList<Proceso> prosacar = new ArrayList<Proceso>();
		Proceso aux = this.raiz.sig;
		while(aux != this.raiz) {
			System.out.println(aux.tesperaRetorno+" hola");
			
			if (aux.tesperaRetorno >= barrera) {
				Proceso auxp = aux.padre;
				auxp.sig = aux.sig;
				aux.sig.padre = auxp;
				aux.padre = null;
				prosacar.add(aux);
				System.out.println("Hola");
			}
			
			aux = aux.sig;
		}
		System.out.println(barrera+" barrera");
		System.out.println(prosacar.size());
		Proceso [] psalir = new Proceso[prosacar.size()];
		for (int i = 0 ; i < psalir.length ; i ++) {
			psalir[i] = prosacar.get(i);
		}
		return psalir;
	}
	
	//Cola vacia
	public boolean colaVacia() {
		if(raiz.sig==raiz) {
			return true;
		}
		return false;
	}
	
	//muestra en consola los procesos en cola con su informacion
	public void mostrarConsola() {
		Proceso aux = this.raiz;
		//int i=this.numProcesos;
		while (aux.sig != this.raiz /*i>0*/) {
			//i--;
			aux = aux.sig;
			System.out.println(aux.padre.id+" | " +aux.sig.id+" | " +  aux.id + " | " + aux.tllegada + " | " + aux.rafaga + " | " + aux.tcomienzo + " | "
					+ aux.tfinal + " | " + aux.tretorno + " | " + aux.tespera+" | "+aux.ejecutado);
		}
	}
}
