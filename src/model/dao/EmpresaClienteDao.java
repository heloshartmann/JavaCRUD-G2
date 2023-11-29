package model.dao;

import java.util.List;

import model.dao.entites.EmpresaCliente;

public interface EmpresaClienteDao {

    void insert(EmpresaCliente empresaCliente);
    void update(EmpresaCliente empresaCliente);
    void deleteById(int id);
    EmpresaCliente findById(int id);
    List<EmpresaCliente> findAll();
}
