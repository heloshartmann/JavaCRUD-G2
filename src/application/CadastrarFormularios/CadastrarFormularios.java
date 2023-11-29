package application.CadastrarFormularios;

import model.dao.DaoFactory;
import model.dao.FormularioDao;
import model.dao.entites.Formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarFormularios extends JFrame {
    private JPanel TelaCadastrarFormularios;
    private JTextField textFieldConformidade;
    private JTextField textFieldCategoria;
    private JTextField textFieldIdEmpresa;
    private JTextField textFieldIdFuncionario;
    private JButton CadastrarFormulariosButton;
    private JLabel Cadastrar;

    public CadastrarFormularios() {
        TelaCadastrarFormularios = new JPanel();
        TelaCadastrarFormularios.setLayout(new GridLayout(9, 2));

        JLabel labelCategoria = new JLabel("Categoria:");
        textFieldCategoria = new JTextField(20);
        TelaCadastrarFormularios.add(labelCategoria);
        TelaCadastrarFormularios.add(textFieldCategoria);


        JLabel labelIdEmpresa = new JLabel("ID da Empresa:");
        textFieldIdEmpresa = new JTextField(20);
        TelaCadastrarFormularios.add(labelIdEmpresa);
        TelaCadastrarFormularios.add(textFieldIdEmpresa);

        JLabel labelIdFuncionario = new JLabel("ID do Funcionário:");
        textFieldIdFuncionario = new JTextField(20);
        TelaCadastrarFormularios.add(labelIdFuncionario);
        TelaCadastrarFormularios.add(textFieldIdFuncionario);




        CadastrarFormulariosButton = new JButton("Cadastrar Formulário");



        setTitle("Cadastro de Formularios");
        getContentPane().add(TelaCadastrarFormularios, BorderLayout.CENTER);
        getContentPane().add(CadastrarFormulariosButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        CadastrarFormulariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conformidade = textFieldConformidade.getText();
                String categoria = textFieldCategoria.getText();
                String idEmpresa = textFieldIdEmpresa.getText();
                int idFuncionario = Integer.parseInt(textFieldIdFuncionario.getText());

                //EmpresaCliente empresa = new EmpresaCliente();
               // Funcionario funcionario = new Funcionario();


                Formulario novoFormulario = new Formulario(0, conformidade, categoria);


                FormularioDao formularioDao = DaoFactory.createFormularioDao();
                formularioDao.insert(novoFormulario);

                JOptionPane.showMessageDialog(CadastrarFormularios.this, "Formulário cadastrado com sucesso!");
            }
        });
    }



    public static void main(String[] args) {
        CadastrarFormularios cadastro = new CadastrarFormularios();
        cadastro.setVisible(true);
    }
}
