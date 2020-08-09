package logica;

public class Main {

	public static void main(String[] args) {
		/*
		Cola prueba= new Cola();
		prueba.insertar(5, 0);
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
		*/
		Proceso a = new Proceso();
		a.id = "F";
		a.rafaga = 5;
		a.tesperaRetorno = 20;
		
		Cola_RoundRobin cl = new Cola_RoundRobin();
		
		cl.insertar(5, 0);
		cl.insertar(2, 1);
		cl.insertar(3, 2);
		cl.insertar(a , 5);
		cl.mostrarConsola();
		System.out.println(cl.barrera);
		System.out.println(cl.validar_cambio_cola(cl.barrera).length);
	//	Proceso [] al = cl.validar_cambio_cola(cl.barrera);
	//	System.out.println(al.length);
	//	for (int i = 0 ; i <al.length ; i ++) {
	//		System.out.println(a.id);
	//	}
		cl.mostrarConsola();
		/*
		Cola_FCFS fc = new Cola_FCFS();
		
		fc.insertar(3, 0);
		fc.insertar(2, 1);
		fc.insertar(5, 2);
		fc.insertar(a , 5);
		fc.mostrarConsola();
		System.out.println();
		System.out.println(cl.validar_cambio_cola(2));
		fc.mostrarConsola();
		*/
	}

}
