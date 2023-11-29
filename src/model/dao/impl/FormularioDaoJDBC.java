package model.dao.impl;
import model.dao.FormularioDao;
import model.dao.entites.Formulario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormularioDaoJDBC implements FormularioDao {
    private Connection connection;

    public FormularioDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Formulario formulario) {
        String sql = "INSERT INTO formulario (categoria, conformidade) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, formulario.getCategoria());
            statement.setString(2, formulario.getConformidade());
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Formulario formulario) {
        String sql = "UPDATE formulario SET categoria = ?, conformidade = ? WHERE IDformulario = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, formulario.getCategoria());
            statement.setString(2, formulario.getConformidade());
            statement.setInt(3,formulario.getIDformulario());
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }

    }


    public void deleteById(int id) {
        String sql = "DELETE FROM formulario WHERE IDformulario = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Formulario findById(int id){
        String sql = "SELECT * FROM formulario WHERE id_formulario = ?";


        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Formulario(
                        resultSet.getInt("IDformulario"),
                        resultSet.getString("categoria"),
                        resultSet.getString("conformidade"),
                        resultSet.getInt("empresa"),
                        resultSet.getInt("funcionario")
                );
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Formulario> findAll() {
        List<Formulario> formulario = new ArrayList<>();
        String sql = "SELECT * FROM formulario";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                formulario.add(new Formulario(
                        resultSet.getInt("IDformulario"),
                        resultSet.getString("categoria"),
                        resultSet.getString("conformidade"),
                        resultSet.getInt("IDformulario"),
                        resultSet.getInt("IDformulario")
                ));
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
        return formulario;
    }
}
