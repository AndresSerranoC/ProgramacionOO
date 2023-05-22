package mundo;

import interfaz.Producto;

public class ProductoMenu extends Producto{
	private int precioBase;
	public ProductoMenu(String pNombre, int pPrecioBase) {
		super(pNombre);
		precioBase=pPrecioBase;
	}
	public String getNombre()
	{
		return super.getNombre();
	}
	public int getPrecioBase()
	{
		return precioBase;
	}
}
