package model.dao;

import db.DB;
import model.dao.impl.EmpresaClienteDaoJDBC;
import model.dao.impl.FormularioDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;
import model.dao.impl.PerguntasDaoJDBC;

public class DaoFactory {

	public static FormularioDao createFormularioDao() {
		return new FormularioDaoJDBC(DB.getConnection());
	}
	public static FuncionarioDao createFuncionarioDao(){
		return new FuncionarioDaoJDBC(DB.getConnection());
	}
	public static EmpresaClienteDao createEmpresaClienteDao(){
		return new EmpresaClienteDaoJDBC(DB.getConnection());
	}
	public static PerguntasDao createPerguntasDao(){
		return new PerguntasDaoJDBC(DB.getConnection());
	}
}
