package mundo;

import java.util.ArrayList;

import excepciones.PrecioPedidoException;
import interfaz.Producto;

public class Pedido {
	public static final int PRECIO_CORTE=30000;
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<ProductoAjustado> productos;
	private int precioPedido;
	
	public Pedido( int pIdPedido, String pNombreCliente, String pDireccionCliente)
	{
		Pedido.numeroPedidos++;
		idPedido=pIdPedido;
		nombreCliente=pNombreCliente;
		direccionCliente=pDireccionCliente;
		productos=new ArrayList<ProductoAjustado>();
		precioPedido=0;
	}
	public void agregarProducto(ProductoAjustado producto) throws PrecioPedidoException
	{
		if (precioPedido+producto.getPrecioBase()>PRECIO_CORTE)
		{
			throw new PrecioPedidoException();
		}
		else
		{
			productos.add(producto);
			precioPedido=precioPedido+producto.getPrecioBase();
		}
		System.err.println(precioPedido);
	}
	/**
	 * @return the productos
	 */
	public ArrayList<ProductoAjustado> getProductos() {
		return productos;
	}
	/**
	 * @param productos the productos to set
	 */
	public void setProductos(ArrayList<ProductoAjustado> pProductos) {
		this.productos = pProductos;
	}
	/**
	 * @return the idPedido
	 */
	public int getIdPedido() {
		return idPedido;
	}
	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	

}
