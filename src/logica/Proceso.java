	package logica;

import java.util.Comparator;

public class Proceso{
	public int rafaga;
	public int tllegada;
	public int tcomienzo;
	public int tfinal;
	public int tretorno;
	public int prioridad;
	public int tespera;
	public String id;
	public Proceso padre;
	public Proceso sig;
	public boolean ejecutado;
	public int tbloqueo;
	public int tesperaRetorno;
	public int IdCola;
	public String NombreCola;
	public int rafagaEjecutada;
	public int rrejecutada;
	public String ColaProviene;

	public Proceso() {
		sig = null;
		padre = null;
		ejecutado = false;
		rafagaEjecutada = 0;
		rrejecutada = 0;
		ColaProviene = "";
	}

	public int getRafaga() {
		return rafaga;
	}

	public int rafagaRestante() {
		return rafaga - rafagaEjecutada;
	}

	public static Comparator<Proceso> ProcesoRafaga = new Comparator<Proceso>() {

		public int compare(Proceso p1, Proceso p2) {

			int rafaga1 = p1.getRafaga();
			int rafaga2 = p2.getRafaga();

			/* For ascending order */
			return rafaga1 - rafaga2;

			/* For descending order */
			// rollno2-rollno1;
		}
	};

	// aux.padre.id + " | " + aux.sig.id + " | " + aux.id + " | " + aux.tllegada + "
	// | "
	// + aux.rafaga + " | " + aux.tcomienzo + " | " + aux.tfinal + " | " +
	// aux.tretorno + " | "
	// + aux.tespera + " | " + aux.ejecutado
	@Override
	public String toString() {
		try {
			return "[ Padre: " + this.padre.id + ", Sig: " + this.sig.id + ", id: " + this.id + ", tllegada: "
					+ this.tllegada + ", rafaga: " + this.rafaga + ", tComienzo: " + this.tcomienzo + ", tFinal: "
					+ this.tfinal + ", tRetorno: " + this.tretorno + ", tEspera: " + this.tespera + "]";
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "Falló";
	}
	
	public Proceso duplicar() {
		Proceso duplicado=new Proceso();
		duplicado.rafaga=this.rafaga;
		duplicado.tllegada=this.tllegada;
		duplicado.tcomienzo=this.tcomienzo;
		duplicado.tfinal=this.tfinal;
		duplicado.tretorno=this.tretorno;
		duplicado.prioridad=this.prioridad;
		duplicado.tespera=this.tespera;
		duplicado.id=this.id;
		duplicado.padre=this.padre;
		duplicado.sig=this.sig;
		duplicado.ejecutado=this.ejecutado;
		duplicado.tbloqueo=this.tbloqueo;
		duplicado.tesperaRetorno=this.tesperaRetorno;
		duplicado.IdCola=this.IdCola;
		duplicado.NombreCola=this.NombreCola;
		duplicado.rafagaEjecutada=this.rafagaEjecutada;
		duplicado.rrejecutada=this.rrejecutada;
		duplicado.ColaProviene=this.ColaProviene;
		return duplicado;
	}
}
