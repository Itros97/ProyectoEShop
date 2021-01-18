package BD;
import java.awt.Image;

import javax.swing.*;

public class LinkPhoto extends JLabel{
	
	private static final long serialVersionUID = 1L;
	protected String ruta;
	public LinkPhoto (String Path) {
		this.ruta = Path;
	}
	
	public void setPath (String Path) {
		this.ruta = Path;
	}
	public void PutImage (JLabel label) {
		ImageIcon img = new ImageIcon(this.ruta);
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
		this.repaint();
	}

}
