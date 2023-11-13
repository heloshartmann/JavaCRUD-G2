package model.dao;

import model.dao.entites.Perguntas;

import java.util.List;

public interface PerguntasDao {

    void insert(Perguntas pergunta);
    void update(Perguntas pergunta);
    void deleteById(Integer id);
    Perguntas findById(Integer id);
    List<Perguntas> findAll();
}