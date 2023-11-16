package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.FormularioDao;
import model.dao.FuncionarioDao;
import model.dao.entites.Formulario;
import model.dao.entites.Funcionario;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FormularioDao formularioDao = DaoFactory.createFormularioDao();
        FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();

        int opcao;
        do{
            System.out.println("1- Cadastrar Formulario");
            System.out.println("2- Excluir Formulario");
            System.out.println("3- Cadastrar Funcionario");
            System.out.println("4- Excluir Funcionario");
            System.out.println("5- Listar todos Formularios");
            System.out.println("6- Listar todos Funcionarios");
            System.out.println("0- Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("---Novo Formulario---");
                    Formulario formulario = new Formulario();
                    System.out.println("Digite o categoria: ");
                    formulario.setCategoria(sc.next());
                    System.out.println("Digite a conformidade: ");
                    formulario.setConformidade(sc.next());
                    formularioDao.insert(formulario);
                    break;
                case 2:
                    System.out.println("---Deletar Formulario---");
                    System.out.println("Digite o ID do formulario que deseja excluir: ");
                    int idForm = sc.nextInt();
                    formularioDao.deleteById(idForm);
                    break;
                case 3:
                    System.out.println("---Novo Funcionario---");
                    Funcionario funcionario = new Funcionario();
                    System.out.println("Digite o nome: ");
                    funcionario.setNome(sc.next());
                    System.out.println("Digite o CPF: ");
                    funcionario.setCpf(sc.next());
                    System.out.println("Digite o cargo: ");
                    funcionario.setCargo(sc.next());
                    System.out.println("Digite a cidade: ");
                    funcionario.setCidade(sc.next());
                    System.out.println("Digite o estado: ");
                    funcionario.setEstado(sc.next());
                    System.out.println("Digite o telefone: ");
                    funcionario.setTelefone(sc.next());
                    System.out.println("Digite o email: ");
                    funcionario.setEmail(sc.next());
                    System.out.println("Digite o senha: ");
                    funcionario.setSenha(sc.next());
                    funcionarioDao.insert(funcionario);
                    break;
                case  4:
                    System.out.println("---Deletar Funcionario---");
                    System.out.println("Digite o ID do funcionario que deseja excluir: ");
                    int idFunc = sc.nextInt();
                    funcionarioDao.deleteById(idFunc);
                    break;
                case 5:
                    System.out.println("---Todos os Formularios---");
                    List<Formulario> formularios = formularioDao.findAll();
                    for (Formulario formulario1 : formularios){
                        System.out.println(formulario1.toString());
                    }
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
