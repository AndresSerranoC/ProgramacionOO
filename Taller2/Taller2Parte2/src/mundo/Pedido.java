package mundo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Pedido {
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido;
	public Pedido(String pNombreCliente, String pDireccionCliente)
	{
		nombreCliente=pNombreCliente;
		direccionCliente=pDireccionCliente;
		itemsPedido=new ArrayList<Producto>();
		idPedido=numeroPedidos+1;
		numeroPedidos++;
		
	}
	public int getIdPedido()
	{
		return idPedido;
	}
	public String getNombreCliente()
	{
		return nombreCliente;
	}
	public void agregarProducto(Producto nuevoItem)
	{
		itemsPedido.add(nuevoItem);
	}
	private int getPrecioNetoPedido()
	{
		int precio=0;
		for (int i=0; i<itemsPedido.size();i++)
		{
			precio=precio+itemsPedido.get(i).getPrecio();
		}
		return precio;
	}
	private int getPrecioTotalPedido()
	{
		return getPrecioNetoPedido()+getPrecioIVAPedido();
	}
	private int getPrecioIVAPedido()
	{
		return (int) Math.round(getPrecioNetoPedido()*0.19);
	}
	public String generarTextoFactura()
	{
		String texto="Nombre cliente: "+nombreCliente+"\n"+"Dirección cliente: "+direccionCliente+"\n";
		texto=texto+"Items en el pedido"+"\n"+"------------------";
		for (int i=0;i<itemsPedido.size();i++)
		{
			texto=texto+"\n"+itemsPedido.get(i).generarTextoFactura();
		}
		texto=texto+"\n"+"Precio neto: $"+getPrecioNetoPedido()+"\n"+"IVA: $"+getPrecioIVAPedido()+"\n"+"Precio total: $"+getPrecioTotalPedido();
		texto=texto+"Calorias: "+getCalorias()+"\n"+".................................";				

		return texto;
	}
	public void guardarFactura(File archivo)
	{
		try {
		      FileWriter escritor = new FileWriter(archivo.getPath());
		      escritor.write(generarTextoFactura());
		      escritor.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	public ArrayList<Producto> getItemsPedido()
	{
		return itemsPedido;
	}
	public int getCalorias()
	{
		int calorias=0;
		for (int i=0;i<itemsPedido.size();i++)
		{
			calorias=calorias+itemsPedido.get(i).getCalorias();
		}
		return calorias;
	}
	@Override
	public boolean equals(Object o)
	{
		boolean respuesta=true;
		Pedido comparar=(Pedido) o;
		if (comparar.getItemsPedido().size()!=itemsPedido.size())
		{
			return false;
		}
		else
		{
			for (int i=0;i<comparar.getItemsPedido().size();i++)
			{
				boolean existeEquivalente=false;
				for (int j=0; j<itemsPedido.size();j++)
				{
					if (comparar.getItemsPedido().get(i).getNombre().equals(itemsPedido.get(i).getNombre()))
					{
						if (comparar.getItemsPedido().get(i).equals(itemsPedido.get(i)))
						{
							existeEquivalente=true;
						}

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
