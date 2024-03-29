package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.mysql.cj.xdevapi.PreparableStatement;

import BD.LLamadasBD;
import BD.UsuarioBD;
import Tienda.Tienda;
import Usuario.Usuario;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lnickname;
	JTextField tnickname;
	JLabel lemail;
	JTextField temail;
	JLabel lcalle;
	JTextField tcalle;
	JLabel lfecha;
	JSpinner spinFecha;
	JLabel ltarjeta;
	JTextField ttarjeta;
	JLabel lpassword;
	JPasswordField ppassword;
	JLabel ltipo;
	JCheckBox cbtipo;
	JButton crear;
	JButton cancelar;

	public VentanaRegistro(Usuario usuario, Tienda tienda, VentanaPrincipal principal) {

		lnickname = new JLabel("Nombre");
		tnickname = new JTextField(20);
	//	lfecha = new JLabel("Fecha de nacimiento");
	//	spinFecha = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
	//	spinFecha.setEditor(new JSpinner.DateEditor(spinFecha, "dd/MM/yyyy"));
		lemail = new JLabel("Email");
		temail = new JTextField(20);
		lcalle = new JLabel("Direccion");
		tcalle = new JTextField(20);
		ltarjeta = new JLabel("Tarjeta Bancaria:");
		ttarjeta = new JTextField(20);
		lpassword = new JLabel("Contraseņa");
		ppassword = new JPasswordField(20);
		ltipo = new JLabel("Administrador:");
		cbtipo = new JCheckBox();
		crear = new JButton("Crear");

		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Usuario nuevoUsuario = null;
				
				try {

					boolean coincide = false;
					if (usuario != null) {
						nuevoUsuario = usuario;
					} else {
						nuevoUsuario = new Usuario();
					}

					for (Usuario i : tienda.getClientes()) {
						if (i.getCorreoElectronico().equals(temail.getText())) {
							coincide = true;
						}
					}
					if (ppassword.getText().equals("") || temail.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "MAIL Y CONTRASEŅA OBLIGATORIAS.");
					} else {

						if (coincide == false) {
							nuevoUsuario.setNickname(tnickname.getText());
						//	nuevoUsuario.setFechaNacimiento((Date) spinFecha.getValue());
							nuevoUsuario.setCalle(tcalle.getText());
							nuevoUsuario.setCorreoElectronico(temail.getText());
							nuevoUsuario.setPassword(ppassword.getText());
							nuevoUsuario.setTarjeta_credito(ttarjeta.getText());
							if (cbtipo.isSelected() == true) {
								nuevoUsuario.setTipo_cuenta(true);
								UsuarioBD.InsertarUsuarios(nuevoUsuario);
							} else {
								nuevoUsuario.setTipo_cuenta(false);
								UsuarioBD.InsertarUsuarios(nuevoUsuario);
							}

							if (usuario == null) {
								tienda.getClientes().add(nuevoUsuario);
								
							}

							System.out.println(nuevoUsuario);

							dispose();
							principal.binicio.setEnabled(true);
							principal.bregistro.setEnabled(true);

						}

						if (coincide == true) {
							JOptionPane.showMessageDialog(null, "EL EMAIL YA ESTA SIENDO UTILIZADO.");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "FALtA ALGUN CAMPO", "Error", JOptionPane.ERROR_MESSAGE);
				}

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

		this.setLayout(new GridLayout(7, 2));
		add(lnickname);
		add(tnickname);
		add(lemail);
		add(temail);
		add(lpassword);
		add(ppassword);
		add(lcalle);
		add(tcalle);
		//add(lfecha);
		//add(spinFecha);
		add(ltarjeta);
		add(ttarjeta);
		add(ltipo);
		add(cbtipo);
		add(crear);
		add(cancelar);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("REGISTRATE");
		pack();
		setLocationRelativeTo(null);
		// setLocation(700, 300);
		setVisible(true);
	}
}
