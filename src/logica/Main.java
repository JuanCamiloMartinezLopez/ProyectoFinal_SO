package logica;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*
		//Prueba Insertar y atender
		 
		Cola prueba= new Cola();
		prueba.insertar(1, 0);
		prueba.insertar(2, 1);
		prueba.insertar(3, 2);
		prueba.mostrarConsola();
		Proceso proc= prueba.atender();
		System.out.println("\nProceso Atendido: "+proc.id + " | " + proc.tllegada + " | " + proc.rafaga+"\n");
		prueba.mostrarConsola();
		proc= prueba.atender();
		System.out.println("\nProceso Atendido: "+proc.id + " | " + proc.tllegada + " | " + proc.rafaga+"\n");
		prueba.mostrarConsola();
		proc= prueba.atender();
		System.out.println("\nProceso Atendido: "+proc.id + " | " + proc.tllegada + " | " + proc.rafaga+"\n");
		prueba.mostrarConsola();
		proc= prueba.atender();
		*/
		
		/*
		//Prueba Politica envejecimiento
		
		Cola_RoundRobin cl = new Cola_RoundRobin(5);
		
		cl.insertar(5, 0);
		cl.insertar(2, 1);
		cl.insertar(3, 2);
		cl.insertar(4, 3);
		cl.insertar(5, 4);
		cl.insertar(2, 5);
		cl.insertar(3, 5);
		cl.insertar(4, 5);
		cl.insertar(5, 6);
		cl.insertar(2, 7);
		cl.insertar(3, 8);
		cl.insertar(4, 9);
		cl.mostrarConsola();
		
		System.out.println("\nComienza Simulacion\n");
		
		for (int tiempo = 0 ; tiempo < 20 ; tiempo ++) {
			System.out.println("\n----------------------------------\n");
			System.out.println("tiempo: "+tiempo);
			cl.setTiempo(tiempo);
			ArrayList<Proceso> procesos= cl.procesosPoliticaEnvejecimiento();
			if(procesos==null) {
				System.out.println("\nNo hay procesos para salir por politica de envejecimiento\n");
			}else {
				System.out.println("\nhay "+procesos.size()+" procesos para salir por politica de envejecimiento\n");
				for(int t=0;t<procesos.size();t++) {
					Proceso a= procesos.get(t);
					System.out.println("Proceso "+a.id + "| Rafaga "+a.rafaga);
				}
			}
			
			System.out.println("\nCola Actualmente\n");
			cl.mostrarConsola();
			System.out.println("\n----------------------------------\n");
		}
		*/
		
		//Prueba Procesador/Monitor/ las tres colas al tiempo
		
		Procesador procesador= new Procesador();
		
		procesador.insertarProcesoCola(3, 0, 0);
		procesador.insertarProcesoCola(2, 1, 0);
		procesador.insertarProcesoCola(4, 2, 0);
		procesador.insertarProcesoCola(4, 0, 1);
		procesador.insertarProcesoCola(2, 1, 1);
		procesador.insertarProcesoCola(3, 2, 1);
		procesador.insertarProcesoCola(2, 0, 2);
		procesador.insertarProcesoCola(3, 1, 2);
		procesador.insertarProcesoCola(4, 2, 2);
		
		procesador.mostrarColas();
		
		procesador.iniciar();
	}

}
