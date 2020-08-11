package logica;

public class Cola_RoundRobin extends Cola{
	
	public Cola_RoundRobin(int IdCola,String NombreCola,int tiempoPE) {
		this.IdCola=IdCola;
		this.NombreCola=NombreCola;
		this.tiempoPE=tiempoPE;
	}
	
	//Ordenamiento Politica Round Robin
	public void Ordenamiento() {
		System.out.println("Ordenamiento Politica Round Robin");
	}

}
