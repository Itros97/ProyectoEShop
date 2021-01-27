package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BD.LLamadasBD;
import BD.UsuarioBD;
import Tienda.Tienda;
import Tienda.Usuario;


public class VentanaInicioSesion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
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
	Usuario usuario;
	
	
	public VentanaInicioSesion(Usuario usuario, VentanaPrincipal principal) {
		
		lemail = new JLabel("Nickname");
		temail = new JTextField(20);
		lpassword = new JLabel("Contraseña");
		ppassword = new JPasswordField(20);

		conectarse = new JButton("Conectarse");
	
		
		conectarse.addActionListener(new ActionListener() {
			Usuario u1;
			@Override
			public void actionPerformed(ActionEvent e) {

				mail = temail.getText();
				contra = ppassword.getText();
				UsuarioBD.LoginUsuario(temail.getText(), ppassword.getText(),usuario);
				dispose();
				try {
					//Generar el txt del log
					FileHandler fh = new FileHandler("logger.txt");//Tambien se puede usar .log en vez de .txt
					fh.setLevel(Level.FINE);
					log.addHandler(fh);
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				log.log(Level.INFO, "Usuario logeado: "+temail.getText());
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

