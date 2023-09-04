package mundo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	private int calorias;
	
	public ProductoMenu(String pNombre, int pPrecioBase, int pCalorias)
	{
		nombre=pNombre;
		precioBase=pPrecioBase;
		calorias=pCalorias;
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
		return nombre+"-$"+getPrecio()+"-Calorias: "+calorias+"\n"+".................................";				

	}
	public int getCalorias()
	{
		return calorias;
	}
	@Override
	public boolean equals(Object o)
	{
		ProductoMenu comparar=(ProductoMenu) o;
		if (comparar.getNombre().equals(nombre))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
