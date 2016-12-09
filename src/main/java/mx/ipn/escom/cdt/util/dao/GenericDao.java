package mx.ipn.escom.cdt.util.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.util.model.Model;

@Service("genericDao")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
//@Repository(value=BeanDefinition.SCOPE_SINGLETON)
public class GenericDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz){
		sessionFactory.getCurrentSession().clear();
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Class<T> clazz, Serializable id){
		sessionFactory.getCurrentSession().clear();
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public <T> List<T> findByExample(T example){
		sessionFactory.getCurrentSession().clear();
		return (List<T>)sessionFactory.getCurrentSession().createCriteria(example.getClass()).add(Example.create(example)).list();
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public <T extends Model> T save(T entity){
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public <T> T update(T entity){
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public <T> void delete(T entity){
		sessionFactory.getCurrentSession().delete(entity);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
