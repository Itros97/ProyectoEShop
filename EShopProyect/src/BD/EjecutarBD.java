package BD;

public class EjecutarBD {
	public void Pruebas()
	{
		
		//Usuario u1 = new Usuario("Rob","asdf","werty@gmail.com","c/falso 12 8B",1,false);
	
	}

	public static void main(String[] args) {
		LLamadasBD bd = new LLamadasBD();
		bd.ReiniciarBasesDeDatos("Admin");
		System.out.println("Acabo agregando una BD Funcional ");
		
		
	}
}
