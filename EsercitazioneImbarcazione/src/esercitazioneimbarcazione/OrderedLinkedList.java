package esercitazioneimbarcazione;

import java.util.ArrayList;

public class OrderedLinkedList {
    public class Nodo{
        private Imbarcazione data;
        private Nodo next;
        
        public Nodo(Imbarcazione elem){
        this.data=elem;
        this.next=null;}
    }
    
    Nodo testa;
    
    public boolean isEmpty(){return this.testa==null;}
    public boolean isFull(){return false;}
    
    public void push(Imbarcazione i){
        Nodo q = new Nodo(i);
        q.next=testa;
        testa=q;
    } 
    //Append: inserimento in coda
    public void append(Imbarcazione i){
        if(isEmpty()){
            push(i);
        }else{
            Nodo q = new Nodo(i);
            Nodo temp = testa;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=q;
        }
    }
    //Inserimento tenendo conto dell'ordinamento naturale sulla stazza
    public void insert(Imbarcazione i){
        if(isEmpty() || testa.data.compareTo(i)>0){push(i);} // Se è vuota o i.stazza<testa.stazza push(i)
        else{
        Nodo temp = testa;
        Nodo q = new Nodo(i);
        while(temp.next!=null && temp.next.data.compareTo(i)<0){
            temp = temp.next;
        }
        q.next=temp.next;
        temp.next=q;
        }
    }
    
    //Pop: rimozione in testa
    public Imbarcazione pop(){
        Imbarcazione i = testa.data;
        testa = testa.next;
        return i;
    }

    //popBack: rimozione in coda    
    public Imbarcazione pop_back(){
        if(testa.next==null){return pop();}
                //Se il nodo da rimuovere non è quello in testa allora:
        else{
            Nodo temp = testa;
            //Faccio scorrere la lista alla ricerca del penultimo nodo
            while(temp.next.next!=null){
                temp = temp.next;
            }
            //Ora temp punta al penultimo nodo, quindi temp.next.data è il dato
            //del nodo successivo che sarà l'ultimo
            Imbarcazione imb = temp.next.data;
            //Imposto temp.next a null,andando a perdere il riferimento all'ultimo nodo
            temp.next=null;
            return imb;
        }
    }
    
    //Delete rimuove la prima occorrenza
    public void delete(Imbarcazione i){
        if(isEmpty()){System.out.println("La lista è vuota");}
        else{
        Nodo temp = testa;
        while(!temp.next.data.equals(i)){
            temp = temp.next;
        }
        
        if(temp.next==null){System.out.println("Elemento non presente nella lista");}
        
        temp.next=temp.next.next;
        
    }
        
    }
    
    //Il metodo numeroContainerInNavigazione restituisce il numero totale di tutti i container in navigazione
    public int numContainerInNavigazione(){
        int numContainer=0;
        Nodo temp = testa;
        while(temp!=null){
            if(temp.data instanceof PortaContainer){
                PortaContainer pc = (PortaContainer) temp.data;
                numContainer = numContainer + pc.getNumContainer();
            }
            temp = temp.next;
        }
        return numContainer;
    }
    
    //Creo questo metodo di ricerca del massimo per usarlo nel metodo imbarcazioniAffollate()
    public Imbarcazione maxPasseggeri(){
        Imbarcazione max = testa.data;
        Nodo temp = testa;
        while(temp.next!=null){
            if(temp.data.getNumPasseggeri()>=max.getNumPasseggeri()){
                max=temp.data;
            }
            temp = temp.next;
        }
        return max;
    }
    
    public ArrayList imbarcazioniAffollate(){
        Imbarcazione max = maxPasseggeri();
        int maxNumPasseggeri = max.getNumPasseggeri();
        ArrayList<Imbarcazione> elenco = new ArrayList<>();
        Nodo temp = testa;
        while(temp.next!=null){
            if(temp.data.getNumPasseggeri()==maxNumPasseggeri){
                elenco.add(temp.data);
            }
            temp = temp.next;
        }
        return elenco; 
    }
    
    public void print(){
        Nodo temp = testa;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    
    
}
