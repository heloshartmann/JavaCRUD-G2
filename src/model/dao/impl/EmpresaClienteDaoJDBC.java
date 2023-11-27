package model.dao.impl;
import model.dao.EmpresaClienteDao;
import model.dao.entites.EmpresaCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EmpresaClienteDaoJDBC implements EmpresaClienteDao{
    private Connection connection;

    public EmpresaClienteDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(EmpresaCliente empresaCliente) {
        String sql = "INSERT INTO empresa_cliente (nome_fantasia, cnpj, razao_social, atividade, porte, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, empresaCliente.getNomeFantasia());
            ps.setString(2, empresaCliente.getCnpj());
            ps.setString(3, empresaCliente.getRazaoSocial());
            ps.setString(4, empresaCliente.getAtividade());
            ps.setString(5, empresaCliente.getPorte());
            ps.setString(6, empresaCliente.getEmail());
            ps.setString(7, empresaCliente.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(EmpresaCliente empresaCliente) {
        String sql = "UPDATE empresa_cliente SET nome_fantasia = ?, cnpj = ?, razao_social = ?, atividade = ?, porte = ?, email = ?, senha = ? WHERE id_empresa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, empresaCliente.getNomeFantasia());
            ps.setString(2, empresaCliente.getCnpj());
            ps.setString(3, empresaCliente.getRazaoSocial());
            ps.setString(4, empresaCliente.getAtividade());
            ps.setString(5, empresaCliente.getPorte());
            ps.setString(6, empresaCliente.getEmail());
            ps.setString(7, empresaCliente.getSenha());
            ps.setInt(8, empresaCliente.getIdEmpresa());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM empresa_cliente WHERE id_empresa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmpresaCliente findById(int id) {
        String sql = "SELECT * FROM empresa_cliente WHERE id_empresa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new EmpresaCliente(
                        rs.getInt("id_empresa"),
                        rs.getString("nome_fantasia"),
                        rs.getString("cnpj"),
                        rs.getString("razao_social"),
                        rs.getString("atividade"),
                        rs.getString("porte"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<EmpresaCliente> findAll() {
        List<EmpresaCliente> empresasClientes = new ArrayList<>();
        String sql = "SELECT * FROM empresa_cliente";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empresasClientes.add(new EmpresaCliente(
                        rs.getInt("id_empresa"),
                        rs.getString("nome_fantasia"),
                        rs.getString("cnpj"),
                        rs.getString("razao_social"),
                        rs.getString("atividade"),
                        rs.getString("porte"),
                        rs.getString("email"),
                        rs.getString("senha")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empresasClientes;
    }
}
