package mundo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	private Producto base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	public ProductoAjustado(Producto pBase)
	{
		base=pBase;
		agregados=new ArrayList<Ingrediente>();
		eliminados=new ArrayList<Ingrediente>();
	}

	@Override
	public int getPrecio() {
		int precio=base.getPrecio();
		for (int i=0; i<agregados.size();i++)
		{
			precio=precio+agregados.get(i).getCostoAdicional();
		}
		return precio;
	}
	public int getPrecioBase()
	{
		return base.getPrecio();
	}

	@Override
	public String getNombre() {
		return base.getNombre();
	}

	@Override
	public String generarTextoFactura() {
		String texto=base.generarTextoFactura()+"\n"+"Adiciones: "+"\n";
		for (int i=0; i<agregados.size();i++)
		{
			texto=texto+agregados.get(i).getNombre()+"-$"+agregados.get(i).getCostoAdicional()+"\n";
		}
		texto=texto+"Eliminaciones: "+"\n";
		for (int i=0; i<eliminados.size();i++)
		{
			texto=texto+eliminados.get(i).getNombre()+"\n";
		}
		texto=texto+"Calorias: "+getCalorias()+"\n";				

		texto=texto+"Total producto: $"+getPrecio()+"\n"+".................................";
		
		return texto;
	}
	public void agregarAgregado(Ingrediente agregado)
	{
		agregados.add(agregado);
	}
	public void agregarEliminado(Ingrediente eliminado)
	{
		eliminados.add(eliminado);
	}
	public ArrayList<Ingrediente> getAgregados()
	{
		return agregados;
	}
	public ArrayList<Ingrediente> getEliminados()
	{
		return eliminados;
	}
	public int getCalorias()
	{
		int calorias=base.getCalorias();
		for (int i=0; i<agregados.size();i++)
		{
			calorias=calorias+agregados.get(i).getCalorias();
		}
		for (int i=0; i<eliminados.size();i++)
		{
			calorias=calorias-eliminados.get(i).getCalorias();
		}
		return calorias;
	}
	@Override
	public boolean equals(Object o)
	{
		boolean respuesta=true;
		ProductoAjustado comparar=(ProductoAjustado) o;
		if (comparar.getAgregados().size() != agregados.size() || comparar.getEliminados().size() !=eliminados.size())
		{
			return false;
		}
		else
		{
			for (int i=0;i<comparar.getAgregados().size();i++)
			{
				boolean existeEquivalente=false;
				for (int j=0; j<agregados.size();j++)
				{
					
					if (comparar.getAgregados().get(i).equals(agregados.get(i)))
					{
						existeEquivalente=true;
					}

				}
				if (existeEquivalente==false)
				{
					return false;
				}
				existeEquivalente=false;
				for (int j=0; j<eliminados.size();j++)
				{
					
					if (comparar.getEliminados().get(i).equals(eliminados.get(i)))
					{
						existeEquivalente=true;
					}

				}
				if (existeEquivalente==false)
				{
					return false;
				}
			}
		}
		return respuesta;
	}

}
