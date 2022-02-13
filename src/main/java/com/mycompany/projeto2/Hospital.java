/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class Hospital {
    private String nome;
    private int ano;
    private static int recuperados;
    private static int obitos;
    private final ArrayList<Paciente> pacEspera;
   // private ArrayList<Paciente> pacDiagnostico;
    private final ArrayList<Paciente> pacObito;
    private final ArrayList<Paciente> pacAlta;
    private final ArrayList<Enf_aux> enfAux;
    private final ArrayList<Enf_esp> enfEsp;
    private final ArrayList<Medico> medicos;
    private final ArrayList<Pedidos> pedidos;
    

    public Hospital(String nome, int ano){
        this.nome = nome;
        this.ano = ano;
        
        pacEspera = new ArrayList<Paciente>();
       // pacDiagnostico = new ArrayList<Paciente>();
        pacObito = new ArrayList<Paciente>();
        pacAlta = new ArrayList<Paciente>();
        enfAux = new ArrayList<Enf_aux>();
        enfEsp = new ArrayList<Enf_esp>();
        medicos = new ArrayList<Medico>();
        pedidos = new ArrayList<Pedidos>();
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    //===========================================================================================================
    public int getAno(){
        return ano;
    }
    public void setAno(int ano){
        this.ano=ano;
    }
    //===========================================================================================================
    public ArrayList<Paciente> getPacEspera(){
        return pacEspera;
    }
    public void addPacEspera(Paciente pac){
        pacEspera.add(pac);
    }
    public void removePacEspera(int i){
        pacEspera.remove(i);
    }
    //===========================================================================================================
   /* public ArrayList<Paciente> getPacDiagnostico(){
        return pacDiagnostico;
    }
    public void addPacDiagnostico(Paciente pac){
        pacDiagnostico.add(pac);
    }
    public void removePacDiagnostico(int i){
        pacDiagnostico.remove(i);
    }*/
    //===========================================================================================================
    public ArrayList<Paciente> getPacObito(){
        return pacObito;
    }
    public void addPacObito(Paciente pac){
        pacObito.add(pac);
    }
    //===========================================================================================================
    public ArrayList<Paciente> getPacAlta(){
        return pacAlta;
    }
    public void addPacAlta(Paciente pac){
        pacAlta.add(pac);
    }
    public void removePacAlta(int i){
        pacAlta.remove(i);
    }
    //===========================================================================================================
    public ArrayList<Enf_aux> getEnfAux(){
        return enfAux;
    }
    public void addEnfAux(Enf_aux enf){
        enfAux.add(enf);
    }
    //===========================================================================================================
    public ArrayList<Enf_esp> getEnfEsp(){
        return enfEsp;
    }
    public void addEnfEsp(Enf_esp enf){
        enfEsp.add(enf);
    }
    public void removeEnfEsp(int i){
        enfEsp.remove(i);
    }
    //===========================================================================================================
    public ArrayList<Medico> getMedico(){
        return medicos;
    }
    public void addMedico(Medico med){
        medicos.add(med);
    }
    //===========================================================================================================
    public ArrayList<Pedidos> getPedido(){
        return pedidos;
    }
    public void addPedido(Pedidos ped){
        pedidos.add(ped);
    }
    public void removePedido(int i){
        pedidos.remove(i);
    }
    
    public String sintoma(){
        String sintomas[]={"Manchas Vermelhas","Diareia","Comichão","Ictericia","Calafrios","Febre Alta", "Nivel de Globulos Brancos Baixos","Conjuntivite","Febre","Dor de Cabeça","Dores Musculares","Hemorragias"};
        //String sintomas[]={"Hemorragias"};
        return sintomas[new Random().nextInt(sintomas.length)];
    }  
    
    public void darDiagnostico(String ID, String diagnostico, int a){
        for(int i=0;i<medicos.get(a).getEnfEsp().size();i++){
            if(medicos.get(a).getEnfEsp().size()<=3){
                for(int e=0;e<pacEspera.size();e++){
                    if(ID.equals(pacEspera.get(i).getID())){
                        pacEspera.get(i).setDiagnostico(diagnostico);//anda aqui algum problema, se não conseguir resolver isto remover o campo do switch da doença
                        medicos.get(a).getEnfEsp().get(i).addPaciente(pacEspera.get(e));
                        pacEspera.remove(e);
                        System.out.println("Foi direcionado ao Enfermeiro " + medicos.get(a).getEnfEsp().get(i).getID());
                    }
                }
            }else{
                System.out.println("Não é possivel adicionar a nenhum dos seu enfermeiros");
            }
        }
    }
        
    public void enviarAlta(String ID, String diagnostico){
        for(int i=0; i<medicos.size();i++){
            for(int e=0; e<medicos.get(i).getEnfEsp().size();e++){
                for(int x=0;x<medicos.get(i).getEnfEsp().get(i).getPaciente().size();x++){
                    if(ID.equals(medicos.get(i).getEnfEsp().get(i).getPaciente().get(x).getID())){
                        medicos.get(i).getEnfEsp().get(i).getPaciente().get(x).setSintoma(diagnostico);
                        medicos.get(i).addPaciente(medicos.get(i).getEnfEsp().get(i).getPaciente().get(x));
                        medicos.get(i).getEnfEsp().get(e).removePaciente(x);
                        System.out.println("Foi direcionado para o medico " + medicos.get(i).getID());
                    }
                }
            }
        }
    }
      
    public void darAlta(String ID, int a){
         for(int i=0;i<medicos.get(a).getPaciente().size();i++){
            if(ID.equals(medicos.get(a).getPaciente().get(i).getID())){
                Hospital.recuperados++;
                pacAlta.add(medicos.get(a).getPaciente().get(i));
                medicos.get(a).removePaciente(i);
            }
         }
    }
    
    
    public void obito(String id,String ID){
        for(int e=0;e<enfEsp.size();e++){
            if(id.equals(enfEsp.get(e).getID())){
                for(int i=0;i<enfEsp.get(e).getPaciente().size();i++){
                    if(enfEsp.get(e).getPaciente().get(i).getID().equals(ID)){
                        pacObito.add(enfEsp.get(e).getPaciente().get(i));
                        Hospital.obitos++;
                        enfEsp.get(e).removePaciente(i);
                    }
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        String texto;
        texto="Bem vindo ao hospital \n--" + nome + "--\nConstruido em " + ano;
       return texto;
    }
   
}
   