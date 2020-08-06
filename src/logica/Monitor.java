package logica;

public class Monitor {
	private Cola[] colas= new Cola[3];
	private int tiempo=0;
	private int[] tiemposPE=new int[3];
	public Monitor() {
		colas[0] = new Cola_RoundRobin();
		tiemposPE[0]= 0;
		colas[1] = new Cola_SFJ();
		tiemposPE[1]= 10;
		colas[2] = new Cola_FCFS();
		tiemposPE[2]= 20;
	}
	
	public void actualizarTiempo(int tiempo) {
		this.tiempo=tiempo;
	}
}
