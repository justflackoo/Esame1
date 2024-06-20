package esame2;

/**
 *
 * @author giuse
 */
public class Galleria {
    
    public static void main(String[] args){
     Lista l = new Lista();
     l.loadFromFile();
     /*System.out.println("PRIMA STAMPA\n");
     l.print();
        */
     Video vid = new Video("VideoProvaAlto",'E',true,100);
     Video vid2 = new Video("VideoProvaBasso",'L',true,50);
     Image img = new Image("ImageProvaAlta",'H',true,100,100);
     Image img2 = new Image("ImageProvaBassa",'M',true,20,20);
     l.push(vid);
     l.push(vid2);
     l.push(img);
     l.push(img2);
     
     /*System.out.println("\n\n SECONDA STAMPA \n");
     l.print(); */
     
     System.out.println("\n\t\t\tSTAMPA POST SAVESPACE \n");
     l.saveSpace();
     l.print();
     
     l.removeLow();
     /*System.out.println("\n\n\t\t\tSTAMPA POST RemoveLow()");*/
     l.print();
        
    }
    
}
