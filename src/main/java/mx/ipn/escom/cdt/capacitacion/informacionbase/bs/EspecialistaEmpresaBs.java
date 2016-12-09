package mx.ipn.escom.cdt.capacitacion.informacionbase.bs;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Empresa;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.EspecialistaEmpresa;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.EspecialistaEmpresaId;
import mx.ipn.escom.cdt.util.bs.GenericBs;

@Service("especialistaEmpresaBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class EspecialistaEmpresaBs extends GenericBs<EspecialistaEmpresa>{
	
	@Transactional(rollbackFor = Exception.class)
	public synchronized void guardar(Empresa empresa, Integer idEspecialista){
		EspecialistaEmpresaId especialistaEmpresaId = new EspecialistaEmpresaId();
		especialistaEmpresaId.setIdEmpresa(empresa.getIdEmpresa());
		especialistaEmpresaId.setIdPersona(idEspecialista);
		
		EspecialistaEmpresa especialistaEmpresa = new EspecialistaEmpresa();
		especialistaEmpresa.setId(especialistaEmpresaId);
		save(especialistaEmpresa);
	}
}
