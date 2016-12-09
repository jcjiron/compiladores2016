package mx.ipn.escom.cdt.capacitacion.informacionbase.bs;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Cuenta;
import mx.ipn.escom.cdt.util.bs.GenericBs;

@Service("cuentaBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class CuentaBs extends GenericBs<Cuenta>{
	
}
