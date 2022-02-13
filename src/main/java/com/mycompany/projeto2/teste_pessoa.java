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
import java.util.Scanner;
public class teste_pessoa { //teste que cria uma pessoa

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Hospital hop = new Hospital("Live Longer", 2021);
        
        Medico med;
        med=new Medico(12345,"fa");//0
        hop.addMedico(med);
        
        Paciente p;
        p = new Paciente(987654321,"1996-12-09", "dores");//1
        hop.addPacEspera(p);
        p = new Paciente(123456789,"1974-11-09", "Cortes");//2
        hop.addPacEspera(p);
        p = new Paciente(543219876,"1939-09-21", "Falta de memoria");//3
        hop.addPacEspera(p);
       
        /*System.out.println(hop.toString());
        
        for(int a=0;a<hop.getPaciente().size();a++){
            
            System.out.println(" ");
            System.out.println(hop.getPaciente().get(a).toString());
            
        }*/
        
        
        Enf_esp esp;
        Enf_aux aux;
        esp=new Enf_esp(234567890, 20, "jose", "alll");//4
        hop.addEnfEsp(esp);
        esp=new Enf_esp(234567890, 24, "alfredo", "tttt");//5
        hop.addEnfEsp(esp);
        esp=new Enf_esp(234567890, 26, "rita", "rrrr");//6
        hop.addEnfEsp(esp);
        aux=new Enf_aux(234567890, 20, "santo");//7
        hop.addEnfAux(aux);
        
        hop.getMedico().get(0).addPaciente(hop.getPacEspera().get(2));
        hop.getMedico().get(0).addPaciente(hop.getPacEspera().get(1));
        
        
        for(int b=0;b<hop.getMedico().get(0).getPaciente().size();b++){
            if(hop.getMedico().get(0).getPaciente().get(b).getCurativo()){
                System.out.println("Curativo true");

            }else{
                System.out.println("Curativo false");
            }
        }
        
        for (Medico medico : hop.getMedico()) {
            System.out.println(medico.toString());
            System.out.println("Tem os seguintes Especialistas atribuidos");
            for (Enf_esp enfEsp : medico.getEnfEsp()) {
                System.out.println(enfEsp.toString());
            }
        }
                            
        
        
        
        
        
        
        
        
        
    }
   
    
}
