package BD;


import Producto.Producto;
import Tiendapck.Usuario;

public class EjecutarBD {
	
	public static void main(String[] args) {
		

		LLamadasBD bd = new LLamadasBD();
		//Usuario u1 = new Usuario("James","frgy","tom@gmail.com",0000,"c/falso 12 8B",null,false);
		//Usuario u2 = new Usuario("Rob","asdf","a@gmail.com",0000,"c/falso 12 8B",null,false);
		//bd.ReiniciarBasesDeDatos("Admin");
//		bd.InsertarUsuario(u1);

		Producto p1 = new Producto("GeForce GTX 3070 TRIO X GDDR6",700.00,0,"La ultima gráfica de nvidia"," ","MSI");
	//	Usuario u1 = new Usuario("James","frgy","tom@gmail.com",0000,"c/falso 12 8B",null,false);
	//	Usuario u2 = new Usuario("Rob","asdf","a@gmail.com",0000,"c/falso 12 8B",null,false);
	//S	bd.ReiniciarBasesDeDatos("Admin");
	//	bd.InsertarUsuario(u1);
	//	bd.InsertarUsuario(u2);
	//	bd.InsertarProducto(p1);
	//	bd.LoginUsuarios("James", "frgy");
//		bd.ModificarUsuario(u1);
		System.out.println("Acabo agregando una BD Funcional ");
		
		
	}
}
