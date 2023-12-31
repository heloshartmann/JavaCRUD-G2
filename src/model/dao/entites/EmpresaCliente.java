package model.dao.entites;


public class EmpresaCliente {
    private int IDempresa;
    private String nomeFantasia;
    private String cnpj;
    private String razaoSocial;
    private String atividade;
    private String porte;
    private String email;
    private String senha;

    // Construtor


    public EmpresaCliente() {
    }

    public EmpresaCliente(int idEmpresa, String nomeFantasia, String cnpj, String razaoSocial, String atividade, String porte, String email, String senha) {
        this.IDempresa = idEmpresa;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.atividade = atividade;
        this.porte = porte;
        this.email = email;
        this.senha = senha;
    }

    public int getIdEmpresa() {
        return IDempresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.IDempresa = idEmpresa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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

    @Override
    public String toString() {
        return
                "ID= " + IDempresa +
                ", NomeFantasia= '" + nomeFantasia + '\'' +
                ", CNPJ= '" + cnpj + '\'' +
                ", RazaoSocial= '" + razaoSocial + '\'' +
                ", Atividade= '" + atividade + '\'' +
                ", Porte= '" + porte + '\'' +
                ", Email= '" + email + '\'' +
                ", Senha= '" + senha + '\'';
    }
}
