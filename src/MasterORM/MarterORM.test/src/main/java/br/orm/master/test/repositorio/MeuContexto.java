/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orm.master.test.repositorio;

import br.orm.master.repositorio.Tabela;
import br.orm.master.model.TipoGeradorBanco;
import br.orm.master.repositorio.Contexto;
import br.orm.master.test.model.Pessoa;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MeuContexto extends Contexto {
    
    public MeuContexto() {
        super(TipoGeradorBanco.POSTGRES);
    }
    
    public Tabela<Pessoa> Pessoas = new Tabela<Pessoa>();
}
