package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Tienda.Tienda;

public class VentanaPrincipal extends JFrame {
	

	private static final long serialVersionUID = 1L;
	
	Tienda tienda;
	VentanaPrincipal ventana;
	JMenuBar barra;
	JMenu cliente;
	JMenuItem registro;
	JMenuItem inicioSesion;
	JMenu opciones;
	JMenuItem cerrar;
	JButton binicio;
	JButton bregistro;
	JPanel panel;
	
	public VentanaPrincipal() {
		tienda = new Tienda();
		
		ventana = this;
		
		panel = new JPanel();
		barra = new JMenuBar();
		cliente = new JMenu("Cliente");
		inicioSesion = new JMenuItem("Inicia Sesion");
		registro = new JMenuItem("Registrate");
		opciones = new JMenu("Opciones");
		cerrar= new JMenuItem("Cerrar Programa");
		binicio = new JButton("INICIAR SESION");
		bregistro = new JButton("REGISTARSE");
		
		inicioSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion v = new VentanaInicioSesion(tienda, ventana);
				v.setModal(true);
				binicio.setEnabled(false);
				bregistro.setEnabled(false);
				
			}
		});
		
		binicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion v = new VentanaInicioSesion(tienda, ventana);
				v.setModal(true);
				binicio.setEnabled(false);
				bregistro.setEnabled(false);
				
			}
		});
		
		bregistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistro(null, tienda, ventana);
				
			}
		});
		registro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistro(null, tienda, ventana);
				
			}
		});
		
		cerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		panel.add(binicio, BorderLayout.NORTH);
		panel.add(bregistro, BorderLayout.SOUTH);
		
		add(panel, BorderLayout.CENTER);
		
		opciones.add(cerrar);
		cliente.add(registro);
		cliente.add(inicioSesion);
		
		barra.add(cliente);
		barra.add(opciones);
		
		setJMenuBar(barra);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("TIENDA DE ROPA");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				new VentanaPrincipal();
			}
		});

	}

}

