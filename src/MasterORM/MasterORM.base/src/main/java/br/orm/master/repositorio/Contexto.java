/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.repositorio;

import br.orm.master.dominio.GeradorDeComandos;
import br.orm.master.util.ExploradorDeObjetos;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.util.logging.Logger;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Contexto implements Closeable {
    private Logger LOGGER = Logger.getLogger(ExploradorDeObjetos.class.getName());
    
    public Contexto(GeradorDeComandos comandos) {
        atribuirAsTabelas(comandos);
    }

    public void close() {
        salvarAlteracoes();
    }

    private void salvarAlteracoes() {
        
    }

    private void atribuirAsTabelas(GeradorDeComandos comandos) {
        for(Field field : this.getClass().getDeclaredFields()) {
            if(field.getClass().getName().equals("Tabela")) {
                try {
                    Field geradorDeComandos = field.getClass().getDeclaredField("_comandos");
                    geradorDeComandos.setAccessible(true);
                    //field.getGenericType();                    
                    geradorDeComandos.set(field, comandos);
                } catch (NoSuchFieldException | SecurityException | IllegalAccessException ex) {
                    LOGGER.severe(ex.getMessage());
                }
            }
        }
    }
}
