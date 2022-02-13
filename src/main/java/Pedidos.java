
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Pedidos {
    private String pedido;
    private int num;

    
    
    public Pedidos (String pedido, int num){
        this.pedido=pedido;
        this.num=num;
        
    }

    public String toString(){
        String texto;
        texto= "É o: "+pedido ;
        texto=texto + "\nCom o numero de auxiliares: " + num;
        return texto;
    }
}
