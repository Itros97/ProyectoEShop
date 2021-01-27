package Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Tienda.Usuario;

class TestUsuario {

	@Test
	public void testNickname() {
	
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com",  "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("MikelCastro", u.getNickname());
	}
	
	@Test
	public void testPassword() {
		
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com",  "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("Mikel123", u.getPassword());
	}
	
	@Test
	public void testCorreoElectronico() {

		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("mikel@gmail.com", u.getCorreoElectronico());
	}
	
	@Test
	public void testCalle() {

		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("Arrigorriaga", u.getCalle());
	}
	
	@Test
	public void testTarjeta_credito() {

		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("111 222 333 5555", u.getTarjeta_credito());
	}
	
	@Test
	public void testTipo_cuenta() {
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals(false, u.isTipo_cuenta());
	}

}
