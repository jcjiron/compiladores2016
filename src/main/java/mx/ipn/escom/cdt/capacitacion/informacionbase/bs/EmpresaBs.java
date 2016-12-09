package mx.ipn.escom.cdt.capacitacion.informacionbase.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Cuenta;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Empresa;
import mx.ipn.escom.cdt.util.bs.GenericBs;

@Service("empresaBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class EmpresaBs extends GenericBs<Empresa>{
	
	@Autowired
	private CuentaBs cuentaBs;
	
	@Transactional(rollbackFor = Exception.class)
	public synchronized void guardar(Empresa empresa, Cuenta cuenta){
		System.err.println(empresa);
		System.out.println(cuenta);
		cuentaBs.save(cuenta);
		empresa.setIdCuenta(cuenta.getIdCuenta());
		save(empresa);
	}
}
