package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Producto.Categoria;
import Producto.PintaLabios;

class TestPintaLabios {
	
	@Test
	void testTipoMaquillaje() {
				
			PintaLabios p = new PintaLabios("", 0, 0, "" , "", "", Categoria.CUALQUIERA, "Mate", "rojo", 3);
				
			assertEquals("Camiseta", p.getTipoMaquillaje());			
	}
	
	@Test
	void testColor() {
				
			PintaLabios p = new PintaLabios("", 0, 0, "" , "", "", Categoria.CUALQUIERA, "Mate", "rojo", 3);
				
			assertEquals("Rojo", p.getColor());			
	}
	
	@Test
	void testCantidad() {
				
			PintaLabios p = new PintaLabios("", 0, 0, "" , "", "", Categoria.CUALQUIERA, "Mate", "rojo", 3);
				
			assertEquals(3, p.getCantidad());			
	}


}
