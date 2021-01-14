package Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LeerProductoCSV {
	public static void guardarProductosBD() {

	}

	public static ArrayList<Producto> cargarProductos() {
			
		FileReader fr = null;
		BufferedReader br = null;
			
		ArrayList<Producto> productos = new ArrayList<>();
			
		try {
			fr = new FileReader("data/Productos.csv");
			br = new BufferedReader(fr);
				
			String linea = br.readLine();
				
			while (linea != null) {
					
				String[] propiedades = linea.split(",");
				
				//TIPO PRODUCTO
				String tipoProducto = propiedades[0];
				
				//PROPIEDADES ESPECIFICAS	
				String nombre  = propiedades[1];
				Double precio  = (Double.parseDouble(propiedades[2]));
				int stock  = (Integer.parseInt(propiedades[3]));
				String descripcion  = propiedades[4];
				String imagen = propiedades[5];
				String marca = propiedades[6];
				String categoria = propiedades[7];
				
				//PROPIEDADES DE BALON
				String categoriaDeporte = propiedades[8];
				String material = propiedades[9];
				
				//PROPIEDADES DE CAMISETA
				double talla = (Double.parseDouble(propiedades[10]));
				String materialCamiseta = propiedades[11];
				
				//PROPIEDADES DE ORDENADOR
				double pulgadas = (Double.parseDouble(propiedades[12]));
				String resolucion = propiedades[13];
				int memoriaRam = (Integer.parseInt(propiedades[14]));
				int almacenamiento =(Integer.parseInt(propiedades[15]));
				String color = propiedades[16];
				
				//PROPIEDADES DE PINTA LABIOS
				String tipoMaquillaje = propiedades[17];
				String colorMaquillaje = propiedades[18];
				int cantidad = (Integer.parseInt(propiedades[19]));
				
				categoria.toLowerCase();
				Categoria cate = Categoria.CUALQUIERA;
				
				if(categoria.equals("deporte")) {
					cate = Categoria.DEPORTE;
					
				}else if(categoria.equals("electronica")) {
					cate = Categoria.ELECTRONICA;
					
				}else if(categoria.equals("maquillaje")) {
					cate = Categoria.MAQUILLAJE;
					
				}else if (categoria.equals("moda")) {
					cate = Categoria.MODA;
					
				}
				
				if(tipoProducto.equals("balon")) {
					Balon b = new Balon(nombre, precio, stock, descripcion, imagen, marca, categoriaDeporte, material);
					
					linea = br.readLine();
					System.out.println(b);
					productos.add(b);
					
				} else if(tipoProducto.equals("camiseta")) {
					Camiseta c = new Camiseta(nombre, precio, stock, descripcion, imagen, marca, cate, talla, materialCamiseta);
					
					linea = br.readLine();
					System.out.println(c);
					productos.add(c);
					
				}else if(tipoProducto.equals("ordenador")) {
					Ordenador o = new Ordenador(nombre, precio, stock, descripcion, imagen, marca, pulgadas, resolucion, memoriaRam, almacenamiento, color);
					
					linea = br.readLine();
					System.out.println(o);
					productos.add(o);
					
				}else if(tipoProducto.equals("pintaLabios")) {
					PintaLabios l = new PintaLabios(nombre, precio, stock, descripcion, imagen, marca, cate, tipoMaquillaje, colorMaquillaje, cantidad);
					
					linea = br.readLine();
					System.out.println(l);
					productos.add(l);
				}
				
			}
		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return productos;

			 
		}

}
