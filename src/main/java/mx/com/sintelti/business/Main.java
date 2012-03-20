package mx.com.sintelti.business;
				
import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.Producto;
import mx.com.sintelti.util.SpringUtil;

public class Main {
	
	public static void main(String[] args) 
	{
	 	SpringUtil sp = SpringUtil.getContext().getBean("spUtil", SpringUtil.class);
		Producto producto = sp.getContext().getBean("producto", Producto.class);
		Almacen alm = sp.getContext().getBean("almacen", Almacen.class);
		alm.init();
		//alm.agregarProducto();
		alm.productosExistentes();
		
		Cajero caj = sp.getContext().getBean("cajero", Cajero.class);
		caj.init();
		caj.registrarVenta();
		
		/*RegistraProducto registraproducto = new RegistraProducto();
		Producto producto;
		
		
		for(int i=1; i<4; i++)
		{
			producto = registraproducto.resgistrarProducto();
			crud.create(producto);
		}
		
		System.out.println("\nInventario de Productos");
		for(Producto listaProducto : crud.list(new Producto()))
		{
			System.out.println(listaProducto.getCodigoProducto()+":-"+listaProducto);
		}*/
	}
}
