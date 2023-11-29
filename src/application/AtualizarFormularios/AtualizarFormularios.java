package application.AtualizarFormularios;

import model.dao.DaoFactory;
import model.dao.FormularioDao;
import model.dao.entites.Formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarFormularios extends JFrame {
    private JPanel TelaAtualizarFormularios;
    private JTextField textFieldID;
    private JButton buscarFormulariosButton;
    private JButton confirmarAlteracoesButton;
    private JTextField textFieldConformidade;
    private JTextField textFieldCategoria;
    private JTextField textFieldEmpresa;
    private JTextField textFieldFuncionario;

    private Formulario formulario;

    public AtualizarFormularios() {
        TelaAtualizarFormularios = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel labelID = new JLabel("ID do Funcionário:");
        textFieldID = new JTextField(20);
        buscarFormulariosButton = new JButton("Buscar Funcionário");
        confirmarAlteracoesButton = new JButton("Confirmar Alterações");

        gbc.gridx = 0;
        gbc.gridy = 0;
        TelaAtualizarFormularios.add(labelID, gbc);
        gbc.gridx = 1;
        TelaAtualizarFormularios.add(textFieldID, gbc);
        gbc.gridx = 2;
        TelaAtualizarFormularios.add(buscarFormulariosButton, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFormularios.add(new JLabel("Conformidade:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        TelaAtualizarFormularios.add(textFieldConformidade = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFormularios.add(new JLabel("Categoria:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFormularios.add(textFieldCategoria = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFormularios.add(new JLabel("Funcionario:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFormularios.add(textFieldFuncionario = new JTextField(20), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        TelaAtualizarFormularios.add(new JLabel("Empresa:"), gbc);
        gbc.gridx = 1;
        TelaAtualizarFormularios.add(textFieldEmpresa = new JTextField(20), gbc);



        gbc.gridy++;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        TelaAtualizarFormularios.add(confirmarAlteracoesButton, gbc);

        getContentPane().add(TelaAtualizarFormularios, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

        buscarFormulariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldID.getText());

                FormularioDao formularioDao = DaoFactory.createFormularioDao();
                formulario = formularioDao.findById(id);

                if (formulario != null) {
                    textFieldConformidade.setText(formulario.getConformidade());
                    textFieldCategoria.setText(formulario.getCategoria());
                } else {
                    JOptionPane.showMessageDialog(AtualizarFormularios.this, "Funcionário não encontrado!");
                }
            }
        });

        confirmarAlteracoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formulario != null) {
                    formulario.setConformidade(textFieldConformidade.getText());
                    formulario.setCategoria(textFieldCategoria.getText());

                    FormularioDao formularioDao = DaoFactory.createFormularioDao();
                    formularioDao.update(formulario);

                    JOptionPane.showMessageDialog(AtualizarFormularios.this, "Informações atualizadas com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(AtualizarFormularios.this, "Formulário não encontrado!");
                }
            }
        });
    }

    public static void main(String[] args) {
        AtualizarFormularios atualizarFormularios = new AtualizarFormularios();
        atualizarFormularios.setVisible(true);
    }
}
