/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.util;

import br.orm.master.exception.NaoContemPrimaryKeyException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ExploradorDeObjeto<T extends Object> {

    private final Class<T> base;
    private static final Logger LOGGER = Logger.getLogger(ExploradorDeObjeto.class.getName());

    public ExploradorDeObjeto(Class<T> base) {
        this.base = base;
    }

    public Object getValor(Field atr, Object obj) {
        try {
            String nomeGetter = "get"
                    + Character.toUpperCase(atr.getName().charAt(0))
                    + atr.getName().substring(1);

            Method mtd = base.getMethod(nomeGetter, (Class[]) null);
            return mtd.invoke(obj, (Object[]) null);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            LOGGER.severe(ex.getMessage());
        }
        return null;
    }

    public void setValor(Field atr, Object obj, Object value) {
        try {
            String nomeSetter = "set"
                    + Character.toUpperCase(atr.getName().charAt(0))
                    + atr.getName().substring(1);

            Method mtd = base.getMethod(nomeSetter, new Class[]{value.getClass()});
            mtd.invoke(obj, value);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }

    public Field getPrimaryKey() throws NaoContemPrimaryKeyException {
        for (Field atr : this.base.getDeclaredFields()) {
            if (ExploradorDeObjetos.ehPrimaryKey(atr)) {
                return atr;
            }
        }
        throw new NaoContemPrimaryKeyException();
    }

    public String getTabela() {
        return this.base.getSimpleName();
    }

    public Field[] getFields() {
        return this.base.getDeclaredFields();
    }
}
