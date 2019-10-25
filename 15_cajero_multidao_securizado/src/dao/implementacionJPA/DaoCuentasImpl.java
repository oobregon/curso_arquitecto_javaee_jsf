package dao.implementacionJPA;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dao.interfaces.DaoCuentas;
import model.Cuenta;

/**
 * Session Bean implementation class DaoCuentasImpl
 */
@Stateless
public class DaoCuentasImpl implements DaoCuentas {
	@PersistenceContext(unitName = "UPcajero")
	EntityManager em;
	@Override
	public Cuenta findCuenta(int numeroCuenta) {
		return em.find(Cuenta.class, numeroCuenta);
	}

	@Override
	public List<Cuenta> findAllCuenta() {
		TypedQuery<Cuenta> tquery=em.createNamedQuery("Cuenta.findAll",Cuenta.class);
		return tquery.getResultList();
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		em.merge(cuenta);		
	}

   

}
