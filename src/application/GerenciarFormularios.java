package application;

import model.dao.DaoFactory;
import model.dao.FormularioDao;
import model.dao.entites.Formulario;
import model.dao.entites.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GerenciarFormularios extends JFrame {

    private JPanel TelaGerenciarFormulario;
    private JButton cadastrarFormularioButton;
    private JButton excluirFormularioButton;
    private JButton listarTodosOsFormulariosButton;
    private JButton atualizarFormulariosButton;

    private JTextArea displayFormulario;
    private FormularioDao formularioDao;

    public GerenciarFormularios() {
        formularioDao = DaoFactory.createFormularioDao();

        TelaGerenciarFormulario = new JPanel();
        cadastrarFormularioButton = new JButton("Cadastrar Formulario");
        excluirFormularioButton = new JButton("Excluir Formulario");
        atualizarFormulariosButton = new JButton("Atualizar Funcionario");
        listarTodosOsFormulariosButton = new JButton("Listar todos os Formularios");

        displayFormulario = new JTextArea(30, 70);
        displayFormulario.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayFormulario);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);


        cadastrarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarFormularios cadastrarFormularios = new CadastrarFormularios();
                cadastrarFormularios.setVisible(true);
            }
        });
        excluirFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExcluirFormularios excluirFormularios = new ExcluirFormularios();
                excluirFormularios.setVisible(true);
            }
        });
        listarTodosOsFormulariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarExibicaoFormularios();
            }
        });

        TelaGerenciarFormulario.add(cadastrarFormularioButton);
        TelaGerenciarFormulario.add(excluirFormularioButton);
        TelaGerenciarFormulario.add(listarTodosOsFormulariosButton);
        TelaGerenciarFormulario.add(scrollPane);


        add(TelaGerenciarFormulario);
    }

    private void atualizarExibicaoFormularios() {
        List<Formulario> formularios = formularioDao.findAll();

        displayFormulario.setText("");

        if (formularios != null) {
            for (Formulario formulario : formularios) {
                displayFormulario.append("ID: " + formulario.getIDformulario() + "  ");
                displayFormulario.append("Nome: " + formulario.getCategoria() + "  ");
                displayFormulario.append("CPF: " + formulario.getConformidade() + "  ");
                displayFormulario.append("\n");
            }
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da SegundaTela para testar
        GerenciarFormularios segundaTela = new GerenciarFormularios();
        segundaTela.setVisible(true);
    }
}
