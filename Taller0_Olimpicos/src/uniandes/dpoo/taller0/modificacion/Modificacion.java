package uniandes.dpoo.taller0.modificacion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uniandes.dpoo.taller0.consola.ConsolaOlimpicos;
import uniandes.dpoo.taller0.procesamiento.*;
import uniandes.dpoo.taller0.modelo.Atleta;
import uniandes.dpoo.taller0.modelo.Genero;
import uniandes.dpoo.taller0.procesamiento.CalculadoraEstadisticas;
import uniandes.dpoo.taller0.procesamiento.LoaderOlimpicos;

public class Modificacion {
		public static void main(String[] args) throws IOException {
		System.out.println("Hola, mundo!");
		try {
			CalculadoraEstadisticas calc = LoaderOlimpicos.cargarArchivo("./data/atletas.csv");
			System.out.println("El país con más medallistas es: "+calc.paisConMasMedallistas().keySet().toArray()[0]);
		} catch (FileNotFoundException e) {
			System.err.println("El archivo atletas.csv no está en la carpeta data");
		}	}

}
