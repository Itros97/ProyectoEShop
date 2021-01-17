package GUI;

import java.awt.GridLayout;
import java.io.PrintWriter;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import Producto.Producto;
import Tienda.Tienda;

public class VentanaProgreso extends JDialog{
	JProgressBar barraProgreso;
	JLabel mensaje;
	int prog = 0;
	
	public VentanaProgreso(Tienda tienda){
		mensaje = new JLabel("COMPRANDO... ");
		barraProgreso = new JProgressBar(0, 100);
		
		this.setLayout(new GridLayout(2, 1));
		add(mensaje);
		add(barraProgreso);
		barraProgreso.setStringPainted(true);
		
		Thread t = new Thread(){
			public void run() {
				
				for(int i =0; i< 101; i++) {
					prog = i;
					barraProgreso.setValue(prog);
					try {
						Thread.sleep(50);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				dispose();	
			}
		};
		t.start();


        try {
            PrintWriter pw = new PrintWriter("FACURA.TXT");
            pw.println(tienda.getConectado());
            pw.println();
            pw.println("-----------------------------------------");
            pw.println();
            for (Producto p : tienda.getCarro().getProducto()) {
                pw.println(p);
            }
            pw.println();
            pw.println("-----------------------------------------");
            pw.println();
            pw.println("Articulos comprados: "+tienda.getCarro().getCantidad());
            pw.println("Precio Total: "+ tienda.getCarro().getPrecioTotal()+" €");
            pw.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("PROGRESO");
		setResizable(false);
		setSize(500, 75);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
