package mx.ipn.escom.cdt.util.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.util.dao.GenericDao;
import mx.ipn.escom.cdt.util.model.Model;

@Service("genericBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class GenericBs <T extends Model>{
	@Autowired
	/**
	 * Singleton proxy 
	 */
	private GenericDao genericDao;
	
	@Transactional(rollbackFor = Exception.class)
	public T save(T entity){
		return genericDao.save(entity);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public T update(T entity){
		return genericDao.update(entity);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(T entity){
		genericDao.delete(entity);
	}	

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
}