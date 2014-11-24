package br.com.giovanna.trabalhoFinalGiovannaFranco.DAO;

import java.util.List;

public interface DAO<T > {
    int inserir(T obj);
    void alterar(T obj);
    void excluir(int id);
    List<T > listarTodos();
    T buscar(int id);
}
