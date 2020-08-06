package logica;

public class Main {

	public static void main(String[] args) {
		Cola prueba= new Cola();
		prueba.insertar(1, 0);
		prueba.insertar(2, 1);
		prueba.insertar(3, 2);
		prueba.mostrarConsola();
		Proceso proc= prueba.atender();
		System.out.println("\nProceso Atendido: "+proc.id + " | " + proc.tllegada + " | " + proc.rafaga+"\n");
		prueba.mostrarConsola();
		System.out.println("\nReinsertando el proceso "+proc.id+"\n");
		prueba.insertar(proc);
		prueba.mostrarConsola();
		proc= prueba.atender();
		System.out.println("\nProceso Atendido: "+proc.id + " | " + proc.tllegada + " | " + proc.rafaga+"\n");
		prueba.mostrarConsola();
		System.out.println("\nReinsertando el proceso "+proc.id+" con un nuevo tiempo de llegada\n");
		prueba.insertar(proc, 4);
		prueba.mostrarConsola();
		proc= prueba.atender();
		System.out.println("\nProceso Atendido: "+proc.id + " | " + proc.tllegada + " | " + proc.rafaga+"\n");
		prueba.mostrarConsola();
		proc= prueba.atender();
		System.out.println("\nProceso Atendido: "+proc.id + " | " + proc.tllegada + " | " + proc.rafaga+"\n");
		System.out.println("\nReinsertando el proceso "+proc.id+"\n");
		prueba.insertar(proc);
		prueba.mostrarConsola();
	}

}
