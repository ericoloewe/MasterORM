/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.gerador;

/**
 *
 * @author Érico de Souza Loewe
 */
public interface GeradorDeComandos {
    void criarTabela(Object obj);
    void adicionar(Object obj);
    void remover(Object obj);    
    void atualizar(Object obj);
}
