package Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Usuario.Usuario;

class TestUsuario {

	@Test
	public void testNickname() {
		Date  fecha = new Date();
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", fecha , "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("MikelCastro", u.getNickname());
	}
	
	@Test
	public void testPassword() {
		Date  fecha = new Date();
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", fecha , "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("Mikel123", u.getPassword());
	}
	
	@Test
	public void testCorreoElectronico() {
		Date  fecha = new Date();
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", fecha , "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("mikel@gmail.com", u.getCorreoElectronico());
	}
	
	@Test
	public void testFechaNacimiento() {
		Date  fecha = new Date();
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", fecha , "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals(fecha, u.getFechaNacimiento());
	}
	
	@Test
	public void testCalle() {
		Date  fecha = new Date();
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", fecha , "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("Arrigorriaga", u.getCalle());
	}
	
	@Test
	public void testTarjeta_credito() {
		Date  fecha = new Date();
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", fecha , "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals("111 222 333 5555", u.getTarjeta_credito());
	}
	
	@Test
	public void testTipo_cuenta() {
		Date  fecha = new Date();
		Usuario u = new Usuario("MikelCastro","Mikel123","mikel@gmail.com", fecha , "Arrigorriaga", "111 222 333 5555", false);
		
		assertEquals(false, u.isTipo_cuenta());
	}

}
