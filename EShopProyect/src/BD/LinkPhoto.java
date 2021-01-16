package BD;
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
	public void PutImage () {
		this.setIcon( new ImageIcon(this.ruta));
	}

}
