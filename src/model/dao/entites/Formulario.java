package model.dao.entites;

public class Formulario {
    private int IDforms;
    private String nome;
    private float conformidade;
    private Empresa empresa;
    private Funcionario funcionario;

    public Formulario() {
    }

    public Formulario(int IDforms, String nome, float conformidade, Empresa empresa, Funcionario funcionario) {
        this.IDforms = IDforms;
        this.nome = nome;
        this.conformidade = conformidade;
        this.empresa = empresa;
        this.funcionario = funcionario;
    }

    public int getIDforms() {
        return IDforms;
    }

    public void setIDforms(int IDforms) {
        this.IDforms = IDforms;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getConformidade() {
        return conformidade;
    }

    public void setConformidade(float conformidade) {
        this.conformidade = conformidade;
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
