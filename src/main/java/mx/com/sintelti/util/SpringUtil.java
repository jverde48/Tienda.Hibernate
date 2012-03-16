package mx.com.sintelti.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil 
{
	/**
	 * Esta clase funciona para definir donde se encuentra ubicado nuestro "/applicationContext"
	 * lo cual hace que cada clase que necesite extender de esta clase para ubicar este archivo 
	 * no se tenga que definir en cada una sino solamente en esta, lo cual hace tener un bajo 
	 * acoplamiento de nuestra aplicacion
	 */
	private static final ApplicationContext CONTEXT = buildSpringContext();
	
	private static ClassPathXmlApplicationContext buildSpringContext()
	{
		try
		{
			return new ClassPathXmlApplicationContext("/applicationContext.xml");
		}
		catch(BeansException be)
		{
			throw new ExceptionInInitializerError(be);
		}
	}
	
	public static final ApplicationContext getContext()
	{
		return CONTEXT;
	}
}
