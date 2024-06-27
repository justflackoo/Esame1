package esercitazioneimbarcazione;

import java.util.ArrayList;

/**
 *
 * @author giuse
 */
public class CompagniaNavigazione {
    public static void main(String[] args){
        
        Traghetto t1 = new Traghetto(20,100,"Traghetto1",10);
        PortaContainer p1 = new PortaContainer(10,200,"PortaContainer1",50);
        Traghetto t2 = new Traghetto(60,200,"Traghetto2",30);
        Traghetto t3 = new Traghetto(80,300,"Traghetto3",60);
        PortaContainer p2 = new PortaContainer(50,800,"PortaContainer2",80);
        PortaContainer p3 = new PortaContainer(80,300,"PortaContainer3",60);
        Traghetto t4 = new Traghetto(80,120,"Traghetto4",60);
        
        OrderedLinkedList l = new OrderedLinkedList();
        l.insert(t1);
        l.insert(p1);
        l.insert(t2);
        l.insert(t3);
        l.insert(p2);
        l.insert(p3);
        l.insert(t4);
        l.print();
        /*l.pop();
        l.pop();
        l.pop_back();
        l.pop_back();
        System.out.println("\n\n\t\tStampa post pop x2 e pop_back x2: ");
        l.print();*/
        
        int num = l.numContainerInNavigazione();
        System.out.println("\n\t\tIl numero di container in navigazione è "+num);
        
        System.out.println("Numero massimo di passeggeri: "+l.maxPasseggeri().getNumPasseggeri());
        
        ArrayList<Imbarcazione> elenco = l.imbarcazioniAffollate();
        
        System.out.println("\nElenco delle imbarcazioni con il numero maggiore di passeggeri: \n");
        for(Imbarcazione i : elenco){
            System.out.println(i.toString());
        }
    }
       
    
}
