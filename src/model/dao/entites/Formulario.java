package model.dao.entites;

public class Formulario {
    private int IDformulario;
    private String conformidade;
    private String categoria;
    private int empresa;
    private int funcionario;

    public Formulario(int iDformulario, String categoria, String conformidade, String idEmpresa, int idFuncioario) {
    }

    public Formulario(int IDformulario, String conformidade, String categoria, int empresa, int funcionario) {
        this.IDformulario = IDformulario;
        this.conformidade = conformidade;
        this.categoria = categoria;
        this.empresa = empresa;
        this.funcionario = funcionario;
    }

    public Formulario() {

    }

    public int getIDformulario() {
        return IDformulario;
    }

    public void setIDformulario(int IDformulario) {
        this.IDformulario = IDformulario;
    }

    public String getConformidade() {
        return conformidade;
    }

    public void setConformidade(String conformidade) {
        this.conformidade = conformidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }
}
