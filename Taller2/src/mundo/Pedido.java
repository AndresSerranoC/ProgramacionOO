package mundo;

import java.util.ArrayList;

import interfaz.Producto;

public class Pedido {
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<ProductoAjustado> productos;
	
	public Pedido( int pIdPedido, String pNombreCliente, String pDireccionCliente)
	{
		Pedido.numeroPedidos++;
		idPedido=pIdPedido;
		nombreCliente=pNombreCliente;
		direccionCliente=pDireccionCliente;
		productos=new ArrayList<ProductoAjustado>();
	}
	public void agregarProducto(ProductoAjustado producto)
	{
		productos.add(producto);
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
