package mx.com.sintelti.business;
				
import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.Producto;

public class Main {
	
	public static void main(String[] args) 
	{
		OperacionesCRUD<Producto> crud = new OperacionesCRUD<Producto>();
		RegistraProducto registraproducto = new RegistraProducto();
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
		}
	}
}
