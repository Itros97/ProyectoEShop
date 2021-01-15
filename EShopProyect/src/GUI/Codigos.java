package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Codigos {

	JFrame frame;
	private JTextField textField;
	protected JLabel lblNewLabel1 = new JLabel("CODIGO1");
	protected JLabel lblNewLabel2 = new JLabel("CODIGO2");
	protected JLabel lblNewLabel3 = new JLabel("CODIGO3");
	protected JLabel lblNewLabel4 = new JLabel("CODIGO4");
	
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
		
		lblNewLabel1.setBounds(10, 11, 242, 32);
		frame.getContentPane().add(lblNewLabel1);
		
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		lblNewLabel2.setBounds(10, 67, 242, 14);
		frame.getContentPane().add(lblNewLabel2);
		
		lblNewLabel3.setBounds(10, 110, 242, 14);
		frame.getContentPane().add(lblNewLabel3);
		
		lblNewLabel4.setBounds(10, 158, 242, 14);
		frame.getContentPane().add(lblNewLabel4);
		
		JLabel lblNewLabel5 = new JLabel("Longitud de los codigos");
		lblNewLabel5.setBounds(301, 26, 123, 14);
		frame.getContentPane().add(lblNewLabel5);
		
		textField = new JTextField();
		textField.setBounds(301, 45, 107, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelwritter();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Exportar c\u00F3digos");
		btnNewButton_2.setBounds(100, 227, 123, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
	private void labelwritter() 
	{
		for (int i = 0; i < 4; i++) {
			
			Codigo p = new Codigo();
			p.generarcodigo(0, Integer.parseInt(textField.getText()));
			System.out.println(p.getCodigo());
			if (i==0) {
				lblNewLabel1.setText(p.getCodigo());
			}
			else if (i==1) {
				lblNewLabel2.setText(p.getCodigo());
			}
			else if (i==2) {
				lblNewLabel3.setText(p.getCodigo());
			}
			else if (i==3) {
				lblNewLabel4.setText(p.getCodigo());
			}
			
		}
		
	}
}
