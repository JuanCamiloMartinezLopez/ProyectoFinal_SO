package logica;

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
		this.barrera=0;
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
		if (rafaga <= 0 ) {
			return;
		}
		Proceso nuevo = new Proceso();
		/*if (a == null) {
			String [] aindex = index.split(",");
			aindex[2] = idcola;
			index = String.valueOf(Integer.valueOf(aindex[0])+1);
			index = index+","+aindex[1]+","+aindex[2];
			nuevo.id = index;
			nuevo.rafaga = rafaga;
			nuevo.tllegada = tiempo;
		}else {
			String auxindex = "";
			if (mover) {
				nuevo.rafaga = a.rafaga;
				nuevo.id = a.id;
				nuevo.tllegada = tiempo;
			}else {
				nuevo.rafaga = rafaga;
				String [] aindex = a.id.split(",");
				auxindex  = String.valueOf(Integer.valueOf(aindex[1])+1);
				auxindex  = aindex[0]+","+auxindex +","+aindex[2];
				nuevo.id = auxindex ;
				nuevo.tllegada = a.tllegada;
			}
		}*/
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
