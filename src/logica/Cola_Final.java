package logica;

public class Cola_Final extends Cola {
	public void Ordenamiento() {

		//this.calcularTiemposProcesos();
	}

	public void CambiarRafaga(int rafagaEjecutada) {
		Proceso proceso = raiz.padre;
		if (proceso == this.raiz) {
			System.out.println("Cola Vacia");
			return;
		}
		this.raiz.padre.rafaga = rafagaEjecutada;
		//this.calcularTiemposProcesos();
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo=tiempo;
	}
	
	public void recalcularBloqueado(int rafagaEjecutada) {
		Proceso proceso = raiz.padre;
		if (proceso == this.raiz) {
			System.out.println("Cola Vacia");
			return;
		}
		Proceso p=this.raiz.padre;
		int aux = p.tfinal - p.tcomienzo - rafagaEjecutada; 
		p.rafaga = rafagaEjecutada;
		p.tfinal = p.tfinal-aux;
		p.tretorno = p.tretorno-aux;
		//System.out.println("Proceso reacomododo "+p.toString());
		this.raiz.padre=p;
	}
	
	//"Id proceso", "T.LLegada", "Rafaga", "T.Comienzo", "T.Final", "T.Retorno","T.Espera", "Cola Origen", "Cola Final" 
	
	public Object[][] infoProcesos(){
		//System.out.println("Numero de procesos Cola Final:"+this.getNumProcesos());
		Object[][] info= new Object[this.getNumProcesos()][9];
		Proceso aux = this.raiz;
		for(int i=0;i<this.getNumProcesos(); i++) {
			//System.out.println("i: "+i);
			aux=aux.sig;

			info[i][0]=aux.id;
			info[i][1]=aux.tllegada;
			info[i][2]=aux.rafaga;
			info[i][3]=aux.tcomienzo;
			info[i][4]=aux.tfinal;
			info[i][5]=aux.tretorno;
			info[i][6]=aux.tespera;
			info[i][7]=aux.ColaProviene;
			info[i][8]=aux.NombreCola;
			
		}
		return info;
	}
}
