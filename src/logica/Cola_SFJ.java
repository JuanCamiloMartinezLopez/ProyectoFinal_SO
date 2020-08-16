package logica;

import java.util.ArrayList;
import java.util.Collections;

public class Cola_SFJ extends Cola {

	public Cola_SFJ(int IdCola, String NombreCola, int tiempoPE) {
		this.IdCola = IdCola;
		this.NombreCola = NombreCola;
		this.tiempoPE = tiempoPE;
	}

	// Ordenamiento Politica SFJ
	public void Ordenamiento() {
		// El mas corto primero
		System.out.println("Ordenamiento politica SFJ");
		Proceso aux = this.raiz;
		ArrayList<Proceso> procesos = new ArrayList<Proceso>();
		while (aux.sig != this.raiz) {
			aux = aux.sig;
			procesos.add(aux);
		}
		Collections.sort(procesos, Proceso.ProcesoRafaga);
		//System.out.println("\n-------------");
		//System.out.println("Numero de procesos: " + procesos.size());
		//for (Proceso p : procesos) {
			//System.out.println(p.toString());
		//}
		this.raiz.sig = this.raiz;
		this.raiz.padre = this.raiz;
		for(Proceso p: procesos) {
			if (raiz.sig == raiz) {
				raiz.sig = p;
				p.sig = raiz;
				p.padre = raiz;
				raiz.padre = p;
			} else {
				Proceso aux2 = raiz.padre;
				aux2.sig = p;
				p.sig = raiz;
				raiz.padre = p;
				p.padre = aux2;
			}
		}
		//System.out.println("-------------");
		this.calcularTiemposProcesos();
		//System.out.println("\nCola final\n");
		//this.mostrarConsola();
	}
}
