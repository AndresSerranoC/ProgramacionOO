package consola;

import mundo.Combo;
import mundo.Ingredientes;
import mundo.ProductoAjustado;
import mundo.ProductoMenu;
import mundo.Restaurante;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Aplicacion {
	private String menu;
	private Restaurante restaurante;
	public static void main(String[] args) {
		
		new Aplicacion();
	}
	public Aplicacion()
	{
		restaurante=new Restaurante();
		while(true)
		{
			mostrarMenu();
		} 
	}
	public void mostrarMenu()
	{
		System.out.println("Opciones (elegir alguna usando el número adecuado):");
		System.out.println("---------------------------------------------------");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su ID");
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream 
		int opcionElegida=sc.nextInt();
		ejecutrarOpcion(opcionElegida);
		
		
	}
	public void ejecutrarOpcion(int opcionElegida)
	{
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream 
		if (opcionElegida==1)
		{
			System.out.println("Productos base");
			System.out.println("--------------");
			ArrayList<ProductoMenu> menu=restaurante.getMenuBase();
			for (int i=0; i<menu.size();i++)
			{
				System.out.println(menu.get(i).getNombre().substring(0,1).toUpperCase()+menu.get(i).getNombre().substring(1)+" - $"+menu.get(i).getPrecioBase());
			}
			System.out.println("Combos");
			System.out.println("------");
			ArrayList<Combo> combos=restaurante.getCombos();
			for (int i=0; i<combos.size();i++)
			{
				System.out.println(combos.get(i).getNombre().substring(0,1).toUpperCase()+combos.get(i).getNombre().substring(1)+" - Descuento - "+combos.get(i).getDescuento()+" %");
			}
			System.out.println("Ingredientes adicionales");
			System.out.println("------------------------");
			ArrayList<Ingredientes> ingredientes=restaurante.getIngredientes();
			for (int i=0; i<ingredientes.size();i++)
			{
				System.out.println(ingredientes.get(i).getNombre().substring(0,1).toUpperCase()+ingredientes.get(i).getNombre().substring(1)+" - $"+ingredientes.get(i).getCostoAdicional());
			}
			
		}
		else if (opcionElegida==2)
		{
			System.out.println("Ingresar nombre del cliente completo");
			String nombre="";
			while (nombre.equals(""))
			{
				nombre=sc.nextLine();
			}
			
			System.out.println("Ingresar dirección del cliente");
			String direccion="";
			while (direccion.equals(""))
			{
				direccion=sc.nextLine();
			}
			restaurante.iniciarPedido(nombre, direccion);
		}
		else if(opcionElegida==3)
		{
			System.out.println("Que tipo de producto desea agregar?");
			System.out.println("------------------------------------");
			System.out.println("1. Productos base");
			System.out.println("2. Combos");
			
			int opcionElegida31=sc.nextInt();
			if (opcionElegida31==1)
			{
				System.out.println("Que tipo de producto base desea agregar?");
				System.out.println("------------------------------------");
				System.out.println("1. Hamburguesas");
				System.out.println("2. Wraps");
				System.out.println("3. Ensaladas");
				System.out.println("4. Papas");
				System.out.println("5. Bebidas");
				int opcionElegida32=sc.nextInt();
				ProductoMenu producto=null;
				if (opcionElegida32==1)
				{
					
					System.out.println("Elija su hamburguesa");
					System.out.println("--------------------");
					for (int i=0;i<12;i++)
					{
						System.out.println((i+1)+". "+restaurante.getMenuBase().get(i).getNombre().substring(0,1).toUpperCase()+restaurante.getMenuBase().get(i).getNombre().substring(1)+" - $"+restaurante.getMenuBase().get(i).getPrecioBase());
					}						
					int opcionElegida33=sc.nextInt();
					producto=restaurante.getProductoSinMod(restaurante.getMenuBase().get(opcionElegida33-1).getNombre(),restaurante.getMenuBase().get(opcionElegida33-1).getPrecioBase());

					

				}
				else if (opcionElegida32==2)
				{
					System.out.println("Elija su wrap");
					System.out.println("-------------");
					for (int i=12;i<14;i++)
					{
						System.out.println((i-11)+". "+restaurante.getMenuBase().get(i).getNombre().substring(0,1).toUpperCase()+restaurante.getMenuBase().get(i).getNombre().substring(1)+" - $"+restaurante.getMenuBase().get(i).getPrecioBase());
					}
					int opcionElegida33=sc.nextInt();
					producto=restaurante.getProductoSinMod(restaurante.getMenuBase().get(opcionElegida33+11).getNombre(),restaurante.getMenuBase().get(opcionElegida33+11).getPrecioBase());					

				}
				else if (opcionElegida32==3)
				{
					System.out.println("Elija su ensalada");
					System.out.println("-----------------");
					for (int i=14;i<15;i++)
					{
						System.out.println((i-13)+". "+restaurante.getMenuBase().get(i).getNombre().substring(0,1).toUpperCase()+restaurante.getMenuBase().get(i).getNombre().substring(1)+" - $"+restaurante.getMenuBase().get(i).getPrecioBase());
					}
					int opcionElegida33=sc.nextInt();
					producto=restaurante.getProductoSinMod(restaurante.getMenuBase().get(opcionElegida33+13).getNombre(),restaurante.getMenuBase().get(opcionElegida33+13).getPrecioBase());
				}
				else if (opcionElegida32==4)
				{
					System.out.println("Elija sus papas");
					System.out.println("---------------");
					for (int i=15;i<19;i++)
					{
						System.out.println((i-14)+". "+restaurante.getMenuBase().get(i).getNombre().substring(0,1).toUpperCase()+restaurante.getMenuBase().get(i).getNombre().substring(1)+" - $"+restaurante.getMenuBase().get(i).getPrecioBase());
					}
					int opcionElegida33=sc.nextInt();
					producto=restaurante.getProductoSinMod(restaurante.getMenuBase().get(opcionElegida33+14).getNombre(),restaurante.getMenuBase().get(opcionElegida33+14).getPrecioBase());

				}
				else if (opcionElegida32==5)
				{
					System.out.println("Elija su bebida");
					System.out.println("---------------");
					for (int i=19;i<22;i++)
					{
						System.out.println((i-18)+". "+restaurante.getMenuBase().get(i).getNombre().substring(0,1).toUpperCase()+restaurante.getMenuBase().get(i).getNombre().substring(1)+" - $"+restaurante.getMenuBase().get(i).getPrecioBase());
					}
					int opcionElegida33=sc.nextInt();
					producto=restaurante.getProductoSinMod(restaurante.getMenuBase().get(opcionElegida33+18).getNombre(),restaurante.getMenuBase().get(opcionElegida33+18).getPrecioBase());

				}
				System.out.println("Desea modificar su "+producto.getNombre()+"?");
				System.out.println("--------------------------");

				System.out.println("1. Sí");
				System.out.println("2. No");
				int opcionElegida34=sc.nextInt();
				if (opcionElegida34==2)
				{
					ProductoAjustado productoModificado=new ProductoAjustado(producto.getNombre(), producto.getPrecioBase());
					producto=productoModificado;
				}
				while (opcionElegida34==1)
				{
					System.out.println("Desea agregar o eliminar ingredientes?");
					System.out.println("-----------------------------------");

					System.out.println("1. Eliminar");
					System.out.println("2. Agregar");
					System.out.println("3. Regresar");
					int opcionElegida35=sc.nextInt();
					if (opcionElegida35==1)
					{
						System.out.println("Qué ingrediente desea eliminar?");
						System.out.println("-------------------------------");
						ArrayList<Ingredientes> ingredientes=restaurante.getIngredientes();
						for (int i=0;i<ingredientes.size();i++)
						{
							System.out.println((i+1)+". "+ingredientes.get(i).getNombre().substring(0,1).toUpperCase()+ingredientes.get(i).getNombre().substring(1)+" - $"+restaurante.getMenuBase().get(i).getPrecioBase());
						}
						
						int opcionElegida36=sc.nextInt();
						ProductoAjustado productoModificado=new ProductoAjustado(producto.getNombre(), producto.getPrecioBase());
						productoModificado.eliminarIngredientes(new Ingredientes(restaurante.getIngredientes().get(opcionElegida36-1).getNombre(),restaurante.getIngredientes().get(opcionElegida36-1).getCostoAdicional()));
						producto=productoModificado;

					}
					else if (opcionElegida35==2)
					{
						System.out.println("Qué ingrediente desea agregar?");
						System.out.println("-------------------------------");
						ArrayList<Ingredientes> ingredientes=restaurante.getIngredientes();
						for (int i=0;i<ingredientes.size();i++)
						{
							System.out.println((i+1)+". "+ingredientes.get(i).getNombre().substring(0,1).toUpperCase()+ingredientes.get(i).getNombre().substring(1)+" - $"+restaurante.getIngredientes().get(i).getCostoAdicional());
						}
						
						int opcionElegida36=sc.nextInt();
						ProductoAjustado productoModificado=new ProductoAjustado(producto.getNombre(), producto.getPrecioBase());
						productoModificado.agregarIngredientes(new Ingredientes(restaurante.getIngredientes().get(opcionElegida36-1).getNombre(),restaurante.getIngredientes().get(opcionElegida36-1).getCostoAdicional()));
						producto=productoModificado;

					}
					else if (opcionElegida35==3)
					{
						break;

					}
					
					
				}
				restaurante.setPedidoEnCurso((ProductoAjustado) producto);
				System.out.println("Se creó el pedido por un "+restaurante.getPedidoEnCurso().getProductos().get(0).getNombre()+" correctamente. El total es $"+restaurante.getPedidoEnCurso().getProductos().get(0).getPrecioBase()+"\n"+"El id del pedido es "+restaurante.getPedidoEnCurso().getIdPedido());
			}	
			else if(opcionElegida31==2)
			{
				System.out.println("Qué combo desea?");
				System.out.println("------------------------------------");
				System.out.println("1. Combo corral");
				System.out.println("2. Combo corral queso");
				System.out.println("3. Combo todoterreno");
				System.out.println("4. Combo especial");
				int opcionElegida32=sc.nextInt();
				if (opcionElegida32==1)
				{
					//restaurante.
				}
			}
		}
		else if (opcionElegida==4)
		{
			try {

			      FileWriter myWriter = new FileWriter("./data/"+restaurante.getPedidoEnCurso().getIdPedido()+"pedido.txt");
			      myWriter.write("Producto"+"\n");
			      myWriter.write(restaurante.getPedidoEnCurso().getProductos().get(0).getNombre().substring(0,1).toUpperCase()+restaurante.getPedidoEnCurso().getProductos().get(0).getNombre().substring(1)+" - "+restaurante.getPedidoEnCurso().getProductos().get(0).getPrecioBase());
			      myWriter.write("\n"+"Adiciones"+"\n");
			      
			      for (int i=0; i<restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesAgregados().size();i++)
			      {
			    	  myWriter.write(restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesAgregados().get(i).getNombre().substring(0,1).toUpperCase()+restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesAgregados().get(i).getNombre().substring(1)+" - "+restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesAgregados().get(i).getCostoAdicional());
			      }
			      myWriter.write("\n"+"Eliminados"+"\n");

			      
			      for (int i=0; i<restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesEliminados().size();i++)
			      {
			    	  myWriter.write(restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesEliminados().get(i).getNombre().substring(0,1).toUpperCase()+restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesEliminados().get(i).getNombre().substring(1)+" - "+restaurante.getPedidoEnCurso().getProductos().get(0).getIngredientesEliminados().get(i).getCostoAdicional());
			      }
			      myWriter.close();
			      restaurante.setPedidoEnCurso(null);
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			  }
		else if (opcionElegida==5)
		{
			System.out.println("Ingresar ID del pedido");
			System.out.println("----------------------");
			int id=sc.nextInt();
			ArrayList<String> datos=restaurante.buscarPorID(id);
			for (int i=0; i<datos.size();i++)
			{
				System.out.println(datos.get(i));
			}
			
			

		}
				
		}
	}



