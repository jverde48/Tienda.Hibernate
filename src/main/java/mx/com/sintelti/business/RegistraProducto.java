package mx.com.sintelti.business;

import javax.swing.JOptionPane;

import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.Producto;

public class RegistraProducto extends OperacionesCRUD<Producto> 
{
	
	public Producto resgistrarProducto()
	{
		String datos[]=JOptionPane.showInputDialog("Ingrese los siguientes datos:\nNombre Producto, Precio, Peso, Cantidad, Existencia, Categoria, Proveedor").split(",");
		return datos.length == 7 ? new Producto(datos):null;
	}
	
	/*
	public void crearPersonaAuto(Auto auto)
	{
		if(auto != null)
		{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.getTransaction().commit();
		}
	}
	
	public void create()
	{
		
	}*/
}
