/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.repositorio;

import br.orm.master.gerador.GeradorDeComandos;
import br.orm.master.gerador.GeradorDeComandosOracle;
import br.orm.master.gerador.GeradorDeComandosPostgres;
import br.orm.master.model.TipoGeradorBanco;
import br.orm.master.util.ExploradorDeObjetos;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.util.logging.Logger;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Contexto implements Closeable {

    private Logger LOGGER = Logger.getLogger(Contexto.class.getName());

    public Contexto(TipoGeradorBanco gerador) {
        ExecutadorDeComandosSingleton.setGerador(getGeradorDeComandos(gerador));
        contruirTabelas();
    }

    private GeradorDeComandos getGeradorDeComandos(TipoGeradorBanco nomeGerador) {
        GeradorDeComandos gerador = null;

        switch (nomeGerador.name()) {
            case "ORACLE": {
                gerador = new GeradorDeComandosOracle();
                break;
            }
            case "POSTGRES": {
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

    private void contruirTabelas() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getType().getTypeName().equals(Tabela.class.getTypeName())) {
                try {
                    System.out.println(ExploradorDeObjetos.getNomeTipoGenerico(field));
                } catch (SecurityException ex) {
                    LOGGER.severe(ex.getMessage());
                }
            }
        }
    }
}
