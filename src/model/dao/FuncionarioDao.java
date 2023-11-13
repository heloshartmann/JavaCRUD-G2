package model.dao;

import java.util.List;

import model.dao.entites.Funcionario;

public interface FuncionarioDao {
    void insert(Funcionario funcionario);
    void update(Funcionario funcionario);
    void deleteById(int id);
    Funcionario findById(int id);
    List<Funcionario> findAll();
}
