package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarFormularios extends JFrame {

    private JPanel TelaGerenciarFormulario;
    private JButton cadastrarFormularioButton;
    private JButton excluirFormularioButton;
    private JButton listarTodosOsFormulariosButton;

    public GerenciarFormularios() {
        TelaGerenciarFormulario = new JPanel();
        cadastrarFormularioButton = new JButton("Cadastrar Formulario");
        excluirFormularioButton = new JButton("Excluir Formulario");
        listarTodosOsFormulariosButton = new JButton("Listar todos os Formularios");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        cadastrarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarFormularios cadastrarFormularios = new CadastrarFormularios();
                cadastrarFormularios.setVisible(true);
            }
        });

        TelaGerenciarFormulario.add(cadastrarFormularioButton);
        TelaGerenciarFormulario.add(excluirFormularioButton);
        TelaGerenciarFormulario.add(listarTodosOsFormulariosButton);

        add(TelaGerenciarFormulario);
    }

    public static void main(String[] args) {
        // Criando uma instância da SegundaTela para testar
        GerenciarFormularios segundaTela = new GerenciarFormularios();
        segundaTela.setVisible(true);
    }
}
