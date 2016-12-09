package mx.ipn.escom.cdt.capacitacion.proyecto.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.cdt.capacitacion.proyecto.model.EmpresaProyecto;
import mx.ipn.escom.cdt.capacitacion.proyecto.model.EmpresaProyectoId;
import mx.ipn.escom.cdt.capacitacion.proyecto.model.Proyecto;
import mx.ipn.escom.cdt.util.bs.GenericBs;

@Service("proyectoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ProyectoBs extends GenericBs<Proyecto> {
	@Autowired
	private EmpresaProyectoBs empresaProyectoBs;

	@Transactional(rollbackFor = Exception.class)
	public synchronized void guardar(EmpresaProyecto empresaProyecto, Proyecto proyecto) {
		EmpresaProyectoId empresaProyectoId = new EmpresaProyectoId();
		save(proyecto);
		empresaProyectoId.setIdEmpresa(empresaProyecto.getIdEmpresa());
		empresaProyectoId.setIdProyecto(proyecto.getIdProyecto());
		empresaProyecto.setEmpresaProyectoId(empresaProyectoId);
		empresaProyecto.setIdProyecto(proyecto.getIdProyecto());
		System.err.println(empresaProyecto);
		empresaProyectoBs.save(empresaProyecto);
	}
}
