/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imbarcazione;

/**
 *
 * @author giuse
 */
public class Traghetto extends Imbarcazione {
    
    private int numAutomobili;
    
    public Traghetto(int numPasseggeri, int stazza, String nome, int numAutomobili){
        super(numPasseggeri,stazza,nome);
        this.numAutomobili=numAutomobili;
    }
    
    public int getNumAutomobili(){return this.numAutomobili;}
    public void setNumAutomobili(int num){this.numAutomobili=num;}
    
    @Override
    public int notificaPasseggeri(){return this.numAutomobili+this.getNumPasseggeri();}
    
    @Override
    public String toString(){
    return super.toString()+"\tNumAutomobili: "+this.numAutomobili;
    }
}
