package Logica;

public class Cola {
	private int procesos = 0;
	private Proceso raiz;
	private int rafagaTotal = 0;
	public int t = 0;
	private String index = "0,0, ";
	private int barrera = 0;
	private Proceso cabeza;
	private int prioridad;
	private int espera;
	private String idcola;
	
	Cola(int prioridad, int espera, String idcola){
		this.raiz = new Proceso();
		this.raiz.rafaga = -1;
		this.raiz.id = "-1";
		this.raiz.sig = raiz;
		this.raiz.padre = raiz;
		this.prioridad = prioridad;
		this.espera = espera;
		this.idcola = idcola;
		cabeza = raiz.sig;
	}

	public void insertar(Proceso a, int rafaga, int tiempo, boolean mover) {
		if (rafaga <= 0 ) {
			return;
		}
		Proceso nuevo = new Proceso();
		if (a == null) {
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
		}
		if (raiz.sig == raiz) {
			raiz.sig = nuevo;
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
		procesos++;
		rafagaTotal+=rafaga;
	}
	public void mostrarConsola() {
		Proceso aux = raiz;
		while (aux.sig != raiz) {
			aux = aux.sig;
			System.out.println(aux.id + " | " + aux.tllegada + " | " + aux.rafaga + " | " + aux.tcomienzo + " | "
					+ aux.tfinal + " | " + aux.tretorno + " | " + aux.tespera+" | "+aux.ejecutado);
		}
	}
}
