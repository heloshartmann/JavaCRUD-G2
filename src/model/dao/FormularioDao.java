package model.dao;

import java.util.List;

import model.dao.entites.Formulario;



    public interface FormularioDao {

        void insert(Formulario formulario);
        void update(Formulario formulario);
        void deleteById(Integer id);
        Formulario findById(Integer id);
        List<Formulario> findAll();
    }

