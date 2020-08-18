package logica;

public class Cola_Final extends Cola {
	public void Ordenamiento() {

		this.calcularTiemposProcesos();
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
	public void recalcularBloqueado(int rafagaEjecutada) {
		Proceso proceso = raiz.padre;
		if (proceso == this.raiz) {
			System.out.println("Cola Vacia");
			return;
		}
		int aux = this.raiz.padre.tfinal - this.raiz.padre.tcomienzo - rafagaEjecutada; 
		this.raiz.padre.rafaga = rafagaEjecutada;
		this.raiz.padre.tfinal = this.raiz.padre.tfinal-aux;
		this.raiz.padre.tretorno = this.raiz.padre.tretorno-aux;
	}
	
	//"Id proceso", "T.LLegada", "Rafaga", "T.Comienzo", "T.Final", "T.Retorno","T.Espera", "Cola Origen", "Cola Final" 
	
	public Object[][] infoProcesos(){
		System.out.println("Numero de procesos Cola Final:"+this.getNumProcesos());
		Object[][] info= new Object[this.getNumProcesos()][9];
		Proceso aux = this.raiz;
		int i=0;
		while (aux.sig != this.raiz) {
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
			i++;
		}
		return info;
	}
}
