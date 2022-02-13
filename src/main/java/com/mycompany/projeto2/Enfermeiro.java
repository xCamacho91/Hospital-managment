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
public class Enfermeiro extends Pessoa{
    private int anosCarreira;
    private String nome;
 
    public Enfermeiro (int nif, int anosCarreira, String nome){
        super(nif);
        this.anosCarreira= anosCarreira;
        this.nome=nome;
    }
    public int getAnosCarreira(){
        return anosCarreira;
    }
    public String getNome(){
        return nome;
    }
    public void setAnosCarreira(int anosCarreira){
        this.anosCarreira=anosCarreira;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void aumentarAnos(int aumentaAnos){
        this.anosCarreira=anosCarreira+aumentaAnos;
    } 
        
    public String toString (){
        String texto;
        texto=super.toString() + "\nÉ o enfermeiro " + nome + "\nTem "+anosCarreira+ " anos de carreira.";
        return texto;
    }
}
    

