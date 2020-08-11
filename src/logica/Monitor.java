package logica;

public class Monitor {
	private Cola[] colas= new Cola[3];
	@SuppressWarnings("unused")
	private int tiempo;
	
	public Monitor() {
		//inicializacion variables del monitor
		tiempo=0;
		colas[0] = new Cola_RoundRobin(0);
		colas[1] = new Cola_SFJ(10);
		colas[2] = new Cola_FCFS(20);
	}
	
	//metodo para actualizar el tiempo
	public void actualizarTiempo(int tiempo) {
		this.tiempo=tiempo;
	}
}
