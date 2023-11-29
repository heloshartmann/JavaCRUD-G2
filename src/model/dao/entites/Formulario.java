package model.dao.entites;

public class Formulario {
    private int IDformulario;
    private String conformidade;
    private String categoria;

    public Formulario(int IDformulario, String conformidade, String categoria) {
        this.IDformulario = IDformulario;
        this.conformidade = conformidade;
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return
                "ID= " + IDformulario +
                ", Conformidade= '" + conformidade + '\'' +
                ", Categoria= '" + categoria + '\'';
    }
}
