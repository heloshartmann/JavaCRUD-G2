package model.dao;

import db.DB;

public class DaoFactory {

	public static FormularioDao createSellerDao() {
		return new FormularioDaoJDBC(DB.getConnection());
	}
	
	public static FuncionarioDao createDepartmentDao() {
		return new FuncionarioDaoJDBC(DB.getConnection());
	}

	public static Empresa_clienteDao createSellerDao() {
		return new Empresa_clienteDaoJDBC(DB.getConnection());
	}

	public static PerguntaDao createSellerDao() {
		return new PerguntaDaoJDBC(DB.getConnection());
	}
}
