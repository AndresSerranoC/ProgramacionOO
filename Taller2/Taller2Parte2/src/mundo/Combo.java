package mundo;

import java.util.ArrayList;

public class Combo implements Producto{
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo(String nombre, double pDescuento)
	{
		nombreCombo=nombre;
		descuento=pDescuento;
		itemsCombo=new ArrayList<ProductoMenu>();

	}
	
	public void agregarItemACombo(ProductoMenu itemCombo)
	{
		itemsCombo.add(itemCombo);
	}

	@Override
	public int getPrecio() {
		int precio=0;
		for (int i=0; i<itemsCombo.size();i++)
		{
			precio=precio+itemsCombo.get(i).getPrecio();
		}
		precio=(int) Math.round(precio-(precio*descuento/100));
		return precio;
	}

	@Override
	public String getNombre() {
		return nombreCombo;
	}

	@Override
	public String generarTextoFactura() {
		return nombreCombo+"-$"+getPrecio()+"-Calorias: "+getCalorias()+"\n"+".................................";	
	}
	public int getCalorias()
	{
		int calorias=0;
		for (int i=0; i<itemsCombo.size();i++)
		{
			calorias=calorias+itemsCombo.get(i).getCalorias();
		}
		return calorias;
	}
	@Override
	public boolean equals(Object o)
	{
		Combo comparar=(Combo) o;
		if (comparar.getNombre().equals(nombreCombo))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
