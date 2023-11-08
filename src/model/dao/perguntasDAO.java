package model.dao;

import model.dao.entites.Perguntas;

import java.util.List;

public interface perguntasDAO {

    void insert(Pergunta pergunta);
    void update(Pergunta pergunta);
    void deleteById(Integer id);
    Pergunta findById(Integer id);
    List<Pergunta> findAll();
}