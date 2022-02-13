/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Enf_chefe extends Enf_esp {
    
    public Enf_chefe (int nif, int anosCarreira, String nome, String especialidade){
        super(nif, anosCarreira, nome, especialidade);
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        String texto;
        texto="Enfermeiro Chefe\n" + super.toString() ;
        return texto;
    }
}
