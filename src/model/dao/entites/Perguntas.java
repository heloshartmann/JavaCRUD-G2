package model.dao.entites;

public class Perguntas {
    private int IDquestionario;
    private String nome;
    private String eixo;
    private String pergunta;
    private Empresa empresa;
    private Funcionario funcionario;

    public Perguntas() {
    }

    public Perguntas(int IDquestionario, String nome, String eixo, String pergunta, Empresa empresa, Funcionario funcionario) {
        this.IDquestionario = IDquestionario;
        this.nome = nome;
        this.eixo = eixo;
        this.pergunta = pergunta;
        this.empresa = empresa;
        this.funcionario = funcionario;
    }

    public int getIdQuestionario() {
        return IDquestionario;
    }

    public void setIdQuestionario(int IDquestionario) {
        this.IDquestionario = IDquestionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEixo() {
        return eixo;
    }

    public void setEixo(String eixo) {
        this.eixo = eixo;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}