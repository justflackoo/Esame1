package esame1;

import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

import java.nio.file.Paths;

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
    
    
    public Lista(){this.testa=null;}
    public boolean isEmpty(){return this.testa==null;}
    
   
    
    public void append(Vulnerability v){
        Nodo q = new Nodo(v);       
        if(testa==null){        //Se la lista è vuota allora il nuovoNodo sarà la testa della lista
            testa=q;
        }else{
            Nodo temp = testa;      
            while(temp.next != null){   //Scorro tutta la lista per arrivare all'ultimo nodo
                temp = temp.next;
            }                           //Sono arrivato all'ultimo nodo
            temp.next=q;                //temp attualmente è l'ultimo nodo, quindi il successivo di temp
        }                               //sarà il nuovo ultimo nodo
    }
    
     public Vulnerability pop(){
        Vulnerability v = testa.data;
        testa = testa.next;
        return v;
    }
    
    public void remove(Vulnerability v){
        if(isEmpty()){System.out.println("Lista vuota");}
        if(testa.next==null){pop();}
        
        Nodo temp = testa;
        while(temp.next.data.equals(v)){
                temp=temp.next;
            }
        
        temp.next = temp.next.next;
    }
    
    /*Il metodo numberExploitable restituisce il numero di vulnerabilità SW e il numero di 
      vulnerabilità HW che sono exploitable.*/
    public void numberExploitable(){
        Nodo temp = testa;
        int SW=0;
        int HW=0;
        while(temp!=null){
            if(temp.data.checkExploitable() && temp.data instanceof SWVulnerability){
                SW++;              
            }
            if(temp.data.checkExploitable() && temp.data instanceof HWVulnerability){
                HW++;
            }
            temp = temp.next;
        }
        
        System.out.println("\nNumero SWVulnerability exploitable: "+SW+"\nNumero HWVulnerability exploitable: "+HW);
    }
    /*Il metodo removeNotExploitable rimuove dalla lista tutte le vulnerabilità che non sono 
exploitable. Di fatto dopo l’esecuzione del metodo, nella lista devono essere presenti solo 
vulnerabilità exploitable.
*/
    public void removeNotExploitable(){
       Nodo temp = testa;    
        //Gestisco il caso speciale del primo nodo non exploitable
       while(testa!=null && !testa.data.checkExploitable()){ 
           testa = testa.next;   // Avanza la testa alla prossima posizione se il nodo corrente non è exploitable
       }
       
       /*Finchè temp non è null e nemmeno il suo successivo affinche possa accedere al nodo succcessivo*/
       while(temp!=null && temp.next!=null){
           
            //Verifico se il nodo successivo NON è exploitable
           if(!temp.next.data.checkExploitable()){
               
               //Se tale nodo non è exploitable lo rimuovo
               temp.next=temp.next.next;
           }else{
               
               //Altrimenti proseguo nella mia ricerca
                 temp= temp.next;
           }
       }
     

    }
    
    public void loadFromFile(){
        
        try{
            Scanner input = new Scanner(Paths.get("Vulnerability.txt"));
            int numElem = input.nextInt();
            System.out.println("\t\t\tElementi presenti: "+numElem+"\n");
            
            for(int i=0; i<numElem;i++){
                String className;
                className= input.next();
                if(className.equals("Vulnerability.software")){
                    SWVulnerability swv = new SWVulnerability(input.nextInt(), input.nextBoolean(),input.next(),input.nextInt());
                    append(swv);
                }else{
                    HWVulnerability hwv = new HWVulnerability(input.nextInt(), input.nextBoolean(),input.next());
                    append(hwv);
                }
            }
            input.close();
            
        }catch(IOException | NoSuchElementException e){
            e.printStackTrace();
        }
        
    }
    
    public void print(){
        Nodo temp = testa;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
