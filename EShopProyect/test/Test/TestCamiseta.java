package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Producto.Camiseta;
import Producto.Categoria;

class TestCamiseta {

	@Test
	void testTallas() {
		Camiseta c = new Camiseta("", 0, 0, "" , "", "", Categoria.CUALQUIERA, 45, "Cuero");
		
		assertEquals(45, c.getTalla());	
	}
	
	@Test
	void testMaterial() {
		Camiseta c = new Camiseta("", 0, 0, "" , "", "", Categoria.CUALQUIERA, 45, "Cuero");
		
		assertEquals("Cuero", c.getMaterial());	
	}
}
