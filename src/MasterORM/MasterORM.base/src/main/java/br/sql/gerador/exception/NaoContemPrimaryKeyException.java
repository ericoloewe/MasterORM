/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sql.gerador.exception;

/**
 *
 * @author Érico de Souza Loewe
 */
public class NaoContemPrimaryKeyException extends Exception {

    public NaoContemPrimaryKeyException() {
        this("Objeto não contem primary key");
    }

    public NaoContemPrimaryKeyException(String message) {
        super(message);
    }
    
}
