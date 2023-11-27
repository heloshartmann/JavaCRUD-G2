package model.dao.impl;

import model.dao.PerguntasDao;
import model.dao.entites.Perguntas;

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
        String sql = "INSERT INTO perguntas (pergunta, pontuacao, imagemDoc) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, perguntas.getPergunta());
            statement.setString(2, perguntas.getPontuacao());
            statement.setString(3, perguntas.getImagemDoc());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Perguntas perguntas) {
        String sql = "UPDATE perguntas SET pergunta = ?, pontuacao = ?, imagemDoc = ? WHERE IDpergunta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, perguntas.getPergunta());
            statement.setString(2, perguntas.getPontuacao());
            statement.setString(3, perguntas.getImagemDoc());
            statement.setInt(4,perguntas.getIDpergunta());
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
                        resultSet.getString("pergunta"),
                        resultSet.getString("pontuacao"),
                        resultSet.getString("imagemDoc")
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
                        resultSet.getString("pergunta"),
                        resultSet.getString("pontuacao"),
                        resultSet.getString("imagemDoc")
                );
                perguntasList.add(perguntas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return perguntasList;
    }
}