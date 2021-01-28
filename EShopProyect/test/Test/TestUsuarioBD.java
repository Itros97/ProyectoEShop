package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import BD.UsuarioBD;
import Tiendapck.Usuario;

public class TestUsuarioBD {

	@Test
	public void test() {
		Usuario u1 = new Usuario("Jon", "123", "mikel@gmail.com", "", "", true);
		
		String nickname = "Jon";
		String password = "123";
		
		UsuarioBD.LoginUsuario(nickname, password, u1);
		assertEquals(true, u1.isTipo_cuenta());
	}

}
