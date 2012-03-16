package mx.com.sintelti.domain;

import java.util.Set;

public class Venta implements Persistible
{
	private long codigoProducto;
	private double subTotal;
	private double totalVenta;
	private Set<Producto> listaProductos;
	
	public Long getCodigoProducto() 
	{
		return codigoProducto;
	}
	
	public void setCodigoProducto(Long codigoProducto) 
	{
		this.codigoProducto = codigoProducto;
	}
	
	public double getSubTotal() 
	{
		return subTotal;
	}
	
	public void setSubTotal(double subTotal) 
	{
		this.subTotal = subTotal;
	}
	
	public double getTotalVenta() 
	{
		return totalVenta;
	}
	
	public void setTotalVenta(double totalVenta) 
	{
		this.totalVenta = totalVenta;
	}
	
	public void setListaProductos(Set<Producto> listaProductos) 
	{
		this.listaProductos = listaProductos;
	}
	
	public Set<Producto> getListaProductos() {
		return listaProductos;
	}
	public void agregarVenta(Producto producto)
	{
		listaProductos.add(producto);
	}
}
