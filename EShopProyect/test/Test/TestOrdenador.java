package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Producto.Categoria;
import Producto.Ordenador;

class TestOrdenador {

	@Test
	void testPulgadas() {
		Ordenador o = new Ordenador("", 0, 0, "" , "", "",  32.1, "1920x1080", 16, 500, "Amarillo");
		
		assertEquals(32.1, o.getPulgadas());	
	}
	
	@Test
	void testResolucion() {
		Ordenador o = new Ordenador("", 0, 0, "" , "", "",  32.1, "1920x1080", 16, 500, "Amarillo");
		
		assertEquals("1920x1080", o.getResolucion());	
	}
	
	@Test
	void testMemoriaRam() {
		Ordenador o = new Ordenador("", 0, 0, "" , "", "",  32.1, "1920x1080", 16, 500, "Amarillo");
		
		assertEquals(16, o.getMemoriaRam());	
	}
	
	@Test
	void testAlmacenamiento() {
		Ordenador o = new Ordenador("Camiseta", 11.1, 21, "Manga larga" , "camiseta.jpg", "Adidas", 32.1, "1920x1080", 16, 500, "Amarillo");
		
		assertEquals(500, o.getAlmacenamiento());	
	}
	
	@Test
	void testColor() {
		Ordenador o = new Ordenador("Camiseta", 11.1, 21, "Manga larga" , "camiseta.jpg", "Adidas", 32.1, "1920x1080", 16, 500, "Amarillo");
		
		assertEquals("Amarillo", o.getColor());	
	}

}
