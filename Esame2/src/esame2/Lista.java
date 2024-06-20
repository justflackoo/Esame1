//Manca solo il removeLow

package esame2;

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
        private Multimedia data;
        private Nodo next;
        
        public Nodo(Multimedia elem){
        this.data=elem;
        this.next=null;
        }
    }
    
    Nodo testa;
    
    public Lista(){this.testa=null;}
    public boolean isEmpty(){return this.testa==null;}
    
    public void push(Multimedia m){
        Nodo nuovoNodo = new Nodo(m);
        nuovoNodo.next=testa;
        testa = nuovoNodo;
    }
    
    public Multimedia pop(){
        Multimedia m = testa.data;
        testa = testa.next;
        return m;
    }
    /*Il metodo saveSpace riduce del 50% tutti i file multimediali di tipo video che hanno alta qualità.*/
    public void saveSpace(){
        Nodo temp = testa; //Parto dalla testa
       while(temp!=null){   
           if(temp.data.checkQuality()){ //Se checkQuality è alto allora faccio agire resize
               temp.data.resize(50);
           }
                          temp = temp.next; //Altrimenti scorri al prossimo elemento
       }
    }
    
    /*Il metodo removeLow rimuove dalla lista le prime due immagini e gli ultimi due video di 
bassa qualità. Nel caso in cui sia presente un solo video o una sola immagine a bassa 
qualità il metodo cancella solo questi file multimediali.
*/
    
    
    public void removeLow(){
        Nodo temp = testa;
        int immaginiEliminabili=0;
        while(temp!=null){
            if(temp.data instanceof Image && temp.data.checkQuality()){
                immaginiEliminabili++;
            }
            temp=temp.next;
        }
        System.out.println("\tCi sono "+immaginiEliminabili+" immagini eliminabili");
       
    }
    
    public void remove(Multimedia m){
        if(isEmpty()){System.out.println("Lista vuota");}
        if(testa.data.equals(m)){testa = testa.next;}
        Nodo temp = testa;
        while(temp!=null){
            if(temp.data.equals(m)){
            temp = temp.next;
         }
        }
        
        temp.next=temp.next.next;
    }
    
    public void print(){
        Nodo temp = testa;
        while(temp!=null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }
    
    public void loadFromFile(){
        try{
            
            Scanner input = new Scanner(Paths.get("Informazioni.txt"));
            int numElem = input.nextInt();
            System.out.println("Numero elementi: "+numElem);
            
            for(int i=0; i<numElem;i++){
                
                String className;
                className = input.next();
                if(className.equals("Multimedia.Image")){
                    Image img = new Image(input.next(), input.next().charAt(0),input.nextBoolean(),input.nextInt(),input.nextInt());
                   push(img);
                }if(className.equals("Multimedia.Video")){
                    Video vid = new Video(input.next(), input.next().charAt(0),input.nextBoolean(),input.nextInt());
                    push(vid);
                }
            }
            input.close();
        }catch(IOException | NoSuchElementException e){
            e.printStackTrace();
        }
    }
}
