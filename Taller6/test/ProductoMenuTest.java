package test;
import org.junit.jupiter.api.Test;

import mundo.ProductoMenu;

import static org.junit.jupiter.api.Assertions.*;
public class ProductoMenuTest {
	@Test
    public void testPrecio() {
        ProductoMenu productoMenu = new ProductoMenu("Producto", 100);
        int precio = productoMenu.getPrecioBase();
        assertEquals(100, precio);
    }
}
