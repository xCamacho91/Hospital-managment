/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

/**
 *
 * @author joaoc
 */
public class Pedidos  {
    private int id_pedido;
    private int valor;
    private String pedido;
    private static int contar;
    
    public Pedidos(int valor,String pedido){
        this.contar++;
        this.id_pedido=contar;
        this.valor=valor;
        this.pedido=pedido;
    }
    
    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor=valor;
    }
    
    public static int getContar() {
        return contar;
    }
    
    public String getPedido(){
        return pedido;
    }
    public void setPedido(String pedido){
        this.pedido=pedido;
    }
    
    public String toString(){
        String texto;
        texto="Nº: "+id_pedido + "   Quantidade: " + valor + "  Pedido: " + pedido;
        return texto;
    }
    
}
