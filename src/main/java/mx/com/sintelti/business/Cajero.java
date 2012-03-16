package mx.com.sintelti.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;

import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.Producto;
import mx.com.sintelti.domain.Venta;
import mx.com.sintelti.util.SpringUtil;

public class Cajero 
{
	private Venta venta;
	private static ApplicationContext context;//para la inyeccion de dependencia
	private static BufferedReader br;
	private static OperacionesCRUD<Venta> operacionesCrud;
	private static Producto producto;
	private static Almacen almacen;
	
	public static void init()
	{
		context = SpringUtil.getContext();
		almacen = context.getBean("almacen", Almacen.class);
		br = new BufferedReader(new InputStreamReader(System.in));
		operacionesCrud = new OperacionesCRUD<Venta>();
	}
	
	public void registrarVenta()
	{
		venta = context.getBean("venta",Venta.class);
		menu();
	}
	
	private void agregarProducto(long id) throws NumberFormatException, IOException
	{
		producto = almacen.obtenerProducto(id);
		System.out.println("cuantos "+producto.getNombre()+" Desea agregar");
		int cantidad = Integer.parseInt(br.readLine());
		int existencia = producto.getExistencia();
		if(cantidad > existencia)
		{
			System.out.println("No  hay producto suficiente");
		}
		else
		{
			double precio = producto.getPrecio();
			double subTotal = venta.getSubTotal()+(cantidad * precio);
			producto.setExistencia(existencia-cantidad);
			almacen.actualizarProducto(producto);
			venta.setSubTotal(subTotal);
			venta.agregarVenta(producto);
		}
	}
	
	private void cobrar() 
	{
		double totalVenta = (venta.getSubTotal()+(venta.getSubTotal()*0.16)); 
		venta.setTotalVenta(totalVenta);
		operacionesCrud.create(venta);
	}
	
	private void menu()
	{
		String opcion = "";
		int opcion2=0;
		int opcion3=0;
		
		while(opcion3 != 3)
		{
			try 
			{
				opcion = br.readLine();
				opcion2= Integer.parseInt(opcion);
				System.out.println("1.- Listar Productos\n2.- Agregar producto\n3.- Cobrar");
		
				switch (opcion2) 
				{
					case 1:
						System.out.println("_-_-_-_-Productos Existentes-_-_-_-_");
						almacen.productosExistentes();
						System.out.println();
						break;
				
					case 2:
						do
						{
							System.out.println("Ingrese id de producto");
							try
							{
								System.out.println("Ingrese el ID del Producto");
								long id = Long.parseLong(br.readLine());
								agregarProducto(id);
							}
							catch(NumberFormatException ne)
							{
								System.out.println("El valor que ingreso no es numerico");
							}
							opcion2= Integer.parseInt(opcion);
							System.out.println("Desea ingresar un nuevo producto 1.- si 2.- no");
						}while(opcion2==1);
					break;
				
					case 3:
						cobrar();
					break;

					default:
						System.out.println("opcion no valida");
					break;
				}
				System.out.println("Deseas realizar alguna otra opcion 1.- si 2.- no");
				opcion3 = Integer.parseInt(br.readLine());
			}
			catch (IOException e) 
			{
				System.out.println("El valor que ingreso no es valido");
			}
			catch(NumberFormatException ne)
			{
				System.out.println("El valor que ingreso no es numerico");
			}
		}
	}
}
