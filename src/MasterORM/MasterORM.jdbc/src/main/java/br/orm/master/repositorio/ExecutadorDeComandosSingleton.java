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
public class ExecutadorDeComandosSingleton {
    
    private static GeradorDeComandos _gerador;
    
    public static void setGerador(GeradorDeComandos gerador) {
        _gerador = gerador;
    }
    
    public static GeradorDeComandos getGerador() {
        return _gerador;
    }
}
