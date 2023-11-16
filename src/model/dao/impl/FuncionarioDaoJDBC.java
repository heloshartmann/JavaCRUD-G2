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
    private Connection connection;


    public FuncionarioDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cpf, cargo, cidade, estado, email, telefone, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getCargo());
            ps.setString(4, funcionario.getCidade());
            ps.setString(5, funcionario.getEstado());
            ps.setString(6, funcionario.getEmail());
            ps.setString(7, funcionario.getTelefone());
            ps.setString(8, funcionario.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, cargo = ?, cidade = ?, estado = ?, email = ?, telefone = ?, senha = ? WHERE id_funcionario = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getCargo());
            ps.setString(4, funcionario.getCidade());
            ps.setString(5, funcionario.getEstado());
            ps.setString(6, funcionario.getEmail());
            ps.setString(7, funcionario.getTelefone());
            ps.setString(8, funcionario.getSenha());
            ps.setInt(9, funcionario.getIDfuncionario());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario findById(int id) {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                    rs.getInt("IDfuncionario"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("cargo"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> funcionario = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funcionario.add(new Funcionario(
                    rs.getInt("IDfuncionario"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("cargo"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("senha")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }
}
