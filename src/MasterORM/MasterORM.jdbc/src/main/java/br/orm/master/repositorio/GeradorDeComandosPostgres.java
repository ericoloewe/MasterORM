/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.repositorio;

import br.orm.master.annotation.Required;
import br.orm.master.dominio.GeradorDeComandos;
import br.orm.master.util.ExploradorDeObjetos;
import java.lang.reflect.Field;

/**
 *
 * @author Érico de Souza Loewe
 */
public class GeradorDeComandosPostgres implements GeradorDeComandos {

    private final ExploradorDeObjetos explorador;

    public GeradorDeComandosPostgres() {
        explorador = null;
    }

    public GeradorDeComandosPostgres(ExploradorDeObjetos<?> explorador) {
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
        StringBuilder cmd = new StringBuilder();

        try {
            Field primaryKey = explorador.getPrimaryKey();
            cmd.append(String.format("CREATE TABLE %s \n(", explorador.getTabela()));

            for (Field atr : this.explorador.getFields()) {
                cmd.append(this.criarCampoDaTabela(atr.getName(), atr.getType().getSimpleName(), atr.isAnnotationPresent(Required.class)));
            }

            cmd.append(String.format("\nCONSTRAINT %s_PK PRIMARY KEY (%s)", explorador.getTabela(), primaryKey.getName()));
            cmd.append("\n)");
        } catch (Exception ex) {

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
