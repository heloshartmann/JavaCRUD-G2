import java.sql.*;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.FormularioDao;
import model.dao.entites.Formulario;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FormularioDao formularioDao = DaoFactory.createFormularioDao();

        int opcao;
        do{
            System.out.println("1- Cadastrar Formulario");
            System.out.println("2- Excluir Formulario");
            System.out.println("0- Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("---Novo Formulario---");
                    Formulario formulario = new Formulario();
                    System.out.println("Digite o nome: ");
                    formulario.setNome(sc.next());
                    System.out.println("Digite a conformidade: ");
                    formulario.setConformidade(sc.nextInt());
                    formularioDao.insert(formulario);
                    break;
                case 2:
                    System.out.println("---Deletar Formulario---");
                    System.out.println("Digite o ID do formulario que deseja excluir: ");
                    int id = sc.nextInt();
                    formularioDao.deleteById(id);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opcao invaida. Tente novamente!");
                    break;
            }
        }while (opcao != 0);
        sc.close();
    }
}
