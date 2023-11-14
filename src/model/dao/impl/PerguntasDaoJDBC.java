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
        String sql = "INSERT INTO perguntas (pontuacao,Pergunta,imagem_doc) VALUES (?, ?, ?,)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, perguntas.getImagemDoc());
            statement.setString(2, perguntas.getPontuacao());
            statement.setString(3, perguntas.getPergunta());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Perguntas perguntas) {
        String sql = "UPDATE perguntas SET pontuacao = ?, imagem_doc = ?, Pergunta = ? WHERE IDpergunta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, perguntas.getImagemDoc());
            statement.setString(2, perguntas.getPontuacao());
            statement.setString(3, perguntas.getPergunta());
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
                        resultSet.getString("Pergunta"),
                        resultSet.getString("pontuacao"),
                        resultSet.getString("imagem_doc")
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
                        resultSet.getString("Pergunta"),
                        resultSet.getString("pontuacao"),
                        resultSet.getString("imagem_doc")
                );
                perguntasList.add(perguntas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return perguntasList;
    }
}