package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Producto.Categoria;
import Producto.Producto;

class TestProducto {

	@Test
	void testNombre() {
			
			Producto p = new Producto("Camiseta", 11.1, 21, "Manga larga" , "camiseta.jpg", "Adidas", Categoria.CUALQUIERA);
			
			assertEquals("Camiseta", p.getNombre());	
	}
	
	@Test
	void testPrecio() {
			
			Producto p = new Producto("Camiseta", 11.10, 21, "Manga larga" , "camiseta.jpg", "Adidas", Categoria.CUALQUIERA);
			
			assertEquals(11.10, p.getPrecio());	
	}
	
	@Test
	void testStock() {
			
			Producto p = new Producto("Camiseta", 11.1, 21, "Manga larga" , "camiseta.jpg", "Adidas", Categoria.CUALQUIERA);
			
			assertEquals(21, p.getStock());	
	}
	
	@Test
	void testDescripcion() {
			
			Producto p = new Producto("Camiseta", 11.1, 21, "Manga larga", "camiseta.jpg", "Adidas", Categoria.CUALQUIERA);
			
			assertEquals("Manga larga", p.getDescripcion());	
	}
	
	@Test
	void testImagen() {
			
			Producto p = new Producto("Camiseta", 11.1, 21, "Manga larga" , "camiseta.jpg", "Adidas", Categoria.CUALQUIERA);
			
			assertEquals("camiseta.jpg", p.getImagen());	
	}
	
	@Test
	void testMarca() {
			
			Producto p = new Producto("Camiseta", 11.1, 21, "Manga larga" , "camiseta.jpg", "Adidas", Categoria.CUALQUIERA);
			
			assertEquals("Adidas", p.getMarca());	
	}
	
	@Test
	void testCategoria() {
			
			Producto p = new Producto("Camiseta", 11.1, 21, "Manga larga" , "camiseta.jpg", "Adidas", Categoria.CUALQUIERA);
			
			assertEquals(Categoria.CUALQUIERA, p.getCategoria());	
	}

}
