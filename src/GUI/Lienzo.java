package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTable;

import logica.Cola_Final;

public class Lienzo extends Canvas {
	private String nombre;
	private int largo = 866;
	private int ancho = 163;
	private JTable tabla;

	Lienzo() {
		this.setBackground(Color.WHITE);
		this.setBounds(10, 222, largo, ancho);
	}

	public void paint(Graphics g) {
		// g.setColor(Color.red);
		// g.drawString(nombre, 0, 10);

		g.setColor(Color.black);
		g.drawString("ID", 0, 10);
		int i = 0;
		for (int x = 24; x < largo; x = x + 24) {
			g.setColor(Color.black);
			g.drawString(String.valueOf(i), x - 5, 10);
			g.setColor(Color.black);
			g.drawLine(x, 12, x, ancho);
			i = i + 4;
		}

	//	if ( != null) {
	//		g.setColor(Color.orange);
			//tabla.
			//g.drawRect(20, 20, (int) cFinal[0][2], 10);
	//	}

	}

	public void nombre(String nombre) {
		this.nombre = nombre;
	}

	public void tabla(JTable tabla) {
		this.tabla = tabla;
	}

}
