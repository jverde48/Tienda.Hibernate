package mx.com.sintelti.business;

import org.springframework.context.ApplicationContext;

import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.Producto;
import mx.com.sintelti.domain.Venta;
import mx.com.sintelti.util.SpringUtil;

public class RegistroVenta 
{
	private Producto producto;
	private Venta venta;
	private static ApplicationContext context;
	private static OperacionesCRUD<Venta> operacionesCrud;
	
	public static void init()
	{
		context = SpringUtil.getContext();
		operacionesCrud = new OperacionesCRUD<Venta>();
	}
	
	public void registrarVenta()
	{
		venta = context.getBean("venta",Venta.class);
	}
}
