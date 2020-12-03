package BD;

import Usuario.Usuario;

public class EjecutarBD {
	public void Pruebas()
	{
		
	
	
	}

	public static void main(String[] args) {
		
		LLamadasBD bd = new LLamadasBD();
		Usuario u1 = new Usuario("James","frgy","tom@gmail.com",0000,"c/falso 12 8B",null,false);
		Usuario u2 = new Usuario("Rob","asdf","a@gmail.com",0000,"c/falso 12 8B",null,false);
	//	bd.ReiniciarBasesDeDatos("Admin");
//		bd.InsertarUsuario(u1);
//		bd.ModificarUsuario(u1);
		System.out.println("Acabo agregando una BD Funcional ");
		
		
	}
}
