package model.dao;

import java.util.List;

import model.dao.entites.Perguntas;

public interface perguntasDAO {

    void insert(Pergunta pergunta);
    void update(Pergunta pergunta);
    void deleteById(Integer id);
    Pergunta findById(Integer id);
    List<Pergunta> findAll();
}