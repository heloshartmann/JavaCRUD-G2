
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
    public Formulario buscarFormularioPorID(int IDforms) throws SQLException {
        String sql = "SELECT * FROM formulario WHERE id_formulario = ?";


        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IDforms);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                formulario = new Formulario(
                    resultSet.getInt("IDforms"),
                    resultSet.getString("nome"),
                    resultSet.getFloat("conformidade"),
                    resultSet.getInt("id_empresa")
                    resultSet.getInt("id_funcioario")
                );
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public void insert(Formulario formulario) {
        String sql = "INSERT INTO formulario (nome, conformidade, id_empresa, id_fucioario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, formulario.getNome());
            statement.setFloat(2, formulario.getConformidade());
            statement.setInt(3, formulario.getIDEmpresa());
            statement.setInt(4, formulario.getIDFuncionario());
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Formulario formulario) {
                String sql = "UPDATE formulario SET nome = ?, coformidade = ?, id_empresa = ?, id_fucioario = ? WHERE id_formulario = ?";
           
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, formulario.getNome());
            statement.setFloat(2, formulario.getConformidade());
            statement.setInt(3, formulario.getIDEmpresa());
            statement.setInt(4, formulario.getIDFuncionario());
            statement.setInt(formulario.getIDforms());
            statement.executeUpdate();
            }catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM formulario WHERE id_formualario = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IDforms);
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public List<Formulario> findAll() {
        List<Formulario> formulario = new ArrayList<>();
        String sql = "SELECT * FROM formulario";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                formulario.add(new Formulario(
                    resultSet.getInt("IDforms"),
                    resultSet.getString("nome"),
                    resultSet.getFloat("conformidade"),
                    resultSet.getInt("id_empresa")
                    resultSet.getInt("id_funcioario")
                ));
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
        return formulario;
    }
}
