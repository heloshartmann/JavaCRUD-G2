
package model.dao.impl;
import model.dao.FormularioDao;
import model.dao.entites.Formulario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FormularioDaoJDBC implements FormularioDao {
    private Connection connection; // A conexão JDBC com o banco de dados

    // Construtor que recebe a conexão
    public FormularioDaoJDBC(Connection connection) {
        this.connection = connection;
    }



    // Método para buscar um Formulario pelo ID
    public Formulario buscarFormularioPorID(int IDforms) throws SQLException {
        String sql = "SELECT * FROM formulario WHERE IDforms = ?";
        Formulario formulario = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IDforms);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                formulario = new Formulario(
                    resultSet.getInt("IDforms"),
                    resultSet.getString("nome"),
                    resultSet.getFloat("conformidade"),
                    /* Recupere a Empresa e o Funcionario, se necessário */
                );
            }
        }

        return formulario;
    }

    @Override
    public void insert(Formulario formulario) {
        String sql = "INSERT INTO formulario (nome, conformidade, empresa_id, funcionario_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, formulario.getNome());
            statement.setFloat(2, formulario.getConformidade());
            statement.setInt(3, formulario.getEmpresa().getIDEmpresa());
            statement.setInt(4, formulario.getFuncionario().getIDFuncionario());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Formulario formulario) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Formulario findById(Integer id) {
        return null;
    }

    @Override
    public List<Formulario> findAll() {
        return null;
    }

    // Outros métodos, como atualizar e excluir, podem ser adicionados de maneira semelhante.
}
