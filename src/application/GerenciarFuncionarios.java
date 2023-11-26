package application;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.dao.entites.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GerenciarFuncionarios extends JFrame {
    private JButton cadastrarFuncionarioButton;
    private JButton excluirFuncionarioButton;
    private JButton listarTodosOsFuncionariosButton;
    private JPanel TelaGerenciarFuncionario;
    private JButton atualizarFuncionarioButton;
    private JTextArea displayFuncionarios;
    private FuncionarioDao funcionarioDao;

    public GerenciarFuncionarios() {
        funcionarioDao = DaoFactory.createFuncionarioDao();

        TelaGerenciarFuncionario = new JPanel();
        cadastrarFuncionarioButton = new JButton("Cadastrar Funcionario");
        atualizarFuncionarioButton = new JButton("Atualizar Funcionario");
        listarTodosOsFuncionariosButton = new JButton("Listar todos os Funcionarios");
        excluirFuncionarioButton = new JButton("Excluir Funcionario");


        displayFuncionarios = new JTextArea(30, 70);
        displayFuncionarios.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayFuncionarios);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        cadastrarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarFuncionarios cadastrarFuncionarios = new CadastrarFuncionarios();
                cadastrarFuncionarios.setVisible(true);
            }
        });

        atualizarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtualizarFuncionarios atualizarFuncionarios = new AtualizarFuncionarios();
                atualizarFuncionarios.setVisible(true);
            }
        });

        listarTodosOsFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarExibicaoFuncionarios();
            }
        });

        excluirFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExcluirFuncionarios excluirFuncionarios = new ExcluirFuncionarios();
                excluirFuncionarios.setVisible(true);
            }
        });


        TelaGerenciarFuncionario.add(cadastrarFuncionarioButton);
        TelaGerenciarFuncionario.add(atualizarFuncionarioButton);
        TelaGerenciarFuncionario.add(listarTodosOsFuncionariosButton);
        TelaGerenciarFuncionario.add(excluirFuncionarioButton);
        TelaGerenciarFuncionario.add(scrollPane);

        add(TelaGerenciarFuncionario);

    }


    private void atualizarExibicaoFuncionarios() {
        List<Funcionario> funcionarios = funcionarioDao.findAll();

        displayFuncionarios.setText("");

        if (funcionarios != null) {
            for (Funcionario funcionario : funcionarios) {
                displayFuncionarios.append("ID: " + funcionario.getIDfuncionario() + "  ");
                displayFuncionarios.append("Nome: " + funcionario.getNome() + "  ");
                displayFuncionarios.append("CPF: " + funcionario.getCpf() + "  ");
                displayFuncionarios.append("Cargo: " + funcionario.getCargo() + "  ");
                displayFuncionarios.append("Cidade: " + funcionario.getCidade() + "  ");
                displayFuncionarios.append("Estado: " + funcionario.getEstado() + "  ");
                displayFuncionarios.append("Email: " + funcionario.getEmail() + "  ");
                displayFuncionarios.append("Telefone: " + funcionario.getTelefone() + "  ");
                displayFuncionarios.append("Senha: " + funcionario.getSenha() + "\n\n");
                displayFuncionarios.append("\n");
            }
        }
    }

    public static void main(String[] args) {
        GerenciarFuncionarios segundaTela = new GerenciarFuncionarios();
        segundaTela.setVisible(true);
    }
}

