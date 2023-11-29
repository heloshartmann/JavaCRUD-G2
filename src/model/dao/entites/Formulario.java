package model.dao.entites;

public class Formulario {
    private int IDformulario;
    private String conformidade;
    private String categoria;
    private int idEmpresa;
    private int idFuncionario;

    public Formulario() {
    }

    public Formulario(int IDformulario, String conformidade, String categoria,int idEmpresa,int idFuncionario) {
        this.IDformulario = IDformulario;
        this.conformidade = conformidade;
        this.categoria = categoria;
        this.idEmpresa=idEmpresa;
        this.idFuncionario=idFuncionario;
    }


    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    @Override
    public String toString() {
        return
                "ID= " + IDformulario +
                ", Conformidade= '" + conformidade + '\'' +
                ", Categoria= '" + categoria + '\'';
    }

}
