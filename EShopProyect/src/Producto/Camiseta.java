package Producto;

public class Camiseta extends Producto{
	protected double talla;
	protected String material;
	
	public Camiseta(double precio, int stock, String descripcion, String imagen, String marca, int talla,
			String material) {
		super(precio, stock, descripcion, imagen, marca);
		this.talla = talla;
		this.material = material;
	}
	
	public Camiseta() {
		super();
		this.talla = 0.0;
		this.material = "";
	}
	
	public Camiseta(Camiseta r) {
		super(r.precio, r.stock, r.descripcion, r.imagen, r.marca);
		this.talla = r.talla;
		this.material = r.material;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Ropa [talla=" + talla +  ", material=" + material + ", precio=" + precio
				+ ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen + ", marca=" + marca + "]";
	}
	
}
