package mundo;

public class Bebida implements Producto{
	private String nombre;
	private int precio;
	private int calorias;
	
	public Bebida(String pNombre, int pPrecio, int pCalorias)
	{
		nombre=pNombre;
		precio=pPrecio;
		calorias=pCalorias;
	}
	@Override
	public int getPrecio() {
		return precio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String generarTextoFactura() {
		return nombre+"-$"+precio+"-Calorias: "+calorias+"\n"+".................................";				

	}
	public int getCalorias()
	{
		return calorias;
	}
	@Override
	public boolean equals(Object o)
	{
		Bebida comparar=(Bebida) o;
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
