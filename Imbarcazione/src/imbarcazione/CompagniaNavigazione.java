package imbarcazione;

import java.util.ArrayList;

/**
 *
 * @author giuse
 */
public class CompagniaNavigazione {
    public static void main(String[] args){
        
    OrderedLinkedList lista = new OrderedLinkedList();
    Traghetto traghetto1 = new Traghetto(300,2000,"Traghetto1",100);
    Traghetto traghetto2 = new Traghetto(200,1500,"Traghetto2",50);
    Traghetto traghetto3 = new Traghetto(600,4000,"Traghetto3",200);
    
    PortaContainer portacontainer1 = new PortaContainer(50, 5000, "PortaContainer1",500);
    PortaContainer portacontainer2 = new PortaContainer(600, 7000, "PortaContainer2",700);
    PortaContainer portacontainer3 = new PortaContainer(80, 8000, "PortaContainer3",800);
    
    lista.insert(traghetto1);
    lista.insert(traghetto2);
    lista.insert(traghetto3);
    lista.insert(portacontainer1);
    lista.insert(portacontainer2);
    lista.insert(portacontainer3);
    
    lista.print();
    int x= lista.numeroContainerInNavigazione();
    System.out.println("\nNumero container in navigazione: "+x+"\n");
    
    ArrayList <Imbarcazione> elenco = lista.imbarcazioniAffollate();
    
    System.out.println("Elenco imbarcazioni con numero massimo di passeggeri");
    for(Imbarcazione i: elenco){
        System.out.println(i.getNome()+" con "+i.getNumPasseggeri()+" passeggeri");
    }
    
    }
    
   
   
}
