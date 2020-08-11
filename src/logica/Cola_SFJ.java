package logica;

public class Cola_SFJ extends Cola{
	
	public Cola_SFJ(int IdCola,String NombreCola,int tiempoPE) {
		this.IdCola=IdCola;
		this.NombreCola=NombreCola;
		this.tiempoPE=tiempoPE;
	}

	//Ordenamiento Politica SFJ
	public void Ordenamiento() {
		System.out.println("Ordenamiento politica SFJ");
	}
}
