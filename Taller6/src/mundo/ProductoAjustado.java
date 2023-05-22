package mundo;

import java.util.ArrayList;

import interfaz.Producto;

public class ProductoAjustado extends ProductoMenu {
	private ArrayList<Ingredientes> ingredientesAgregados;
	private ArrayList<Ingredientes> ingredientesEliminados;
	private int precioAjustado;
	public ProductoAjustado(String pNombre, int precioBase) {
		super(pNombre,precioBase);
		ingredientesAgregados=new ArrayList<Ingredientes>();
		ingredientesEliminados=new ArrayList<Ingredientes>();
		
	}
	public void agregarIngredientes(Ingredientes ingrediente)
	{
		ingredientesAgregados.add(ingrediente);
		precioAjustado=precioAjustado+ingrediente.getCostoAdicional();
	}
	public void eliminarIngredientes(Ingredientes ingrediente)
	{
		ingredientesEliminados.add(ingrediente);
	}
	/**
	 * @return the ingredientesAgregados
	 */
	public ArrayList<Ingredientes> getIngredientesAgregados() {
		return ingredientesAgregados;
	}
	/**
	 * @return the ingredientesEliminados
	 */
	public ArrayList<Ingredientes> getIngredientesEliminados() {
		return ingredientesEliminados;
	}
	

}
