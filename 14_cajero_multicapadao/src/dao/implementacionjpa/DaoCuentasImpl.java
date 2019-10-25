package dao.implementacionjpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Cuenta;
import model.DaoCuentas;

/**
 * Session Bean implementation class DaoCuentasImpl
 */
@Stateless
public class DaoCuentasImpl implements DaoCuentas {
	@PersistenceContext(unitName = "UPcajero")
	EntityManager em;

	@Override
	public Cuenta findCuenta(int numCuenta) {
		return em.find(Cuenta.class,numCuenta);
	}

	@Override
	public List<Cuenta> findAllCuenta() {
		TypedQuery<Cuenta> q = em.createNamedQuery("Cuenta.findAll",Cuenta.class);
		return q.getResultList();  	  	
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		em.merge(cuenta);
	}

}
