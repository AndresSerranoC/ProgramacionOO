package mundo;

public class Ingredientes {
	private String nombre;
	private int costoAdicional;
	public Ingredientes(String pNombre, int pCostoAdicional)
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
