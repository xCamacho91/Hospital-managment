/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */

    
import com.mycompany.projeto2.Enf_aux;
import com.mycompany.projeto2.Enf_chefe;
import com.mycompany.projeto2.Enf_esp;
import com.mycompany.projeto2.Hospital;
import com.mycompany.projeto2.Medico;
import com.mycompany.projeto2.Paciente;
import com.mycompany.projeto2.Pedidos;
import java.util.Random;
import java.util.Scanner;
public class Menu{

    private static Random random = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Hospital hop = new Hospital("Live Longer", 2021);
        
        Medico med;
        med=new Medico(12345,"fa");
        hop.addMedico(med);
        
        Enf_esp esp;
        Enf_aux aux;
        esp=new Enf_esp(54321, 20, "jose", "alll");
        hop.addEnfEsp(esp);
        esp=new Enf_esp(234567890, 24, "alfredo", "tttt");
        hop.addEnfEsp(esp);
        esp=new Enf_esp(234567890, 26, "rita", "rrrr");
        hop.addEnfEsp(esp);
        aux=new Enf_aux(234567890, 20, "santo");
        hop.addEnfAux(aux);
        
        
        Paciente p;
        p = new Paciente(987654321,"1996-12-09", "Ictericia");
        hop.addPacEspera(p);
        p = new Paciente(123456789,"1974-11-09", "Ictericia");
        hop.addPacEspera(p);
        p = new Paciente(543219876,"1939-09-21", "Dor de Cabeça");
        hop.addPacEspera(p);    
        
        hop.getMedico().get(0).addEnfEsp(hop.getEnfEsp().get(2));
        
        //hop.getMedico().get(0).addPaciente(hop.getPacEspera().get(2));
        //hop.getMedico().get(0).addPaciente(hop.getPacEspera().get(1));
        
