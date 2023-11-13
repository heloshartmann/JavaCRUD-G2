package model.dao;

import java.util.List;

import model.dao.entites.EmpresaCliente;

public interface EmpresaClienteDao {
    // Operações CRUD (Create, Read, Update, Delete)

    // Cria uma nova empresa cliente
    void criarEmpresaCliente(EmpresaCliente empresaCliente);

    // Obtém uma empresa cliente pelo ID
    EmpresaCliente obterEmpresaClientePorId(int id);

    // Obtém todas as empresas clientes
    List<EmpresaCliente> obterTodasEmpresasClientes();

    // Atualiza uma empresa cliente
    void atualizarEmpresaCliente(EmpresaCliente empresaCliente);

    // Exclui uma empresa cliente pelo ID
    void excluirEmpresaCliente(int id);
}
