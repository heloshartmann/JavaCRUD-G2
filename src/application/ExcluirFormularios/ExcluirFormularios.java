package application.ExcluirFormularios;

import db.DB;
import model.dao.DaoFactory;
import model.dao.FormularioDao;
import model.dao.impl.FormularioDaoJDBC;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExcluirFormularios extends JFrame {
    private JPanel TelaExcluirFormularios;
    private JTextField textFieldId;
    private JButton excluirButton;


    public ExcluirFormularios() {
        setLayout(new BorderLayout());
        FormularioDao formulariosDao = DaoFactory.createFormularioDao();


        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTitulo = new JLabel("Excluir Formularios pelo ID");
        painelTitulo.add(labelTitulo);

        JPanel painelFormulario = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTexto = new JLabel("Digite o ID do Formulario:");
        textFieldId = new JTextField(20);
        painelFormulario.add(labelTexto);
        painelFormulario.add(textFieldId);

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        excluirButton = new JButton("Excluir");
        painelBotao.add(excluirButton);

        TelaExcluirFormularios = new JPanel(new GridLayout(3, 1));
        TelaExcluirFormularios.add(painelTitulo);
        TelaExcluirFormularios.add(painelFormulario);
        TelaExcluirFormularios.add(painelBotao);


        setTitle("Excluir Funcionário");
        getContentPane().add(TelaExcluirFormularios, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = textFieldId.getText();
                int id = Integer.parseInt(idText);

                formulariosDao.deleteById(id);
                JOptionPane.showMessageDialog(null, "Formulário excluído com sucesso!");
                textFieldId.setText("");

            }
        });
    }

    public static void main(String[] args) {
        ExcluirFormularios excluirFormularios = new ExcluirFormularios();
        excluirFormularios.setVisible(true);
    }
}

