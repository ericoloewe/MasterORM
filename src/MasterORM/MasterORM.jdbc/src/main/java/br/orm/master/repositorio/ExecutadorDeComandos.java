/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.repositorio;

import br.orm.master.gerador.GeradorDeComandos;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ExecutadorDeComandos<T extends Object> {
    
    private static GeradorDeComandos _gerador;
    
    public void adicionar(T obj) {
        _gerador.adicionar(obj);
    }
    
    public void atualizar(T obj) {
        _gerador.adicionar(obj);
    }
    
    public void remover(T obj) {
        _gerador.adicionar(obj);
    }
    
    public static void definirGerador(GeradorDeComandos gerador) {
        _gerador = gerador;
    }
}
