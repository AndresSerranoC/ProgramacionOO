package mundo;

public class Ingrediente {
	private String nombre;
	private int costoAdicional;
	private int calorias;
	public Ingrediente(String pNombre, int pCostoAdicional,int pCalorias)
	{
		nombre=pNombre;
		costoAdicional=pCostoAdicional;
		calorias=pCalorias;
	}
	public String getNombre()
	{
		return nombre;
	}
	public int getCostoAdicional()
	{
		return costoAdicional;
	}
	public int getCalorias()
	{
		return calorias;
	}
	@Override
	public boolean equals(Object o)
	{
		Ingrediente comparar=(Ingrediente) o;
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
