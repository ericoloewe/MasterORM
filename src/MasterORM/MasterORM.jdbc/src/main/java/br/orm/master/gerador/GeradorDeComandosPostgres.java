/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.gerador;

import br.orm.master.annotation.Required;
import br.orm.master.util.ExploradorDeObjeto;
import java.lang.reflect.Field;
import java.util.logging.Logger;

/**
 *
 * @author Érico de Souza Loewe
 */
public class GeradorDeComandosPostgres implements GeradorDeComandos {
    private Logger LOGGER = Logger.getLogger(GeradorDeComandosPostgres.class.getName());
    
    public void adicionar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remover(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void criarTabela(Object obj) {
        StringBuilder cmd = new StringBuilder();
        ExploradorDeObjeto exp = new ExploradorDeObjeto(obj.getClass());
        try {
            Field primaryKey = exp.getPrimaryKey();
            cmd.append(String.format("CREATE TABLE %s \n(", exp.getTabela()));

            for (Field atr : exp.getFields()) {
                cmd.append(this.criarCampoDaTabela(atr.getName(), atr.getType().getSimpleName(), atr.isAnnotationPresent(Required.class)));
            }

            cmd.append(String.format("\nCONSTRAINT %s_PK PRIMARY KEY (%s)", exp.getTabela(), primaryKey.getName()));
            cmd.append("\n)");
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }

        System.out.println(cmd.toString());
    }

    private String criarCampoDaTabela(String nome, String tipo, boolean required) {
        String tipoDoBanco = "";

        switch (tipo) {
            case "String":
                tipoDoBanco = "character varying(255)";
                break;
            case "int":
            case "Integer":
                tipoDoBanco = "integer";
                break;
        }

        return String.format("\n%s %s%s,", nome, tipoDoBanco, required ? " NOT NULL" : "");
    }
}
