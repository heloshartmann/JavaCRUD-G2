package model.dao;

import db.DB;
import model.dao.impl.FormularioDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;

public class DaoFactory {

	public static FormularioDao createFormularioDao() {
		return new FormularioDaoJDBC(DB.getConnection());
	}

	public static FuncionarioDao createFuncionarioDao(){
		return new FuncionarioDaoJDBC(DB.getConnection());
	}
}
