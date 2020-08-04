/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import javax.swing.JTextField;


public class Endereco {
    
    private String logradouro = "";
    private int numero = 0;
    
    public Endereco(){
        
    }
    
    public Endereco (String logradouro, int numero){
        this.logradouro = logradouro;
        this.numero = numero;
    }   

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
