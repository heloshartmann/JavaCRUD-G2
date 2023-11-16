package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JButton gerenciarFormulariosButton;
    private JPanel TelaPrincipal;
    private JButton gerenciarFuncionariosButton;

    public App() {

        TelaPrincipal = new JPanel();

        gerenciarFormulariosButton = new JButton("Gerenciar Formularios");
        gerenciarFuncionariosButton = new JButton("Gerenciar Funcionarios");

        gerenciarFormulariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciarFormularios gerenciarFormulario = new GerenciarFormularios();
                gerenciarFormulario.setVisible(true);
            }
        });

        TelaPrincipal.add(gerenciarFormulariosButton);
        TelaPrincipal.add(gerenciarFuncionariosButton);


        add(TelaPrincipal);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        gerenciarFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciarFuncionarios gerenciarFuncionarios = new GerenciarFuncionarios();
                gerenciarFuncionarios.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}
