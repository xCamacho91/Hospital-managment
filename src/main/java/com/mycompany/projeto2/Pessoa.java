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
public class Pessoa {
    private int utente;
    private String ID;
    private static int contar;
    
    public Pessoa(int utente){
        this.utente=utente;
        this.contar++;
        
        if (contar<10){
            this.ID = "ID000"+contar;
        }
        else if (contar<100){
            this.ID = "ID00"+contar;
        }
        else if (contar<1000){
            this.ID = "ID0"+contar;
        }
        else{
            this.ID = "ID"+contar;
        }
    }
    public int getUtente(){
        return utente;
    }
    public static int getContar() {
        return contar;
    }
    public String getID(){
        return ID;
    }
    
    public void setNif(int utente){
        this.utente=utente;
    }
    public String toString(){
        String texto;
        texto="Esta pessoa - ID: "+ID+"\nNºutente: " + utente;
        return texto;
    }
    
    public boolean equals (Object obj2){ //2 pessoas com o mm nºutente é a mm pessoa
        if (this==obj2) return true;
        if (obj2 ==null) return false;
        if (this.getClass()!= obj2.getClass()) return false;
        Pessoa p =(Pessoa) obj2;
        return utente == p.getUtente();    
    }
}
