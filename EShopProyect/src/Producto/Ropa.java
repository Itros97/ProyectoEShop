package Producto;

public class Ropa extends Producto{
	protected double talla;
	protected String tipoPrenda;
	protected String material;
	
	public Ropa(double precio, int stock, String descripcion, String imagen, String marca, int talla, String tipoPrenda,
			String material) {
		super(precio, stock, descripcion, imagen, marca);
		this.talla = talla;
		this.tipoPrenda = tipoPrenda;
		this.material = material;
	}
	
	public Ropa() {
		super();
		this.talla = 0.0;
		this.tipoPrenda = "";
		this.material = "";
	}
	
	public Ropa(Ropa r) {
		super(r.precio, r.stock, r.descripcion, r.imagen, r.marca);
		this.talla = r.talla;
		this.tipoPrenda = r.tipoPrenda;
		this.material = r.material;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public String getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Ropa [talla=" + talla + ", tipoPrenda=" + tipoPrenda + ", material=" + material + ", precio=" + precio
				+ ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen + ", marca=" + marca + "]";
	}
	
}
