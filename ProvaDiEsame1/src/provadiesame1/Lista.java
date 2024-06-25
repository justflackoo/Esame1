/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provadiesame1;

/**
 *
 * @author giuse
 */
public class Lista {
    public class Nodo{
        private Vulnerability data;
        private Nodo next;
        
        public Nodo(Vulnerability elem){
            this.data=elem;
            this.next=null;
        }
    }
    
    Nodo testa;
    
    public boolean isEmpty(){return this.testa==null;}
    
    public void push(Vulnerability v){
        Nodo q = new Nodo(v);
        q.next = testa;
        testa=q;
    }
    
    public Vulnerability pop(){
        Vulnerability v = testa.data;
        testa = testa.next;
        return v;
    }
    
    //La lista inserisce un elemento sempre in ultima posizione
    public void append(Vulnerability v){
        if(isEmpty()){push(v);}
        else{
        Nodo q = new Nodo(v);
        Nodo temp = testa;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=q;   
        }
    }
    
    public void rimuovi(Vulnerability v){
    if(isEmpty()){
        System.out.println("Lista vuota");}
    
    if(testa.data.equals(v)){
        pop();
    }else{
        Nodo temp = testa;
        while(temp.next!=null && !temp.next.data.equals(v)){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        
      }
 }
    
    
    
    /*Il metodo numberExploitable restituisce il numero di vulnerabilità SW e il numero di
    vulnerabilità HW che sono exploitable*/
    public void numberExploitable(){
        int SW=0;
        int HW=0;
        Nodo temp = testa;
        while(temp!=null){
            if(temp.data instanceof SWVulnerability && temp.data.checkExploitable()){
                SW++;
            }
            if(temp.data instanceof HWVulnerability && temp.data.checkExploitable()){
                HW++;
            }
            temp = temp.next;
        }
        System.out.println("\n\t\tSW Exploitable: "+SW+"\tHW Exploitable: "+HW);
    }
    
    public void print(){
        Nodo temp = testa;
        while(temp!=null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }
    
    /*Il metodo removeNotExploitable rimuove dalla lista tutte le vulnerabilità che non sono
exploitable. Di fatto dopo l’esecuzione del metodo, nella lista devono essere presenti solo
vulnerabilità exploitable*/
    public void removeNotExploitable(){
        Nodo temp = testa;
        while(temp.next!=null){
            if(!temp.data.checkExploitable()){
                rimuovi(temp.data);
            }
            temp=temp.next;
        }
    }
    
}
