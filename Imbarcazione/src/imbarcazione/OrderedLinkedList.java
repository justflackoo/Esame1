package imbarcazione;

import java.util.ArrayList;

/**
 *
 * @author giuse
 */
public class OrderedLinkedList {
    public class Nodo{
       private Imbarcazione data;
       private Nodo next;
       
       public Nodo(Imbarcazione elem){
           this.data=elem;
           this.next=null;
       }
    }
    
    Nodo testa;
    public OrderedLinkedList(){this.testa=null;}
    
    public boolean isEmpty(){return this.testa==null;}
    
    public void push(Imbarcazione i){
        Nodo q = new Nodo(i);
        q.next = testa;
        testa=q;
    }
    
    public void insert(Imbarcazione i){
        if(isEmpty() || testa.data.compareTo(i)>0){push(i);}
        else{
        Nodo temp = testa;
        Nodo q = new Nodo(i);
        while(temp.next!=null && temp.next.data.compareTo(i)<0){
            temp=temp.next;
        }
        q.next=temp.next;
        temp.next=q;
        }

    }


    public void delete(Imbarcazione elem)throws EccezioneCoda{
        if(isEmpty()){throw new EccezioneCoda("La lista è vuota");}
        if(testa.data.equals(elem)){testa = testa.next;}
        
        //Se l'elemento non era puntato dalla testa inizio la ricerca
        Nodo temp = testa;
        while(temp.next.data.equals(elem)){ 
            temp = temp.next;
        }
        
        if(temp.next==null){
            throw new EccezioneCoda("Elemento non presente in lista");
        }
        
        temp.next = temp.next.next;
    }
    
    public Imbarcazione ricercaMassimo(){
        Imbarcazione max = testa.data;  //Inizializzo il primo elemento della lista come massimo
        Nodo temp = testa;
        while(temp.next!=null){
            if(temp.data.getNumPasseggeri()>max.getNumPasseggeri()){
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }
    
    //Il metodo imbarcazioniAffollate restituisce le imbarcazioni della lista che presentano il numero
    //più alto di passeggeri imbarcati. E' ammmesso solo in questo caso l'utilizzo dei container java come
    //eventuale parametro di ritorno
    public ArrayList<Imbarcazione> imbarcazioniAffollate(){
        
        //In primis mi vado a prendere l'elemento massimo
        Imbarcazione maxElem = ricercaMassimo();
        
        //Dopo di ciò vado a prendere il numero massimo di passeggeri
        int maxPasseggeri = maxElem.getNumPasseggeri();
        
        //Mi creo l'arrayList che dovrò restituire
        ArrayList<Imbarcazione> elenco = new ArrayList<>();
        
        Nodo temp = testa;
        
        //Ora vado a cercare quanti e quali imbarcazioni hanno il max numero di passeggeri
        while(temp.next != null){
            // Se l'imbarcazione corrente ha il numero massimo di passeggeri, la aggiunge alla lista
            if(temp.data.getNumPasseggeri()==maxPasseggeri){
                elenco.add(temp.data);
            }
            //Se non ha il numMax di passeggeri passa al successivo
            temp = temp.next;
        }
        return elenco;
    }
    
    public int numeroContainerInNavigazione(){
        int numContainer = 0;
        Nodo temp = testa;
        while(temp!= null){
           if(temp.data instanceof PortaContainer){
               PortaContainer pc = (PortaContainer) temp.data;
               numContainer = numContainer + pc.getNumContainer();
           }
           temp = temp.next;
        }
        return numContainer;
    }
    
    public void print(){
        Nodo temp = testa;
        while(temp!=null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }
    

    
}
