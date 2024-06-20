package esame2;

/**
 *
 * @author giuse
 */
public class Image extends Multimedia{
    private int xPixel;
    private int yPixel;
    
    public Image(String fileName, char resolution, boolean raw, int x, int y){
        super(fileName,resolution,raw);
        this.xPixel=x;
        this.yPixel=y;
    }
    
        /*Il metodo resize permette di ridimensionare un file multimediale in base ad una 
    percentuale passata come parametro. Se la percentuale è esterna all’intervallo ]0 100[ 
    allora il metodo solleva una eccezione del tipo IllegalArgumentException con 
    opportuno messaggio.
    Una immagine è ridotta modificando in percentuale i valori dei suoi pixel.*/
    
    @Override
    public void resize(int percentage) throws IllegalArgumentException{
        
        if(percentage<=0 || percentage>=100){
            throw new IllegalArgumentException("Valore non consentito");}
        
        this.xPixel= xPixel -(percentage*xPixel)/100;
        this.yPixel = yPixel -(percentage*yPixel)/100;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\tPixel: "+this.xPixel+","+this.yPixel;
    }
    
}
