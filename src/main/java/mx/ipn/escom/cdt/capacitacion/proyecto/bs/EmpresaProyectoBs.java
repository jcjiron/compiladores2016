package mx.ipn.escom.cdt.capacitacion.proyecto.bs;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.cdt.capacitacion.proyecto.model.EmpresaProyecto;
import mx.ipn.escom.cdt.util.bs.GenericBs;

@Service("empresaProyectoBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class EmpresaProyectoBs extends GenericBs<EmpresaProyecto>{

}
