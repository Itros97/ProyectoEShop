package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BD.LLamadasBD;
import BD.UsuarioBD;
import Tienda.Tienda;
import Usuario.Usuario;

public class VentanaInicioSesion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lemail;
	JTextField temail;
	JLabel lpassword;
	JPasswordField ppassword;
	JButton conectarse;
	JButton cancelar;
	String mail;
	String contra;
	int conectado = 0;
	ArrayList<Usuario> listaUsuarios ;
	Tienda tienda;
	
	public VentanaInicioSesion(Tienda tienda, VentanaPrincipal principal) {
		
		lemail = new JLabel("Nickname");
		temail = new JTextField(20);
		lpassword = new JLabel("Contraseña");
		ppassword = new JPasswordField(20);

		conectarse = new JButton("Conectarse");
	
		
		conectarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mail = temail.getText();
				contra = ppassword.getText();
				UsuarioBD.LoginUsuario(temail.getText(), ppassword.getText(),tienda);
				
			}
		});
		
		cancelar = new JButton("Cancelar");

		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				principal.binicio.setEnabled(true);
				principal.bregistro.setEnabled(true);
			}
		});
		
		this.setLayout(new GridLayout(3, 2));
		
		add(lemail);
		add(temail);
		add(lpassword);
		add(ppassword);
		add(conectarse);
		add(cancelar);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIAR SESION");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

