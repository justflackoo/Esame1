package esercitazioneimbarcazione;

import java.io.IOException;
import java.io.PrintStream;
import java.io.FileOutputStream;
/**
 *
 * @author giuse
 */
public class ScritturaSuFile {
    public static void main(String[] args){
        Traghetto t1 = new Traghetto(20,100,"Traghetto1",10);
        PortaContainer p1 = new PortaContainer(10,200,"PortaContainer1",50);
        Traghetto t2 = new Traghetto(60,200,"Traghetto2",30);
        Traghetto t3 = new Traghetto(80,300,"Traghetto3",60);
        PortaContainer p2 = new PortaContainer(50,800,"PortaContainer2",80);
        PortaContainer p3 = new PortaContainer(80,300,"PortaContainer3",60);
        Traghetto t4 = new Traghetto(8000,120,"Traghetto4",60);
        
        OrderedLinkedList lista = new OrderedLinkedList();
        lista.insert(t1);
        lista.insert(t2);
        lista.insert(p1);
        lista.insert(t3);
        lista.insert(p2);
        lista.insert(p3);
        lista.insert(t4);        
        
        try{
            // Creazione di un PrintStream per scrivere su un file chiamato "Scrittura.txt"
            PrintStream fileStream = new PrintStream(new FileOutputStream("Scrittura.txt"));
            
            // Salvataggio del PrintStream originale della console
            PrintStream consoleStream = System.out;
            
            // Reindirizzamento dell'output standard verso il file
            System.setOut(fileStream);
       
            lista.print();
            
            // Chiusura del PrintStream associato al file
            System.out.close();
            // Ripristino del PrintStream originale della console
            System.setOut(consoleStream);
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
