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
public class Medico extends Pessoa{
    public String doenca;
    public ArrayList<Enf_aux> enf_aux;
    public ArrayList<Enf_esp> enf_esp;
    public ArrayList<Paciente> pac;
    
    
    public Medico (int nif, String doenca){
        super(nif);
        this.doenca=doenca;
        enf_aux=new ArrayList<Enf_aux>();
        enf_esp=new ArrayList<Enf_esp>();
        pac=new ArrayList<Paciente>();
    }
    
    public String getDoenca(){
        return doenca;
    }
    public void setDoenca(String doenca){
        this.doenca=doenca;
    }
    
    public ArrayList<Enf_aux> getEnfAux(){
        return enf_aux;
    }
    public void addEnfAux(Enf_aux enf_aus){
        enf_aux.add(enf_aus);
    }
    
    public ArrayList<Enf_esp> getEnfEsp(){
        return enf_esp;
    }
    public void addEnfEsp(Enf_esp enf_esps){
        enf_esp.add(enf_esps);
    }
    
    public ArrayList<Paciente> getPaciente(){
        return pac;
    }
    public void addPaciente(Paciente paci){
        pac.add(paci);
    }
    public void removePaciente(int paci){
        pac.remove(paci);
    }
      
    
    
    
    public String toString (){
        String texto;
        texto=super.toString() + "\nÉ médico e trata a doença " + getDoenca();
        return texto;
    }
    
    
}
