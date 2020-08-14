package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.TextField;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.List;
import java.awt.Checkbox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import java.awt.Choice;

public class Gui {

	private JFrame frame;
	private JTable tabla_final;
	private JTable grannt;
	private JTable tablaRoundRobin;
	private JTable tablaSJF;
	private JTable tablaFCFS;
	private JTable tablaBloqueados;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 923, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Label labelTitulo = new Label("Procesador");
		labelTitulo.setFont(new Font("Arial", Font.PLAIN, 23));
		labelTitulo.setBounds(255, 10, 123, 32);
		frame.getContentPane().add(labelTitulo);

		tabla_final = new JTable();
		tabla_final.setBounds(10, 48, 643, 168);
		frame.getContentPane().add(tabla_final);

		grannt = new JTable();
		grannt.setBounds(10, 225, 643, 155);
		frame.getContentPane().add(grannt);

		Label labelRoundRobin = new Label("Round Robin");
		labelRoundRobin.setFont(new Font("Arial", Font.PLAIN, 18));
		labelRoundRobin.setBounds(80, 386, 123, 27);
		frame.getContentPane().add(labelRoundRobin);

		Label labelSJF = new Label("SJF");
		labelSJF.setFont(new Font("Arial", Font.PLAIN, 18));
		labelSJF.setBounds(428, 391, 37, 22);
		frame.getContentPane().add(labelSJF);

		Label labelFCFS = new Label("FCFS");
		labelFCFS.setFont(new Font("Arial", Font.PLAIN, 18));
		labelFCFS.setBounds(736, 386, 62, 22);
		frame.getContentPane().add(labelFCFS);

		tablaRoundRobin = new JTable();
		tablaRoundRobin.setBounds(10, 417, 273, 236);
		frame.getContentPane().add(tablaRoundRobin);

		tablaSJF = new JTable();
		tablaSJF.setBounds(316, 417, 273, 236);
		frame.getContentPane().add(tablaSJF);

		tablaFCFS = new JTable();
		tablaFCFS.setBounds(624, 417, 273, 236);
		frame.getContentPane().add(tablaFCFS);

		Label labelBloquedo = new Label("Bloqueados");
		labelBloquedo.setFont(new Font("Arial", Font.PLAIN, 18));
		labelBloquedo.setBounds(736, 20, 123, 22);
		frame.getContentPane().add(labelBloquedo);

		tablaBloqueados = new JTable();
		tablaBloqueados.setBounds(663, 48, 234, 303);
		frame.getContentPane().add(tablaBloqueados);

		Button botonBloquear = new Button("Bloquear");
		botonBloquear.setBounds(736, 357, 90, 22);
		frame.getContentPane().add(botonBloquear);

		Button botonInsertar = new Button("Insertar");
		botonInsertar.setBounds(361, 670, 90, 22);
		frame.getContentPane().add(botonInsertar);

		Button botonIniciar = new Button("Iniciar");
		botonIniciar.setBounds(499, 670, 90, 22);
		frame.getContentPane().add(botonIniciar);

		Button botonPausar = new Button("Pausar");
		botonPausar.setBounds(660, 670, 90, 22);
		frame.getContentPane().add(botonPausar);

		JRadioButton RBRoundRobin = new JRadioButton("Round Robin");
		RBRoundRobin.setSelected(true);
		RBRoundRobin.setFont(new Font("Arial", Font.PLAIN, 11));
		RBRoundRobin.setBounds(10, 670, 98, 16);
		frame.getContentPane().add(RBRoundRobin);

		JRadioButton RBSJF = new JRadioButton("SJF");
		RBSJF.setFont(new Font("Arial", Font.PLAIN, 11));
		RBSJF.setBounds(110, 670, 54, 16);
		frame.getContentPane().add(RBSJF);

		JRadioButton RBFCFS = new JRadioButton("FCFS");
		RBFCFS.setFont(new Font("Arial", Font.PLAIN, 11));
		RBFCFS.setBounds(166, 670, 54, 16);
		frame.getContentPane().add(RBFCFS);

		ButtonGroup nomColas = new ButtonGroup();
		nomColas.add(RBRoundRobin);
		nomColas.add(RBSJF);
		nomColas.add(RBFCFS);
		
		Label labelRafaga = new Label("Rafaga:");
		labelRafaga.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRafaga.setBounds(226, 670, 54, 22);
		frame.getContentPane().add(labelRafaga);
		
		SpinnerModel modeloSpinner = new SpinnerNumberModel(1,1,100,1);
		JSpinner spinnerRafaga = new JSpinner(modeloSpinner);
		spinnerRafaga.setBounds(275, 670, 55, 22);
		frame.getContentPane().add(spinnerRafaga);
		
		
	}
}
