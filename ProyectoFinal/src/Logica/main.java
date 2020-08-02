package Logica;

public class main {

	public static void main(String[] args) {
		Cola sfj = new Cola(1,15,"A");
		int tiempo = 0;
		sfj.insertar(null, 14, tiempo, false);
		tiempo++;
		sfj.insertar(null, 20, tiempo, false);
		tiempo++;
		sfj.insertar(null, 5, tiempo, false);
		sfj.insertar(null, 3, tiempo, false);
		sfj.insertar(null, 4, tiempo, false);
		Proceso a = new Proceso();
		a.id = "1,0,B";
		a.rafaga = 550;
		a.tllegada = 5;
		sfj.insertar(a,a.rafaga,tiempo,true);
		sfj.insertar(null, 4, tiempo, false);
		a = new Proceso();
		a.id = "5,0,B";
		a.rafaga = 70;
		a.tllegada = 3;
		sfj.insertar(a,a.rafaga,tiempo,false);
		sfj.mostrarConsola();

	}

}
