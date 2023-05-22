package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.text.Utilities;

import excepciones.HamburguesaException;
import excepciones.IngredienteRepetidoException;
import excepciones.PrecioPedidoException;
import excepciones.ProductoRepetidoException;
import interfaz.Producto;

public class Restaurante {
	private ArrayList<Ingredientes> ingredientes;
	private Pedido pedidoEnCurso;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Combo> combos;
	private ArrayList<ProductoMenu> menu;
	public Restaurante()
	{
		ingredientes=new ArrayList<Ingredientes>();
		menu=new ArrayList<ProductoMenu>();
		pedidos=new ArrayList<Pedido>();
		combos=new ArrayList<Combo>();
		cargarInformacionRestaurante(new File("./data/ingredientes.txt"), new File("./data/menu.txt"), new File("./data/combos.txt"));
	}
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		Pedido pedidoActual=new Pedido(pedidos.size(), nombreCliente, direccionCliente);
		pedidos.add(pedidoActual);
		pedidoEnCurso=pedidoActual;
	}
	public void cerrarYGuardarPedido()
	{
		
	}
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
	public void setPedidoEnCurso(ProductoAjustado producto)
	{
		try
		{
			pedidoEnCurso.agregarProducto(producto);
		}
		catch(PrecioPedidoException e)
		{
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		catch (Exception e) {
			System.err.println("Iniciar primero el pedido usando la opci�n 2");
		}
	}
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menu;
	}
	public ArrayList<Ingredientes> getIngredientes()
	{
		return ingredientes;
	}
	public ArrayList<Combo> getCombos()
	{
		return combos;
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos)
	{
		try {
			cargarIngredientes(archivoIngredientes);
		} catch (HamburguesaException e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		try {
			cargarMenu(archivoMenu);
		} catch (ProductoRepetidoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		cargarCombos(archivoCombos);
		
	}

	private void cargarIngredientes(File archivoIngredientes) throws HamburguesaException
	{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(archivoIngredientes));
			String st;
	        while ((st = br.readLine()) != null)
	            ingredientes.add(new Ingredientes(st.split(";")[0], Integer.parseInt(st.split(";")[1])));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HashSet<String> conjunto=new HashSet<>();
		String nombreActual="";
		for (Ingredientes ingredienteActual:ingredientes)
		{
			nombreActual=ingredienteActual.getNombre();
			if (conjunto.contains(nombreActual))
			{
				throw new IngredienteRepetidoException(nombreActual);
			}
			conjunto.add(nombreActual);
		}
		
	}
	private void cargarMenu(File archivoMenu) throws ProductoRepetidoException
	{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(archivoMenu));
			String st;
	        while ((st = br.readLine()) != null)
	        {
	        	menu.add(new ProductoMenu(st.split(";")[0], Integer.parseInt(st.split(";")[1])));
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HashSet<String> conjunto=new HashSet<>();
		String nombreActual="";
		for (ProductoMenu productoActual:menu)
		{
			nombreActual=productoActual.getNombre();
			if (conjunto.contains(nombreActual))
			{
				throw new ProductoRepetidoException(nombreActual);
			}
			conjunto.add(nombreActual);
		}
		
	}
	private void cargarCombos(File archivoCobmos)
	{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(archivoCobmos));
			String st;
	        while ((st = br.readLine()) != null) {
	        	String[] items = Arrays.copyOfRange(st.split(";"), 2, st.split(";").length-1);
	        	Combo comboActual=new Combo(Double.parseDouble(st.split(";")[1].split("%")[0]), st.split(";")[0]);
	        	comboActual.agregarListaItemACombo(items);
	        	combos.add(comboActual);
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ProductoMenu getProductoSinMod(String nombre, int precio)
	{
		return new ProductoMenu(nombre, precio);
	}
	public ProductoAjustado addProductoActual(ProductoMenu producto, Ingredientes ingrediente)
	{
		try
		{
			ProductoAjustado productoA=(ProductoAjustado) producto;
			productoA.agregarIngredientes(ingrediente);
			return productoA;
		}
		catch (Exception e)
		{
			ProductoAjustado productoMod=new ProductoAjustado(producto.getNombre(), producto.getPrecioBase());
			productoMod.agregarIngredientes(ingrediente);
			return productoMod;
		}
		
	}
	public ProductoAjustado delProductoActual(ProductoMenu producto, Ingredientes ingrediente)
	{
		try
		{
			ProductoAjustado productoA=(ProductoAjustado) producto;
			productoA.eliminarIngredientes(ingrediente);
			return productoA;
		}
		catch (Exception e)
		{
			ProductoAjustado productoMod=new ProductoAjustado(producto.getNombre(), producto.getPrecioBase());
			productoMod.eliminarIngredientes(ingrediente);
			return productoMod;
		}
		
	}
	public ArrayList<String> buscarPorID(int id)
	{
		File archivo=new File("./data/"+id+"pedido.txt");
		BufferedReader br;
		ArrayList<String> datos=new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(archivo));
			String st;
	        while ((st = br.readLine()) != null)
	            datos.add(st);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datos;
	}
}
