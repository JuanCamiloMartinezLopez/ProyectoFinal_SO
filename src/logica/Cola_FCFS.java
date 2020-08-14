package logica;

public class Cola_FCFS extends Cola{
	
	public Cola_FCFS(int IdCola, String NombreCola,int tiempoPE) {
		this.IdCola=IdCola;
		this.NombreCola=NombreCola;
		this.tiempoPE=tiempoPE;
	}
	
	//Ordenamiento Politica FCFS
	public void Ordenamiento() {
		//Primero en llegar, primero en ejecutarse 
		//System.out.println("Ordenamiento Politica FCFS");
		this.calcularTiemposProcesos();
	}

}
