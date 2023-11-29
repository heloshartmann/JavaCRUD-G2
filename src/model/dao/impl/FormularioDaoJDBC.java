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
        String sql = "INSERT INTO formulario (categoria, conformidade, IDempresa, IDfucionario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, formulario.getCategoria());
            statement.setString(2, formulario.getConformidade());
            statement.setInt(3, formulario.getEmpresa());
            statement.setInt(4, formulario.getFuncionario());
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Formulario formulario) {
        String sql = "UPDATE formulario SET nome = ?, coformidade = ?, id_empresa = ?, id_fucioario = ? WHERE id_formulario = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, formulario.getCategoria());
            statement.setString(2, formulario.getConformidade());
            statement.setInt(3, formulario.getEmpresa());
            statement.setInt(4, formulario.getFuncionario());
            statement.setInt(5,formulario.getIDformulario());
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM formulario WHERE id_formualario = ?";

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
                        resultSet.getString("id_empresa"),
                        resultSet.getInt("id_funcioario")
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
                        resultSet.getString("IDempresa"),
                        Integer.parseInt(resultSet.getString("IDfuncionario"))
                ));
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
        return formulario;
    }
}
