package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Producto.Balon;
import Producto.Categoria;

class TestBalon {
	protected String categoriaDeporte;
	protected String material;

	@Test
	void testCategoriaDeporte() {
		Balon b = new Balon("", 0, 0, "" , "", "", Categoria.CUALQUIERA, "Futbol", "Cuero");
		
		assertEquals("Futbol", b.getCategoriaDeporte());	
	}
	
	@Test
	void testMaterial() {
		Balon b = new Balon("", 0, 0, "" , "", "", Categoria.CUALQUIERA, "Futbol", "Cuero");
		
		assertEquals("Cuero", b.getMaterial());	
	}

}
