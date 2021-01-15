package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Codigos {

	JFrame frame;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Codigos window = new Codigos();
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
	public Codigos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CODIGO1");
		lblNewLabel.setBounds(10, 11, 151, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO2");
		lblNewLabel_1.setBounds(10, 67, 56, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CODIGO3");
		lblNewLabel_2.setBounds(10, 110, 56, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CODIGO4");
		lblNewLabel_3.setBounds(10, 158, 56, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Longitud de los codigos");
		lblNewLabel_4.setBounds(301, 26, 123, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(301, 45, 107, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Exportar c\u00F3digos");
		btnNewButton_2.setBounds(100, 227, 123, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
	
}
