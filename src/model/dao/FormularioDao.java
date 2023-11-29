package model.dao;

import java.util.List;

import model.dao.entites.Formulario;

public interface FormularioDao {
    void insert(Formulario formulario);
    void update(Formulario formulario);


    static void deleteById(int id) {

    }


    Formulario findById(int id);
    List<Formulario> findAll();
}
