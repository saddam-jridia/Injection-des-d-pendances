package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;

// import dao.DaoImpl;
// import metier.MetierImpl;

public class Presentation {

	public static void main(String[] args) {
//		DaoImpl dao=new DaoImpl();
//		MetierImpl metier = new MetierImpl();
//		metier.setDao(dao);
		
		try {
			Scanner scanner= new Scanner(new File("config.txt"));
			String daoClassName=scanner.next();
			String metierClassName = scanner.next();
			Class cDao=Class.forName(daoClassName);
			Class cMetier=Class.forName(metierClassName);
			IDao dao=(IDao) cDao.newInstance();
			IMetier metier=(IMetier) cMetier.newInstance();
			
			Method m=cMetier.getMethod("setDao", new Class[]{IDao.class});
			m.invoke(metier, new Object[]{dao});
			
;			System.out.println(metier.calcul());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(metier.calcul());

	}

}
