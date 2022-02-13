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

import java.util.Random;

public class CRIAR_DOENÇA_RANDOM {

    /**
     * @param args the command line arguments
     */
    private static Random random = new Random();
    
    public static void main(String[] args) {
        String sintomas[]={"Febre alta","Sintomas gastrointestinais","Nível globulo branco baixo"};
        System.out.println(sintomas[new Random().nextInt(sintomas.length)]);
        
    }
    
}

