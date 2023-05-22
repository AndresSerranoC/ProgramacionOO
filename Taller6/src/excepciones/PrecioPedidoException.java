package excepciones;

public class PrecioPedidoException extends Exception{
	public PrecioPedidoException() {
		super("El precio del pedido no puede superar los 150.000 pesos");
	}

}
