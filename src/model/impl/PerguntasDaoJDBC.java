package model.dao.impl;

import model.dao.perguntasDAO;
import model.dao.entites.perguntas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerguntasDaoJDBC implements PerguntasDao {
    private Connection connection; // A conexão JDBC com o banco de dados

    // Construtor que recebe a conexão
    public PerguntasDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Perguntas perguntas) {
        String sql = "INSERT INTO perguntas (nome, eixo, pergunta, empresa_id, funcionario_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, perguntas.getNome());
            statement.setString(2, perguntas.getEixo());
            statement.setString(3, perguntas.getPergunta());
            statement.setInt(4, perguntas.getEmpresa().getIDEmpresa());
            statement.setInt(5, perguntas.getFuncionario().getIDFuncionario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Perguntas perguntas) {
        String sql = "UPDATE perguntas SET nome = ?, eixo = ?, pergunta = ?, empresa_id = ?, funcionario_id = ? WHERE IDpergunta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, perguntas.getNome());
            statement.setString(2, perguntas.getEixo());
            statement.setString(3, perguntas.getPergunta());
            statement.setInt(4, perguntas.getEmpresa().getIDEmpresa());
            statement.setInt(5, perguntas.getFuncionario().getIDFuncionario());
            statement.setInt(6, perguntas.getIDpergunta());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM perguntas WHERE IDpergunta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Perguntas findById(Integer id) {
        String sql = "SELECT * FROM perguntas WHERE IDpergunta = ?";
        Perguntas perguntas = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                perguntas = new Perguntas(
                        resultSet.getInt("IDpergunta"),
                        resultSet.getString("nome"),
                        resultSet.getString("eixo"),
                        resultSet.getString("pergunta"),
                        /* Recupere a Empresa e o Funcionario, se necessário */
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return perguntas;
    }

    @Override
    public List<Perguntas> findAll() {
        String sql = "SELECT * FROM perguntas";
        List<Perguntas> perguntasList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Perguntas perguntas = new Perguntas(
                        resultSet.getInt("IDpergunta"),
                        resultSet.getString("nome"),
                        resultSet.getString("eixo"),
                        resultSet.getString("pergunta"),
                        /* Recupere a Empresa e o Funcionario, se necessário */
                );
                perguntasList.add(perguntas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return perguntasList;
    }
}