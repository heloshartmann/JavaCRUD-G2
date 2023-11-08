package model.dao;

import db.DB;
import model.dao.impl.FormularioDaoJDBC;

public class DaoFactory {

	public static FormularioDao createSellerDao() {
		return new FormularioDaoJDBC(DB.getConnection());
	}
	
	public static FuncionarioDao createDepartmentDao() {
		return new FuncionarioDaoJDBC(DB.getConnection());
	}
}