        Scanner scan =new Scanner(System.in);
        int opcao=0, r, opcao2=0;
        int ID, anosCarreira, valor;
        String ano_nascimento;
        int nif;
        String nome, especialidade, escolha, escolha2;
        int casos=0;
        int recuperados=0;
        int obitos=0;
        int testes=0;
        int casosTotal=0;
        int obitosTotal=0;
        int recuperadosTotal=0;
        
        
        for(int i=0;i<hop.getEnfEsp().size();i++){
            System.out.println(hop.getEnfEsp().get(i).toString());
        }
        for(int i=0;i<hop.getPacEspera().size();i++){
            System.out.println(hop.getPacEspera().get(i).toString());
        }
        
        
        
        
        do{
            System.out.println("");
            System.out.println("-----Bem Vindo ao Hospital-----");
            System.out.println("========  "+hop.getNome()+"  ========");
            System.out.println("1-Menu Médico");
            System.out.println("2-Menu Enfermeiro");
            System.out.println("3-Menu Admin");
            
            System.out.println("Insira a sua opção:");
            opcao=scan.nextInt();
            scan.nextLine();
            
            switch (opcao){
                case 1:
                    String Id;
                    int utente;
                    System.out.println("Introduza o seu ID: ");
                    Id=scan.next();
                    System.out.println("Introduza o seu Nº Utente: ");
                    utente=scan.nextInt();
                    for(int a=0;a<hop.getMedico().size();a++){
                        if(Id.equals(hop.getMedico().get(a).getID()) && utente==hop.getMedico().get(a).getUtente()){
                            do{
                                System.out.println("     ==    MWNU MÉDICO     ==       " + hop.getMedico().get(a).getID() );
                                System.out.println("1-Listar pacientes em espera no hospital");
                                System.out.println("2-Listar pacientes a aguardar alta");
                                System.out.println("3-Diagnóstico ao paciente");
                                System.out.println("4-Dar alta hospitalar");
                                System.out.println("5-Requerimento de auxiliares");
                                System.out.println("6-Voltar");
                                System.out.println("Insira a sua opção:");

                                opcao2 = scan.nextInt();
                                scan.nextLine();
                                switch(opcao2){
                                    case 1:
                                        //LISTA DE PACIENTES EM ESPERA
                                        if(!hop.getPacEspera().isEmpty()){
                                            for(int e=0;e<hop.getPacEspera().size();e++){
                                                System.out.println(hop.getPacEspera().get(e).toString());
                                            }
                                        }else{
                                            System.out.println("Lista de espera está vazia");
                                        }
                                        break;
                                    case 2:
                                        //LISTA PACIENTES ESPERA A AGUARDAR ALTA
                                        if(!hop.getMedico().get(a).getPaciente().isEmpty()){
                                            for(int e=0;e<hop.getMedico().get(a).getPaciente().size();e++){
                                                if(hop.getMedico().get(a).getPaciente().get(e).getCurativo()){
                                                    System.out.println(hop.getMedico().get(a).getPaciente().get(e).toString());
                                                }
                                            }
                                        }else{
                                            System.out.println("Não tem pacientes para dar alta");
                                        }
                                        break;
                                    case 3:
                                        //DIAGNÓSTICO AO PACIENTE
                                        if(hop.getMedico().get(a).getEnfEsp().size()>=1){
                                            if(!hop.getMedico().get(a).getPaciente().isEmpty() && 3>=hop.getMedico().get(a).getPaciente().size()){
                                                System.out.println("Insira o ID do paciente: b");
                                                escolha=scan.nextLine();
                                                 for(int i=0;i<hop.getMedico().get(a).getPaciente().size();i++){
                                                    if(escolha.equals(hop.getMedico().get(a).getPaciente().get(i).getID())){
                                                        if("Curado".equals(hop.getMedico().get(a).getPaciente().get(i).getSintoma())){
                                                            nome="RECUPERADO";
                                                            hop.getMedico().get(a).getPaciente().get(i).setDiagnostico(nome);
                                                            hop.getMedico().get(a).getPaciente().get(i).setCurativo(true);
                                                        }else{
                                                            nome=hop.getMedico().get(a).getPaciente().get(i).getSintoma();
                                                            hop.darDiagnostico(hop.getMedico().get(a).getPaciente().get(i).getID(), nome, a);
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("Não existe" + escolha);
                                                    }
                                                 }
                                            }else{
                                                System.out.println("Insira o ID do paciente: a ");
                                                escolha=scan.nextLine();
                                                for(int i=0;i<hop.getPacEspera().size();i++){
                                                    if(escolha.equals(hop.getPacEspera().get(i).getID())){

                                                        switch (hop.getPacEspera().get(i).getSintoma()) {
                                                            case "Febre Alta" -> {
                                                                testes=testes+1;
                                                                nome="COVID-19";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casos=casos+1;
                                                                casosTotal=casosTotal+1;
                                                                
                                                            }
                                                            case "Diareia" -> {
                                                                nome="EBOLA";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casosTotal=casosTotal+1;
                                                            }
                                                            case "Nivel de Globulos Brancos Baixos" -> {
                                                                nome="HIV";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casosTotal=casosTotal+1;
                                                            }
                                                            case "Conjuntivite" -> {
                                                                nome="ZIKA";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casosTotal=casosTotal+1;
                                                            }
                                                            case "Manchas Vermelhas" -> {
                                                                nome="DENGUE";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casosTotal=casosTotal+1;
                                                            }
                                                            case "Comichão" -> {
                                                                nome="ESCABIOSE";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casosTotal=casosTotal+1;
                                                            }
                                                            case "Ictericia" -> {
                                                                nome="FEBRE AMARELA";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casosTotal=casosTotal+1;
                                                            }
                                                            case "Calafrios" -> {
                                                                nome="MALARIA";
                                                                System.out.println(nome);
                                                                hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                casosTotal=casosTotal+1;
                                                            }
                                                            
                                                            case "Febre" -> {
                                                                testes=testes+1;
                                                                r = new Random().nextInt(6);
                                                                switch(r){
                                                                    case 0 -> {
                                                                        nome="DENGUE";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 1 -> {
                                                                        nome="EBOLA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 2 -> {
                                                                        nome="FEBRE AMARELA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 3 -> {
                                                                        nome="MALARIA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 4 -> {
                                                                        nome="ZIKA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    default -> {
                                                                        nome="curado";
                                                                        System.out.println(nome);
                                                                        hop.enviarAlta(hop.getPacEspera().get(i).getID(), nome);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                }
                                                            }

                                                            case "Dor de Cabeça" -> {
                                                                r = new Random().nextInt(5);
                                                                switch(r){
                                                                    case 0 -> {
                                                                        nome="DENGUE";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 1 -> {
                                                                        nome="EBOLA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 2 -> {
                                                                        nome="ZIKA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 3 -> {
                                                                        nome="MALARIA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    default -> {
                                                                        nome="curado";
                                                                        System.out.println(nome);
                                                                        hop.enviarAlta(hop.getPacEspera().get(i).getID(), nome);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                }
                                                            }

                                                            case "Dores Musculares" -> {
                                                                r = new Random().nextInt(4);
                                                                testes=testes+1;
                                                                switch(r){
                                                                    
                                                                    case 0 -> {
                                                                        nome="DENGUE";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 1 -> {
                                                                        nome="EBOLA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 2 -> {
                                                                        nome="FEBRE AMARELA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 3 -> {
                                                                        nome="MALARIA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 4 -> {                                                
                                                                        nome="COVID-19";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);  
                                                                        casosTotal=casosTotal+1;
                                                                        casos=casos+1;
                                                                    }
                                                                }
                                                            }
                                                            case "Hemorragias" -> {
                                                                int v = new Random().nextInt(2);
                                                                switch(v){
                                                                    case 0 -> {
                                                                        nome="DENGUE";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                    case 1 -> {
                                                                        nome="EBOLA";
                                                                        System.out.println(nome);
                                                                        hop.darDiagnostico(hop.getPacEspera().get(i).getID(), nome, a);
                                                                        casosTotal=casosTotal+1;
                                                                    }
                                                                }
                                                            }
                                                        }

                                                    }
                                                }
                                               
                                            }
                                        }else{
                                            System.out.println("Não tem o número minimo de Enfermeiros especialistas consigo");
                                        }
                                        break;

                                    case 4:
                                        //DAR ALTA HOSPITALAR
                                        if(!hop.getMedico().get(a).getPaciente().isEmpty()){
                                            for(int e=0;e<hop.getMedico().get(a).getPaciente().size();e++){
                                                System.out.println("Insira o ID do Paciente que quer dar alta: ");
                                                escolha=scan.nextLine();
                                                if(escolha.equals(hop.getMedico().get(a).getPaciente().get(e).getID()) && hop.getMedico().get(a).getPaciente().get(e).getCurativo()){
                                                    hop.darAlta(hop.getMedico().get(a).getPaciente().get(e).getID(),a);
                                                }
                                                if(hop.getMedico().get(a).getPaciente().get(e).getCurativo()){
                                                    System.out.println(hop.getMedico().get(a).getPaciente().get(e).toString());
                                                }
                                            }
                                        }else{
                                            System.out.println("Não tem pacientes para dar alta");
                                        }
                                        break;

                                    case 5:
                                        //FUNCAO A PEDIR REQUERIMENTO DE AUXILIARES
                                        Pedidos ped;
                                        String pedido;
                                        System.out.println("Quantos auxiliares precisa: ");
                                        int auxiliares = scan.nextInt();

                                        System.out.println("Razões: ");
                                        pedido=scan.nextLine();

                                        ped=new Pedidos(auxiliares,pedido);

                                        hop.addPedido(ped);
                                        break;
                                    }
                                }
                            while(opcao2!=6);
                        }else{
                            System.out.println("Procurando...");
                        }
                    }
                    break;
                     
                case 2:
                    String Idd;
                    int utentes;
                    System.out.println("Introduza o seu ID: ");
                    Idd=scan.next();
                    System.out.println("Introduza o seu Nº Utente: ");
                    utentes=scan.nextInt();
                    for(int a=0;a<hop.getEnfEsp().size();a++){
                        if((Idd.equals(hop.getEnfEsp().get(a).getID()) && utentes==hop.getEnfEsp().get(a).getUtente()) ){
                            do{
                                System.out.println("== MWNU ENFERMEIRO ==" + hop.getEnfEsp().get(a).getID() );

                                System.out.println("1-Listar enfermeiros de médico" );
                                System.out.println("2-Listar pacientes a aguardar curativo");
                                System.out.println("3-Atribuir enfermeiro-especialista a médico");
                                System.out.println("4-Aplicar curativo a paciente");
                                System.out.println("Insira a sua opção:");

                                opcao2 = scan.nextInt();
                                scan.nextLine();
                                switch(opcao2){

                                    case 1:
                                        //APRESENTA LISTA DE ENFERMEIROS
                                        for (Medico medico : hop.getMedico()) {
                                            System.out.println(medico.toString());
                                            if(!medico.getEnfEsp().isEmpty()){
                                                System.out.println("--Tem os seguintes Especialistas atribuidos");
                                                for (Enf_esp enfEsp : medico.getEnfEsp()) {
                                                    System.out.println(enfEsp.toString());
                                                    System.out.println("\n");
                                                }
                                            }
                                            if(!medico.getEnfAux().isEmpty()){
                                                System.out.println("--Tem os seguintes Auxiliares atribuidos");
                                                for (Enf_aux enfAux : medico.getEnfAux()) {
                                                    System.out.println(enfAux.toString());
                                                    System.out.println("\n");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        //LISTA DE PACIENTES A AGUARDAR CURATIVO
                                        if(!hop.getEnfEsp().get(a).getPaciente().isEmpty()){
                                            for(int i=0;i<hop.getEnfEsp().get(a).getPaciente().size();i++){
                                                System.out.println(hop.getEnfEsp().get(a).getPaciente().get(i).toString());
                                            }
                                        }else{
                                            System.out.println("Não tem pacientes para fazer curativo...");
                                        }
                                        break;
                                    case 3:
                                        //ATRIBUIR ESPECIALISTA A MEDICO SO SE FOR ENFERMEIRO CHEFE
                                        if(hop.getEnfEsp().get(a).getChefe()){
                                            System.out.println("Insira o ID do Medico a quem deseja atribuir um Enfermeiro Especialista: ");
                                            escolha=scan.nextLine();
                                            for(int c=0; c<hop.getMedico().size();c++){
                                                if(escolha.equals(hop.getMedico().get(c).getID())){
                                                    System.out.println("Insira o ID do Enfermeiro Especialista: ");
                                                    escolha=scan.nextLine();
                                                    for(int b=0;b<hop.getEnfEsp().size();b++){
                                                        if(escolha.equals(hop.getEnfEsp().get(b).getID())){
                                                            if(hop.getMedico().get(c).getEnfEsp().get(b).getID().equals(escolha)){
                                                                System.out.println("Este Enfermeiro Especialista já foi inserido a sua lista.");
                                                            }else{
                                                                hop.getMedico().get(c).addEnfEsp(hop.getEnfEsp().get(b));
                                                                System.out.println("Operação realizada com sucesso.");
                                                            }
                                                        }
                                                    }
                                                }
                                                else{
                                                    System.out.println("Medico não existe.");
                                                }
                                            }
                                        }else{
                                            System.out.println("\nNão é Enfermeiro Chefe para usar está opção\n");
                                        }
                                        break;
                                    case 4:
                                        if(!hop.getEnfEsp().get(a).getPaciente().isEmpty()){
                                            int rad=new Random().nextInt(6);
                                            System.out.println("Insira o ID do paciente para aplicar curativo:");
                                            escolha=scan.nextLine();
                                            for (int i = 0; i<hop.getEnfEsp().get(a).getPaciente().size(); i++){
                                                System.out.println("Aplincando curativo...");
                                                if (escolha.equals(hop.getEnfEsp().get(a).getPaciente().get(i).getID())){
                                                    if(5<hop.getEnfEsp().get(a).getPaciente().get(i).getTentativas()){
                                                        System.out.println(hop.getEnfEsp().get(a).getPaciente().get(i).toString() + "\nNão resistiu ao tratamento\n");
                                                        
                                                        hop.obito(hop.getEnfEsp().get(a).getID(),hop.getEnfEsp().get(a).getPaciente().get(i).getID());
                                                        if (hop.getPacEspera().get(i).getSintoma()=="Covid19"){
                                                            obitos=obitos+1;
                                                        }
                                                        obitosTotal=obitosTotal+1;
                                                    }
                                                    else{
                                                        switch(rad){
                                                            case 0,3 -> {
                                                                hop.enviarAlta(hop.getEnfEsp().get(a).getPaciente().get(i).getID(), "Curado");
                                                                System.out.println("Curativo aplicado com sucesso....");
                                                                if(hop.getPacEspera().get(i).getSintoma()=="Covid19"){
                                                                    recuperados=recuperados+1;
                                                                }
                                                                recuperadosTotal=recuperadosTotal+1;
                                                            }
                                                            case 1,2,4,5 -> {
                                                                hop.enviarAlta(hop.getEnfEsp().get(a).getPaciente().get(i).getID(), hop.getEnfEsp().get(a).getPaciente().get(i).getSintoma());
                                                                System.out.println("Curativo aplicado sem sucesso....");
                                                            }
                                                        }
                                                    }
                                                }else{ 
                                                    System.out.println("Nao ha nenhum paciente com esse indice na lista de espera");
                                                }
                                            }
                                        }
                                        
                                        break; 
                                    }
                            }
                            while(opcao2!=5);
                        }
                    }
                    break;
                     
                case 3:
                    System.out.println("== MWNU ADMINISTRATIVO ==");
                    System.out.println("Insira a sua opção:");
                    
                    System.out.println("1-Criar médico");
                    System.out.println("2-Criar enfermeiro-especialista");
                    System.out.println("3-Criar enfermeiro-auxiliar");
                    System.out.println("4-Criar novo paciente");
                    System.out.println("5-Promover enfermeiro a chefe");
                    System.out.println("6-Aumentar anos carreira a todos os enfermeiros");
                    System.out.println("7-Listar enfermeiros");
                    System.out.println("8-Listar médicos");
                    System.out.println("9-Listar pedidos para enfermeiros-auxiliares");
                    System.out.println("10-Listar pacientes em espera no hospital");
                    System.out.println("11-Atirar pedidos de enfermeiros-auxiliares para trituradora");
                    System.out.println("12-Atende ao pedido para enfermeiros-auxiliares");
                    System.out.println("13-Virus outbreak");
                    System.out.println("14-Relatório hospitalar numero trabalhadores");
                    System.out.println("15-Relatorio hospitalar Covid19");
                    System.out.println("16-Relatorio hospitalar Informacao total doenças");
                    System.out.println("17-Sair de aplicacao");
                    
                    opcao = scan.nextInt();


                    switch(opcao){

                        case 1:
                            Medico m;
                            System.out.println("Insira os dados do novo médico:");
                            System.out.println("NIF:");
                            nif=scan.nextInt();
                            System.out.println("Doença que trata:");
                            nome=scan.next();

                            m=new Medico(nif,nome);
                            hop.addMedico(m);

                            System.out.println("Médico criado.");
                            break;
                        case 2:
                            System.out.println("Insira os dados do novo enfermeiro especialista:");
                            System.out.println("NIF:");
                            nif=scan.nextInt();
                            System.out.println("Nome:");
                            nome=scan.next();
                            System.out.println("Anos de Carreira:");
                            anosCarreira=scan.nextInt();
                            System.out.println("Especialidade:");
                            especialidade=scan.next();

                            esp=new Enf_esp(nif,anosCarreira,nome,especialidade);
                            hop.addEnfEsp(esp);

                            System.out.println("Enfermeiro especialista criado.");
                            break;
                        case 3:
                            System.out.println("Insira os dados do novo enfermeiro auxiliar:");
                            System.out.println("NIF:");
                            nif=scan.nextInt();
                            System.out.println("Nome:");
                            nome=scan.nextLine();
                            System.out.println("Anos de Carreira:");
                            anosCarreira=scan.nextInt();

                            aux = new Enf_aux(nif,anosCarreira, nome);
                            hop.addEnfAux(aux);

                            System.out.println("Enfermeiro auxiliar criado.");
                            break;

                        case 4:
                            Paciente paci;
                            System.out.println("Insira os dados do novo paciente:");
                            System.out.println("NIF: ");
                            nif=scan.nextInt();
                            System.out.println("Ano de Nascimento: ");
                            ano_nascimento=scan.next();
                            paci=new Paciente(nif, ano_nascimento, hop.sintoma());
                            hop.addPacEspera(paci);

                            System.out.println("Paciente criado.");
                            break;

                        case 5:
                            if(!hop.getEnfEsp().isEmpty()){ //anos de carreira minimos estabelecidos pelo hospitl e 0
                                System.out.println("Digite o ID do enfermeiro especialista, desta lista, a quem deseja promover a chefe:");
                                escolha=scan.next();
                                for(int a=0; a<hop.getEnfEsp().size();a++){
                                    if(escolha.equals(hop.getEnfEsp().get(a).getID())){              
                                        hop.getEnfEsp().get(a).setChefe(true);
                                        System.out.println("Enfermeiro promovido a chefe.");
                                    }
                                }
                            }else{
                                System.out.println("Não tem enfermeiros especialistas no hospital");
                            }
                            break;

                        case 6:  
                            //aumentarAnos
                            System.out.println("Quantos anos deseja aumentar ao Enfermeiros: ");
                            anosCarreira=scan.nextInt();

                            for(int a =0;a<hop.getEnfAux().size();a++){
                                hop.getEnfAux().get(a).aumentarAnos(anosCarreira);
                            }
                            for(int a =0;a<hop.getEnfEsp().size();a++){
                                hop.getEnfEsp().get(a).aumentarAnos(anosCarreira);
                            }
                            System.out.println("Aumentou os anos de carreira de todos os enfermeiros.");
                            break;

                        case 7:   
                            //LISTA DE ENF
                            if(!hop.getEnfEsp().isEmpty()){
                                for(int a=0; a<hop.getEnfEsp().size();a++){
                                    System.out.println("");
                                    System.out.println(hop.getEnfEsp().get(a).toString());
                                }
                            }else{
                                System.out.println("Não tem enfermeiros especialistas no hospital");
                            }
                            if(!hop.getEnfAux().isEmpty()){
                                for(int a=0; a<hop.getEnfAux().size();a++){
                                    System.out.println("");
                                    System.out.println(hop.getEnfAux().get(a).toString());
                                }
                            }else{
                                System.out.println("Não tem enfermeiros auxiliares no hospital");
                            }
                            break;

                        case 8:
                            //LISTA DE MEDICOS
                            for(int a=0; a<hop.getMedico().size();a++){
                                System.out.println("\n");
                                System.out.println(hop.getMedico().get(a).toString());
                            }
                            break;

                        case 9:
                            //LISTA DE PEDIDOS DE AUXILIARES
                            if (hop.getPedido().size()==0){
                                System.out.print("Sem pedidos");
                            }else{
                                for(int a=0; a<hop.getPedido().size();a++){
                                    System.out.println(hop.getPedido().get(a).toString());
                                }
                            }
                            break;

                        case 10:
                            //LISTA PACIENTES EM ESPERA
                            if(!hop.getPacEspera().isEmpty()){
                                for(int e=0;e<hop.getPacEspera().size();e++){
                                    System.out.println(hop.getPacEspera().get(e).toString());
                                }
                            }else{
                                System.out.println("Lista de espera está vazia");
                            }
                            break;

                        case 11:
                            //PEDIDO DE AUXILIARES PARA A TRIRURADORA
                           
                            int random =(int)(Math.random()*3); //nr vezes que elimina os pedidos (0-2)

                            int random2=(int)(Math.random()*3); //indices random
                            if (random<hop.getPedido().size()){
                                if (random2<hop.getPedido().size()){
                                    for(random=0; random<hop.getPedido().size(); random++){
                                        hop.removePedido(random2); 
                                        System.out.print("Feito.");
                                    }
                                }else{
                                    System.out.println("Nao foi eliminado.");
                                }                                                     
                            }else{
                                 System.out.println("Nao foi eliminado.");
                            }                          
                            break;

                        case 12:
                            //ATENDER PEDIDOS DE AUXILIARES
                            System.out.println("2 novos enfermeiros auxiliares ficarão ao dispor dos medicos.");
                            System.out.println("Insira os dados do primeiro novo enfermeiro auxiliar:");
                            System.out.println("NIF:");
                            nif=scan.nextInt();
                            System.out.println("Nome:");
                            nome=scan.nextLine();
                            System.out.println("Anos de Carreira:");
                            anosCarreira=scan.nextInt();
                            aux = new Enf_aux(nif,anosCarreira, nome);
                            hop.addEnfAux(aux);
                            //====
                            System.out.println("Insira os dados do segundo novo enfermeiro auxiliar:");
                            System.out.println("NIF:");
                            nif=scan.nextInt();
                            System.out.println("Nome:");
                            nome=scan.nextLine();
                            System.out.println("Anos de Carreira:");
                            anosCarreira=scan.nextInt();
                            aux = new Enf_aux(nif,anosCarreira, nome);
                            hop.addEnfAux(aux);

                            hop.getPedido().clear();
                            break;

                        case 13:
                            //VIRUS OUTBREACK
                            break;

                        case 14:
                            //RELATORIO
                            System.out.println("Relatorio com a informaçao do numero de trabalhadores no hospital " +hop.getNome());
                            System.out.println("Numero de Medicos: "+hop.getMedico().size());
                            int aw=0, ar=0;
                            for(int a=0;a<hop.getEnfEsp().size();a++){
                                if(hop.getEnfEsp().get(a).getChefe()){
                                    aw++;
                                }else{
                                    ar++;
                                }
                            }
                            System.out.println("Numero de enfermeiros chefes: "+aw);
                            System.out.println("Numero de enfermeiros especialistas: "+ar);
                            System.out.println("Numero de enfermeiros auxiliares: "+hop.getEnfAux().size()); 
                            break;

                        case 15:
                            System.out.println("Relatorio com informaçoes relativas a Covid19");
                            if (casos==0){
                                System.out.println("Sem casos positivos Covid19");
                            }
                            else{
                                System.out.println("Numero de casos positivos testados: " +casos);
                            }
                            if (recuperados==0){
                                System.out.println("---");
                            }
                            else{
                                System.out.println("Numero de casos recuperados: " +recuperados );
                            }
                            if (obitos==0){
                                System.out.println("---");
                            }else{
                                System.out.println("Numero de obitos: "+obitos);
                            }
                            if(testes==0){
                                System.out.println("---");
                            }else{
                                System.out.println("Racio de casos positivos por testes feitos: "+casos/testes);
                            }
                            //System.exit(0); 
                            break;
                            
                        case 16:
                            System.out.println("Relatorio com informaçoes de doentes/recuperados/obitos de todas as doencas");
                            if (casosTotal==0){
                                System.out.println("Nenhuma doenca diagnosticada");
                            }
                            else{
                                System.out.println("Numero de doentes diagnosticados: " +casosTotal);
                            }
                            if (recuperadosTotal==0){
                                System.out.println("---");
                            }
                            else{
                                System.out.println("Numero de doentes recuperados: " +recuperadosTotal );
                            }
                            if (obitos==0){
                                System.out.println("---");
                            }else{
                                System.out.println("Numero de obitos: "+obitosTotal);
                            }
                            break;
                            
                        case 17:
                            System.out.println("A sair...");
                            System.exit(0); 
                            break;


                }
                break;
            }
        }
        while (opcao!=18);
    }
}
