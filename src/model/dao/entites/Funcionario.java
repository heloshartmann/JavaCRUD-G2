package model.dao.entites;

public class Funcionario {
    private int IDfuncionario;
    private String nome;
    private String cpf;
    private String cargo;
    private String cidade;
    private String estado;
    private String email;
    private String telefone;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int IDfuncionario, String nome, String cpf, String cargo, String cidade, String estado, String email, String telefone, String senha) {
        this.IDfuncionario = IDfuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public int getIDfuncionario() {
        return IDfuncionario;
    }

    public void setIDfuncionario(int id_funcionario) {
        this.IDfuncionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}