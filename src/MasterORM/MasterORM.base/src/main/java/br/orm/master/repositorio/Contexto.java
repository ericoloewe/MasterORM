/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.repositorio;

import br.orm.master.gerador.GeradorDeComandos;
import br.orm.master.gerador.GeradorDeComandosOracle;
import br.orm.master.gerador.GeradorDeComandosPostgres;
import java.io.Closeable;
import java.util.logging.Logger;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Contexto implements Closeable {
    private Logger LOGGER = Logger.getLogger(Contexto.class.getName());
    
    public Contexto(String gerador) {
        ExecutadorDeComandos.definirGerador(getGeradorDeComandos(gerador));
    }
    
    private GeradorDeComandos getGeradorDeComandos(String nomeGerador) {
        GeradorDeComandos gerador = null;
        
        switch(nomeGerador) {
            case "oracle": {
                gerador = new GeradorDeComandosOracle();
                break;
            }
            case "postgre": {
                gerador = new GeradorDeComandosPostgres();
                break;
            }
        }
        
        return gerador;
    }

    public void close() {
        salvarAlteracoes();
    }

    private void salvarAlteracoes() {
        
    }
}
