package model.dao.entites;

public class Empresa {

    private int IDempresa;
    private String nome_fantasia;
    private int cnpj;
    private  String razao_social;
    private String atividade;
    private String porte;
    private String email;
    private String senha;

    public Empresa(){
    }


    public Empresa(int IDempresa, String nome_fantasia, int cnpj, String razao_social, String atividade, String porte, String email, String senha){
        this.IDempresa = IDempresa;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.atividade = atividade;
        this.porte = porte;
        this.email = email;
        this.senha = senha;
    }

    public int getIDempresa() {
        return IDempresa;
    }

    public void setIDempresa(int IDempresa) {
        this.IDempresa = IDempresa;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

