package model.dao;

import java.util.List;

import model.dao.entites.Funcionario;

public interface FuncionarioDao {
    void inserir(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    void excluir(int id);
    Funcionario buscarPorId(int id);
    List<Funcionario> listarTodos();
}
