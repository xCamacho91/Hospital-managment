/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

/**
 *
 * @author Asus
 */
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Enf_aux extends Enfermeiro{
    
    public Enf_aux (int nif, int anosCarreira, String nome){
        super(nif, anosCarreira, nome);
    }
    public String toString (){
        String texto;
        texto=super.toString();
        return texto;
    }
}
