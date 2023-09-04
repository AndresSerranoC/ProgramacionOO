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

}
