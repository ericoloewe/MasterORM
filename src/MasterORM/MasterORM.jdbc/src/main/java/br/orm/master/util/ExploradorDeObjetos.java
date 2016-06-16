/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.util;

import br.orm.master.exception.NaoContemPrimaryKeyException;
import java.lang.reflect.Field;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ExploradorDeObjetos {
    public static String getNomeTipoGenerico(Field atr) {
        String entidadeCompleta = atr.getGenericType().getTypeName();
        return entidadeCompleta.split("\\.")[entidadeCompleta.split("\\.").length - 1].replaceAll(">", "");
    }
    
    public static boolean ehPrimaryKey(Field atr) {
        return atr.getName().toLowerCase().equals("id") || atr.getName().substring(atr.getName().length() - 2, atr.getName().length()).toLowerCase().equals("id") || atr.getName().substring(0, 2).toLowerCase().equals("id");
    }
    
    public Field getPrimaryKey(Field atr) throws NaoContemPrimaryKeyException {
        for (Field field : atr.getClass().getDeclaredFields()) {
            if (ehPrimaryKey(field)) {
                return field;
            }
        }
        throw new NaoContemPrimaryKeyException();
    }

    public String getTabela(Field atr) {
        return atr.getClass().getSimpleName();
    }

    public Field[] getFields(Field atr) {
        return atr.getClass().getDeclaredFields();
    }
}
