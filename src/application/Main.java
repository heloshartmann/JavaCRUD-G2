package application;

import java.util.List;
import java.util.Scanner;

import model.dao.*;
import model.dao.entites.EmpresaCliente;
import model.dao.entites.Formulario;
import model.dao.entites.Funcionario;
import model.dao.entites.Perguntas;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FormularioDao formularioDao = DaoFactory.createFormularioDao();
        EmpresaClienteDao empresaClienteDao = DaoFactory.createEmpresaClienteDao();
        PerguntasDao perguntasDao = DaoFactory.createPerguntasDao();

        int opcao;
        do{
            System.out.println("1- Gerenciar Formularios");
            System.out.println("2- Gerenciar Empresas");
            System.out.println("3- Gerenciar Perguntas");
            System.out.println("0- Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Selecione o que deseja fazer:");
                    System.out.println("1- Cadastrar Formulario");
                    System.out.println("2- Excluir Formulario");
                    System.out.println("3- Atualizar Formulario");
                    System.out.println("4- Listar todos Formularios");
                    int escolhaForm = sc.nextInt();
                    switch (escolhaForm){
                        case 1:
                            System.out.println("---Novo Formulario---");
                            Formulario formulario = new Formulario();
                            System.out.println("Digite a categoria: ");
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
                            System.out.println("---Atualizar Formulario---");
                            Formulario formulario2 = new Formulario();
                            System.out.println("Digite o ID do formulario que deseja atualizar: ");
                            formulario2.setIDformulario(sc.nextInt());
                            System.out.println("Digite a categoria: ");
                            formulario2.setCategoria(sc.next());
                            System.out.println("Digite a conformidade: ");
                            formulario2.setConformidade(sc.next());
                            formularioDao.update(formulario2);
                            break;
                        case 4:
                            System.out.println("---Todos os Formularios---");
                            List<Formulario> formularios = formularioDao.findAll();
                            for (Formulario formulario1 : formularios){
                                System.out.println(formulario1.toString());
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Selecione o que deseja fazer:");
                    System.out.println("1- Cadastrar Empresa");
                    System.out.println("2- Excluir Empresa");
                    System.out.println("3- Atualizar Empresa");
                    System.out.println("4- Listar todas Empresa");
                    int escolhaEmp = sc.nextInt();
                    switch (escolhaEmp){
                        case 1:
                            System.out.println("---Nova Empresa---");
                            EmpresaCliente empresaCliente = new EmpresaCliente();
                            System.out.println("Digite o Nome Fantasia: ");
                            empresaCliente.setNomeFantasia(sc.next());
                            System.out.println("Digite a Razao Social: ");
                            empresaCliente.setRazaoSocial(sc.next());
                            System.out.println("Digite a Atividade: ");
                            empresaCliente.setAtividade(sc.next());
                            System.out.println("Digite o Porte: ");
                            empresaCliente.setPorte(sc.next());
                            System.out.println("Digite o CNPJ: ");
                            empresaCliente.setCnpj(sc.next());
                            System.out.println("Digite o Email: ");
                            empresaCliente.setEmail(sc.next());
                            System.out.println("Digite a Senha: ");
                            empresaCliente.setSenha(sc.next());
                            empresaClienteDao.insert(empresaCliente);
                            break;
                        case 2:
                            System.out.println("---Deletar Empresa---");
                            System.out.println("Digite o ID da Empresa que deseja excluir: ");
                            int idEmp = sc.nextInt();
                            empresaClienteDao.deleteById(idEmp);
                            break;
                        case 3:
                            System.out.println("---Atualizar Empresa---");
                            EmpresaCliente empresaCliente2 = new EmpresaCliente();
                            System.out.println("Digite o ID da Empresa que deseja atualizar: ");
                            empresaCliente2.setIdEmpresa(sc.nextInt());
                            System.out.println("Digite o Nome Fantasia: ");
                            empresaCliente2.setNomeFantasia(sc.next());
                            System.out.println("Digite a Razao Social: ");
                            empresaCliente2.setRazaoSocial(sc.next());
                            System.out.println("Digite a Atividade: ");
                            empresaCliente2.setAtividade(sc.next());
                            System.out.println("Digite o Porte: ");
                            empresaCliente2.setPorte(sc.next());
                            System.out.println("Digite o CNPJ: ");
                            empresaCliente2.setCnpj(sc.next());
                            System.out.println("Digite o Email: ");
                            empresaCliente2.setEmail(sc.next());
                            System.out.println("Digite a Senha: ");
                            empresaCliente2.setSenha(sc.next());
                            empresaClienteDao.update(empresaCliente2);
                            break;
                        case 4:
                            System.out.println("---Todos as Empresas---");
                            List<EmpresaCliente> empresaClientes = empresaClienteDao.findAll();
                            for (EmpresaCliente empresaCliente1 : empresaClientes){
                                System.out.println(empresaCliente1.toString());
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Selecione o que deseja fazer:");
                    System.out.println("1- Cadastrar Perguntas");
                    System.out.println("2- Excluir Perguntas");
                    System.out.println("3- Atualizar Perguntas");
                    System.out.println("4- Listar todas Perguntas");
                    int escolhaPerg = sc.nextInt();
                    switch (escolhaPerg){
                        case 1:
                            System.out.println("---Nova Pergunta---");
                            Perguntas perguntas = new Perguntas();
                            System.out.println("Digite a Pergunta: ");
                            perguntas.setPergunta(sc.next());
                            System.out.println("Digite a Pontuacao: ");
                            perguntas.setPontuacao(sc.next());
                            System.out.println("Anexe o Documento/Imagem: ");
                            perguntas.setImagemDoc(sc.next());
                            perguntasDao.insert(perguntas);
                            break;
                        case 2:
                            System.out.println("---Deletar Pergunta---");
                            System.out.println("Digite o ID da Pergunta que deseja excluir: ");
                            int idPerg = sc.nextInt();
                            perguntasDao.deleteById(idPerg);
                            break;
                        case 3:
                            System.out.println("---Atualizar Pergunta---");
                            Perguntas perguntas2 = new Perguntas();
                            System.out.println("Digite o ID da Pergunta que deseja atualizar: ");
                            perguntas2.setIDpergunta(sc.nextInt());
                            System.out.println("Digite a Pergunta: ");
                            perguntas2.setPergunta(sc.next());
                            System.out.println("Digite a Pontuacao: ");
                            perguntas2.setPontuacao(sc.next());
                            System.out.println("Anexe o Documento/Imagem: ");
                            perguntas2.setImagemDoc(sc.next());
                            perguntasDao.update(perguntas2);
                            break;
                        case 4:
                            System.out.println("---Todos as Perguntas---");
                            List<Perguntas> pergunta = perguntasDao.findAll();
                            for (Perguntas perguntas1 : pergunta){
                                System.out.println(perguntas1.toString());
                            }
                            break;
                    }
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
