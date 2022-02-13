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
import java.util.Random;

public class Paciente extends Pessoa{
    private int tentativas;
    private String ano_nascimento;
    private String sintoma;
    private String doenca;
    private String diagnostico;
    private boolean curativo;
    private boolean alta;
    private static Random random = new Random();
    
    public Paciente (int nif, String ano_nascimento, String sintoma){
        super(nif);
        this.ano_nascimento=ano_nascimento;
        this.sintoma=sintoma;
        this.tentativas=0;
        this.diagnostico="";
        this.doenca="";
        this.curativo=false;
        this.alta=false;
    }
    public int getTentativas(){
        return tentativas;
    }
    public void setTentativas(int tentativas){
        this.tentativas+=tentativas;
    }
    public String getAno_nascimento(){
        return ano_nascimento;
    }
    public void setAno_nascimento(String ano_nascimento){
        this.ano_nascimento=ano_nascimento;
    }
    
    public boolean getAlta(){
        return alta;
    }
    public void setAlta(boolean alta){
        this.alta=alta;
    }
    
    public String getSintoma(){
        return sintoma;
    }
    public void setSintoma(String sintoma){
        this.sintoma=sintoma;
    }
    
    public String getDoenca(){
        return doenca;
    }
    public void setDoenca(String doenca){
        this.doenca=doenca;
    }
    public String getDiagnostico(){
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico){
        this.diagnostico=diagnostico;
    }
    public boolean getCurativo(){
        return curativo;
    }
    public void setCurativo(boolean curativo){
        this.curativo=curativo;
    }
    
        
    public String toString(){
        String texto;
        texto=super.toString() + "\nNascido a: " + ano_nascimento;
        texto=texto + "\nTem os sintomas: " + sintoma;
        
        if(!diagnostico.isEmpty()){
            texto=texto + "\nDiagnostico: " + diagnostico;
        }
        if(curativo){
            texto=texto + "\nCurativo foi realizado";
        }
        
        texto=texto + "\n";
        return texto;
    }
    
    
   
    
    
    
}
