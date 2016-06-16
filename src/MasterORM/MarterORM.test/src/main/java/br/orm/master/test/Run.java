/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.test;

import br.orm.master.test.repositorio.MeuContexto;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Run {
    public static void main(String[] args) {
        try(MeuContexto db = new MeuContexto()) {
            System.out.println("OK!");
        }
    }
}
