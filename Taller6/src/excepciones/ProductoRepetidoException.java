package excepciones;

public class ProductoRepetidoException extends HamburguesaException{
	public ProductoRepetidoException(String nombreProducto)
	{
		super("Existe un producto repetido: "+nombreProducto);
	}
}
