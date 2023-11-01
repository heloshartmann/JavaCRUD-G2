import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FormularioDAOJDBC {
    private Connection connection; // A conexão JDBC com o banco de dados

    // Construtor que recebe a conexão
    public FormularioDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um novo Formulario no banco de dados
    public void inserirFormulario(Formulario formulario) throws SQLException {
        String sql = "INSERT INTO formulario (nome, conformidade, empresa_id, funcionario_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, formulario.getNome());
            statement.setFloat(2, formulario.getConformidade());
            statement.setInt(3, formulario.getEmpresa().getIDEmpresa());
            statement.setInt(4, formulario.getFuncionario().getIDFuncionario());
            statement.executeUpdate();
        }
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

    // Outros métodos, como atualizar e excluir, podem ser adicionados de maneira semelhante.
}
