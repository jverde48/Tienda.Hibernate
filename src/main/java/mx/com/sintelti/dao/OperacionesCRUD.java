package mx.com.sintelti.dao;

import java.util.List;

import mx.com.sintelti.domain.Persistible;
import mx.com.sintelti.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class OperacionesCRUD<T>  {
	private Session session;
	
	
	public final void create(T objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(objeto);
		session.getTransaction().commit();
	}
	
	public final T read(Persistible objeto){
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T objetoNuevo = (T) session.createCriteria(objeto.getClass())
		.add(Restrictions.idEq(objeto.getCodigoProducto()))
		.uniqueResult();
		return objetoNuevo;
		
	}
	
	public final void update(T objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(objeto);
		session.getTransaction().commit();
	}	
	
	public final void delete(T objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete((T)objeto);
		session.getTransaction().commit();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> list(Persistible objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return (List<T>)session.createCriteria(objeto.getClass()).list();		
	}
}
