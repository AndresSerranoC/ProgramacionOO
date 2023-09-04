package mundo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String pNombre, int pPrecioBase)
	{
		nombre=pNombre;
		precioBase=pPrecioBase;
	}
	@Override
	public int getPrecio() {
		return precioBase;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String generarTextoFactura() {
		return nombre+"-$"+precioBase+"\n"+".................................";				

	}

}
