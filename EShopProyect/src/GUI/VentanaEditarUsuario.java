package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Tiendapck.Tienda;
import Tiendapck.Usuario;

public class VentanaEditarUsuario extends JFrame {
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
	JButton crear;
	JButton cancelar;

	public VentanaEditarUsuario(Usuario usuario, Tienda tienda) {

		lnickname = new JLabel("Nombre");
		tnickname = new JTextField(usuario.getNickname(), 20);
		lfecha = new JLabel("Fecha de nacimiento");
		spinFecha = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		spinFecha.setEditor(new JSpinner.DateEditor(spinFecha, "dd/MM/yyyy"));
		lemail = new JLabel("Email");
		temail = new JTextField(usuario.getCorreoElectronico(), 20);
		lcalle = new JLabel("Direccion");
		tcalle = new JTextField(usuario.getCalle(),20);
		ltarjeta = new JLabel("Tarjeta Bancaria:");
		ttarjeta = new JTextField(usuario.getTarjeta_credito(), 20);
		lpassword = new JLabel("Contraseña");
		ppassword = new JPasswordField(usuario.getPassword(),20);
		crear = new JButton("Guardar cambios");

		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				try {
							usuario.setNickname(tnickname.getText());
							usuario.setCalle(tcalle.getText());
							usuario.setCorreoElectronico(temail.getText());
							usuario.setPassword(ppassword.getText());
							usuario.setTarjeta_credito(ttarjeta.getText());
								
							System.out.println(usuario);

							dispose();

					
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
				//principal.binicio.setEnabled(true);
				//principal.bregistro.setEnabled(true);
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
		add(lfecha);
		add(spinFecha);
		add(ltarjeta);
		add(ttarjeta);
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
