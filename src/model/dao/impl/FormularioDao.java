package model.dao;

import java.util.List;

import model.dao.entites.Formulario;



    public interface FormularioDao {

        void insert(Formulario obj);
        void update(Formulario obj);
        void deleteById(Integer id);
        Formulario findById(Integer id);
        List<Formulario> findAll();
    }

