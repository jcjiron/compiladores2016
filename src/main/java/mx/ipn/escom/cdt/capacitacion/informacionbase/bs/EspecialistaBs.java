package mx.ipn.escom.cdt.capacitacion.informacionbase.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Cuenta;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Especialista;
import mx.ipn.escom.cdt.util.bs.GenericBs;

@Service("especialistaBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class EspecialistaBs extends GenericBs<Especialista> {
	
	@Autowired
	private CuentaBs cuentaBs;
	
	@Transactional(rollbackFor = Exception.class)
	public synchronized void guardar(Especialista especialista, Cuenta cuenta){
		System.out.println(cuenta);
		cuentaBs.save(cuenta);
		System.err.println(especialista);
		especialista.setIdCuenta(cuenta.getIdCuenta());
		save(especialista);
	}
}
