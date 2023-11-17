package application;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.dao.entites.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CadastrarFuncionarios extends JFrame {
    private JPanel TelaCadastrarFuncionario;
    private JTextField textFieldNome;
    private JTextField textFieldCpf;
    private JTextField textFieldCargo;
    private JTextField textFieldCidade;
    private JTextField textFieldEstado;
    private JTextField textFieldEmail;
    private JTextField textFieldTelefone;
    private JTextField textFieldSenha;
    private JButton cadastrarFuncionarioButton;

    public CadastrarFuncionarios() {
        TelaCadastrarFuncionario = new JPanel();
        TelaCadastrarFuncionario.setLayout(new GridLayout(9, 2));

        JLabel labelNome = new JLabel("Nome:");
        textFieldNome = new JTextField(20);
        TelaCadastrarFuncionario.add(labelNome);
        TelaCadastrarFuncionario.add(textFieldNome);

        JLabel labelCpf = new JLabel("CPF:");
        textFieldCpf = new JTextField(20);
        TelaCadastrarFuncionario.add(labelCpf);
        TelaCadastrarFuncionario.add(textFieldCpf);

        JLabel labelCargo = new JLabel("Cargo:");
        textFieldCargo = new JTextField(20);
        TelaCadastrarFuncionario.add(labelCargo);
        TelaCadastrarFuncionario.add(textFieldCargo);

        JLabel labelCidade = new JLabel("Cidade:");
        textFieldCidade = new JTextField(20);
        TelaCadastrarFuncionario.add(labelCidade);
        TelaCadastrarFuncionario.add(textFieldCidade);

        JLabel labelEstado = new JLabel("Estado:");
        textFieldEstado = new JTextField(20);
        TelaCadastrarFuncionario.add(labelEstado);
        TelaCadastrarFuncionario.add(textFieldEstado);

        JLabel labelEmail = new JLabel("Email:");
        textFieldEmail = new JTextField(20);
        TelaCadastrarFuncionario.add(labelEmail);
        TelaCadastrarFuncionario.add(textFieldEmail);

        JLabel labelTelefone = new JLabel("Telefone:");
        textFieldTelefone = new JTextField(20);
        TelaCadastrarFuncionario.add(labelTelefone);
        TelaCadastrarFuncionario.add(textFieldTelefone);

        JLabel labelSenha = new JLabel("Senha:");
        textFieldSenha = new JTextField(20);
        TelaCadastrarFuncionario.add(labelSenha);
        TelaCadastrarFuncionario.add(textFieldSenha);

        cadastrarFuncionarioButton = new JButton("Cadastrar Funcionário");



        setTitle("Cadastro de Funcionários");
        getContentPane().add(TelaCadastrarFuncionario, BorderLayout.CENTER);
        getContentPane().add(cadastrarFuncionarioButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        cadastrarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                String cpf = textFieldCpf.getText();
                String cargo = textFieldCargo.getText();
                String cidade = textFieldCidade.getText();
                String estado = textFieldEstado.getText();
                String email = textFieldEmail.getText();
                String telefone = textFieldTelefone.getText();
                String senha = textFieldSenha.getText();

                Funcionario novoFuncionario = new Funcionario();
                novoFuncionario.setNome(nome);
                novoFuncionario.setCpf(cpf);
                novoFuncionario.setCargo(cargo);
                novoFuncionario.setCidade(cidade);
                novoFuncionario.setEstado(estado);
                novoFuncionario.setEmail(email);
                novoFuncionario.setTelefone(telefone);
                novoFuncionario.setSenha(senha);

                FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();
                funcionarioDao.insert(novoFuncionario);

                JOptionPane.showMessageDialog(CadastrarFuncionarios.this, "Funcionário cadastrado com sucesso!");
            }
        });
    }



    public static void main(String[] args) {
        CadastrarFuncionarios cadastro = new CadastrarFuncionarios();
        cadastro.setVisible(true);
    }
}
