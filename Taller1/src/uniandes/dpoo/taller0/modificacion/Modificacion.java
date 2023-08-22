package uniandes.dpoo.taller0.modificacion;

import java.io.FileNotFoundException;
import java.io.IOException;

import uniandes.dpoo.taller0.procesamiento.CalculadoraEstadisticas;
import uniandes.dpoo.taller0.procesamiento.LoaderOlimpicos;

public class Modificacion {

	public static void main(String[] args) {
		System.out.println("Hola, mundo!");
		try {
			CalculadoraEstadisticas calc = LoaderOlimpicos.cargarArchivo("./data/atletas.csv");
			String llaves=calc.paisConMasMedallistas().keySet().toString();
			System.out.println("El país con más medallistas es "+llaves.substring(1, llaves.length() - 1)+".");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
