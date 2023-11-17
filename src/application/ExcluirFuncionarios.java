package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.dao.impl.FuncionarioDaoJDBC;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExcluirFuncionarios extends JFrame {
    private JPanel TelaExcluirFuncionario;
    private JTextField textFieldId;
    private JButton excluirButton;


    public ExcluirFuncionarios() {
        setLayout(new BorderLayout());
        FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();


        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTitulo = new JLabel("Excluir Funcionário pelo ID");
        painelTitulo.add(labelTitulo);

        JPanel painelFormulario = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTexto = new JLabel("Digite o ID do Funcionário:");
        textFieldId = new JTextField(20);
        painelFormulario.add(labelTexto);
        painelFormulario.add(textFieldId);

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        excluirButton = new JButton("Excluir");
        painelBotao.add(excluirButton);

        TelaExcluirFuncionario = new JPanel(new GridLayout(3, 1));
        TelaExcluirFuncionario.add(painelTitulo);
        TelaExcluirFuncionario.add(painelFormulario);
        TelaExcluirFuncionario.add(painelBotao);


        setTitle("Excluir Funcionário");
        getContentPane().add(TelaExcluirFuncionario, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = textFieldId.getText();
                int id = Integer.parseInt(idText);

                funcionarioDao.deleteById(id);
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
                textFieldId.setText("");

            }
        });
    }

    public static void main(String[] args) {
        ExcluirFuncionarios excluirFuncionarios = new ExcluirFuncionarios();
        excluirFuncionarios.setVisible(true);
    }
}

