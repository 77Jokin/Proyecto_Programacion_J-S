package modelo.dao;

import modelo.entidades.Factura;

public class FacturaDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements FacturaDao {

	@Override
	public int altaFactura(Factura factura) {
		try {
			tx.begin();
				em.persist(factura);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Factura findById(String idFactura) {
		return em.find(Factura.class, idFactura);
	}

	

}
