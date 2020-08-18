package logica;

public class Cola_RoundRobin extends Cola{
	private int Quantum;
	
	public Cola_RoundRobin(int IdCola,String NombreCola,int tiempoPE, int Quantum) {
		this.IdCola=IdCola;
		this.NombreCola=NombreCola;
		this.tiempoPE=tiempoPE;
		this.Quantum=Quantum;
	}
	
	public int getQuantum() {
		return Quantum;
	}
	
	public void calcularTiemposProcesos() {
		//System.out.println("Calculo de tiempos para el round robin con el Quantum: "+ this.Quantum);
		Proceso aux= this.raiz.sig;
		aux.tcomienzo=this.tiempo;
		if (aux.tcomienzo < aux.tllegada) {
			aux.tcomienzo = aux.tllegada;
		}
		int rafaga=aux.rafaga;
		if(rafaga<this.Quantum) {
			aux.tfinal=aux.rafaga+aux.tcomienzo;
		}else {
			aux.tfinal=this.Quantum+aux.tcomienzo;
		}
		aux.tretorno=aux.tfinal-aux.tllegada;
		if(rafaga < this.Quantum) {
			aux.tespera = aux.tretorno-aux.rafaga-aux.rrejecutada;
		}else {
			aux.tespera = aux.tretorno-this.Quantum-aux.rrejecutada;
		}
		if(aux.tespera<0) {
			aux.tespera=0;
		}
		aux=aux.sig;
		while(aux!=this.raiz) {
			rafaga=aux.rafaga;
			//tiempo comienzo
			aux.tcomienzo=aux.padre.tfinal;
			//tiempo final
			if(rafaga<this.Quantum) {
				aux.tfinal=aux.rafaga+aux.tcomienzo;
			}else {
				aux.tfinal=this.Quantum+aux.tcomienzo;
			}
			//tiempo retorno
			aux.tretorno=aux.tfinal-aux.tllegada;
			//tiempo espera
			//System.out.println(aux.rafagaEjecutada+" rafaga ejecurada");
			if(rafaga < this.Quantum) {
				aux.tespera = aux.tretorno-aux.rafaga-aux.rrejecutada;
			}else {
				aux.tespera = aux.tretorno-this.Quantum-aux.rrejecutada;
			}
			aux=aux.sig;
		}
	}
	
	//Ordenamiento Politica Round Robin
	public void Ordenamiento() {
		// Politica con un Quantum limite para la ejecucion del proceso
		//System.out.println("Ordenamiento Politica Round Robin");
		this.calcularTiemposProcesos();
	}

}
