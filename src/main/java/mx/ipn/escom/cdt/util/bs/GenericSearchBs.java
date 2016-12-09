package mx.ipn.escom.cdt.util.bs;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.util.dao.GenericDao;

@Service("genericSearchBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class GenericSearchBs {

	@Autowired
	private GenericDao genericDao;
	
	@Transactional(readOnly=true)
	public <T> List<T> findAll(Class<T> clazz){
		return genericDao.findAll(clazz);
	}
	
	@Transactional(readOnly=true)
	public <T> T findById(Class<T> clazz, Serializable id){
		return genericDao.findById(clazz, id);
	}
	
	@Transactional(readOnly=true)
	public <T> List<T> findByExample(T example){
		return genericDao.findByExample(example);
	}
}
