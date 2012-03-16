package mx.com.sintelti.domain;

public class Producto implements Persistible {
	
	private long codigoProducto;
	private String nombre;
	private Double precio;
	private String peso;
	private Integer cantidad;
	private Integer existencia;
	private String categoria;
	private String proveedor;
	private Venta venta;
	
	//private static Producto producto = new Producto();
	
	/*private Producto()
	{
		
	}
	
	public static Producto getInstance()
	{
		return producto;
	}*/

	public Producto(){}
	
	public Producto(String... datos)
	{
		this.nombre = datos[0];
		this.precio = Double.parseDouble(datos[1]);
		this.peso = datos[2];
		this.cantidad = Integer.parseInt(datos[3]);
		this.existencia = Integer.parseInt(datos[4]);
		this.categoria= datos[5];
		this.proveedor = datos[6];
	}

	public Long getCodigoProducto() 
	{
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) 
	{
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}


	public Double getPrecio() 
	{
		return precio;
	}

	public void setPrecio(Double precio) 
	{
		this.precio = precio;
	}

	public String getPeso() 
	{
		return peso;
	}

	public void setPeso(String peso)
	{
		this.peso = peso;
	}
	

	public Integer getCantidad() 
	{
		return cantidad;
	}

	public void setCantidad(Integer cantidad) 
	{
		this.cantidad = cantidad;
	}

	public Integer getExistencia() 
	{
		return existencia;
	}

	public void setExistencia(Integer existencia) 
	{
		this.existencia = existencia;
	}

	public String getCategoria() 
	{
		return categoria;
	}

	public void setCategoria(String categoria) 
	{
		this.categoria = categoria;
	}

	public String getProveedor() 
	{
		return proveedor;
	}

	public void setProveedor(String proveedor) 
	{
		this.proveedor = proveedor;
	}
	
	public void setVenta(Venta venta)
	{
		this.venta=venta;
	}
	
	public Venta getVenta()
	{
		return venta;
	}

	@Override
	public String toString() 
	{
		return "Nombre Producto|"+this.nombre+ 
			   "\tPrecio|"+this.precio+
			   "\tPeso|"+this.peso+
			   "\tCantidad|"+this.cantidad+
			   "\tExistencia|"+this.existencia+
			   "\tCategoria|"+this.categoria+
			   "\tProveedor|"+this.proveedor;
	}

}
