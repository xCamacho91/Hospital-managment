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
public class Enf_esp extends Enfermeiro{
    private String especialidade;
    private ArrayList<Paciente> paciente;
    private boolean chefe;
    
    
    public Enf_esp (int nif, int anosCarreira, String nome, String especialidade){
        super(nif, anosCarreira, nome);
        this.especialidade=especialidade;
        paciente=new ArrayList<Paciente>();
        this.chefe=false;
    }
    
    public String getEspecialidade(){
        return especialidade;
    }
    public void setEspecialidade(String especialidade){
        this.especialidade=especialidade;
    }
    
    public ArrayList<Paciente> getPaciente(){
        return paciente;
    }
    public void addPaciente(Paciente i){
        paciente.add(i);
    }
    public void removePaciente(int i){
        paciente.remove(i);
    }
    public boolean getChefe(){
        return chefe;
    }
    public void setChefe(boolean chefe){
        this.chefe=chefe;
    }
    
    
    
    
    
    @Override
    public String toString (){
        String texto;
        texto=super.toString() + "\nTem a especialidade: " + especialidade;
        if(chefe){
            texto=texto + "\nFoi promovido a chefe";
        }
        return texto;
    }
    
    public void tornaChefe(Enf_esp id){
        //this.id.add(Enf_chefe);
        
    }
}
