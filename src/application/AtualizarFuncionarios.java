package application;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.dao.entites.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarFuncionarios extends JFrame {
    private JPanel TelaAtualizarFuncionario;
    private JTextField textFieldID;
    private JButton buscarFuncionarioButton;
    private JButton confirmarAlteracoesButton;
    private JTextField textFieldNome;
    private JTextField textFieldCpf;
    private JTextField textFieldCargo;
    private JTextField textFieldCidade;
    private JTextField textFieldEstado;
    private JTextField textFieldEmail;
    private JTextField textFieldTelefone;
    private JTextField textFieldSenha;
    private Funcionario funcionario;

    public AtualizarFuncionarios() {
        TelaAtualizarFuncionario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel labelID = new JLabel("ID do Funcionário:");
        textFieldID = new JTextField(20);
        buscarFuncionarioButton = new JButton("Buscar Funcionário");
        confirmarAlteracoesButton = new JButton("Confirmar Alterações");

        gbc.gridx = 0;
        gbc.gridy = 0;
        TelaAtualizarFuncionario.add(labelID, gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldID, gbc);
        gbc.gridx = 2;
        TelaAtualizarFuncionario.add(buscarFuncionarioButton, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        TelaAtualizarFuncionario.add(textFieldNome = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("CPF:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldCpf = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("Cargo:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldCargo = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("Cidade:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldCidade = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("Estado:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldEstado = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldEmail = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldTelefone = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFuncionario.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFuncionario.add(textFieldSenha = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        TelaAtualizarFuncionario.add(confirmarAlteracoesButton, gbc);

        getContentPane().add(TelaAtualizarFuncionario, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

        buscarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldID.getText());

                FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();
                funcionario = funcionarioDao.findById(id);

                if (funcionario != null) {
                    textFieldNome.setText(funcionario.getNome());
                    textFieldCpf.setText(funcionario.getCpf());
                    textFieldCargo.setText(funcionario.getCargo());
                    textFieldCidade.setText(funcionario.getCidade());
                    textFieldEstado.setText(funcionario.getEstado());
                    textFieldEmail.setText(funcionario.getEmail());
                    textFieldTelefone.setText(funcionario.getTelefone());
                    textFieldSenha.setText(funcionario.getSenha());
                } else {
                    JOptionPane.showMessageDialog(AtualizarFuncionarios.this, "Funcionário não encontrado!");
                }
            }
        });

        confirmarAlteracoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (funcionario != null) {
                    funcionario.setNome(textFieldNome.getText());
                    funcionario.setCpf(textFieldCpf.getText());
                    funcionario.setCargo(textFieldCargo.getText());
                    funcionario.setCidade(textFieldCidade.getText());
                    funcionario.setEstado(textFieldEstado.getText());
                    funcionario.setEmail(textFieldEmail.getText());
                    funcionario.setTelefone(textFieldTelefone.getText());
                    funcionario.setSenha(textFieldSenha.getText());

                    FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();
                    funcionarioDao.update(funcionario);

                    JOptionPane.showMessageDialog(AtualizarFuncionarios.this, "Informações atualizadas com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(AtualizarFuncionarios.this, "Funcionário não encontrado!");
                }
            }
        });
    }

    public static void main(String[] args) {
        AtualizarFuncionarios atualizarFuncionarios = new AtualizarFuncionarios();
        atualizarFuncionarios.setVisible(true);
    }
}
