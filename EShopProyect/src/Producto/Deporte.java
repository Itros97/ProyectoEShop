package Producto;

public class Deporte extends Producto{
	
	private static final TipoDeProducto ProductoTipo = null;
	protected static String categoriaDeporte;
	protected String material;
	
	public Deporte(double precio, int stock, String descripcion, String imagen, String marca, String categoriaDeporte,
			String material) {
		super(material, precio, stock, ProductoTipo, descripcion, imagen, marca);
		this.categoriaDeporte = categoriaDeporte;
		this.material = material;
	}
	
	public Deporte() {
		super();
		this.categoriaDeporte = "";
		this.material = "";
	}
	
	public Deporte(Deporte d) {
		super(getCategoriaDeporte(), d.precio, d.stock, null, d.descripcion, d.imagen, d.marca);
		this.categoriaDeporte = d.categoriaDeporte;
		this.material = d.material;
	}

	public static String getCategoriaDeporte() {
		return categoriaDeporte;
	}

	public void setCategoriaDeporte(String categoriaDeporte) {
		this.categoriaDeporte = categoriaDeporte;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Deporte [categoriaDeporte=" + categoriaDeporte + ", material=" + material + ", precio=" + precio
				+ ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen + ", marca=" + marca + "]";
	}	

}
