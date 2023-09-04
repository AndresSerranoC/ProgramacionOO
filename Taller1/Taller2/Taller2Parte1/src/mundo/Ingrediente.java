package mundo;

public class Ingrediente {
	private String nombre;
	private int costoAdicional;
	public Ingrediente(String pNombre, int pCostoAdicional)
	{
		nombre=pNombre;
		costoAdicional=pCostoAdicional;
	}
	public String getNombre()
	{
		return nombre;
	}
	public int getCostoAdicional()
	{
		return costoAdicional;
	}
}
