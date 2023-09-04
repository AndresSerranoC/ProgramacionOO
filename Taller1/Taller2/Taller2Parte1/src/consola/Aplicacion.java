package consola;

import java.util.ArrayList;
import java.util.Scanner;

import mundo.Combo;
import mundo.Ingrediente;
import mundo.Producto;
import mundo.ProductoAjustado;
import mundo.ProductoMenu;
import mundo.Restaurante;

public class Aplicacion {
	private Restaurante restaurante;
	public Aplicacion ()
	{
		restaurante=new Restaurante();
		System.out.println("Iniciando restaurante");
		System.out.println("---------------------");
		mostrarMenu();
	}
	public void mostrarMenu()
	{
		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			System.out.println("Menú");
			System.out.println("----");
			System.out.println("1. Iniciar un nuevo pedido");
			System.out.println("2. Agregar elemento a un pedido");
			System.out.println("3. Cerrar pedido y guardar factura");
			System.out.println("4. Consultar pedido por ID");

			int opcionSeleccionada=Integer.parseInt(scanner.nextLine());
			ejecutarOpcion(opcionSeleccionada);
		}
	}
	public void ejecutarOpcion(int opcionSeleccionada)
	{
		Scanner scanner = new Scanner(System.in);
		if (opcionSeleccionada==1)
		{
			if (restaurante.getPedidoEnCurso()==null)
			{
				System.out.println("Ingresar nombre cliente: ");
				String nombre=scanner.nextLine();
				System.out.println("Ingresar dirección cliente: ");
				String direccion=scanner.nextLine();
				restaurante.iniciarPedido(nombre, direccion);
			}
			else
			{
				System.out.println("¿Qué desea hacer con el pedido anterior?");
				System.out.println("----------------------------------------");
				System.out.println("1. Eliminarlo");
				System.out.println("2. Cerrarlo y guardarlo");
				System.out.println("3. Continuar agregándole productos");
				int opcion=Integer.parseInt(scanner.nextLine());
				if (opcion==1)
				{
					restaurante.resetearPedidoEnCurso();
					System.out.println("El pedido anterior se eliminó");
					ejecutarOpcion(1);
					
				}
				else if (opcion==2)
				{
					restaurante.cerrarYGuardarPedido();
					System.out.println("El pedido anterior se cerró y guardó");
					ejecutarOpcion(1);
				}
				else if (opcion==3)
				{
					System.out.println("Continuar en el pedido anterior");
				}
				else
				{
					System.out.println("Opción desconocida");
					ejecutarOpcion(1);
				}
			}
			
			
		}
		else if(opcionSeleccionada==2)
		{
			System.out.println("¿Qué tipo de elemento desea agregar?");
			System.out.println("----------------------------------");
			System.out.println("1. Producto menú");
			System.out.println("2. Combo");
			int tipoElemento=Integer.parseInt(scanner.nextLine());
			if (tipoElemento==1)
			{
				System.out.println("¿Cuál de los productos del menú desea agregar?");
				System.out.println("----------------------------------------------");
				ArrayList<ProductoMenu> menu=restaurante.getMenuBase();
				for (int i=1; i<=menu.size();i++)
				{
					System.out.println(i+". "+menu.get(i-1).getNombre()+"-$"+menu.get(i-1).getPrecio());
				}

				int producto=Integer.parseInt(scanner.nextLine())-1;
				ProductoAjustado productoAjustado=new ProductoAjustado(restaurante.getMenuBase().get(producto));
				System.out.println("--------------------------------");
				ArrayList<Integer> ingredientes=new ArrayList<Integer>();
				for (int i=0; i<restaurante.getIngredientes().size();i++)
				{
					ingredientes.add(i);
				}

				ArrayList<Integer> ingredientesAgregar=new ArrayList<Integer>();
				ArrayList<Integer> ingredientesEliminar=new ArrayList<Integer>();
				while (true)
				{
					System.out.println("¿Desea agregar algún ingrediente?");
					System.out.println("---------------------------------");
					System.out.println("0. No agregar ningún ingrediente");

					for (int i=1; i<=ingredientes.size();i++)
					{
						System.out.println(i+". Agregar "+restaurante.getIngredientes().get(i-1).getNombre()+"-$"+restaurante.getIngredientes().get(i-1).getCostoAdicional());
					}
					int ingredienteAgregar=Integer.parseInt(scanner.nextLine());
					if (ingredienteAgregar==0)
					{
						break;
					}
					else if (ingredienteAgregar>=ingredientes.size())
					{
						System.out.println("Ingrediente no válido");
					}
					else
					{
						ingredientesAgregar.add(ingredienteAgregar-1);
						
					}
					

				}

				while (true)
				{
					
					System.out.println("¿Desea eliminar algún ingrediente?");
					System.out.println("---------------------------------");
					System.out.println("0. No eliminar ningún ingrediente");
					for (int i=1; i<=ingredientes.size();i++)
					{
						System.out.println(i+". Eliminar "+restaurante.getIngredientes().get(i-1).getNombre()+"-$"+restaurante.getIngredientes().get(i-1).getCostoAdicional());
					}
					int ingredienteEliminar=Integer.parseInt(scanner.nextLine());
					if (ingredienteEliminar==0)
					{
						break;
					}
					else if (ingredienteEliminar>=ingredientes.size())
					{
						System.out.println("Ingrediente no válido");
					}
					else
					{
						ingredientesEliminar.add(ingredientes.get(ingredienteEliminar-1));
					}
				}
				
				productoAjustado=restaurante.convertirProductoAjustado(restaurante.getMenuBase().get(producto));
				productoAjustado=restaurante.agregarAProducto(productoAjustado, ingredientesAgregar);
				productoAjustado=restaurante.eliminarDeProducto(productoAjustado, ingredientesEliminar);
				restaurante.getPedidoEnCurso().agregarProducto(productoAjustado);
			}
			else if(tipoElemento==2)
			{
				System.out.println("¿Cuál de los combos del menú desea agregar?");
				System.out.println("----------------------------------------------");
				ArrayList<Combo> combos=restaurante.getCombos();
				for (int i=1; i<=combos.size();i++)
				{
					System.out.println(i+". "+combos.get(i-1).getNombre()+"-$"+combos.get(i-1).getPrecio());
				}
				int comboAgregar=Integer.parseInt(scanner.nextLine());
				restaurante.getPedidoEnCurso().agregarProducto(combos.get(comboAgregar));
			}
			else
			{
				System.out.println("Opción desconocida");
			}
		}
		else if (opcionSeleccionada==3)
		{
			restaurante.cerrarYGuardarPedido();
			

		}
		else if (opcionSeleccionada==4)
		{
			System.out.println("Ingresar ID pedido ");
			int idPedido=Integer.parseInt(scanner.nextLine());
			System.out.println(restaurante.getInformacionPedidoPorID(idPedido));
			
			

		}
		else
		{
			System.out.println("Opción desconocida");
		}
	}
	public static void main(String[] args) {
		Aplicacion aplicacion=new Aplicacion();
	}


}
