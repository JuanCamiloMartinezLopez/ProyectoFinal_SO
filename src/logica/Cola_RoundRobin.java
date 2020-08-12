package logica;

public class Cola_RoundRobin extends Cola{
	private int Quantum;
	
	public Cola_RoundRobin(int IdCola,String NombreCola,int tiempoPE, int Quantum) {
		this.IdCola=IdCola;
		this.NombreCola=NombreCola;
		this.tiempoPE=tiempoPE;
		this.Quantum=Quantum;
	}
	
	public void calcularTiemposProcesos() {
		System.out.println("Calculo de tiempos para el round robin con el Quantum: "+ this.Quantum);
	}
	
	//Ordenamiento Politica Round Robin
	public void Ordenamiento() {
		// Politica con un Quantum limite para la ejecucion del proceso
		System.out.println("Ordenamiento Politica Round Robin");
		this.calcularTiemposProcesos();
	}

}
