package model.dao.impl;
import model.dao.FuncionarioDao;
import model.dao.entites.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDaoJDBC implements FuncionarioDao {
    private Connection conexao;


    public FuncionarioDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cpf, telefone, cidade, estado, cargo, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getTelefone());
            ps.setString(4, funcionario.getCidade());
            ps.setString(5, funcionario.getEstado());
            ps.setString(6, funcionario.getCargo());
            ps.setString(7, funcionario.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome = ?, cpf = ?, telefone = ?, cidade = ?, estado = ?, cargo = ?, senha = ? WHERE id_funcionario = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getTelefone());
            ps.setString(4, funcionario.getCidade());
            ps.setString(5, funcionario.getEstado());
            ps.setString(6, funcionario.getCargo());
            ps.setString(7, funcionario.getSenha());
            ps.setInt(8, funcionario.getId_funcionario());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                    rs.getInt("id_funcionario"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cargo"),
                    rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funcionarios.add(new Funcionario(
                    rs.getInt("id_funcionario"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cargo"),
                    rs.getString("senha")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return funcionarios;
    }
}
