package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Button;
import java.awt.TextField;
import logica.Cola;
import logica.Cola_Final;
import logica.Procesador;
import logica.Proceso;

import javax.swing.JLabel;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.List;
import java.awt.Checkbox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import java.awt.Choice;

import javax.swing.JList;
import javax.swing.JScrollPane;

@SuppressWarnings("unused")
public class Gui {

	private JFrame frame;
	private JTable tabla_final;
	private JTable tablaRoundRobin;
	private JTable tablaSJF;
	private JTable tablaFCFS;
	private JTable tablaBloqueados;
	private Procesador procesador;
	private JLabel labeltiempo;
	private Lienzo canvasGrantt;

	public Lienzo getCanvasGrantt() {
		return canvasGrantt;
	}

	private int tiempo = 0;
	public boolean iniciar = false;

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
		this.labeltiempo.setText(this.Mostrartiempo());
		this.ActualizarTablas();
		this.ActualizarTablaHistorial();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui() {
		initialize();
	}

	private void initialize() {
		this.procesador = new Procesador(this);

		String[] columnaTablaFinal = { "Id proceso", "T.LLegada", "Rafaga", "T.Comienzo", "T.Final", "T.Retorno",
				"T.Espera", "Cola Origen", "Cola Final" };
		String[][] filasTablaFinal = null;
		Object[] columnaTabla = { "Id proceso", "Rafaga", "T.LLegada", "Cola Origen", "T.En Cola" };
		Object[][] filasTabla = null;
		String[] columnaTablaBloqueados = { "Id proceso", "Cola", "T.En cola" };
		String[][] filasTablaBloqueados = null;

		frame = new JFrame();
		frame.setBounds(0, 0, 1400, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		DefaultTableModel modeloTablaFinal = new DefaultTableModel(filasTablaFinal, columnaTablaFinal);
		DefaultTableModel modeloTablaRR = new DefaultTableModel(filasTabla, columnaTabla);
		DefaultTableModel modeloTablaSJF = new DefaultTableModel(filasTabla, columnaTabla);
		DefaultTableModel modeloTablaFCFS = new DefaultTableModel(filasTabla, columnaTabla);
		DefaultTableModel modeloTablaBloqueado = new DefaultTableModel(filasTablaBloqueados, columnaTablaBloqueados);

		tabla_final = new JTable(modeloTablaFinal);
		tabla_final.setBounds(233, 48, 643, 168);
		frame.getContentPane().add(tabla_final);

		JScrollPane scrollTablaF = new JScrollPane(tabla_final);
		scrollTablaF.setBounds(233, 48, 643, 168);
		frame.getContentPane().add(scrollTablaF);

		tablaRoundRobin = new JTable(modeloTablaRR);
		tablaRoundRobin.setBounds(10, 417, 440, 236);
		frame.getContentPane().add(tablaRoundRobin);

		JScrollPane scrollTablaRR = new JScrollPane(tablaRoundRobin);
		scrollTablaRR.setBounds(10, 417, 440, 236);
		frame.getContentPane().add(scrollTablaRR);

		tablaSJF = new JTable(modeloTablaSJF);
		tablaSJF.setBounds(460, 417, 440, 236);
		frame.getContentPane().add(tablaSJF);

		JScrollPane scrollTablaSJF = new JScrollPane(tablaSJF);
		scrollTablaSJF.setBounds(460, 417, 440, 236);
		frame.getContentPane().add(scrollTablaSJF);

		tablaFCFS = new JTable(modeloTablaFCFS);
		tablaFCFS.setBounds(910, 417, 450, 236);
		frame.getContentPane().add(tablaFCFS);

		JScrollPane scrollTablaFCFS = new JScrollPane(tablaFCFS);
		scrollTablaFCFS.setBounds(910, 417, 450, 236);
		frame.getContentPane().add(scrollTablaFCFS);

		tablaBloqueados = new JTable(modeloTablaBloqueado);
		tablaBloqueados.setBounds(917, 48, 234, 303);
		frame.getContentPane().add(tablaBloqueados);

		JScrollPane scrollBloqueado = new JScrollPane(tablaBloqueados);
		scrollBloqueado.setBounds(917, 48, 234, 303);
		frame.getContentPane().add(scrollBloqueado);

		canvasGrantt = new Lienzo();
		frame.getContentPane().add(canvasGrantt);
		
		Label labelTitulo = new Label("Procesador");
		labelTitulo.setFont(new Font("Arial", Font.PLAIN, 23));
		labelTitulo.setBounds(514, 10, 123, 32);
		frame.getContentPane().add(labelTitulo);

		Label labelRoundRobin = new Label("Round Robin");
		labelRoundRobin.setFont(new Font("Arial", Font.PLAIN, 18));
		labelRoundRobin.setBounds(157, 391, 123, 27);
		frame.getContentPane().add(labelRoundRobin);

		Label labelSJF = new Label("SJF");
		labelSJF.setFont(new Font("Arial", Font.PLAIN, 18));
		labelSJF.setBounds(678, 391, 37, 22);
		frame.getContentPane().add(labelSJF);

		Label labelFCFS = new Label("FCFS");
		labelFCFS.setFont(new Font("Arial", Font.PLAIN, 18));
		labelFCFS.setBounds(1112, 391, 62, 22);
		frame.getContentPane().add(labelFCFS);

		Label labelBloquedo = new Label("Bloqueados");
		labelBloquedo.setFont(new Font("Arial", Font.PLAIN, 18));
		labelBloquedo.setBounds(975, 20, 123, 22);
		frame.getContentPane().add(labelBloquedo);

		JRadioButton RBRoundRobin = new JRadioButton("Round Robin");
		RBRoundRobin.setSelected(true);
		RBRoundRobin.setFont(new Font("Arial", Font.PLAIN, 11));
		RBRoundRobin.setBounds(133, 670, 98, 16);
		frame.getContentPane().add(RBRoundRobin);

		JRadioButton RBSJF = new JRadioButton("SJF");
		RBSJF.setFont(new Font("Arial", Font.PLAIN, 11));
		RBSJF.setBounds(233, 670, 54, 16);
		frame.getContentPane().add(RBSJF);

		JRadioButton RBFCFS = new JRadioButton("FCFS");
		RBFCFS.setFont(new Font("Arial", Font.PLAIN, 11));
		RBFCFS.setBounds(316, 670, 54, 16);
		frame.getContentPane().add(RBFCFS);

		ButtonGroup nomColas = new ButtonGroup();
		nomColas.add(RBRoundRobin);
		nomColas.add(RBSJF);
		nomColas.add(RBFCFS);

		Label labelRafaga = new Label("Rafaga:");
		labelRafaga.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRafaga.setBounds(426, 670, 54, 22);
		frame.getContentPane().add(labelRafaga);

		SpinnerModel modeloSpinner = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner spinnerRafaga = new JSpinner(modeloSpinner);
		spinnerRafaga.setBounds(486, 670, 55, 22);
		frame.getContentPane().add(spinnerRafaga);

		Label labelidColaRR = new Label("Prioridad Round Robin: 1");
		labelidColaRR.setFont(new Font("Arial", Font.PLAIN, 14));
		labelidColaRR.setAlignment(Label.RIGHT);
		labelidColaRR.setBounds(273, 391, 177, 22);
		frame.getContentPane().add(labelidColaRR);

		Label labelidColaSJF = new Label("Prioridad SJF: 2");
		labelidColaSJF.setFont(new Font("Arial", Font.PLAIN, 14));
		labelidColaSJF.setBounds(732, 391, 123, 22);
		frame.getContentPane().add(labelidColaSJF);

		Label labelidColaFCFS = new Label("Prioridad FCFS: 3");
		labelidColaFCFS.setFont(new Font("Arial", Font.PLAIN, 14));
		labelidColaFCFS.setBounds(1193, 391, 150, 22);
		frame.getContentPane().add(labelidColaFCFS);

		labeltiempo = new JLabel("tiempo: 0");
		labeltiempo.setForeground(Color.RED);
		labeltiempo.setFont(new Font("Arial", Font.PLAIN, 13));
		labeltiempo.setBounds(669, 671, 75, 21);
		frame.getContentPane().add(labeltiempo);

		Button botonBloquear = new Button("Bloquear");
		botonBloquear.setBounds(995, 363, 90, 22);
		frame.getContentPane().add(botonBloquear);
		botonBloquear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				procesador.bloquearProcesoEjecutar();
				ActualizarTablas();
				ActualizarTablaHistorial();
			}
		});

		Button botonInsertar = new Button("Insertar");
		botonInsertar.setBounds(563, 670, 90, 22);
		frame.getContentPane().add(botonInsertar);
		botonInsertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rafaga = (int) spinnerRafaga.getValue();
				int tllegada = tiempo;
				int idcola;
				if (RBRoundRobin.isSelected()) {
					idcola = 0;
				} else if (RBSJF.isSelected()) {
					idcola = 1;
				} else {
					idcola = 2;
				}

				insertarProceso(rafaga, tllegada, idcola);
			}
		});

		Button botonIniciar = new Button("Iniciar");
		botonIniciar.setBounds(782, 670, 90, 22);
		frame.getContentPane().add(botonIniciar);
		botonIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				procesador.iniciar();
				iniciar = true;

			}
		});

		Button botonPausar = new Button("Pausar");
		botonPausar.setBounds(1061, 670, 90, 22);
		frame.getContentPane().add(botonPausar);

		botonPausar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!iniciar) {
					botonPausar.setLabel("Pausar");
					iniciar = true;
				} else {
					botonPausar.setLabel("Continuar");
					iniciar = false;
				}
				procesador.pausar_despuasar();
			}
		});
	}

	public String Mostrartiempo() {
		if (this.iniciar) {

			return "tiempo: " + String.valueOf(this.tiempo);
		}
		return "tiempo: 0";
	}

	public void insertarProceso(int rafaga, int tllegada, int cola) {
		this.procesador.insertarProcesoCola(rafaga, tllegada, cola);
		this.ActualizarTablas();
	}

	public void procesoEjecucion(Proceso p) {

	}

	public void ActualizarTablas() {
		Cola colas[] = this.procesador.procesosEnColas();
		Object[][] info;
		for (Cola cola : colas) {
			JTable tabla = this.tablaCola(cola.getIdCola());
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			if (cola.colaVacia()) {
				this.limpiarTabla(tabla, tabla.getRowCount());
				continue;
			}

			this.limpiarTabla(tabla, tabla.getRowCount());
			info = cola.infoProcesos();
			int tamaño = cola.getNumProcesos();
			for (int i = 0; i < tamaño; i++) {
				modelo.addRow(info[i]);
			}
		}
	}

	public JTable tablaCola(int id) {
		JTable Cola;
		switch (id) {
		case 0:
			Cola = this.tablaRoundRobin;
			break;
		case 1:
			Cola = this.tablaSJF;
			break;
		case 2:
			Cola = this.tablaFCFS;
			break;
		case 3:
			Cola = this.tablaBloqueados;
			break;
		default:
			System.out.println("Problema al insertar proceso");
			return null;
		}
		return Cola;
	}

	public void ActualizarTablaHistorial() {
		JTable tabla = this.tabla_final;
		Cola_Final cFinal = this.procesador.getCola_final();
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		if (cFinal.colaVacia()) {
			this.limpiarTabla(tabla, tabla.getRowCount());
			return;
		}
		this.limpiarTabla(tabla, tabla.getRowCount());
		Object[][] info = cFinal.infoProcesos();
		int tamaño = cFinal.getNumProcesos();
		// System.out.println("tamaño cola final " + tamaï¿½o);
		for (int i = 0; i < tamaño; i++) {
			// System.out.println("proceso " + (i + 1));
			for (int j = 0; j < 5; j++) {
				// System.out.println(info[i][j]);
			}
			modelo.addRow(info[i]);
		}
	}

	public void limpiarTabla(JTable t, int n) {

		DefaultTableModel modelo = (DefaultTableModel) t.getModel();
		if (modelo.getRowCount() > 0) {
			for (int i = 0; i < n; i++) {
				modelo.removeRow(0);
			}
		}

	}

	public void pintar() {
		// canvasGrantt.nombre("Hola");
		canvasGrantt.tabla(tabla_final);
		canvasGrantt.repaint();
	}
}
