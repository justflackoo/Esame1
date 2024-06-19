package esame1;

public class Main {
    public static void main (String[] args){
       Lista l = new Lista();
       l.loadFromFile();
       l.print();
       l.numberExploitable();
       l.removeNotExploitable();
       System.out.println("\nStampa post rimozione notExploitable");
       l.print();
       System.out.println("\nStampa post 2 pop()");
       l.pop();
       l.pop();
       l.print();
       SWVulnerability elem = new SWVulnerability(5, true,"ProvaElem", 5);
       l.append(elem);
       System.out.println("\nStampa post append(elem)");
       l.print();
       elem.fix();
        System.out.println("\nStampa post fix su elem");
       l.print();
       
       System.out.println("Programma terminato");
    }
    
}
