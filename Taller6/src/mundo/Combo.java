package mundo;

import java.util.ArrayList;

import interfaz.Producto;

public class Combo {
	private double descuento;
	private String nombreCombo;
	private ArrayList<Producto> itemsCombo;
	public Combo(double pDescuento, String pNombreCombo)
	{
		descuento=pDescuento;
		nombreCombo=pNombreCombo;
		itemsCombo=new ArrayList<Producto>();
	}
	public void agregarListaItemACombo(String[] listaItems)
	{
		for (int i=0; i<listaItems.length;i++)
		{
			Producto producto=new Producto(listaItems[i]);
			itemsCombo.add(producto);
		}
		
	}
	public void agregarItemACombo(Producto itemCombo)
	{
		itemsCombo.add(itemCombo);
	}
	public String getNombre()
	{
		return nombreCombo;
	}
	public double getDescuento()
	{
		return descuento;
	}
}
