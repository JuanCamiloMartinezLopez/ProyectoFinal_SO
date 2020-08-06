package logica;

public class Monitor {
	private Cola[] colas= new Cola[1];
	private int tiempo=0;
	public Monitor() {
		for(Cola cola:colas) {
			cola= new Cola();
		}
	}
	
	public void actualizarTiempo() {
		
	}
}
