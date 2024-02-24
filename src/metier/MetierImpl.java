package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
	private IDao dao;
	@Override
	public double calcul() {
		double t= dao.getTemperature()  ;
		return t*7;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	
}
