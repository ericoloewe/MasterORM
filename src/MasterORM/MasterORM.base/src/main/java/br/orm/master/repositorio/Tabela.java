/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.repositorio;

import br.orm.master.repositorio.ExecutadorDeComandos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Tabela<T extends Object> {

    private final List<T> _objetosAAdicionar;
    private final List<T> _objetosARemover;
    private final List<T> _objetosAAtualizar;
    private final ExecutadorDeComandos _comandos;
    
    public Tabela() {
        this._comandos = new ExecutadorDeComandos<T>();
        this._objetosAAdicionar = new ArrayList<>();
        this._objetosARemover = new ArrayList<>();
        this._objetosAAtualizar = new ArrayList<>();
    }
    
    public void adicionar(T obj) {
        _objetosAAdicionar.add(obj);
    }
    
    public void remover(T obj) {
        _objetosARemover.add(obj);
    }
    
    public void atualizar(T obj) {
        _objetosAAtualizar.add(obj);
    }
    
    public void buscar(Object Id) {
        
    }
    
    public void salvarAlteracoes() {
        for(T obj : _objetosAAdicionar) {
            _comandos.adicionar(obj);
        }
        
        for(T obj : _objetosARemover) {
            _comandos.remover(obj);
        }
        
        for(T obj : _objetosAAtualizar) {
            _comandos.atualizar(obj);
        }
    }
}
