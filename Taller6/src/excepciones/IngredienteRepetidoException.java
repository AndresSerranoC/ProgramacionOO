package excepciones;

public class IngredienteRepetidoException extends HamburguesaException{
	public IngredienteRepetidoException(String nombreIngrediente)
	{
		super("Existe un ingrediente repetido: "+nombreIngrediente);
	}

}
