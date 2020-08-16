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

import javafx.scene.control.TableColumn;

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
		String[] columnaTablaFinal = { "ID cola", "Id proceso", "T.LLegada", "Rafaga", "T.Comienzo", "T.Final",
				"T.Retorno", "T.Espera" };
		String[][] filasTablaFinal = {
				{ "ID cola", "Id proceso", "T.LLegada", "Rafaga", "T.Comienzo", "T.Final", "T.Retorno", "T.Espera" } };
		String[] columnaTabla = { "ID cola", "Id proceso", "T.LLegada", "Rafaga", "T.En Cola" };
		String[][] filasTabla = { { "ID cola", "Id proceso", "T.LLegada", "Rafaga", "T.En Cola" } };
		String[] columnaTablaBloqueados = { "ID cola", "Id proceso", "T.En cola" };
		String[][] filasTablaBloqueados = { { "ID cola", "Id proceso", "T.En cola" } };

		frame = new JFrame();
		frame.setBounds(0, 0, 1400, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Label labelTitulo = new Label("Procesador");
		labelTitulo.setFont(new Font("Arial", Font.PLAIN, 23));
		labelTitulo.setBounds(514, 10, 123, 32);
		frame.getContentPane().add(labelTitulo);

		DefaultTableModel modeloTablaFinal = new DefaultTableModel(filasTablaFinal, columnaTablaFinal);
		DefaultTableModel modeloTablaRR = new DefaultTableModel(filasTabla, columnaTabla);
		DefaultTableModel modeloTablaSJF = new DefaultTableModel(filasTabla, columnaTabla);
		DefaultTableModel modeloTablaFCFS = new DefaultTableModel(filasTabla, columnaTabla);
		DefaultTableModel modeloTablaBloqueado = new DefaultTableModel(filasTablaBloqueados, columnaTablaBloqueados);

		tabla_final = new JTable(modeloTablaFinal);
		tabla_final.setBounds(233, 48, 643, 168);
		frame.getContentPane().add(tabla_final);

		Canvas grannt = new Canvas();
		grannt.setBounds(233, 222, 643, 163);
		frame.getContentPane().add(grannt);

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

		tablaRoundRobin = new JTable(modeloTablaRR);
		tablaRoundRobin.setBounds(10, 417, 440, 236);
		frame.getContentPane().add(tablaRoundRobin);
		String[] n = { "1", "2", "3", "4", "5" };

		tablaSJF = new JTable(modeloTablaSJF);
		tablaSJF.setBounds(460, 417, 440, 236);
		frame.getContentPane().add(tablaSJF);

		tablaFCFS = new JTable(modeloTablaFCFS);
		tablaFCFS.setBounds(910, 417, 450, 236);
		frame.getContentPane().add(tablaFCFS);

		Label labelBloquedo = new Label("Bloqueados");
		labelBloquedo.setFont(new Font("Arial", Font.PLAIN, 18));
		labelBloquedo.setBounds(975, 20, 123, 22);
		frame.getContentPane().add(labelBloquedo);

		tablaBloqueados = new JTable(modeloTablaBloqueado);
		tablaBloqueados.setBounds(917, 48, 234, 303);
		frame.getContentPane().add(tablaBloqueados);

		Button botonBloquear = new Button("Bloquear");
		botonBloquear.setBounds(995, 363, 90, 22);
		frame.getContentPane().add(botonBloquear);

		Button botonInsertar = new Button("Insertar");
		botonInsertar.setBounds(563, 670, 90, 22);
		frame.getContentPane().add(botonInsertar);

		Button botonIniciar = new Button("Iniciar");
		botonIniciar.setBounds(782, 670, 90, 22);
		frame.getContentPane().add(botonIniciar);

		Button botonPausar = new Button("Pausar");
		botonPausar.setBounds(1061, 670, 90, 22);
		frame.getContentPane().add(botonPausar);

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

		Label labelidColaRR = new Label("ID Round Robin: 1");
		labelidColaRR.setFont(new Font("Arial", Font.PLAIN, 14));
		labelidColaRR.setAlignment(Label.RIGHT);
		labelidColaRR.setBounds(273, 391, 143, 22);
		frame.getContentPane().add(labelidColaRR);

		Label labelidColaSJF = new Label("ID SJF: 2");
		labelidColaSJF.setFont(new Font("Arial", Font.PLAIN, 14));
		labelidColaSJF.setBounds(732, 391, 62, 22);
		frame.getContentPane().add(labelidColaSJF);

		Label labelidColaFCFS = new Label("ID FCFS: 3");
		labelidColaFCFS.setFont(new Font("Arial", Font.PLAIN, 14));
		labelidColaFCFS.setBounds(1193, 391, 84, 22);
		frame.getContentPane().add(labelidColaFCFS);

	}
}
