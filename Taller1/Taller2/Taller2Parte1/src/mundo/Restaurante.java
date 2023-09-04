package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante {
	private ArrayList<Combo> combos;
	private ArrayList<Pedido> pedidos;
	private Pedido pedidoEnCurso;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	public Restaurante ()
	{
		combos=new ArrayList<Combo>();
		pedidos=new ArrayList<Pedido>();
		ingredientes=new ArrayList<Ingrediente>();
		menuBase=new ArrayList<ProductoMenu>();
		cargarInformacionRestaurante(new File("./data/ingredientes.txt"), new File("./data/menu.txt"), new File("./data/combos.txt"));
	}
	public ProductoAjustado convertirProductoAjustado(Producto producto)
	{
		ProductoAjustado productoAjustado=new ProductoAjustado(producto);
		return productoAjustado;
	}
	public String getInformacionPedidoPorID(int id)
	{
		return pedidos.get(id-1).generarTextoFactura();
	}
	public ProductoAjustado agregarAProducto(ProductoAjustado producto, ArrayList<Integer> ingrediente)
	{
		for (int i=0; i<ingrediente.size();i++)
		{
			producto.agregarAgregado(ingredientes.get(ingrediente.get(i)));
		}
		
		return producto;
	}
	public ProductoAjustado eliminarDeProducto(ProductoAjustado producto, ArrayList<Integer> ingrediente)
	{
		for (int i=0; i<ingrediente.size();i++)
		{
			producto.agregarEliminado(ingredientes.get(ingrediente.get(i)));
		}
		return producto;
	}
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		pedidoEnCurso=new Pedido(nombreCliente, direccionCliente);
		pedidos.add(pedidoEnCurso);
	}
	
	public void cerrarYGuardarPedido()
	{
		pedidoEnCurso.guardarFactura(new File("./facturas/"+pedidoEnCurso.getIdPedido()+".txt"));
		resetearPedidoEnCurso();
	}
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menuBase;
	}
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}
	public ArrayList<Combo> getCombos()
	{
		return combos;
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos)
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
		
		
	}
	private void cargarIngredientes(File archivoIngredientes)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes))) {
	        while (true)
	        {
	        	String linea=br.readLine();
	        	if (linea==null)
	        	{
	        		break;
	        	}
	        	else
	        	{
	        		ingredientes.add(new Ingrediente(linea.split(";")[0], Integer.parseInt(linea.split(";")[1])));
	        	}
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	private void cargarMenu (File archivoMenu)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoMenu))) {
	        while (true)
	        {
	        	String linea=br.readLine();
	      
	        	if (linea==null)
	        	{
	        		break;
	        	}
	        	else
	        	{
	        	
	        		menuBase.add(new ProductoMenu(linea.split(";")[0],Integer.parseInt(linea.split(";")[1])));
	        	}
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	private void cargarCombos (File archivoCombos)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoCombos))) {
	        while (true)
	        {
	        	String linea=br.readLine();
	        	if (linea==null)
	        	{
	        		break;
	        	}
	        	else
	        	{
	        		combos.add(new Combo(linea.split(";")[0], Integer.parseInt(linea.split(";")[1].replace("%", ""))));
	        		for (int i=2; i<linea.split(";").length;i++)
	        		{
	        			String nombreProducto=linea.split(";")[i];
	        			for (int j=0; j<menuBase.size();j++)
	        			{
	        				if (nombreProducto.equals(menuBase.get(j).getNombre()))
	        				{
	        					combos.get(combos.size()-1).agregarItemACombo(menuBase.get(j));
	        				}
	        			}
	        		}
	        	}
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void resetearPedidoEnCurso()
	{
		pedidoEnCurso=null;
	}
}

