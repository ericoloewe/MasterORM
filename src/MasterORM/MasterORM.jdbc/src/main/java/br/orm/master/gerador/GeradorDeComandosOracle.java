/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.repositorio;

import br.orm.master.dominio.GeradorDeComandos;
import br.orm.master.util.ExploradorDeObjetos;

/**
 *
 * @author Érico de Souza Loewe
 */
public class GeradorDeComandosOracle implements GeradorDeComandos {
    
    private final ExploradorDeObjetos explorador;
    
    public GeradorDeComandosOracle() {
        explorador = null;
    }   
    
    public GeradorDeComandosOracle(ExploradorDeObjetos<?> explorador) {
        this.explorador = explorador;
    }
    
    public void adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void criarTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
