package model.dao.entites;

public class Funcionario {
    private int id_funcionario;
    private String nome;
    private String cpf;
    private String telefone;
    private String cidade;
    private String estado;
    private String cargo;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int id_funcionario, String nome, String cpf, String telefone, String cidade, String estado, String cargo, String senha) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.cargo = cargo;
        this.senha = senha;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
