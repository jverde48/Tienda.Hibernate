package mx.com.sintelti.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;

import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.Producto;
import mx.com.sintelti.util.SpringUtil;

public class Almacen 
{
	private Producto producto;
	private static ApplicationContext context;//para la inyeccion de dependencia
	private static BufferedReader br;
	private static OperacionesCRUD<Producto> operacionesCrud;//para persistir el objeto
	
	public static void init()
	{
		context = SpringUtil.getContext();
		br = new BufferedReader(new InputStreamReader(System.in));
		operacionesCrud = new OperacionesCRUD<Producto>();
	}
	
	public void agregarProducto()
	{
		producto = context.getBean("producto", Producto.class);//regresa una intancia del objeto(producto) y realiza el cast al objeto que se necesite
		leerDatosProducto();
		operacionesCrud.create(producto);
	}

	public Producto obtenerProducto(long codigoProducto)
	{
		producto = context.getBean("producto", Producto.class);
		producto.setCodigoProducto(codigoProducto);
		return operacionesCrud.read(producto);
	}
	
	public void actualizarProducto(Producto producto)
	{
		operacionesCrud.update(producto);
	}
	
	public void actualizarProducto(long codigoProducto)
	{
		producto = context.getBean("producto", Producto.class);
		producto.setCodigoProducto(codigoProducto);
		operacionesCrud.read(producto);
		System.out.println("_-_-_-_-Actualizando producto-_-_-_-_");
		System.out.println(producto);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		leerDatosProducto();
		operacionesCrud.update(producto);
	}
	
	private void leerDatosProducto() 
	{
		try 
		{
			System.out.println("Nombre Producto: ");
			producto.setNombre(br.readLine());
			System.out.println("Precio Producto: ");
			producto.setPrecio(Double.parseDouble(br.readLine()));
			System.out.println("Peso Producto: ");
			producto.setPeso(br.readLine());
			System.out.println("cantidad Producto: ");
			producto.setCantidad(Integer.parseInt(br.readLine()));
			System.out.println("Existencia Producto: ");
			producto.setExistencia(Integer.parseInt(br.readLine()));
			System.out.println("Categoria Producto: ");
			producto.setCategoria(br.readLine());
			System.out.println("Proveedor Producto: ");
			producto.setProveedor(br.readLine());
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void productosExistentes()
	{
		for(Producto producto:operacionesCrud.list(new Producto()))
		{
			System.out.println(producto);
		}
		
	}
}
